package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class GoogleSearch extends BaseSeleniumTest {

    GooglePage googlePage;

    @Given("an open browser with google.com")
    public void googleSearch(){
        setUp();
        driver.get("https://www.google.com/");
    }

    @When("a keyword Korn is entered in input field")
    public void enterKeyword(){
        googlePage = new GooglePage();
        googlePage.enterTextareaSearchGoogle("Korn");
    }

    @Then("the first one should contain Korn")
    public void theFirstOneShouldContainsKeyword(){
        Assert.assertEquals("Zespół muzyczny", googlePage.getSearchingInformationSubtitle());

    }
    @And("^close browser&")
    public void closeBrowser(){
        tearDown();
    }


}
