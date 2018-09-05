package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.Labels.*;
import static com.automation.rehlat.Labels.DEPARTURE_MONTH;
import static com.automation.rehlat.Labels.TO_DOMESTIC_AIRPORT_CODE;

public class Verify3DPaymentSecureScreenIsDisplayedAfterTappingOnPaySecurelyButton extends BaseTest {
    @Test
    public void testVerify3DPaymentSecureScreenIsDisplayedAfterTappingOnPaySecurelyButton() throws Exception{
        Logger.beginTest("Verify 3D payment secure screen is displayed after tapping on pay secure button");
        FlightsScreen.selectCountryNameInSelectLanguageModal(INDIA_LANGUAGE_COUNTRY_LABEL); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        if (!MenuScreen.isUserSignedIn()){
            Logger.logComment("User is not signed in. So going to sign in with account :- "+ Labels.EMAIL_ID_SIGN_IN);
            MenuScreen.tapOnSignUpOrSignInButton();
            SignInScreen.checkSignInScreenIsDisplayed();
            SignInScreen.enterLoginCredentials();
            SignInScreen.tapOnLoginButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
            MenuScreen.checkUserIsSignedUpSignedInWithCorrectParsingCredentials(Labels.EMAIL_ID_SIGN_IN);
        }
        MenuScreen.navigateToFlightsTab();
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
        FlightsScreen.tapOnSearchButton();
        FlightsSearchResultsScreen.checkFlightsSearchResultsScreenIsDisplayed();
        FlightsSearchResultsScreen.tapOnACellInFlightSearchResults(CELL_NUMBER_OF_FLIGHT_SEARCH_RESULTS); //Change this method to tap on a flight cell by sending the cell number as string/integer like this : //  FlightsSearchResultsIos.getTheBookingCostOfSelectedFlightInSearchResults("6");
        if ( FlightsSimilarOptionsSearchResultsScreen.checkFlightsSimilarOptionsSearchResultsScreenIsDisplayed()){
            FlightsSimilarOptionsSearchResultsScreen.tapOnFirstSimilarOptionCell();
        }else{
            Logger.logComment("Flights similar options screen is not displayed");
        }
        ReviewBookingScreen.checkReviewBookingScreenIsDisplayed();
        ReviewBookingScreen.compareTheSelectedBookingSeatCostInSearchResultsScreenDisplayedInReviewBookingScreen();
        ReviewBookingScreen.tapOnContinueButton();
        BookingPageScreen.checkBookingPageScreenIsDisplayed();
        BookingPageScreen.enterUserBookingInfo();
        BookingPageScreen.tapOnAdultAddTravellersDetailsButton();
        if (TravellerDetailsScreen.acceptAutoFillPopulateModalIfDisplayed()){
            TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
        }else {
            TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
            TravellerDetailsScreen.enterAdultTravellersDetails(INTERNATIONALS_TRAVELLERS_COUNTRY_NAME);
        }
        TravellerDetailsScreen.tapOnSaveButton();
        BookingPageScreen.checkBookingPageScreenIsDisplayed();
        BookingPageScreen.tapOnContinueButton();
        PaymentOptionsScreen.checkPaymentOptionsScreenIsDisplayed();
        PaymentOptionsScreen.enterCreditOrDebitCardDetails();
        PaymentOptionsScreen.enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment();
        PaymentOptionsScreen.tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment();
        PaymentOptionsScreen.checkTheCreditOrDebitCardBookingProcessIsSuccess();
        Logger.endTest("Verify 3D payment secure screen is displayed after tapping on pay secure button");

    }
}
