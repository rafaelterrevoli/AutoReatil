package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement esperarElementoClickable(By byElement, int tiempo) {
        WebElement elemento = null;
        elemento = new WebDriverWait(driver, tiempo)
                .until(ExpectedConditions
                        .elementToBeClickable(byElement));
        return elemento;
    }

    public WebElement esperarElementoVisible(By byElement, int tiempo) {
        WebElement elemento = null;
        elemento = new WebDriverWait(driver, tiempo)
                .until(ExpectedConditions.
                        visibilityOfElementLocated(byElement));
        return elemento;
    }

    public boolean waitElementoVisible(WebElement elemento, int timeout) {
        Boolean isElementPresent = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            isElementPresent = elemento.isDisplayed();
            return isElementPresent ;
        }catch (TimeoutException e) {
            System.out.println("No esta visible o no existe el elemento: " + elemento);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean waitElementoClickable(WebElement elemento, int timeout) {
        Boolean isElementClicleable = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            wait.until(ExpectedConditions.elementToBeClickable(elemento));
            isElementClicleable = elemento.isDisplayed();
            return isElementClicleable ;
        }catch (TimeoutException e) {
            System.out.println("No elemento no clicleable: " + elemento);
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void ingresarTexto(WebElement elemento, String valor) {
        elemento.sendKeys(valor);
    }

    public void hacerClicElemento(WebElement elemento) {
        elemento.click();
    }

    public void moverHastaElemento(WebElement elemento){
        Actions builder = new Actions(driver);
        builder.moveToElement(elemento).build().perform();
    }

    public String textoDelElemento(WebElement elemento){
        return elemento.getText();
    }

    public void cambioDeIframe(WebElement elemento){
        driver.switchTo().frame(elemento);
    }

    public void defaultIframe(){
        driver.switchTo().defaultContent();
    }

    public void seleccionar(WebElement selectelement, String valor){
    Select select = new Select(selectelement);
        select.selectByVisibleText(valor);
    }

    public void seleccionar(By byElement, String valor){
        Select select = new Select(driver.findElement(byElement));
        select.selectByVisibleText(valor);

    }

    public void seleccionar(By byElement, int valor){
        Select selectSize = new Select(driver.findElement(byElement));
        selectSize.selectByIndex(valor);
    }
}
