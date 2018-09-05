package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyUserIsSignedUpWithValidCredentials extends BaseTest {
    @Test
    public void  testRLTC_7() throws Exception{
        Logger.beginTest("Verify user is signed in with valid credentials");
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
       if(MenuScreen.isUserSignedIn())
       {
            MenuScreen.tapOnLogoutButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
        }
        MenuScreen.tapOnSignUpOrSignInButton();
        SignInScreen.checkSignInScreenIsDisplayed();
        SignInScreen.enterLoginCredentials();
        SignInScreen.tapOnLoginButton();
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        MenuScreen.checkUserIsSignedUpSignedInWithCorrectParsingCredentials(Labels.EMAIL_ID_SIGN_IN);
        Logger.endTest("Verify user is signed in with valid credentials");
    }
}
