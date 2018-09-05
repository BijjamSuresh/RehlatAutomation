package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyMenuScreenIsDisplayedWithAllTheRequiredOptions extends BaseTest {
    @Test
    public void  testRLTC_6() throws Exception{
        Logger.beginTest("Verify menu screen is displayed with all the required options");
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.checkAllTheSubMenuOptionsAreDisplayed();
        Logger.endTest("Verify menu screen is displayed with all the required options");
    }
}
