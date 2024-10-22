package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddNewAddressPage extends BaseSeleniumTest {

    public AddNewAddressPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-alias")
    WebElement inputAlias;

    @FindBy(id = "field-address1")
    WebElement inputAddress;

    @FindBy(id = "field-city")
    WebElement inputCity;

    @FindBy(id = "field-postcode")
    WebElement inputZipPostalCode;

    @FindBy(id = "field-phone")
    WebElement inputPhone;

    @FindBy(id = "field-id_country")
    WebElement inputCountry;

    @FindBy(xpath = "//select[@id='field-id_country']/option[2]")
    WebElement selectCountry;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSave;

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

}
