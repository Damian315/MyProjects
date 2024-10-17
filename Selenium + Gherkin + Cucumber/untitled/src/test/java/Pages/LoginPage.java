package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumTest {

public LoginPage(){
    PageFactory.initElements(driver, this);
}

    @FindBy(xpath = "//div[@class='no-account']/a")
    WebElement inputCreateNew;

    @FindBy(xpath = "//input[@id='field-email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='field-password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@id='submit-login']")
    WebElement buttonSignIn;

    @FindBy(xpath = "//div[@id='_desktop_logo']//a")
    WebElement logoMyStore;

    public void enterInputCreateNewAccount(){
        waitUntilElementToBeVisible(By.xpath("//div[@class='no-account']/a"));
        inputCreateNew.click();
    }

    public void userSignIn(String email, String password){
        waitUntilElementToBeVisible(By.xpath("//input[@id='field-password']"));
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonSignIn.click();
    }

    public void goToHomePage(){
        logoMyStore.click();
    }

}
