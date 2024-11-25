package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;
import utils.Config;

public class CityWeatherPage extends Form {
    static IElementFactory elementFactory = AqualityServices.getElementFactory();
    private ITextBox pageHeader = elementFactory.getTextBox(By.className(Config.CITY_WEATHER_PAGE_HEADER_CLASS_NAME), "City Weather Page Header");

    public CityWeatherPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, Config.CITY_WEATHER_PAGE_LOCATOR_TEXT)), "City Weather Page");
    }

    public boolean headerContainsCityName() {
        return pageHeader.getText().contains(Config.CITY_NAME_TO_SEARCH);
    }
}
