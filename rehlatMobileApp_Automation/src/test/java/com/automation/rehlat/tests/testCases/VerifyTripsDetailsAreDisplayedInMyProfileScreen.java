package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyTripsDetailsAreDisplayedInMyProfileScreen extends BaseTest {
    @Test
    public void testRLTC_11() throws Exception{
        Logger.beginTest(" Verify trips details are displayed in My Profile screen");
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        if (!MenuScreen.isUserSignedIn()){
            MenuScreen.tapOnSignUpOrSignInButton();
            SignInScreen.checkSignInScreenIsDisplayed();
            SignInScreen.enterLoginCredentials();
            SignInScreen.tapOnLoginButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
        }
        MenuScreen.checkUserIsSignedUpSignedInWithCorrectParsingCredentials(Labels.EMAIL_ID_SIGN_IN);
        MenuScreen.tapOnProfileEditIcon();
        MyProfileScreen.checkMyProfileScreenIsDisplayed();
        MyProfileScreen.getTheTripsCountDisplayedInKaramPointsAndTripsLayout();
        Logger.endTest(" Verify trips details are displayed in My Profile screen");

    }
}
