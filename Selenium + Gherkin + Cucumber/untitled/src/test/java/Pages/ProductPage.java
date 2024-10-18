package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseSeleniumTest {

    public ProductPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='product-discount']//span")
    WebElement productRegularPrice;

    @FindBy(xpath = "(//ul[@class='product-flags js-product-flags']//li)[1]")
    WebElement productDiscountValue;


    public String getChosenProductFromListAndCalculateDiscount(){
        waitUntilElementToBeVisible(By.xpath("//div[@class='product-discount']//span"));
        double percentValue = Double.parseDouble(productDiscountValue.getText().substring(1, productDiscountValue.getText().length() - 1));
        double valueProduct = Double.parseDouble(productRegularPrice.getText().substring(1));
        double percent = percentValue/ 100;
        double rabatValue = valueProduct * percent;
        Math.round(rabatValue);
        double discountedValue = valueProduct - rabatValue;
        return String.valueOf(discountedValue);
    }
}
