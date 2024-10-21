package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseSeleniumTest {

    public OrderPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@name='confirm-addresses']")
    WebElement buttonConfirmAddress;

    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    WebElement buttonConfirmDeliveryOption;

    @FindBy(xpath = "//input[@id='payment-option-1']")
    WebElement checkboxPayByCheck;

    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]']")
    WebElement checkboxTermsOfService;

    @FindBy(xpath = "//div[@id='payment-confirmation']//button")
    WebElement buttonPlaceOrder;


    public void enterButtonConfirmAddressDeliveryOption(){
        waitUntilElementToBeVisible(By.xpath("//button[@name='confirm-addresses']"));
        buttonConfirmAddress.click();
        buttonConfirmDeliveryOption.click();
    }

    public void enterCheckboxPayByCheck(){
        checkboxPayByCheck.click();
    }

    public void enterTermsOfService(){
        checkboxTermsOfService.click();
    }

    public void enterButtonPlaceOrder(){
        buttonPlaceOrder.click();
    }
}
