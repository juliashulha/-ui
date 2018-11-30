package tests;

import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;

abstract public class BaseTest {

    @BeforeClass
    public static void setUp() {


//        Configuration.baseUrl = BASE_URL;
//        Configuration.browser = "chrome";
//        Configuration.headless = true;
//        Configuration.holdBrowserOpen = true;
//        Configuration.browserCapabilities = DesiredCapabilities.

//        System.setProperty("webdriver.chrome.driver", "/Users/yshulha/Documents/WorkSpace/bpp/src/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities().chrome();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        Configuration.browserCapabilities = desiredCapabilities;
        Configuration.startMaximized = false;



    @After
    public void cleanUp(){
        clearBrowserCookies();

    }
}
