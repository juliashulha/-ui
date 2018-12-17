package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import service.Drivers;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static enums.Constants.BASE_URL;

abstract public class BaseTest extends Drivers {


    @BeforeClass
    public static void setUp() {


        WebDriverRunner.setWebDriver(getChrome("Nexus 5"));


//        System.setProperty("webdriver.chrome.driver", "/Users/yshulha/Documents/chromedriver");
//
////
////        Map<String, String> mobileEmulation = new HashMap<>();
////
////        mobileEmulation.put("deviceName", "Nexus 5");
////
////
////        ChromeOptions chromeOptions = new ChromeOptions();
////        chromeOptions.setExperimentalOption("mobileEmulation",  mobileEmulation );
////        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
////        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//
//        driver = new ChromeDriver(desiredCapabilities);
//        driver.navigate().to(BASE_URL);
//
//
//        Configuration.browserCapabilities = desiredCapabilities;
//        Configuration.startMaximized = false;


    }

        @After
        public void cleanUp() {
            clearBrowserCookies();
        }
    }
