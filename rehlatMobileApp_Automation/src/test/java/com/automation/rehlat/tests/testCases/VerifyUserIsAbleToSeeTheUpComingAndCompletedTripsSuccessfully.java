package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyUserIsAbleToSeeTheUpComingAndCompletedTripsSuccessfully extends BaseTest {
    @Test
    public void testRLTC_26() throws Exception{
        Logger.beginTest("Verify user is able to see the upcoming and completed trips successfully");
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        if (!MenuScreen.isUserSignedIn()){
            MenuScreen.tapOnSignUpOrSignInButton();
            SignInScreen.checkSignInScreenIsDisplayed();
            SignInScreen.enterLoginCredentials();
            SignInScreen.tapOnLoginButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
            MenuScreen.checkUserIsSignedUpSignedInWithCorrectParsingCredentials(Labels.EMAIL_ID_SIGN_IN);
        }
        MenuScreen.tapOnMyTripsSubMenuButton();
        MyTripsScreen.checkMyTripsScreenIsDisplayed();
        MyTripsScreen.tapOnFlightsButton();
        MyTripsScreen.tapOnUpcomingButton();
        MyTripsScreen.checkUpcomingFlightsTravelInformationIsDisplayed();
        MyTripsScreen.tapOnCompletedButton();
        MyTripsScreen.checkCompletedFlightsTravelInformationIsDisplayed();
        Logger.endTest("Verify user is able to see the upcoming and completed trips successfully");

    }
}
