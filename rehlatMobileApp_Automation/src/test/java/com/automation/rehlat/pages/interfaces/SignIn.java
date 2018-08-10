package com.automation.rehlat.pages.interfaces;


public interface SignIn {


    /**
     * Check sign in screen is displayed
     * @throws Exception
     */
     void checkSignInScreenIsDisplayed() throws Exception;

    /**
     * Decline the touch id access set up Popup if displayed
     * @throws Exception
     */
    void declineTheTouchIdAccessSetUpPopupIfDisplayed() throws Exception;

    /**
     * Tap on create account button
     * @throws Exception
     */
    void tapOnCreateAccountButton() throws Exception;

    /**
     * Entering login credentials
     * @throws Exception
     */
    void enterLoginCredentials() throws Exception;

    /**
     * Tap on Login button
     * @throws Exception
     */
    void tapOnLoginButton() throws Exception;
}
