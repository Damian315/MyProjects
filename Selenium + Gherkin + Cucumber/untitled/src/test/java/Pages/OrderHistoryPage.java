package Pages;

import BaseSeleniumTest.BaseSeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryPage extends BaseSeleniumTest {

    public OrderHistoryPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id='content']//table")
    WebElement orderDataTable;

    @FindBy(xpath = "(//th[@scope='row'])[1]")
    WebElement orderHistoryReference;

    public List<String> orderHistoryData(){
        waitUntilElementToBeVisible(By.xpath("//section[@id='content']//table"));
        List<String> orderData = new ArrayList<>();
        List<WebElement> ordersDataTable = orderDataTable.findElements(By.xpath("//section[@id='content']//tbody/tr[1]/td"));
        for (WebElement elements : ordersDataTable){
            orderData.add(elements.getText());
        }
        return orderData;
    }

    public String getOrderReferenceInHistory(){
        return orderHistoryReference.getText();
    }
}
