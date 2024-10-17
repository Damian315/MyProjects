package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.CreateAccountAndPersonalInformationPage;
import Pages.LoginPage;
import Pages.MyStoreHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddNewAccountMyStore extends BaseSeleniumTest {

    MyStoreHomePage myStoreHomePage;
    CreateAccountAndPersonalInformationPage createAccountPage;
    LoginPage loginPage;

    @Given("an open browser with my-store-testlab")
    public void openMyStorePage(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("user signUp and goes to create new account")
    public void userSignUpAndGoesToCreateNewAccount(){
        myStoreHomePage = new MyStoreHomePage();
        myStoreHomePage.enterInputSignIn();
        loginPage = new LoginPage();
        loginPage.enterInputCreateNewAccount();
    }

    @And("user completes form")
    public void userCompletesForm(){
        createAccountPage = new CreateAccountAndPersonalInformationPage();
        createAccountPage.completedForm("Jan", "Kowalski",
                "passpass", generateUniqueEmailAddress(), "01/04/1990");
    }

    @And("user save new account")
    public void userSaveNewAccount(){
        createAccountPage.saveNewAccount();
    }

    @Then("user has logged in MyStore")
    public void verificationNewUserLogged(){
        Assert.assertEquals("View my customer account", myStoreHomePage.verificationLoggedUsers());
    }

    @And("close browser")
    public void closeBrowser(){
        tearDown();
    }
}
