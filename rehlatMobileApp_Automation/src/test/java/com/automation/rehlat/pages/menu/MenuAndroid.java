package com.automation.rehlat.pages.menu;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuAndroid extends MenuBase {

    public static final String NAVIGATION_MENU_VIEW = "com.app.rehlat:id/nav_view";
    public static final String SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN = "com.app.rehlat:id/userEmailAddress";
    public static final String SETTINGS_OPTION = "com.app.rehlat:id/sidemenu_settingllyt";
    public static final String LANGUAGE_ICON = "language_icon";
    public static final String TRIPS_OPTION = "Trips";
    public static final String SIGN_IN_OR_SIGN_UP_BUTTON = "com.app.rehlat:id/menu_signup";
    public static final String FULL_SCREEN_LAYOUT = "com.app.rehlat:id/drawer_layout";
    public static final String LOGOUT_BUTTON = "com.app.rehlat:id/logoutLayout";
    public static final String SCROLL_VIEW_IN_MENU_SCREEN = "android.widget.ScrollView";
    public static final String TWENTY_FOUR_BAR_SEVEN_SUPPORT_LABEL = "com.app.rehlat:id/sidemenu_supportllyt";
    public static final String XPATH_OF_SETTINGS_SCREEN_TITTLE = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView";
//    public static final String


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
            if (isElementDisplayedById(SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN) && !isElementDisplayedById(SIGN_IN_OR_SIGN_UP_BUTTON)){
//                List<WebElement> checkedTextViews = driver.findElementsByClassName(CHECKED_TEXT_VIEW);
//                for (int index=0; index<=checkedTextViews.size()-1;index++){
//                    String checkedTextViewName = checkedTextViews.get(index).getText();
//                    if (checkedTextViewName.equals(LOGOUT_BUTTON)){
                        Logger.logStep("User is signed in");
                        return true;
//                    }else {
//                        continue;
//                    }
//                }
            }else {
                Logger.logStep("User is not signed in");
                return false;
            }
        }catch (Exception exception){
            Logger.logError("encountered error: Unable to check the user signed in status");
        }
        return false;
    }

    /**
     * Tap on Settings button
     */
    @Override
    public void tapOnSettingsButton() throws Exception{
        Logger.logAction("Tapping on settings button");
        try {
//            if (isElementDisplayedByClassName(SCROLL_VIEW_IN_MENU_SCREEN)){
                if (isElementDisplayedById(SETTINGS_OPTION)){
                    driver.findElementById(SETTINGS_OPTION).click();
                }else {
                    scrollTheMenuViewUp(SCROLL_VIEW_IN_MENU_SCREEN);
                    if (isElementDisplayedById(SETTINGS_OPTION)) {
                        driver.findElementById(SETTINGS_OPTION).click();
                    }else {
                        Logger.logError(SETTINGS_OPTION+" :- element name is not displayed in the current active screen");
                    }
                }
//            }else {
//                Logger.logError(SCROLL_VIEW_IN_MENU_SCREEN+" :- element id is not displayed in the current active screen");
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on the logout button");
        }
    }

    /**
     * Tap on logout button
     */
    @Override
    public void tapOnLogoutButton() {
        Logger.logAction("Tapping on logout button");
        try {
//            tapOnSettingsButton();
//            Thread.sleep(4000);
            if (isSettingsScreenIsDisplayed()){
                if (isElementDisplayedById(LOGOUT_BUTTON)){
                    driver.findElementById(LOGOUT_BUTTON).click();
                }else {
                    Logger.logError(LOGOUT_BUTTON+" :- element name is not displayed in the current active screen");
                }
            }else {
                Logger.logError("Settigns screen is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on the logout button");
        }
    }

    /**
     * Checking the settings screen is displayed or not ?
     * @return
     * @throws Exception
     */
    public static boolean isSettingsScreenIsDisplayed() throws Exception{
        Logger.logAction("Checking the settings screen is displayed");
        String valueOfSettingsScreenTitle;
        try{
            if (isElementDisplayedByXPath(XPATH_OF_SETTINGS_SCREEN_TITTLE)){
                valueOfSettingsScreenTitle = driver.findElement(By.xpath(XPATH_OF_SETTINGS_SCREEN_TITTLE)).getText();
                if (valueOfSettingsScreenTitle.equals("Settings")){
                    return true;
                }else {
                    Logger.logError(" Settings screen is not displayed in the current active screen");
                }
            }else {
                Logger.logError(XPATH_OF_SETTINGS_SCREEN_TITTLE+" :- element xpath is not visible in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name");
        }
        return false;
    }

    /**
     * Scroll the menu screen to upwards
     */
    public static void scrollTheMenuViewUp(String viewType) {
        Logger.logAction("Scrolling the menu view upwards");
        try{
            if (isElementDisplayedByClassName(viewType)){
                scrollTheScreenUpwards();
            }else {
                Logger.logError(viewType+" :- element id is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll to the menu view to upwards");
        }
    }
}
