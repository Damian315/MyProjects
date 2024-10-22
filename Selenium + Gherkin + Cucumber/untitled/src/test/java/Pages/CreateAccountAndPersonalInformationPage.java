package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateAccountAndPersonalInformationPage extends BaseSeleniumTest {

    public CreateAccountAndPersonalInformationPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-id_gender-1")
    WebElement inputGenderMale;

    @FindBy(id = "field-firstname")
    WebElement inputFirstName;

    @FindBy(id = "field-lastname")
    WebElement inputLastName;

    @FindBy(id = "field-email")
    WebElement inputEmail;

    @FindBy(id = "field-password")
    WebElement inputPassword;

    @FindBy(id = "field-birthday")
    WebElement inputBirthdate;

    @FindBy(name = "psgdpr")
    WebElement inputPrivacyPolicy;

    @FindBy(name = "customer_privacy")
    WebElement inputCustomerPrivacy;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSave;

    @FindBy(xpath = "(//li[@class='alert alert-danger'])[1]")
    WebElement validationMessageInputEmail;

    @FindBy(xpath = "(//li[@class='alert alert-danger'])[2]")
    WebElement validationMessageInputBirthdate;

    @FindBy(id = "field-id_gender-2")
    WebElement inputGenderFemale;

    @FindBy(name = "newsletter")
    WebElement checkboxNewsletter;

    @FindBy(xpath = "//article[@class='alert alert-success']")
    WebElement informationMessage;


    public void completedForm(String name, String surname, String password, String email,  String birthdate){
        waitUntilElementToBeVisible(By.xpath("//input[@id='field-id_gender-1']"));
        inputGenderMale.click();
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

    public void changeGenderBirthdateAndAddNewsletter(String birthdate){
        if(inputGenderMale.getAttribute("checked") == null){
            inputGenderMale.click();
        }else {
            inputGenderFemale.click();
        }
        inputBirthdate.clear();
        inputBirthdate.sendKeys(birthdate);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)");
        inputPassword.sendKeys("passpass");
        inputCustomerPrivacy.click();
        inputPrivacyPolicy.click();
        checkboxNewsletter.click();
    }

    public void enterButtonSave(){
        buttonSave.click();
    }

    public String getMessageInformation(){
        return informationMessage.getText();
    }
}
