package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.CreateAccountAndPersonalInformationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class CheckValidationCreateAccountPage extends BaseSeleniumTest {

    CreateAccountAndPersonalInformationPage createAccountPage;

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
