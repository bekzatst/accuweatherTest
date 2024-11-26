package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CityWeatherPage;
import pages.MainPage;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

public class AccuweatherTest extends BaseTest {
    MainPage mainPage = new MainPage();
    CityWeatherPage cityWeatherPage = new CityWeatherPage();

    @Test(description = "Verify the search functionality and open the city weather page")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("User Management")
    @Feature("Search")
    @Story("Search for the City and Open the City Weather Page")
    @Owner("Beks")
    @Tag("Regression")
    public void testCitySearch() {
        step("Consent Data Usage");
        mainPage.consentDataUsage();
        try {
            step("Input 'New York' in the search field", () -> {
                mainPage.inputCityName();
                Assert.assertTrue(mainPage.isSearchResultsListDisplayed(), "Search Results List is Not Displayed");
            });
        } catch (NoSuchElementException | AssertionError e) {
            byte[] screenshot = browser.getScreenshot();
            addAttachment("Screenshot of search results", new ByteArrayInputStream(screenshot));
            throw e;
        }
        step("Click on the first search result");
        mainPage.clickFirstSearchResult();
        Assert.assertTrue(cityWeatherPage.state().waitForDisplayed(), "City Weather Page is Not Displayed");
        Assert.assertTrue(cityWeatherPage.headerContainsCityName(), "City Weather Page Header Does Not contain the City Name from the Search");
    }
}
