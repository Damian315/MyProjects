package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;


public class GoogleSearch extends BaseSeleniumTest {

    protected WebDriver driver;
    protected Map<String, Object> vars;
    JavascriptExecutor js;


    @Given("an open browser with google.com")
    public void googleSearch(){
        setUp();
        driver.get("https://www.google.com/");
    }
    @When("a keyword (.*) in entered in input filed")
    public void enterKeyword(){
        GooglePage googlePage = new GooglePage(driver);
        googlePage.enterTextareaSearchGoogle("test");
    }

    @Then("the first one should contains (*)")
    public void theFirstOneShouldContainsKeyword(String expectedText){
        System.out.println(expectedText);
    }
    @And("close browser")
    public void closeBrowser(){
        tearDown();
    }


}
