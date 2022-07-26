import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import drivers.DriverSingleton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;
import utils.Constants;
import utils.FrameworkProperties;
import utils.Log;

import static org.junit.Assert.assertEquals;

public class Tests {

    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SignInPage signInPage;
    static CheckoutPage checkoutPage;
    static ExtentTest test;
    static ExtentReports report = new ExtentReports("report/TestReport.html");

    @BeforeClass
    public static void initializeObjects(){
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        signInPage = new SignInPage();
        checkoutPage = new CheckoutPage();
        test = report.startTest("Tests");
        Log.getLogData(Log.class.getName());
        Log.startTest("Tests");
    }

    @Test
    @DisplayName("Should authenticate a user")
    public void testingAuthentication(){
        driver.get(Constants.URL);
        Log.info("Navigating to " + Constants.URL);
        homePage.clickSignIn();
        signInPage.login(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));
        assertEquals(frameworkProperties.getProperty(Constants.USERNAME), homePage.getUsername());
        test.log(LogStatus.PASS, "User successfully authenticated");
    }

    @Test
    @DisplayName("Should add two products to the cart")
    public void testingAddingItemsToCart(){
        driver.get(Constants.URL);
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();
        assertEquals(Constants.CART_SUMMARY, checkoutPage.getSummaryForProducts());
    }

    @Test
    @DisplayName("Should walkthrough the entire buying process")
    public void testingTheEntireBuyingProcess(){
        driver.get(Constants.URL);
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();
        checkoutPage.goToCheckout();
        checkoutPage.confirmAddress();
        checkoutPage.confirmShipping();
        checkoutPage.payByBankWire();
        checkoutPage.confirmFinalOrder();
        assertEquals(true, checkoutPage.checkFinalStatus());
    }

    @AfterClass
    public static void closeObjects(){
        report.endTest(test);
        report.flush();
        driver.close();
    }
}
