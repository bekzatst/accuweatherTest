package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CityWeatherPage;
import pages.MainPage;

public class AccuweatherTest extends BaseTest {
    MainPage mainPage = new MainPage();
    CityWeatherPage cityWeatherPage = new CityWeatherPage();

    @Test
    public void testCitySearch() {
        mainPage.consentDataUsage();
        mainPage.inputCityName();
        Assert.assertTrue(mainPage.isSearchResultsListDisplayed());
        mainPage.clickFirstSearchResult();
        Assert.assertTrue(cityWeatherPage.state().waitForDisplayed());
        Assert.assertTrue(cityWeatherPage.headerContainsCityName());
    }
}
