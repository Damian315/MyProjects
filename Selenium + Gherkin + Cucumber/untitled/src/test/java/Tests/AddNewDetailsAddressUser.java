package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class AddNewDetailsAddressUser extends BaseSeleniumTest {

    MyStoreHomePage myStoreHomePage;
    LoginPage loginPage;
    UserAccountPage userAccountPage;
    AddNewAddressPage addNewAddressPage;
    UserDetailsAddressPage userDetailsAddressPage;

    @Given("^an open browser with MySore, signUp and goes to new address$")
    public void userOpenBrowserAndGoToLoginPage(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStoreHomePage = new MyStoreHomePage();
        myStoreHomePage.enterInputSignIn();
        loginPage = new LoginPage();
        loginPage.userSignIn("test123@wp.pl", "passpass");
        userAccountPage = new UserAccountPage();
        userAccountPage.enterAddress();
    }

    @When("^user completes form new address \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
    public void userSignUpAndGoesToAddNewAddress(String alias, String address, String city,
                                                 String zipPostalCode, String phone){
        userDetailsAddressPage = new UserDetailsAddressPage();
        userDetailsAddressPage.enterAddNewAddress();
        addNewAddressPage = new AddNewAddressPage();
        addNewAddressPage.setDataNewAddress(alias, address, city, zipPostalCode, phone);
    }

    @And("save new address data")
    public void saveUserAddressDate(){
        addNewAddressPage.enterButtonSave();
    }

    @Then("displays information successfully add address data and close browser")
    public void checkoutSaveDataAndInformationMessage(){
        Assert.assertEquals("Address successfully added!", userDetailsAddressPage.getInformationMessageAddDate());
        Assert.assertEquals("Jan Kowalski", userDetailsAddressPage.getSaveDataAddress().get(0));
        Assert.assertEquals("Anielin 10", userDetailsAddressPage.getSaveDataAddress().get(1));
        Assert.assertEquals("Nowe Miasto", userDetailsAddressPage.getSaveDataAddress().get(2));
        Assert.assertEquals("PO16 7GZ", userDetailsAddressPage.getSaveDataAddress().get(3));
        Assert.assertEquals("United Kingdom", userDetailsAddressPage.getSaveDataAddress().get(4));
        Assert.assertEquals("345678901", userDetailsAddressPage.getSaveDataAddress().get(5));
        tearDown();
    }

}