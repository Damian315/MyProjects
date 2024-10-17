package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsAddressPage extends BaseSeleniumTest {

    public UserDetailsAddressPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='addresses-footer']/a")
    WebElement inputAddNewAddress;

    @FindBy(xpath = "(//a[@data-link-action='delete-address'])[2]")
    WebElement inputDeleteDetailsAddress;

    @FindBy(xpath = "//article[@class='alert alert-success']//ul/li")
    WebElement messageInformation;

    @FindBy(xpath = "(//address)[2]")
    WebElement articleData;

    public void enterAddNewAddress(){
        waitUntilElementToBeVisible(By.xpath("//div[@class='addresses-footer']/a"));
        inputAddNewAddress.click();
    }

    public void enterDeleteDetailsAddress(){
        waitUntilElementToBeVisible(By.xpath("(//a[@data-link-action='delete-address'])[2]"));
        inputDeleteDetailsAddress.click();
    }

    public String getInformationMessageAddDate() {
        return messageInformation.getText();
    }

    public List<String> getSaveDataAddress(){
        String[] splitOneLine = articleData.getText().split("\\R");
        List<String> result = Arrays.stream(splitOneLine).collect(Collectors.toList());
        System.out.println("String array value " + result);
        return result;
    }

    public void checkDeletedData(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(6000));
        if (wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//address)[2]")))){
            System.out.println("Data has deleted");
        }else {
            System.out.println("Data has not deleted");
        }
    }

}
