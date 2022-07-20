import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        DriverSingleton driverSingleton = DriverSingleton.getInstance();
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("http://automationpractice.com");
    }
}
