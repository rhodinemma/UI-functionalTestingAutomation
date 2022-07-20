package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "head > title")
    private WebElement pageTitle;

    @FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")
    private WebElement checkoutButtonSummary;

    @FindBy(css ="#center_column > form > p > button > span")
    private WebElement checkoutButtonConfirmAddress;

    @FindBy(id = "cgv")
    private WebElement confirmShippingCheckbox;

    @FindBy(css = "#form > p > button > span")
    private WebElement checkoutButtonConfirmShipping;

    @FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
    private WebElement payByBankWireOption;

    @FindBy(css = "#cart_navigation > button > span")
    private WebElement confirmOrder;

    @FindBy(css = "#center_column > div > p > strong")
    private WebElement orderConfirmationMessage;

    public Boolean checkTitle(String title){
        return pageTitle.getText().equals(title);
    }

    public void goToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT
        ));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonSummary));
        checkoutButtonSummary.click();
    }

    public void confirmAddress(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT
        ));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonConfirmAddress));
        checkoutButtonConfirmAddress.click();
    }

    public void confirmShipping(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT
        ));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonConfirmShipping));
        confirmShippingCheckbox.click();
        checkoutButtonConfirmShipping.click();
    }

    public void payByBankWire(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT
        ));
        wait.until(ExpectedConditions.elementToBeClickable(payByBankWireOption));
        payByBankWireOption.click();
    }

    public void confirmFinalOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT
        ));
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
        confirmOrder.click();
    }

    public Boolean checkFinalStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT
        ));
        wait.until(ExpectedConditions.elementToBeClickable(orderConfirmationMessage));
        return orderConfirmationMessage.getText().contains(Constants.COMPLETE_ORDER);
    }
}
