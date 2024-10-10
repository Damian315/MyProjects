package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStorePage extends BaseSeleniumTest {

    public MyStorePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='user-info']//a")
    WebElement inputSignIn;

    @FindBy(xpath = "//div[@class='no-account']/a")
    WebElement inputCreateNew;

    public void enterInputSignIn(){
        waitUntilElementToBeVisible(By.xpath("//div[@class='user-info']//a"));
        inputSignIn.click();
    }

    public void enterInputCreateNewAccount(){
     waitUntilElementToBeVisible(By.xpath("//div[@class='no-account']/a"));
     inputCreateNew.click();
    }
}
