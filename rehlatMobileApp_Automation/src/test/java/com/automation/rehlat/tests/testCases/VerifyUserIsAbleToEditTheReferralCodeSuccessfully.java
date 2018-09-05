package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyUserIsAbleToEditTheReferralCodeSuccessfully extends BaseTest {
    @Test
    public void  testRLTC_20() throws Exception{
        Logger.beginTest("Verify that user is able to edit the referral code successfully");
        FlightsScreen.checkFlightsTabIsDisplayed();
        FlightsScreen.tapOnMenuButton();
        MenuScreen.checkMenuScreenIsDisplayed();
        if (!MenuScreen.isUserSignedIn()){
            Logger.logComment("User is not signed, referral code is only for signed in users. So going to sign in");
            MenuScreen.tapOnSignUpOrSignInButton();
            SignInScreen.enterLoginCredentials();
            SignInScreen.tapOnLoginButton();
            FlightsScreen.checkFlightsTabIsDisplayed();
            FlightsScreen.tapOnMenuButton();
            MenuScreen.checkMenuScreenIsDisplayed();
            MenuScreen.checkUserIsSignedUpSignedInWithCorrectParsingCredentials(Labels.EMAIL_ID_SIGN_IN);
        }
        MenuScreen.tapOnReferAndEarnIcon();
        ReferYourFriendsScreen.checkReferralCodeIsDisplayed();
        ReferYourFriendsScreen.editTheReferralCode();
        Logger.endTest("Verify that user is able to edit the referral code successfully");
    }
}
