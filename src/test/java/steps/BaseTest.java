package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class BaseTest {
    private WebDriver driver = Hooks.getDriver();
    protected HomePage homePage = new HomePage(driver);
}
