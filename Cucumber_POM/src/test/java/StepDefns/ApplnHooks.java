package StepDefns;


import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplnHooks {
    private WebDriver driver;
    private DriverFactory driverFactory;
    public static ConfigReader configReader;
    public static Properties prop;

    @Before(order = 0)
    public void getBrowser(){
         configReader = new ConfigReader();
         prop = configReader.init_prop();
        String browsername = prop.getProperty("browser");
         driverFactory = new DriverFactory();
        driver = driverFactory.init_Driver(browsername);
    }
    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ","_");
            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenshotName);
        }
    }
}
