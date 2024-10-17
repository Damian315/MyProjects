package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreHomePage extends BaseSeleniumTest {

    public MyStoreHomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='user-info']//a")
    WebElement inputSignIn;

    @FindBy(xpath = "//a[@class='account']")
    WebElement inputInfoUserLogged;

    @FindBy(xpath = "//article[@data-id-product='2']")
    WebElement productMiniatureList;

    public void enterInputSignIn(){
        waitUntilElementToBeVisible(By.xpath("//div[@class='user-info']//a"));
        inputSignIn.click();
    }

    public String verificationLoggedUsers(){
        waitUntilElementToBeVisible(By.xpath("//a[@class='account']"));
       return inputInfoUserLogged.getAttribute("title");
    }

    public void enterProductMiniatureList(){
        waitUntilElementToBeVisible(By.xpath("//article[@data-id-product='2']"));
        productMiniatureList.click();
    }

}
