package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStorePage extends BaseSeleniumTest {

    public MyStorePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='user-info']//a")
    WebElement inputSignIn;

    @FindBy(xpath = "//a[@class='account']")
    WebElement inputInfoUserLogged;


    public void enterInputSignIn(){
        waitUntilElementToBeVisible(By.xpath("//div[@class='user-info']//a"));
        inputSignIn.click();
    }

    public String verificationLoggedUsers(){
        waitUntilElementToBeVisible(By.xpath("//a[@class='account']"));
       return inputInfoUserLogged.getAttribute("title");
    }
}
