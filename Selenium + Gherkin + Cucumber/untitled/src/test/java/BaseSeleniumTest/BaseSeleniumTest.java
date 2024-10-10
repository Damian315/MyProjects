package BaseSeleniumTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;
    protected Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        String driverPath = "src/main/resources/executables/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/executables/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void waitUntilElementToBeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(6000));
        wait.withTimeout(Duration.ofSeconds(200))
                .pollingEvery(Duration.ofMillis(10000))
                .ignoring(NoSuchFieldException.class);
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                List<WebElement> elements = driver.findElements(locator);
                System.out.println("Checking if the element is displayed");
                if (elements.size() > 0){
                    System.out.println("Element is displayed");
                    return true;
                }else {
                    System.out.println("Element is not displayed on the page");
                    return false;
                }
            }
        });
    }
}
