package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.General;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class RLTC_3 extends BaseTest {
    @Test
    public void  testRLTC_3() throws Exception{
        Logger.beginTest("Verify user location country name is displayed in the fourth place of select country layout");
        reInstallApp();
        General.launchApp();
        General.accpetTheLocationAccessAlert();
        General.accpetThenotificationAccessAlert();
        if(FlightsScreen.isSelectLanguageModalIsDisplayed()){
            String nameOfTheLastCountryNameInSelectCountryLayout = FlightsScreen.getTheLastPositionCountryNameInSelectCountryLayout();
            if (nameOfTheLastCountryNameInSelectCountryLayout .equalsIgnoreCase(Labels.INDIA_LANGUAGE_COUNTRY_LABEL)){
                Logger.logStep("User location country name is displayed in correct position in select language modal layout ");
            }else {
                Logger.logError("User location country name is displayed in incorrect position in select language modal layout ");
            }
        }else {
            Logger.logError("Select country layout is not displayed in the current active screen");
        }
        Logger.endTest("Verify user location country name is displayed in the fourth place of select country layout");
    }
}
