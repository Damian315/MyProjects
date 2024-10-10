package Tests;

import BaseSeleniumTest.BaseSeleniumTest;
import io.cucumber.java.en.Given;

public class AddNewAccountMyStore extends BaseSeleniumTest {

    @Given("an open browser with my-store-testlab, and sign up")
    public void myStorePage(){
        setUp();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }
}
