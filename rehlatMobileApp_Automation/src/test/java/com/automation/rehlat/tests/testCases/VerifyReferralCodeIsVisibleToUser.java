package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class VerifyReferralCodeIsVisibleToUser extends BaseTest {
    @Test
    public void testRLTC_19() throws Exception{
        Logger.beginTest("Verify the referral code is visible to the user");
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
        ReferYourFriendsScreen.checkReferYourFriendsScreenIsDisplayed();
        ReferYourFriendsScreen.checkReferralCodeIsDisplayed();
        Logger.endTest("Verify the referral code is visible to the user");

    }
}
