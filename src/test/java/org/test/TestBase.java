package org.test;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {

    public static String baseUrl = "http://testoutlivecontent.blob.core.windows.net/netpro2018v5-en-us/en-us/sims/typescriptv1/netpro2018v5/simstartup_webpack.html?package=netpro2018v5windowspackage&sim=ipademail_np5&dev=true&automation=true";
    private WebDriver driver;

    protected WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver-80.mac");
        driver = new ChromeDriver();
        return driver;
    }

    @After
    public void closeDriverObjects() {
        driver.quit();
    }
}
