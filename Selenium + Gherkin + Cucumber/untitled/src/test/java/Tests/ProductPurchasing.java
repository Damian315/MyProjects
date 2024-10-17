package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.LoginPage;
import Pages.MyStoreHomePage;
import Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductPurchasing extends BaseSeleniumTest {

    MyStoreHomePage myStoreHomePage;
    LoginPage loginPage;
    ProductPage productPage;

    @Given("^an open browser with MyStore and signUp$")
    public void userSignUp(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStoreHomePage = new MyStoreHomePage();
        myStoreHomePage.enterInputSignIn();
        loginPage = new LoginPage();
        loginPage.userSignIn("test123@wp.pl", "passpass");
    }

    @When("^user choose product hummingbird printed sweater and check rabat$")
    public void userChooseProductAndCheckRabat(){
        loginPage.goToHomePage();
        myStoreHomePage = new MyStoreHomePage();
        myStoreHomePage.enterProductMiniatureList();
        productPage = new ProductPage();
        productPage.getChosenProductFromListAndCalculateDiscount();
        Assert.assertEquals("28.72", productPage.getChosenProductFromListAndCalculateDiscount());

    }

}
