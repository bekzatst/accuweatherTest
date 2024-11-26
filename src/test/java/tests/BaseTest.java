package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.SettingsTestData;

import static io.qameta.allure.Allure.step;

public class BaseTest {
    protected Browser browser;

    @BeforeMethod
    public void setup() {
        step("Open the browser");
        browser = AqualityServices.getBrowser();
        step("Maximize the browser window");
        browser.maximize();
        step("Go to start URL");
        browser.goTo(SettingsTestData.getEnvData().getHost());
    }

    @AfterMethod
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            step("Quitting the browser");
            browser.quit();
        }
    }
}
