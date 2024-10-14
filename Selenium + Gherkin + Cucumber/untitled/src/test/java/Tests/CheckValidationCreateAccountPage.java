package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.CreateAccountPage;
import Pages.MyStorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckValidationCreateAccountPage extends BaseSeleniumTest {

    MyStorePage myStorePage;
    CreateAccountPage createAccountPage;

    @Given("^an open browser with my-store$")
    public void openMyStore(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStorePage = new MyStorePage(driver);

    }

    @When("^user signUp and goes to page create new account$")
    public void userSignUpAndGoesToPageCreateNeAccount(){
        myStorePage.enterInputSignIn();
        myStorePage.enterInputCreateNewAccount();
    }

    @And("^user completes form with incorrect date email and birthdate$")
    public void userCompletesFormWithoutBirthdate(){
        createAccountPage = new CreateAccountPage(driver);
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
