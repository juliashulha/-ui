package service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class Drivers {

    private static WebDriver driver = null;

    public Drivers() {

        System.out.println("Drivers initiated");
    }

    public static WebDriver getChrome(String device) {

        System.setProperty("webdriver.chrome.driver", "/Users/yshulha/Documents/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", device);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation",  mobileEmulation );
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return driver = new ChromeDriver(desiredCapabilities);
    }


    public static void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
