package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TestUtils {

    protected static WebDriver driver;

    public TestUtils(WebDriver d) {
        driver = d;
    }
}
