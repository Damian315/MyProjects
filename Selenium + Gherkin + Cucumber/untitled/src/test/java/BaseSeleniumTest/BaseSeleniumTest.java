package BaseSeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.andreinc.mockneat.MockNeat;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public abstract class BaseSeleniumTest {

    protected static WebDriver driver;
    protected Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
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
                .pollingEvery(Duration.ofMillis(8000))
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

    public String generateUniqueEmailAddress(){
        MockNeat mock = MockNeat.threadLocal();
        return mock.emails().domain("gmail.com").val();
    }
}
