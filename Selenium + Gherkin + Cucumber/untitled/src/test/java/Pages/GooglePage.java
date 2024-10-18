package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BaseSeleniumTest {

    public GooglePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    WebElement textarea;

    @FindBy(xpath = "(//button//div[@role='none'])[4]")
    WebElement buttonCookieAcceptance;

    @FindBy(xpath = "//div[@data-attrid= 'subtitle']//span")
    WebElement subtitleInformation;

    public void enterTextareaSearchGoogle(String text){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        waitUntilElementToBeVisible(By.xpath("(//button[@role='link'])[2]"));
        buttonCookieAcceptance.click();
        executor.executeScript("arguments[0].click();", textarea);
        textarea.sendKeys(text);
        textarea.sendKeys(Keys.ENTER);
    }

    public String getSearchingInformationSubtitle(){
        return subtitleInformation.getText();
    }

}
