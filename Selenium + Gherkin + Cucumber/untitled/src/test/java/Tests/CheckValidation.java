package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.CreateAccountPage;
import Pages.MyStorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckValidation extends BaseSeleniumTest {

    MyStorePage myStorePage;

    @Given("an open browser with my-store")
    public void openMyStore(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStorePage = new MyStorePage(driver);

    }

    @When("user signUp and goes to page create new account")
    public void userSignUpAndGoesToPageCreateNeAccount(){
        myStorePage.enterInputSignIn();
        myStorePage.enterInputCreateNewAccount();
    }

    @And("user completes form without birthdate")
    public void userCompletesFormWithoutBirthdate(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.completedForm("Jan", "Kowalski",
                "passpass", " ", " ");
    }

//    @And("user click save button")
//    public void userClickSaveButton(){
        //createAccountPage.saveNewAccount();
//    }
}
