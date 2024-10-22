package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.CreateAccountAndPersonalInformationPage;
import Pages.LoginPage;
import Pages.MyStoreHomePage;
import Pages.UserAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UpdateUserInformationMyStore extends BaseSeleniumTest {

    MyStoreHomePage myStoreHomePage;
    LoginPage loginPage;
    UserAccountPage userAccountPage;
    CreateAccountAndPersonalInformationPage createAccountAndPersonalInformationPage;

    @Given("^user signUp and goes to information account page$")
    public void userSignUpAndGoesToInformationAccountPage(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStoreHomePage = new MyStoreHomePage();
        myStoreHomePage.enterInputSignIn();
        loginPage = new LoginPage();
        loginPage.userSignIn("test123@wp.pl", "passpass");
        userAccountPage = new UserAccountPage();
        userAccountPage.enterUserInformation();
    }

    @When("^user change account data$")
    public void userChangeAccountData(){
        createAccountAndPersonalInformationPage = new CreateAccountAndPersonalInformationPage();
        createAccountAndPersonalInformationPage.changeGenderBirthdateAndAddNewsletter();
    }

    @And("^user saves information$")
    public void userSavesUpdateInformation(){
        createAccountAndPersonalInformationPage.enterButtonSave();
    }

    @Then("^user sees message Information successfully updated and close browser$")
    public void userSeesMessageInformation(){
        Assert.assertEquals("Information successfully updated.", createAccountAndPersonalInformationPage.getMessageInformation());
        tearDown();
    }
}
