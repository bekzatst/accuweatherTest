package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;
import utils.Config;

public class MainPage extends Form {
    IElementFactory elementFactory = AqualityServices.getElementFactory();
    private ILabel dataUsageLbl = elementFactory.getLabel(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, Config.I_UNDERSTAND_TXT)), "Data Usage Label");
    private ILabel seacrhInput = elementFactory.getLabel(By.className(Config.SEARCH_INPUT_CLASS_NAME), "Search Input Field");
    private ILabel searchResultsList = elementFactory.getLabel(By.className(Config.SEARCH_RESULTS_CLASS_NAME), "Search Results List");
    private ILabel firstSearchResult = elementFactory.getLabel(By.xpath(Config.FIRST_SEARCH_RESULT_LOCATOR), "First Search Result");

    public MainPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, Config.MAIN_PAGE_LOCATOR_TEXT)), "Main Page");
    }

    public void consentDataUsage() {
        dataUsageLbl.click();
    }

    public void inputCityName() {
        seacrhInput.sendKeys(Config.CITY_NAME_TO_SEARCH);
    }

    public boolean isSearchResultsListDisplayed() {
        return searchResultsList.state().waitForDisplayed();
    }

    public void clickFirstSearchResult() {
        firstSearchResult.click();
    }

}
