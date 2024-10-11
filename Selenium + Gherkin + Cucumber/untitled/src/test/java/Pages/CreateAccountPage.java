package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class CreateAccountPage extends BaseSeleniumTest {

    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='field-id_gender-1']")
    WebElement inputGender;

    @FindBy(xpath = "//input[@id='field-firstname']")
    WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='field-lastname']")
    WebElement inputLastName;

    @FindBy(xpath = "//input[@id='field-email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='field-password']")
    WebElement inputPassword;

    @FindBy(xpath = "//input[@id='field-birthday']")
    WebElement inputBirthdate;

    @FindBy(xpath = "//input[@name='psgdpr']")
    WebElement inputPrivacyPolicy;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    WebElement inputCustomerPrivacy;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSave;

    public void completedForm(){
        waitUntilElementToBeVisible(By.xpath("//input[@id='field-id_gender-1']"));
        inputGender.click();
        inputFirstName.sendKeys("Jan");
        inputLastName.sendKeys("Kowalski");
        Random number = new Random();
        int random = number.nextInt(101);
        inputEmail.sendKeys("test" + random + "@wp.pl");
        inputPassword.sendKeys("passpass");
        inputBirthdate.sendKeys("01/04/1990");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)");
        inputPrivacyPolicy.click();
        inputCustomerPrivacy.click();
    }

    public void saveNewAccount(){
        buttonSave.click();
    }
}
