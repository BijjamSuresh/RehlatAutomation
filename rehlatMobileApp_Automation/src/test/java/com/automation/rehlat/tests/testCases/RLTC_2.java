package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.General;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class RLTC_2 extends BaseTest {
    @Test
    public void  testRLTC_2() throws Exception{
        Logger.beginTest("Verify that splash screen is displayed on launch");
        General.reInstallApp();
        General.launchApp();
        checkAndWaitTillTheSplashScreenIsInvisible();
        Logger.endTest("Verify that splash screen is displayed on launch");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels.KUWAIT_LANGUAGE_COUNTRY_LABEL);
    }
}
