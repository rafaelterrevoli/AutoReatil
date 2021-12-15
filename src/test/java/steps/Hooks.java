package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import manager.DriverManager;
import manager.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import java.io.FileNotFoundException;
import static util.LeerProperty.leerProperties;

public class Hooks {

    private static WebDriver driver;
    private DriverManager driverManager;

    @Before
    public void setUp() throws FileNotFoundException {
        String url = leerProperties().getProperty("url");
        String navegador = leerProperties().getProperty("navegador").toLowerCase();
        driverManager = DriverManagerFactory.getManager(navegador);
        driver = driverManager.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @After
    public void quitDriver(){
        driverManager.quitDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
