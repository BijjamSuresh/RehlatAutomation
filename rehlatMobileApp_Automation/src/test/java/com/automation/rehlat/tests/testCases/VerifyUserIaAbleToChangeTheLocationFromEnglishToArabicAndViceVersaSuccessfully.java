package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyUserIaAbleToChangeTheLocationFromEnglishToArabicAndViceVersaSuccessfully extends BaseTest {

    @Test
    public void testRLTC_28() throws Exception{
        Logger.beginTest("Verify user is able to change the localization from english to arabic and vice versa successfully");
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.tapOnArabicInSubMenuButton();
        String appCurrentLocalization = FlightsScreen.checkAppLocalizationInFlightsTab();
        if (appCurrentLocalization.equalsIgnoreCase(Labels.ARABIC_LANGUAGE)){
            Logger.logStep("App localization is changed to Arabic");
        }else {
            Logger.logError("App localization is not changed to Arabic");
        }
        FlightsScreen.tapOnMenuButton();
        MenuScreen.tapOnEnglishInSubMenuButton();
        String appUpdatedLocalization = FlightsScreen.checkAppLocalizationInFlightsTab();
        if (appUpdatedLocalization.equalsIgnoreCase(Labels.ENGLISH_LANGUAGE)){
            Logger.logStep("App localization is changed to English");
        }else {
            Logger.logError("App localization is not changed to English");
        }
        Logger.endTest("Verify user is able to change the localization from english to arabic and vice versa successfully");
    }
}
