import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("http://automationpractice.com");

        HomePage homePage = new HomePage();
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();
    }
}
