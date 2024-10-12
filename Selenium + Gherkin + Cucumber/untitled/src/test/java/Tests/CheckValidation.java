package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.CreateAccountPage;
import Pages.MyStorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CheckValidation extends BaseSeleniumTest {

    MyStorePage myStorePage;
    CreateAccountPage createAccountPage;

    @Given("an open browser with my-store")
    public void openMyStore(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStorePage = new MyStorePage(driver);
    }

    @When("user signUp and goes to page create new account")
    public void userSignUpAndGoesToPageCreateNeAccount(){
        createAccountPage = new CreateAccountPage(driver);
        myStorePage.enterInputSignIn();
        myStorePage.enterInputCreateNewAccount();
    }

    @And("user completes form without birthdate")
    public void userCompletesFormWithoutBirthdate(){
        //createAccountPage.completedForm("Jan", "Kowalski", "passpass", " ");
    }

    @And("user click save button")
    public void userClickSaveButton(){
        createAccountPage.saveNewAccount();
    }
}
