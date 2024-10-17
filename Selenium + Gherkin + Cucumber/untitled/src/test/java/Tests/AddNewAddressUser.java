package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.*;
import io.cucumber.java.an.Y;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class AddNewAddressUser extends BaseSeleniumTest {

    MyStorePage myStorePage;
    LoginPage loginPage;
    UserAccountPage userAccountPage;
    AddNewAddressPage addNewAddressPage;
    YourAddressPage yourAddressPage;

    @Given("^an open browser with MySore, signUp and goes to new address$")
    public void userOpenBrowserAndGoToLoginPage(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStorePage = new MyStorePage();
        myStorePage.enterInputSignIn();
        loginPage = new LoginPage();
        loginPage.userSignIn("test123@wp.pl", "passpass");
        userAccountPage = new UserAccountPage();
        userAccountPage.enterAddress();
        yourAddressPage = new YourAddressPage();
        yourAddressPage.enterAddNewAddress();
    }

    @When("^user completes form new address \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
    public void userSignUpAndGoesToAddNewAddress(String alias, String address, String city,
                                                 String zipPostalCode, String phone){
        addNewAddressPage = new AddNewAddressPage();
        addNewAddressPage.setDataNewAddress(alias, address, city, zipPostalCode, phone);
    }

    @And("save new address data")
    public void saveUserAddressDate(){
        addNewAddressPage.enterButtonSave();
    }

    @Then("displays information successfully add address data and close browser")
    public void checkoutSaveDataAndInformationMessage(){
        Assert.assertEquals("Address successfully added!", addNewAddressPage.getInformationSuccessfullyAddDate());
        Assert.assertEquals("Jan Kowalski", addNewAddressPage.getSaveDataAddress().get(0));
        Assert.assertEquals("Anielin 10", addNewAddressPage.getSaveDataAddress().get(1));
        Assert.assertEquals("Nowe Miasto", addNewAddressPage.getSaveDataAddress().get(2));
        Assert.assertEquals("PO16 7GZ", addNewAddressPage.getSaveDataAddress().get(3));
        Assert.assertEquals("United Kingdom", addNewAddressPage.getSaveDataAddress().get(4));
        Assert.assertEquals("345678901", addNewAddressPage.getSaveDataAddress().get(5));
        tearDown();
    }

}