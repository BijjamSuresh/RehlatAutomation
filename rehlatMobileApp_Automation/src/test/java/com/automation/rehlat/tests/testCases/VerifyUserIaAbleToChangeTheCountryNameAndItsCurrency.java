package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyUserIaAbleToChangeTheCountryNameAndItsCurrency extends BaseTest {
    public static final String[] domainsList = {"KUWAIT","UAE","SAUDI ARABIA","EGYPT","INDIA"};
    public static final String[] currencyList = {"KWD","AED","SAR","EGP","INR"};

    @Test
    public void testRLTC_29() throws Exception{
        Logger.beginTest("Verify User is able to change the country name and its currency");
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.tapOnSettingsButton();
        SettingsScreen.checkSettingsScreenIsDisplayed();
        for (int index=0; index<=domainsList.length-1;index++){
            String domainName = domainsList[index];
            SettingsScreen.tapOnChangeCountryOption();
            SettingsScreen.selectTheDomain(domainName);
            SettingsScreen.tapOnContinueButton();
            String currentDomain = SettingsScreen.getTheCurrentDomain();
            if (currentDomain.equalsIgnoreCase(domainName)){
                Logger.logComment(domainName+" :- domain name is selected and is reflecting in the settings screen");
            }else {
                Logger.logComment("Selected domain name is :- "+domainName);
                Logger.logComment("Displaying domain in settings screen is :- "+currentDomain);
                Logger.logError(domainName+" :- domain name is selected and is not reflecting in the settings screen");
            }
        }
        for (int index=0; index<=currencyList.length-1;index++){
            String parsingCurrencyName = currencyList[index];
            SettingsScreen.tapOnChangeCurrencyOption();
            SettingsScreen.selectTheCurrencyName(parsingCurrencyName);
            String currentCurrencyType = SettingsScreen.getTheCurrentCurrencyType();
            if (currentCurrencyType.equalsIgnoreCase(parsingCurrencyName)){
                Logger.logComment(parsingCurrencyName+" :- currency name is selected and is reflecting in the settings screen");
            }else {
                Logger.logComment("Selected currency name is :- "+parsingCurrencyName);
                Logger.logComment("Displaying currency in settings screen is :- "+currentCurrencyType);
                Logger.logError(parsingCurrencyName+" :- currency name is selected and is not reflecting in the settings screen");
            }
        }
        Logger.endTest("Verify User is able to change the country name and its currency");
        Logger.logStep("Setting the domain to default domain :- "+Labels.CURRENT_USER_COUNTRY_NAME);
        for (int index=0; index<=domainsList.length-1;index++){
            String domainName = domainsList[0];
            SettingsScreen.tapOnChangeCountryOption();
            SettingsScreen.selectTheDomain(domainName);
            SettingsScreen.tapOnContinueButton();
            String currentDomain = SettingsScreen.getTheCurrentDomain();
            if (currentDomain.equalsIgnoreCase(Labels.CURRENT_USER_COUNTRY_NAME)){
                Logger.logComment(domainName+" :- domain name is set to default and is reflecting in the settings screen");
                break;
            }else {
                Logger.logComment("Selected domain name is :- "+domainName);
                Logger.logComment("Displaying domain in settings screen is :- "+currentDomain);
                Logger.logError(domainName+" :- domain name is selected and is not reflecting in the settings screen");
            }
        }
    }
}
