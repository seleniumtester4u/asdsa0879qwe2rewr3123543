package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_Driver(String browser){
        System.out.println("Browser" + browser);

        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());

        }
        else if(browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }else {
            System.out.println("Please give correct value");
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }

}
