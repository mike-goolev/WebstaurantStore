package tests;

import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.*;

public class BaseTest extends TestNG {

    public WebDriver driver;
    public TestUtils testUtils;
    private boolean headless = false;

    @Parameters({"browser", "url"})
    @BeforeMethod(groups = {"smoketests"})
    public void setUpMain(@Optional String browser, @Optional String url) {
        if (System.getProperty("headless") != null) {
            headless = Boolean.parseBoolean(System.getProperty("headless"));
        }
        if (browser == null) {
            if (System.getProperty("browser") != null) {
                browser = System.getProperty("browser");
            } else {
                browser = "chrome"; // Browser options: "firefox", "ie", "safari", "chrome" --> See Utils/BrowserFactory
            }
        }

        if (url == null) {
            url = "https://www.webstaurantstore.com/";
        }

        driver = BrowserFactory.getDriver(browser, headless);
        testUtils = new TestUtils(driver);
        TestConfig.setBaseUrl(url);
    }
}
