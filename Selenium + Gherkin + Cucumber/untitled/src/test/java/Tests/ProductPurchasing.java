package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import Helpers.SeleniumHelper;
import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class ProductPurchasing extends BaseSeleniumTest {

    MyStoreHomePage myStoreHomePage;
    LoginPage loginPage;
    ProductPage productPage;
    OrderPage orderPage;
    ConfirmedOrderPage confirmedOrderPage;
    UserAccountPage userAccountPage;
    OrderHistoryPage orderHistoryPage;

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

    @And("^user adds product to the cart and goes to checkout$")
    public void userAddToCartProduct(){
        productPage.enterButtonAddCartAndProceedToCheckout();
    }

    @And("^user confirm address, delivery option and payments type$")
    public void userConfirmDataAddressDeliveryAndPaymentType(){
        orderPage = new OrderPage();
        orderPage.enterButtonConfirmAddressDeliveryOption();
        orderPage.enterCheckboxPayByCheck();
        orderPage.enterTermsOfService();
    }

    @And("^user enter button place order$")
    public void userPlaceOrder(){
        orderPage.enterButtonPlaceOrder();
    }

    @Then("^user sees confirmed order, check quantity \"(.*)\", order history and close browser$")
    public void userSeesDataConfirmedOrderAndCheckOrderHistory(String quantity) throws IOException {
        confirmedOrderPage = new ConfirmedOrderPage();
        SeleniumHelper.takeScreenShot(driver);
        Assert.assertEquals("YOUR ORDER IS CONFIRMED", confirmedOrderPage.informationMessage());
        Assert.assertEquals(quantity, confirmedOrderPage.orderItems().get(1));
        String orderReference = confirmedOrderPage.numberOrderReference();
        String totalPrice = confirmedOrderPage.orderItems().get(2);
        myStoreHomePage.enterUserAccount();
        userAccountPage = new UserAccountPage();
        userAccountPage.enterUserOrderHistoryAndDetails();
        orderHistoryPage = new OrderHistoryPage();
        Assert.assertEquals(orderReference, orderHistoryPage.getOrderReferenceInHistory());
        Assert.assertEquals("Awaiting check payment", orderHistoryPage.orderHistoryData().get(3));
        Assert.assertEquals(totalPrice, orderHistoryPage.orderHistoryData().get(1));
        tearDown();
    }
}
