package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.General;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyOtherIsDisplayedAsCountryLabelWhenUserDeclineTheLocationAccessAlert extends BaseTest {
    @Test
    public void  testRLTC_5() throws Exception{
        Logger.beginTest("Verify other is displayed as country label when user decline the location access alert");
        reInstallApp();
        General.launchApp();
        General.declineTheLocationAccessAlert();
        General.accpetThenotificationAccessAlert();
        if(FlightsScreen.isSelectLanguageModalIsDisplayed()){
            String nameOfTheLastCountryNameInSelectCountryLayout = FlightsScreen.getTheLastPositionCountryNameInSelectCountryLayout();
            if (nameOfTheLastCountryNameInSelectCountryLayout.equalsIgnoreCase(Labels.OTHERS_COUNTRY_LABEL)){
                Logger.logStep("Other country name is displayed in correct position");
            }else {
                Logger.logError("Other country name is displayed in incorrect position");
            }
        }else {
            Logger.logError("Select country layout is not displayed in the current active screen");
        }
        Logger.endTest("Verify other is displayed as country label when user decline the location access alert");
    }
}
