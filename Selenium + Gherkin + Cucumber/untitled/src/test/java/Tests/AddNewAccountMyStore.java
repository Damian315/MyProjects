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

    @Given("^an open browser and signUp$")
    public void openMyStorePage(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStoreHomePage = new MyStoreHomePage();
        myStoreHomePage.enterInputSignIn();
        loginPage = new LoginPage();
        loginPage.enterInputCreateNewAccount();
    }

    @When("^user completes form sets \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
    public void userCompletedFormAddingNewAccount(String name, String surname, String password, String birthdate){
        createAccountPage = new CreateAccountAndPersonalInformationPage();
        createAccountPage.completedForm(name, surname, password, generateUniqueEmailAddress(), birthdate);
    }

    @And("^user save new account$")
    public void userSaveNewAccount(){
        createAccountPage.saveNewAccount();
    }

    @Then("^user has logged in MyStore$")
    public void verificationNewUserLogged(){
        Assert.assertEquals("View my customer account", myStoreHomePage.verificationLoggedUsers());
    }

    @And("^close browser$")
    public void closeBrowser(){
        tearDown();
    }
}
