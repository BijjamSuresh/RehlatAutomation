package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyUserIaAbleToCheckAllTheFieldsAreVisibleToUserInFlightsTab extends BaseTest {
    @Test
    public void testRLTC_32() throws Exception{
        Logger.beginTest("Verify user is able to check all the fields are visible to the user in flights tab");
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.checkAllTheFieldsAreVisibleInFlightsTab();
        Logger.endTest("Verify user is able to check all the fields are visible to the user in flights tab");

    }
}
