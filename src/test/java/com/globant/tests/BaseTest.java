package com.globant.tests;

import com.globant.pages.HomePage;
import com.globant.pages.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.lang.reflect.Type;

public class BaseTest {
    protected static WebDriver driver = null;
    protected static HomePage homepage = null;

    @AfterClass
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
    @Parameters({"browser","url"})
    @BeforeClass
    public static void start(String browser,String url) {

        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
            driver = new ChromeDriver();
        }
        if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", Utils.GECKO_DRIVER_LOCATION);
            driver = new FirefoxDriver();
        }
        driver.get(url);
        homepage = new HomePage(driver);
    }
}
