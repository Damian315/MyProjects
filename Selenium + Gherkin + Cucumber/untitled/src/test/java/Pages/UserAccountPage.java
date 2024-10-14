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

    public void enterUserInformation(){
        waitUntilElementToBeVisible(By.xpath("//a[@id='identity-link']"));
        userInformationLink.click();
    }
}
