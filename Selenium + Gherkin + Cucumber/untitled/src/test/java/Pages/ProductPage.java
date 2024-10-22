package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BaseSeleniumTest {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }
    

    @FindBy(xpath = "//div[@class='product-discount']//span")
    WebElement productRegularPrice;

    @FindBy(xpath = "(//ul[@class='product-flags js-product-flags']//li)[1]")
    WebElement productDiscountValue;

    @FindBy(xpath = "//select[@name='group[1]']")
    WebElement productSize;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement productQuantity;

    @FindBy(xpath = "//div[@class='add']//button")
    WebElement buttonAddToCart;

    @FindBy(xpath = "//div[@class='cart-content-btn']//a")
    WebElement buttonProceedToCheckout;

    @FindBy(xpath = "//div[@class='card cart-summary']//a")
    WebElement buttonCheckoutOnProductCart;


    public String getChosenProductFromListAndCalculateDiscount() {
        waitUntilElementToBeVisible(By.xpath("//div[@class='product-discount']//span"));
        double percentValue = Double.parseDouble(productDiscountValue.getText().substring(1, productDiscountValue.getText().length() - 1));
        double valueProduct = Double.parseDouble(productRegularPrice.getText().substring(1));
        double percent = percentValue / 100;
        double rabatValue = valueProduct * percent;
        Math.round(rabatValue);
        double discountedValue = valueProduct - rabatValue;
        return String.valueOf(discountedValue);
    }

    public void getSizeAndQuantity(String size, String quantity) {
        List<String> valueSizeProduct = new ArrayList<>();
        List<WebElement> elements = productSize.findElements(By.xpath("//select[@name='group[1]']//option"));
        for (WebElement sizeElements : elements) {
            valueSizeProduct.add(sizeElements.getAttribute("title").toString());
            if (sizeElements.getAttribute("title").equals(size)){
                driver.findElement(By.xpath("//option[@title='" + size +"']")).click();
            }
        }
        productQuantity.click();
        String valueQuantity = productQuantity.getAttribute("value");
        if (valueQuantity != null){
            for (int i = 0; i <= valueQuantity.length(); i++){
                Actions actions = new Actions(driver);
                actions.click(productQuantity);
                actions.sendKeys(productQuantity, Keys.CONTROL + "a");
                actions.sendKeys(productQuantity, Keys.DELETE).build().perform();
            }
        }
        productQuantity.sendKeys(quantity);

    }

    public void enterButtonAddCartAndProceedToCheckout(){
        waitUntilElementToBeVisible(By.xpath("//div[@class='add']//button"));
        buttonAddToCart.click();
        waitUntilElementToBeVisible(By.xpath("//div[@class='cart-content-btn']//a"));
        buttonProceedToCheckout.click();
        waitUntilElementToBeVisible(By.xpath("//div[@class='card cart-summary']//a"));
        buttonCheckoutOnProductCart.click();
    }

}

