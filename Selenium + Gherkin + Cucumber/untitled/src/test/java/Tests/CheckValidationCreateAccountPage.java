package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.CreateAccountAndPersonalInformationPage;
import Pages.LoginPage;
import Pages.MyStorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class CheckValidationCreateAccountPage extends BaseSeleniumTest {

    MyStorePage myStorePage;
    CreateAccountAndPersonalInformationPage createAccountPage;
    LoginPage loginPage;

    @Given("^an open browser with my-store$")
    public void openMyStore(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

    }

    @When("^user signUp and goes to page create new account$")
    public void userSignUpAndGoesToPageCreateNeAccount(){
        myStorePage = new MyStorePage();
        myStorePage.enterInputSignIn();
        loginPage = new LoginPage();
        loginPage.enterInputCreateNewAccount();
    }

    @And("^user completes form with incorrect date email and birthdate$")
    public void userCompletesFormWithoutBirthdate(){
        createAccountPage = new CreateAccountAndPersonalInformationPage();
        createAccountPage.completedForm("Jan", "Kowalski",
                "passpass", "test123@wp.pl", "01311999");
    }

    @And("^user click save button$")
    public void userClickSaveButton(){
        createAccountPage.saveNewAccount();
    }

    @Then("^user sees validation message and close browser$")
    public void checkValidationMessageInputBirthdateAndEmail(){
        Assert.assertEquals("The email is already used, please choose another one or sign in",createAccountPage.validationEmail()[0]);
        Assert.assertEquals("Format should be 05/31/1970.", createAccountPage.validationEmail()[1]);
        tearDown();
    }

}
