package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser, boolean headless) {
        WebDriver driver;
        FirefoxProfile ffProfile = new FirefoxProfile();
        ChromeOptions chromeOptions = new ChromeOptions();

        switch (browser) {
            case "chrome":
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--enable-smooth-scrolling");
                driver = new ChromeDriver();
                break;

            case "firefox":
                ffProfile.setPreference("webdriver_accept_untrusted_certs", true);
                ffProfile.setPreference("webdriver_assume_untrusted_issuer", true);
                ffProfile.setPreference("webdriver.log.driver", "ERROR");
                ffProfile.setPreference("browser.private.browsing.autostart", true);
                driver = new FirefoxDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            default:
                driver = new ChromeDriver();
                driver.manage().window().maximize();
        }
        return driver;
    }
}
