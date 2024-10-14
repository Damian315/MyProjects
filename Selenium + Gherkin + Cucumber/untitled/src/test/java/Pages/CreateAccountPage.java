package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "(//li[@class='alert alert-danger'])[1]")
    WebElement validationMessageInputEmail;

    @FindBy(xpath = "(//li[@class='alert alert-danger'])[2]")
    WebElement validationMessageInputBirthdate;

    public void completedForm(String name, String surname, String password, String email,  String birthdate){
        waitUntilElementToBeVisible(By.xpath("//input[@id='field-id_gender-1']"));
        inputGender.click();
        inputFirstName.sendKeys(name);
        inputLastName.sendKeys(surname);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        inputBirthdate.sendKeys(birthdate);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)");
        inputPrivacyPolicy.click();
        inputCustomerPrivacy.click();
    }

    public void saveNewAccount(){
        buttonSave.click();
    }

    public String[] validationEmail(){
        waitUntilElementToBeVisible(By.xpath("(//li[@class='alert alert-danger'])[1]"));
        String[] arrayMessage = new String[2];
        arrayMessage[0] = validationMessageInputEmail.getText();
        arrayMessage[1] = validationMessageInputBirthdate.getText();
        return arrayMessage;
    }
}
