package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@name='q']")
    private WebElement buscar;
    @FindBy(xpath = "//*[contains(text(),'Cuenta/ Registro')]")
    private WebElement cuentaRegistro;
    @FindBy(xpath="//*[@id='productRow']")
    private WebElement grillaproductos;
    @FindBy(xpath="//*[@id='productRow']/div[1]/div/div/div[2]/div[1]/div[1]/a")
    private WebElement nombreProducto;
    @FindBy(xpath="//*[@id='productRow']/div[1]/div/div/div[2]/div[1]/div[1]/span[2]")
    private WebElement sku;
    @FindBy(xpath="//*[@id='productRow']/div[1]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div/span[2]")
    private WebElement despachoDomicilio;
    @FindBy(xpath="//*[@id='productRow']/div[1]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div/span[2]")
    private WebElement retiroEnTienda;

    private final ArrayList<String> detallesProductos = new ArrayList<String>();

    public HomePage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean validarHome()  {
        if (!waitElementoVisible(buscar,15)) return false;
        if (!waitElementoVisible(cuentaRegistro, 15)) return false;
        return true;
    }


    public void buscarProducto(String producto) {
        String disponibleDespachoDomicilio = "False";
        String disponibleRetiroTienda = "False";
        buscar.sendKeys(producto);
        buscar.sendKeys(Keys.RETURN);
        waitElementoVisible(grillaproductos,15);
        detallesProductos.add(nombreProducto.getText());
        detallesProductos.add(sku.getText());
        if (despachoDomicilio.getText().equals("Disponible")){
            disponibleDespachoDomicilio = "True";
        }
        detallesProductos.add(disponibleDespachoDomicilio);
        if (retiroEnTienda.getText().equals("Disponible")){
            disponibleRetiroTienda = "True";
        }
        detallesProductos.add(disponibleRetiroTienda);
    }

    public ArrayList<String> getListaDetallesProductos(){
        return detallesProductos;
    }


}
