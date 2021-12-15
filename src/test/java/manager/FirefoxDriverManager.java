package manager;


import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public void createDriver() {

        System.setProperty("webdriver.gecko.driver", "./src/test/resources/driver/geckodriver.exe");
        driver = new FirefoxDriver();
    }
}
