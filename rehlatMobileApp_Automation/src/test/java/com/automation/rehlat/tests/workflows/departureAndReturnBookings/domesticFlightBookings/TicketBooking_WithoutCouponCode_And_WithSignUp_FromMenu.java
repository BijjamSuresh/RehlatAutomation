package com.automation.rehlat.tests.workflows.departureAndReturnBookings.domesticFlightBookings;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

import static com.automation.rehlat.Labels.*;

public class TicketBooking_WithoutCouponCode_And_WithSignUp_FromMenu extends BaseTest {
    public static final String  newEmailForSignUp = Labels.EMAIL_ID_SIGN_UP.replace("10","71");

    @Test
    public void testTicketBookingWithoutCouponCodeAndWithSignUpFromMenu() throws Exception{
        Logger.beginTest("- Ticket booking without coupon code and with sign up from menu");
        Labels.EMAIL_ID_SIGN_UP = newEmailForSignUp;
        FlightsScreen.checkSelectLanguageModalIsDisplayed();
        FlightsScreen.selectCountryNameAndMoveToFlightsTab(INDIA_LANGUAGE_COUNTRY_LABEL); // Country name needs to changed while testing for countries other than Kuwait.
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        if (MenuScreen.isUserSignedIn()){
            Logger.logComment("User is logged in with an account.., So going to re-sign up with another account");
            MenuScreen.tapOnLogoutButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
        }
        MenuScreen.tapOnSignUpOrSignInButton();
        SignInScreen.checkSignInScreenIsDisplayed();
        SignInScreen.tapOnCreateAccountButton();
        SignUpScreen.checkSignUpScreenIsDisplayed();
        SignUpScreen.enterSignUpCredentials();
        SignUpScreen.tapOnSignUpButton();
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkUserIsSignedUpSignedInWithCorrectParsingCredentials(Labels.EMAIL_ID_SIGN_UP);
        MenuScreen.navigateToFlightsTab();
        FlightsScreen.tapOnFromTextField();
        driver.runAppInBackground(Labels.BACKGROUND_TIME_MIN);
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
        FlightsScreen.tapOnReturnDateBookingButton();
        FlightsScreen.selectReturnDate(RETURN_DATE_BOOKING_MONTH,RETURN_DAY);// Automation Defect: Due to improper element names in calendar view unable to tap on accurate departure date
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
        if (!BookingPageScreen.isUserIsSignedIn()){
            Logger.logError("User is not signed in in booking page where as signed up in menu screen");
        }
        BookingPageScreen.enterUserBookingInfo();
        BookingPageScreen.checkFinalFareCalculationIsCorrect();
        BookingPageScreen.tapOnAdultAddTravellersDetailsButton();
        TravellerDetailsScreen.declineAutoFillPopulateModalIfDisplayed();
        TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
        TravellerDetailsScreen.enterAdultTravellersDetails(DOMESTIC_TRAVELLERS_COUNTRY_NAME);
        TravellerDetailsScreen.tapOnSaveButton();
        BookingPageScreen.checkBookingPageScreenIsDisplayed();
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
            if (!BookingPageScreen.isUserIsSignedIn()){
                Logger.logError("User is not signed in in booking page where as signed up in menu screen");
            }
            BookingPageScreen.enterUserBookingInfo();
            BookingPageScreen.checkFinalFareCalculationIsCorrect();
            BookingPageScreen.tapOnAdultAddTravellersDetailsButton();
            TravellerDetailsScreen.declineAutoFillPopulateModalIfDisplayed();
            TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
            TravellerDetailsScreen.declineAutoFillPopulateModalIfDisplayed();
            TravellerDetailsScreen.enterAdultTravellersDetails(DOMESTIC_TRAVELLERS_COUNTRY_NAME);
            TravellerDetailsScreen.tapOnSaveButton();
            BookingPageScreen.checkBookingPageScreenIsDisplayed();
            BookingPageScreen.tapOnContinueButton();
            if (BookingPageScreen.isTicketSoldOutPopUpIsDisplayed()) {
                BookingPageScreen.tapOnOkButtonInTicketSoldOutPopup();
                Logger.logError("Tried booking seats for two flights, both tickets are sold out......, Please re-run the script with different dates");
            }else {
                PaymentOptionsScreen.checkPaymentOptionsScreenIsDisplayed();
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
        Logger.endTest("- Ticket Booking Without CouponCode and Without SignUp or SignIn ");
    }
}
