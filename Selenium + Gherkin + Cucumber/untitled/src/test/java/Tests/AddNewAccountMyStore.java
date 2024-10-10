package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.CreateAccountPage;
import Pages.MyStorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddNewAccountMyStore extends BaseSeleniumTest {

    MyStorePage myStorePage;
    CreateAccountPage createAccountPage;

    @Given("an open browser with my-store-testlab, and sign up")
    public void myStorePage(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("User goes to create new account")
    public void goToCreateNewAccountPage(){
        myStorePage = new MyStorePage(driver);
        myStorePage.enterInputSignIn();
        myStorePage.enterInputCreateNewAccount();
    }

    @And("User completes form")
    public void userCompletedForm(){
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage.completedForm();
    }

    @And("User save new account")
    public void saveNewAccount(){
        createAccountPage.saveNewAccount();
    }

    @Then("Enter save sees logged user")
    public void verificationNewUserLogged(){
        Assert.assertEquals("View my customer account", myStorePage.verificationLoggedUsers());
    }

    @And("close browser")
    public void closeBrowser(){
        tearDown();
    }
}
