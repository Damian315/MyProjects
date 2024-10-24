package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage extends BaseSeleniumTest {

    public UserAccountPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='identity-link']")
    WebElement userInformationLink;

    @FindBy(xpath = "//a[@id='addresses-link']")
    WebElement userAddNewAddress;

    @FindBy(xpath = "//a[@id='history-link']")
    WebElement userOrderHistoryAndDetails;

    public void enterUserInformation(){
        waitUntilElementToBeVisible(By.xpath("//a[@id='identity-link']"));
        userInformationLink.click();
    }

    public void enterAddress(){
        waitUntilElementToBeVisible(By.xpath("//a[@id='addresses-link']"));
        userAddNewAddress.click();
    }

    public void enterUserOrderHistoryAndDetails(){
        waitUntilElementToBeVisible(By.xpath("//a[@id='history-link']"));
        userOrderHistoryAndDetails.click();
    }

}
