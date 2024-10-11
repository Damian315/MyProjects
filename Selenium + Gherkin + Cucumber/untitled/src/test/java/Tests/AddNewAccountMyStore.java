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

    @Given("an open browser with my-store-testlab")
    public void openMyStorePage(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStorePage = new MyStorePage(driver);
    }

    @When("user signUp and goes to create new account")
    public void userSignUpAndGoesToCreateNewAccount(){
        createAccountPage = new CreateAccountPage(driver);
        myStorePage.enterInputSignIn();
        myStorePage.enterInputCreateNewAccount();
    }

    @And("user completes form")
    public void userCompletesForm(){
        createAccountPage.completedForm("Jan", "Kowalski", "passpass", "01/04/1990");
    }

    @And("user save new account")
    public void userSaveNewAccount(){
        createAccountPage.saveNewAccount();
    }

    @Then("enter save sees logged user")
    public void verificationNewUserLogged(){
        Assert.assertEquals("View my customer account", myStorePage.verificationLoggedUsers());
    }

    @And("close browser")
    public void closeBrowser(){
        tearDown();
    }
}
