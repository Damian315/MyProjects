package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.UserDetailsAddressPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteAddressData extends BaseSeleniumTest {

    UserDetailsAddressPage userDetailsAddressPage;

    @When("^user goes to address page and delete data address$")
    public void userDeleteDataAddress(){
        userDetailsAddressPage = new UserDetailsAddressPage();
        userDetailsAddressPage.enterDeleteDetailsAddress();
    }

    @Then("^displays information message: Address successfully deleted!$")
    public void checkDeletedDataAndInformationMessage(){
        Assert.assertEquals("Address successfully deleted!", userDetailsAddressPage.getInformationMessageAddDate());
    }
}
