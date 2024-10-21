package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.substring;

public class ConfirmedOrderPage extends BaseSeleniumTest {

    public ConfirmedOrderPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[@class='h1 card-title']")
    WebElement informationMessageOrder;

    @FindBy(xpath = "//div[@class='order-confirmation-table']/div/div[3]")
    WebElement orderItems;

    @FindBy(xpath = "//div[@id='order-details']//ul/li[1]")
    WebElement orderDetails;

    public String informationMessage(){
        String message = informationMessageOrder.getText().substring(1);
        return message;
    }

    public List<String> orderItems(){
        List<String> elementsOrder = new ArrayList<>();
        List<WebElement> elementsProductOrder = orderItems.findElements(By.xpath("//div[@class='order-confirmation-table']/div/div/div/div"));
        for (WebElement elements : elementsProductOrder){
            elementsOrder.add(elements.getText());
        }
        return elementsOrder;
    }



}
