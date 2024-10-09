package BaseSeleniumTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;
    protected Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        String driverPath = "untitled/src/main/resources/executables/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", "untitled/src/test/resources/executables/drivers/chromedriver");
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
}
