package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features/Assignment.feature"},
        glue = {"StepDefns"},
        tags= "@All",
        plugin = {"pretty","html:cucumber-reports/report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class TestRunner {

}
