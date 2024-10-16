package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressPage extends BaseSeleniumTest {

    public YourAddressPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='addresses-footer']/a")
    WebElement inputAddNewAddress;

    public void enterAddNewAddress(){
        waitUntilElementToBeVisible(By.xpath("//div[@class='addresses-footer']/a"));
        inputAddNewAddress.click();
    }
}
