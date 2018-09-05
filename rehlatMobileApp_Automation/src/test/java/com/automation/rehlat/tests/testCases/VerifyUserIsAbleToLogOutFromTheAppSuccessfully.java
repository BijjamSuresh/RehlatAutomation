package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyUserIsAbleToLogOutFromTheAppSuccessfully extends BaseTest {
    @Test
    public void testRLTC_31() throws Exception{
        Logger.beginTest("Verify user is able to logout from the app successfully");
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        if (MenuScreen.isUserSignedIn()){
            MenuScreen.tapOnSignUpOrSignInButton();
            SignInScreen.declineTheTouchIdAccessSetUpPopupIfDisplayed();
            SignInScreen.checkSignInScreenIsDisplayed();
            SignInScreen.enterLoginCredentials();
            SignInScreen.tapOnLoginButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
            MenuScreen.checkUserIsSignedUpSignedInWithCorrectParsingCredentials(Labels.EMAIL_ID_SIGN_IN);
        }
        MenuScreen.tapOnLogoutButton();
        Logger.endTest("Verify user is able to logout from the app successfully");

    }
}
