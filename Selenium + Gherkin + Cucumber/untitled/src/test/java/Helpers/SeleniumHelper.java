package Helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalTime;

public class SeleniumHelper {

    WebDriver driver;

    public SeleniumHelper(WebDriver driver){
        this.driver = driver;
    }

    public static void takeScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/main/resources/screenshot" + LocalTime.now().getNano() + ".png");
        Files.copy(screenShotFile.toPath(), destinationFile.toPath());
    }
}
