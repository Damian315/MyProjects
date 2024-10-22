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

    @Given("^user is logged in to CodersLab shop$")
    public void userLoginInToMyStore(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStoreHomePage = new MyStoreHomePage();
        myStoreHomePage.enterInputSignIn();
        loginPage = new LoginPage();
        loginPage.userSignIn("test123@wp.pl", "passpass");
    }

    @When("^user go to UserInformationPage$")
    public void userGoTOUserInformationPage(){
        userAccountPage = new UserAccountPage();
        userAccountPage.enterUserInformation();
    }

    @And("^user change date account$")
    public void userChangeAccountPersonalInformation(){
        createAccountAndPersonalInformationPage = new CreateAccountAndPersonalInformationPage();
        createAccountAndPersonalInformationPage.changeGenderBirthdateAndAddNewsletter("06/12/1990");
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
