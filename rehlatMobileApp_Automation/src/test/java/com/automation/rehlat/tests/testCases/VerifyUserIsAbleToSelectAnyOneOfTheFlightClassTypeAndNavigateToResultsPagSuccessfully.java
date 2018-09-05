package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.Labels.*;
import static com.automation.rehlat.Labels.DEPARTURE_MONTH;

public class VerifyUserIsAbleToSelectAnyOneOfTheFlightClassTypeAndNavigateToResultsPagSuccessfully extends BaseTest {
    @Test
    public void testRLTC_36() throws Exception{
        Logger.beginTest("Verify user is able to select any one of the flight class type and navigate to results page successfully");
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnFromTextField();
        FlightsScreen.checkSearchViewScreenIsDisplayed();
        FlightsScreen.checkKeyboardIsDisplayed();
        FlightsScreen.enterAirportName(FROM_DOMESTIC_AIRPORT_NAME); // Automation Defect: search results are not matching w.r.t. the send keys and due to that using Xpath of first element in search results
        FlightsScreen.selectAirportCodeFromSearchResults(FROM_DOMESTIC_AIRPORT_CODE);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnToTextField();
        FlightsScreen.checkKeyboardIsDisplayed();
        FlightsScreen.enterAirportName(TO_DOMESTIC_AIRPORT_NAME);
        FlightsScreen.selectAirportCodeFromSearchResults(TO_DOMESTIC_AIRPORT_CODE);
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnDepartureDateBookingButton();
        FlightsScreen.selectDepartureDate(DEPARTURE_MONTH,DEPARTURE_DAY); // Automation Defect: Due to improper element names in calendar view unable to tap on accurate departure date
        FlightsScreen.tapOnDoneButton();
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnAdultPlusButton();
        FlightsScreen.tapOnChildrenPlusButton();
        FlightsScreen.tapOnInfantsPlusButton();
        FlightsScreen.tapOnSearchButton();
        FlightsSearchResultsScreen.checkFlightsSearchResultsScreenIsDisplayed();
        Logger.endTest("Verify user is able to select any one of the flight class type and navigate to results page successfully");

    }
}
