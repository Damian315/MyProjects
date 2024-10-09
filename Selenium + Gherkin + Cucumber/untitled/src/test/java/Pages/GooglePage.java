package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BaseSeleniumTest {

    public GooglePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@name='q']")
    WebElement textarea;

    public void enterTextareaSearchGoogle(String text){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", textarea);
        textarea.sendKeys(text);
    }

}
