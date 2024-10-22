package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.CreateAccountAndPersonalInformationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class CheckValidationCreateAccountPage extends BaseSeleniumTest {

    CreateAccountAndPersonalInformationPage createAccountPage;

    @When("^user completes form sets \"(.*)\", \"(.*)\", \"(.*)\" with incorrect date email \"(.*)\" and birthdate \"(.*)\"$")
    public void userCompletesFormIncorrectEmailAndBirthdate(String name, String surname, String password,
                                                            String email, String birthdate){
        createAccountPage = new CreateAccountAndPersonalInformationPage();
        createAccountPage.completedForm(name, surname, password, email, birthdate);
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
