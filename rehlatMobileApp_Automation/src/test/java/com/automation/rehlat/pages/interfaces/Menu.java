package com.automation.rehlat.pages.interfaces;

public interface Menu {

    /**
     * Check menu screen is displayed
     * @throws Exception
     */
    void checkMenuScreenIsDisplayed() throws Exception;

    /**
     * Tap on sign in or sing up button
     * @throws Exception
     */
    void tapOnSignUpOrSignInButton() throws Exception;

    /**
     * Check user is signed up (in menu screen) with correct parsing credentials (in signed up screen )
     * @throws Exception
     */
    void checkUserIsSignedUpSignedInWithCorrectParsingCredentials(String emailEnteredInSignUpScreen) throws Exception;

    /**
     * Navigate to the flights tab
     * @throws Exception
     */
    void navigateToFlightsTab() throws Exception;

    /**
     * Check whether user is signed in in the app
     * @return
     * @throws Exception
     */
    boolean isUserSignedIn() throws Exception;

    /**
     * Tap on logout button
     * @throws Exception
     */
   void tapOnLogoutButton() throws Exception;
}