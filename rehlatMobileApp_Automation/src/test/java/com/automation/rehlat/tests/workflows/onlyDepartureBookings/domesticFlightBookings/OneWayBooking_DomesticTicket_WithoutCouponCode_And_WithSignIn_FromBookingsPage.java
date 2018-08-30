package com.automation.rehlat.tests.workflows.onlyDepartureBookings.domesticFlightBookings;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.Labels.*;

public class OneWayBooking_DomesticTicket_WithoutCouponCode_And_WithSignIn_FromBookingsPage extends BaseTest {
    @Test
    public void testTicketBookingWithoutCouponCodeAndWithSignInFromBookingsPage() throws Exception{
        Labels.FLIGHT_BOOKING_TYPE = DOMESTIC_FLIGHT_BOOKING;
        Logger.beginTest("- Ticket booking without coupon code and with sign in from bookings page");
        FlightsScreen.selectCountryNameInSelectLanguageModal(INDIA_LANGUAGE_COUNTRY_LABEL); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        if (MenuScreen.isUserSignedIn()){
            Logger.logComment("User is signed in with different account.., So going to signed out from that account");
            MenuScreen.tapOnLogoutButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
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
        FlightsScreen.tapOnDepartureButton();
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
        if (BookingPageScreen.isUserIsSignedIn()){
            Logger.logError("User is already signed in where as not signed in or signed up from menu screen");
        }
        BookingPageScreen.tapOnSignInForFasterBookingsButton();
        SignInScreen.checkSignInScreenIsDisplayed();
        SignInScreen.enterLoginCredentials();
        SignInScreen.tapOnLoginButton();
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
        BookingPageScreen.checkFinalFareCalculationIsCorrect();
        BookingPageScreen.tapOnContinueButton();
        if (BookingPageScreen.isTicketSoldOutPopUpIsDisplayed()){
            BookingPageScreen.tapOnOkButtonInTicketSoldOutPopup();
            Logger.logComment("Second time selecting the seat for different flight");
            FlightsSearchResultsScreen.checkFlightsSearchResultsScreenIsDisplayed();
            FlightsSearchResultsScreen.tapOnACellInFlightSearchResults(CELL_NUMBER_OF_FLIGHT_SEARCH_RESULTS_WHEN_SOLDOUT_POPUP_INTERRUPTRED); //Change this method to tap on a flight cell by sending the cell number as string/integer like this : //  FlightsSearchResultsIos.getTheBookingCostOfSelectedFlightInSearchResults("6");
            if ( FlightsSimilarOptionsSearchResultsScreen.checkFlightsSimilarOptionsSearchResultsScreenIsDisplayed()){
                FlightsSimilarOptionsSearchResultsScreen.tapOnFirstSimilarOptionCell();
            }else{
                Logger.logComment("Flights similar options screen is not displayed");
            }
            ReviewBookingScreen.checkReviewBookingScreenIsDisplayed();
            ReviewBookingScreen.compareTheSelectedBookingSeatCostInSearchResultsScreenDisplayedInReviewBookingScreen();
            ReviewBookingScreen.tapOnContinueButton();
            BookingPageScreen.checkBookingPageScreenIsDisplayed();
            BookingPageScreen.tapOnSignInForFasterBookingsButton();
            SignInScreen.checkSignInScreenIsDisplayed();
            SignInScreen.enterLoginCredentials();
            SignInScreen.tapOnLoginButton();
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
            BookingPageScreen.checkFinalFareCalculationIsCorrect();
            BookingPageScreen.tapOnContinueButton();
            if (BookingPageScreen.isTicketSoldOutPopUpIsDisplayed()) {
                BookingPageScreen.tapOnOkButtonInTicketSoldOutPopup();
                Logger.logError("Tried booking seats for two flights, both tickets are sold out......, Please re-run the script with different dates");
            }else {
                PaymentOptionsScreen.checkPaymentOptionsScreenIsDisplayed();
                PaymentOptionsScreen.compareTheFinalPaymentDisplayedInPaymentsCheckOutScreenWithPaymentDisplayedInReviewBookingScreen();
                // KNET PAYMENT PROCESS
                PaymentOptionsScreen.tapOnKnetPaymentGateWay();
                PaymentOptionsScreen.checkKnetPaymentOptionsScreenIsDisplayed();
                PaymentOptionsScreen.selectingBankName(TESTING_BANK_CARD);
                PaymentOptionsScreen.enterCardNumber(); // Automation Defect: Card number text field is not intractable in iOS Platform
                PaymentOptionsScreen.enterPinNumber();
                PaymentOptionsScreen.tapOnSubmitButton();
                PaymentOptionsScreen.checkPostTransactionScreenIsDisplayed();
                PaymentOptionsScreen.tapOnConfirmButton();
                PaymentOptionsScreen.checkTheKnetBookingProcessIsSuccess();

                // CREDIT OR DEBIT CARD PAYMENT PROCESS
//            PaymentOptionsScreen.enterCreditOrDebitCardDetails();
//            PaymentOptionsScreen.enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment();
//            PaymentOptionsScreen.tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment();
//            PaymentOptionsScreen.checkTheCreditOrDebitCardBookingProcessIsSuccess();
//        }
            }
        }else {
            Thread.sleep(Labels.WAIT_TIME_MIN);
            PaymentOptionsScreen.checkPaymentOptionsScreenIsDisplayed();
            PaymentOptionsScreen.compareTheFinalPaymentDisplayedInPaymentsCheckOutScreenWithPaymentDisplayedInReviewBookingScreen();
            // KNET PAYMENT PROCESS
            PaymentOptionsScreen.tapOnKnetPaymentGateWay();
            PaymentOptionsScreen.checkKnetPaymentOptionsScreenIsDisplayed();
            PaymentOptionsScreen.selectingBankName(TESTING_BANK_CARD);
            PaymentOptionsScreen.enterCardNumber(); // Automation Defect: Card number text field is not intractable in iOS Platform
            PaymentOptionsScreen.enterPinNumber();
            PaymentOptionsScreen.tapOnSubmitButton();
            PaymentOptionsScreen.checkPostTransactionScreenIsDisplayed();
            PaymentOptionsScreen.tapOnConfirmButton();
            PaymentOptionsScreen.checkTheKnetBookingProcessIsSuccess();

            // CREDIT OR DEBIT CARD PAYMENT PROCESS
//            PaymentOptionsScreen.enterCreditOrDebitCardDetails();
//            PaymentOptionsScreen.enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment();
//            PaymentOptionsScreen.tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment();
//            PaymentOptionsScreen.checkTheCreditOrDebitCardBookingProcessIsSuccess();
        }
        Logger.endTest("- Ticket booking without coupon code and with sign in from bookings page");

    }
}
