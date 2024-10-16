package Tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features",
        plugin = {"pretty", "html:out"},
        tags = "@UpdateUserInformation"
)

public class UpdateUserInformationRunTest{

}