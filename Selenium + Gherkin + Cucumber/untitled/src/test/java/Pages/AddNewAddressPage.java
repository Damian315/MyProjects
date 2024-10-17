package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class AddNewAddressPage extends BaseSeleniumTest {

    public AddNewAddressPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='field-alias']")
    WebElement inputAlias;

    @FindBy(xpath = "//input[@id='field-address1']")
    WebElement inputAddress;

    @FindBy(xpath = "//input[@id='field-city']")
    WebElement inputCity;

    @FindBy(xpath = "//input[@id='field-postcode']")
    WebElement inputZipPostalCode;

    @FindBy(xpath = "//input[@id='field-phone']")
    WebElement inputPhone;

    @FindBy(xpath = "//select[@id='field-id_country']")
    WebElement inputCountry;

    @FindBy(xpath = "//select[@id='field-id_country']/option[2]")
    WebElement selectCountry;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSave;

    @FindBy(xpath = "//article[@class='alert alert-success']//ul/li")
    WebElement messageInformation;

    @FindBy(xpath = "(//address)[2]")
    WebElement articleData;

    public void setDataNewAddress(String alias, String address, String city, String zipPostalCode, String phone) {
        inputAlias.sendKeys(alias);
        inputAddress.sendKeys(address);
        inputCity.sendKeys(city);
        inputZipPostalCode.sendKeys(zipPostalCode);
        inputPhone.sendKeys(phone);
        inputCountry.click();
        selectCountry.click();
    }

    public void enterButtonSave() {
        buttonSave.click();
    }

    public String getInformationSuccessfullyAddDate() {
        return messageInformation.getText();
    }

    public List<String> getSaveDataAddress(){
        String[] splitOneLine = articleData.getText().split("\\R");
        List<String> result = Arrays.stream(splitOneLine).collect(Collectors.toList());
        System.out.println("String array value " + result);
    return result;
    }


}
