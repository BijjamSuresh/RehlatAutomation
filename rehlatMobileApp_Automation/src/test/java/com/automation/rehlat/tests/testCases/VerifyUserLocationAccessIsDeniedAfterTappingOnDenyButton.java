package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.General;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyUserLocationAccessIsDeniedAfterTappingOnDenyButton extends BaseTest {
    @Test
    public void  testRLTC_4() throws Exception{
        Logger.beginTest("Verify user location access is denied after tapping on deny button");
        reInstallApp();
        General.launchApp();
        General.declineTheLocationAccessAlert();
        Logger.endTest("Verify user location access is denied after tapping on deny button");
        acceptAutoAlertsIfDisplayed();
        FlightsScreen.selectCountryNameInSelectLanguageModal(Labels.KUWAIT_LANGUAGE_COUNTRY_LABEL);
    }
}
