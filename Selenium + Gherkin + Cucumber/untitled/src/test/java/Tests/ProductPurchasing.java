package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Pages.LoginPage;
import Pages.MyStoreHomePage;
import Pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductPurchasing extends BaseSeleniumTest {

    MyStoreHomePage myStoreHomePage;
    LoginPage loginPage;
    ProductPage productPage;

    @Given("^an open browser with MyStore, signUp, choose product and check rabat$")
    public void userSignUpChooseProductAndCheckRabat(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        myStoreHomePage = new MyStoreHomePage();
        myStoreHomePage.enterInputSignIn();
        loginPage = new LoginPage();
        loginPage.userSignIn("test123@wp.pl", "passpass");
        loginPage.goToHomePage();
        myStoreHomePage = new MyStoreHomePage();
        myStoreHomePage.enterProductMiniatureList();
        productPage = new ProductPage();
        productPage.getChosenProductFromListAndCalculateDiscount();
        Assert.assertEquals("28.72", productPage.getChosenProductFromListAndCalculateDiscount());
    }


    @When("^user choose product size \"(.*)\" and quantity \"(.*)\"$")
    public void userChooseProductSizeAndQuantity(String size, String quantity){
        productPage.getSizeAndQuantity(size, quantity);
    }
}
