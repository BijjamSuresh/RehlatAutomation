package com.automation.rehlat.pages.settings;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.pages.flights.FlightsAndroid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automation.rehlat.pages.flights.FlightsAndroid.DOMAIN_LIST_VIEW;
import static com.automation.rehlat.pages.flights.FlightsAndroid.TEXT_VIEW;

public class SettingsAndroid extends SettingsBase {
    public static final String BACK_BUTTON_IN_SETTINGS_SCREEN= "com.app.rehlat:id/setting_search_back_btn";
    public static final String SELECTED_COUNTRY_LAYOUT = "com.app.rehlat:id/country_name";
    public static final String SELECTED_CURRENCY_LAYOUT = "com.app.rehlat:id/selectedCurrency";
    public static final String NOTIFICATION_TOGGLE_SWITCH = "XCUIElementTypeSwitch";
    public static final String CURRENCY_LIST_VIEW = "com.app.rehlat:id/currencyListView";
    public static final String CONTINUE_BUTTON= "com.app.rehlat:id/domainDialogClose";
    public static final String XPATH_OF_CURRENT_CURRENCY_NAME = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]";
    public static final String XPATH_OF_CURRENT_DOMAIN_NAME = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[2]";

    /**
     * Check the settings screen is displayed
     * @throws Exception
     */
    @Override
    public void checkSettingsScreenIsDisplayed() {
        Logger.logAction("Checking the settings screen is displayed or not ?");
        try {
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels.ANDROID_ACTIVITY_INDICATOR);
            if (isElementEnabledById(BACK_BUTTON_IN_SETTINGS_SCREEN)){
                Logger.logStep("Settings screen is displayed");
            }else {
                Logger.logError("Settings screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the current active screen name");
        }
    }

    /**
     * Tap on change country option
     */
    @Override
    public void tapOnChangeCountryOption() {
        Logger.logAction("Tapping on change country option");
        try {
            findElementByIdAndClick(SELECTED_COUNTRY_LAYOUT);
            Logger.logStep("Tapped on change country icon");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on change the country");
        }
    }

    /**
     * Tap on change currency option
     */
    @Override
    public void tapOnChangeCurrencyOption() {
        Logger.logAction("Tapping on change currency option");
        try {
            findElementByIdAndClick(SELECTED_CURRENCY_LAYOUT);
            Logger.logStep("Tapped on change currency icon");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on change the currency");
        }
    }

    /**
     * Change the domain
     * @param parsingDomainName
     */
    @Override
    public void selectTheDomain(String parsingDomainName) {
        Logger.logAction("Selecting the domain :- "+parsingDomainName);
        try {
            FlightsScreen.selectCountryOfUser(parsingDomainName);
            Logger.logStep("Selected the domain :- "+parsingDomainName);
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on select the domain");
        }
    }

    /**
     * Change the domain
     * @param parsingCurrencyName
     */
    @Override
    public void selectTheCurrencyName(String parsingCurrencyName) {
        Logger.logAction("Selecting the currency :- "+parsingCurrencyName);
        try {
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels.ANDROID_ACTIVITY_INDICATOR);
            if (isElementDisplayedById(CURRENCY_LIST_VIEW)) {
                WebElement displayedCurrenciesListView = driver.findElementById(CURRENCY_LIST_VIEW);
                    List<WebElement> displayedCountriesList = displayedCurrenciesListView.findElements(By.className(TEXT_VIEW));
                    for (int index = 0; index <= displayedCountriesList.size(); index++) {
                        WebElement currencyNameTextView = displayedCountriesList.get(index);
                        String currencyNameLabel = currencyNameTextView.getText();
                        if (currencyNameLabel.equals(parsingCurrencyName)) {
                            Logger.logComment("Tapping on element - " + currencyNameLabel);
                            currencyNameTextView.click();
                            Logger.logStep("Tapped on element - "+currencyNameLabel);
                            break;
                        } else {
                            continue;
                        }
                    }
            }else {
                Logger.logError(DOMAIN_LIST_VIEW+" - element name is not displayed in the current active screen");
            }
            Logger.logStep("Selected the currency :- "+parsingCurrencyName);
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on select the domain");
        }
    }

    /**
     * Get the current currency
     */
    @Override
    public String getTheCurrentCurrencyType() {
        Logger.logAction("Getting the current currency");
        try {
            String currentCurrency = driver.findElementById(SELECTED_CURRENCY_LAYOUT).getText();
            if (!currentCurrency.isEmpty()){
                return currentCurrency;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on change the currency");
        }
        return null;
    }

    /**
     * Get the current domain
     */
    @Override
    public String getTheCurrentDomain() {
        Logger.logAction("Getting the current domain");
        try {
            String currentDomain = driver.findElementById(SELECTED_COUNTRY_LAYOUT).getText();
            if (!currentDomain.isEmpty()){
                return currentDomain;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on change the domain");
        }
        return null;
    }

    /**
     * Tap on continue button
     */
    @Override
    public void tapOnContinueButton() {
        Logger.logAction("Tapping on continue button");
        try {
            findElementByIdAndClick(CONTINUE_BUTTON);
            Logger.logStep("Tapped on continue button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on change the domain");
        }
    }


}
