package com.automation.rehlat.pages.settings;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;

public class SettingsIos extends SettingsBase {
    public static final String SETTINGS_TITLE = "Settings";
    public static final String CHANGE_COUNTRY_ICON = "country";
    public static final String CHANGE_CURRENCY_ICON = "currency";
    public static final String NOTIFICATION_TOGGLE_SWITCH = "XCUIElementTypeSwitch";
    public static final String CONTINUE_BUTTON= "CONTINUE";
    public static final String XPATH_OF_CURRENT_CURRENCY_NAME = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]";
    public static final String XPATH_OF_CURRENT_DOMAIN_NAME = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[2]";


    /**
     * Check the settings screen is displayed
     * @throws Exception
     */
    @Override
    public void checkSettingsScreenIsDisplayed(){
        Logger.logAction("Checking the settings screen is displayed or not ?");
        try {
//            waitForAnElementToDisappear_ByName(Labels.IOS_ACTIVITY_INDICATOR);
            if (isElementDisplayedByName(SETTINGS_TITLE)){
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
            findElementByNameAndClick(CHANGE_COUNTRY_ICON);
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
            findElementByNameAndClick(CHANGE_CURRENCY_ICON);
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
            findElementByNameAndClick(parsingDomainName);
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
        Logger.logAction("Selecting the domain :- "+parsingCurrencyName);
        try {
//            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
            findElementByNameAndClick(parsingCurrencyName);
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
            String currentCurrency = findElementByXpathAndReturnItsAttributeValue(XPATH_OF_CURRENT_CURRENCY_NAME);
            return currentCurrency;
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
            String currentCurrency = findElementByXpathAndReturnItsAttributeValue(XPATH_OF_CURRENT_DOMAIN_NAME);
            return currentCurrency;
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
           findElementByNameAndClick(CONTINUE_BUTTON);
           Logger.logStep("Tapped on continue button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on change the domain");
        }
    }

}
