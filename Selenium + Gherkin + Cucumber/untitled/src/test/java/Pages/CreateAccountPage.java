package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//input[@id='psgdpr']")
    WebElement inputPrivacyPolicy;

    public void completedForm(){
        waitUntilElementToBeVisible(By.xpath("//input[@id='field-id_gender-1']"));
        inputGender.click();
        inputFirstName.sendKeys("Jan");
        inputLastName.sendKeys("Kowalski");
        inputEmail.sendKeys("test@wp.pl");
        inputPassword.sendKeys("test");
        inputBirthdate.sendKeys("01.04.1990");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)");
        //Actions action = new Actions(driver);
        //action.moveToElement(inputPrivacyPolicy).click().perform();
        //js.executeScript("arguments[0].scrollIntoView();", inputPrivacyPolicy);
        inputPrivacyPolicy.click();

    }

}
