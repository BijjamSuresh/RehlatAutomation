package com.automation.rehlat.pages.menu;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MenuIos extends MenuBase {

    public static final String TRIPS_OPTION = "Trips";
    public static final String SETTINGS_OPTION = "Settings";
    public static final String TWENTY_FOUR_BAR_SEVEN_SUPPORT_OPTION = "Rehlat 24X 7 Support";
    public static final String SIGN_IN_OR_SIGN_UP_BUTTON = "Sign In/Sign Up";
    public static final String LOGOUT_BUTTON = "Logout";
    public static final String XPATH_OF_MENU_SCREEN = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]";

    /**
     * Check menu screen is displayed
     */
    @Override
    public void checkMenuScreenIsDisplayed() {
        Logger.logAction("Checking menu screen is displayed or not ?");
        try {
            if (isElementDisplayedById(TRIPS_OPTION) && isElementDisplayedById(SETTINGS_OPTION) && isElementDisplayedById(TWENTY_FOUR_BAR_SEVEN_SUPPORT_OPTION)){
                Logger.logStep("Menu screen is displayed");
            }
            else {
                Logger.logError("Menu screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Tap on sign in or sing up button
     */
    @Override
    public void tapOnSignUpOrSignInButton() {
        Logger.logComment("Tapping on sign up or sign in button");
        try {
            if (isElementDisplayedByName(SIGN_IN_OR_SIGN_UP_BUTTON)){
                driver.findElement(By.name(SIGN_IN_OR_SIGN_UP_BUTTON)).click();
            }else {
                Logger.logError("Sign in or sign up button is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on sign up or sign in button");
        }
    }

    /**
     * Check user is signed up (in menu screen) with correct parsing credentials (in signed up screen )
     */
    @Override
    public void checkUserIsSignedUpSignedInWithCorrectParsingCredentials(String emailEnteredInSignUpScreen) {
        Logger.logAction("Check app is signed up with user parsing signUp credentials");
        try {
            if (isElementDisplayedById(emailEnteredInSignUpScreen)){
                Logger.logStep("App is signed up with correct user parsed signed up credentials");
            }else {
                Logger.logError("App is not signed up with correct user parsed signed up credentials");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the user signed up status");
        }
    }

    /**
     * Navigate to the flights tab
     */
    @Override
    public void navigateToFlightsTab() {
        Logger.logAction("Navigating to flights tab");
        try {
            Thread.sleep(Labels.WAIT_TIME_MIN);
            if (isElementDisplayedByXPath(XPATH_OF_MENU_SCREEN)){
                WebElement xpathOfMenuScreen = driver.findElementByXPath(XPATH_OF_MENU_SCREEN);
                tapOnElementBasedOnLocation(xpathOfMenuScreen,"bottomRight");
            }else {
                Logger.logError("Menu screen xpath is incorrect :-"+XPATH_OF_MENU_SCREEN);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to navigate to flights tab");
        }
    }

    /**
     * Check whether user is signed in in the app
     * @return
     */
    @Override
    public boolean isUserSignedIn() {
        Logger.logAction("Checking user is signed in or not ?");
        try {
            if (isElementDisplayedById(LOGOUT_BUTTON)){
                Logger.logComment("User is signed in");
                return true;
            }else {
                Logger.logComment("User is not signed in");
                return false;
            }
        }catch (Exception exception){
            Logger.logError("encountered error: Unable to check the user signed in status");
        }
        return false;
    }

    /**
     * Tap on logout button
     */
    @Override
    public void tapOnLogoutButton() {
        Logger.logAction("Tapping on logout button");
        try {
            if (isElementDisplayedById(LOGOUT_BUTTON)){
                driver.findElement(By.id(LOGOUT_BUTTON)).click();
            }else {
                Logger.logError("Logout button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on the logout button");
        }
    }

}
