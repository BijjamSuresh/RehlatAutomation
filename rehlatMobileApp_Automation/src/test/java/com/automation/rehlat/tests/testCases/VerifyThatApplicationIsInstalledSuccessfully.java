package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.General;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyThatApplicationIsInstalledSuccessfully extends BaseTest {
    @Test
    // Implementation is not yet finished. Will do once all the workflows are cleared
    public void testRLTC_1() throws Exception {
        Logger.beginTest("Verify that application is installed successfully");
        reInstallApp();
        General.launchApp();
        Logger.endTest("Verify that application is installed successfully");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels.KUWAIT_LANGUAGE_COUNTRY_LABEL);
    }
}
