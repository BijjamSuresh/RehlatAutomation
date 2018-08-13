package com.automation.rehlat.pages.menu;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuAndroid extends MenuBase {

    public static final String NAVIGATION_MENU_VIEW = "com.app.rehlat:id/design_navigation_view";
    public static final String SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN = "com.app.rehlat:id/userEmailAddress";
    public static final String SETTINGS_OPTION = "Settings";
    public static final String LANGUAGE_ICON = "language_icon";
    public static final String TRIPS_OPTION = "Trips";
    public static final String SIGN_IN_OR_SIGN_UP_BUTTON = "com.app.rehlat:id/menu_signup";
    public static final String FULL_SCREEN_LAYOUT = "com.app.rehlat:id/drawer_layout";
    public static final String LOGOUT_BUTTON = "Logout";
    public static final String CHECKED_TEXT_VIEW = "android.widget.CheckedTextView";
    public static final String XPATH_OF_LOGOUT_BUTTON_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[";


    /**
     * Check menu screen is displayed
     */
    @Override
    public void checkMenuScreenIsDisplayed() {
        Logger.logAction("Checking menu screen is displayed or not ?");
        try {
            if (isElementDisplayedById(NAVIGATION_MENU_VIEW)){
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
            if (isElementDisplayedById(SIGN_IN_OR_SIGN_UP_BUTTON)){
                driver.findElement(By.id(SIGN_IN_OR_SIGN_UP_BUTTON)).click();
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
        Logger.logAction("Check app is signed up or signed in with user parsing signUp credentials");
        try {
            if (isElementDisplayedById(SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN)){
                String signedInEmailId = driver.findElementById(SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN).getText();
                {
                    if (signedInEmailId.matches(emailEnteredInSignUpScreen)){
                        Logger.logStep("App is signed up with correct user parsed signed up credentials");
                    }else {
                        Logger.logError("App is not signed up with correct user parsed signed up credentials");
                    }
                }
            }else {
                Logger.logError(SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN+"- element name is not displayed in the current active screen");
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
            if (isElementDisplayedById(FULL_SCREEN_LAYOUT)){
                WebElement fullScreenLayout = driver.findElementById(FULL_SCREEN_LAYOUT);
                tapOnElementBasedOnLocation(fullScreenLayout,"bottomRight");
            }else {
                Logger.logError("Menu screen xpath is incorrect :-"+FULL_SCREEN_LAYOUT);
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
            if (isElementDisplayedByClassName(CHECKED_TEXT_VIEW)){
                List<WebElement> checkedTextViews = driver.findElementsByClassName(CHECKED_TEXT_VIEW);
                for (int index=0; index<=checkedTextViews.size()-1;index++){
                    String checkedTextViewName = checkedTextViews.get(index).getText();
                    if (checkedTextViewName.equals(LOGOUT_BUTTON)){
                        Logger.logComment("User is signed in");
                        return true;
                    }else {
                        continue;
                    }
                }
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
            if (isElementDisplayedByClassName(CHECKED_TEXT_VIEW)){
                List<WebElement> checkedTextViews = driver.findElementsByClassName(CHECKED_TEXT_VIEW);
                for (int index=0; index<=checkedTextViews.size()-1;index++){
                    String checkedTextViewName = checkedTextViews.get(index).getText();
                    if (checkedTextViewName.matches(LOGOUT_BUTTON)){
                        index = index+1;
                        Logger.logStep("User is signed in and moving to tap on logout button");
                        driver.findElement(By.xpath(XPATH_OF_LOGOUT_BUTTON_WITHOUT_INDEX+index+"]")).click();
                        break;
                    }else {
                        continue;
                    }
                }
            }else {
                Logger.logError("Logout button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on the logout button");
        }
    }
}
