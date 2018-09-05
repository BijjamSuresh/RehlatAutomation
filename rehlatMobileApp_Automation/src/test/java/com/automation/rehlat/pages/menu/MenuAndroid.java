package com.automation.rehlat.pages.menu;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.automation.rehlat.pages.menu.MenuIos.REFER_AND_EARN_SUB_MENU_ICON;

public class MenuAndroid extends MenuBase {

    public static final String NAVIGATION_MENU_VIEW = "com.app.rehlat:id/nav_view";
    public static final String SIGNED_IN_EMAIL_ID_IN_MENU_SCREEN = "com.app.rehlat:id/userEmailAddress";
    public static final String SETTINGS_OPTION = "com.app.rehlat:id/sidemenu_settingllyt";
    public static final String LANGUAGE_ICON = "language_icon";
    public static final String TRIPS_OPTION = "My Trips";
    public static final String SIGN_IN_OR_SIGN_UP_BUTTON = "com.app.rehlat:id/menu_signup";
    public static final String FULL_SCREEN_LAYOUT = "com.app.rehlat:id/drawer_layout";
    public static final String LOGOUT_BUTTON = "com.app.rehlat:id/logoutLayout";
    public static final String SCROLL_VIEW_IN_MENU_SCREEN = "android.widget.ScrollView";
    public static final String TWENTY_FOUR_BAR_SEVEN_SUPPORT_LABEL = "com.app.rehlat:id/sidemenu_supportllyt";
    public static final String REFER_AND_EARN_SUB_MENU_BUTTON = "com.app.rehlat:id/sidemenu_referllyt";
    public static final String PRIVACY_POLICY_OPTION = "com.app.rehlat:id/sidemenu_referllyt";
    public static final String PROFILE_EDIT_ICON = "com.app.rehlat:id/edit_button";
    public static final String XPATH_OF_SETTINGS_SCREEN_TITTLE = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView";
    public static final String[] listOfSubMenuOptions= {"com.app.rehlat:id/menu_signup","com.app.rehlat:id/sidemenu_referllyt","com.app.rehlat:id/sidemenu_inspllyt","com.app.rehlat:id/sidemenu_dealsllyt","com.app.rehlat:id/sidemenu_supportllyt","com.app.rehlat:id/sidemenu_langllyt"};
    public static final String LANGUAGE_TITLE = "com.app.rehlat:id/lang_title";
    public static final String LANGUAGE_TYPE = "com.app.rehlat:id/lang_type";
    public static final String MAIN_TAB_BAR = "com.app.rehlat:id/types_tab";

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
                Logger.logComment("Tapped on sign in / sign up button");
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
    public void tapOnSettingsButton() {
        Logger.logAction("Tapping on Settings button");
        try {
//            if (isElementDisplayedByClassName(SCROLL_VIEW_IN_MENU_SCREEN)){
                if (isElementDisplayedById(SETTINGS_OPTION)){
                    driver.findElementById(SETTINGS_OPTION).click();
                    Logger.logComment("Tapped on Settings button");
                }else {
                    scrollTheMenuViewUp(SCROLL_VIEW_IN_MENU_SCREEN);
                    if (isElementDisplayedById(SETTINGS_OPTION)) {
                        driver.findElementById(SETTINGS_OPTION).click();
                        Logger.logComment("Tapped on Settings button");
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
            tapOnSettingsButton();
//            Thread.sleep(4000);
            if (isSettingsScreenIsDisplayed()){
                if (isElementDisplayedById(LOGOUT_BUTTON)){
                    driver.findElementById(LOGOUT_BUTTON).click();
                    Logger.logComment("Tapped on logout button");
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
     * Checking the Settings screen is displayed or not ?
     * @return
     */
    public static boolean isSettingsScreenIsDisplayed() {
        Logger.logAction("Checking the Settings screen is displayed");
        String valueOfSettingsScreenTitle;
        try{
            waitTillTheProgressIndicatorIsInvisibleById_ANDROID(Labels.ANDROID_ACTIVITY_INDICATOR);
            if (isElementDisplayedByXPath(XPATH_OF_SETTINGS_SCREEN_TITTLE)){
                valueOfSettingsScreenTitle = driver.findElementByXPath(XPATH_OF_SETTINGS_SCREEN_TITTLE).getText();
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

    /**
     * Check all the sub menu options are displayed in menu screen
     * @throws Exception
     */
    @Override
    public void checkAllTheSubMenuOptionsAreDisplayed() throws Exception{
        Logger.logAction("Checking all the sub menu options are displayed");
        try{
            for (int count = 0 ; count<= listOfSubMenuOptions.length;count++){
                String elementName = listOfSubMenuOptions[count];
                if (isElementEnabledById(elementName)){
                    Logger.logComment(elementName+" :- sub menu element is enabled");
                }else {
                    Logger.logError(elementName+" sub menu element is not enabled");
                }
            }
            scrollTheScreenUpwards();
            if (isElementEnabledById(PRIVACY_POLICY_OPTION)){
                Logger.logComment(PRIVACY_POLICY_OPTION+" :- sub menu element is enabled");
            }else {
                Logger.logError(PRIVACY_POLICY_OPTION+" :- sub menu element is not enabled");
            }if (isElementEnabledById(SETTINGS_OPTION)){
                Logger.logComment(SETTINGS_OPTION+" :- sub menu element is enabled");
            }else {
                Logger.logError(SETTINGS_OPTION+" :- sub menu element is not enabled");
            }
            if (isUserSignedIn()){
                if (isElementEnabledById(LOGOUT_BUTTON)){
                    Logger.logComment(LOGOUT_BUTTON+" :- sub menu element id is enabled");
                }else {
                    Logger.logError(LOGOUT_BUTTON+" :- sub menu element id is not enabled");
                }
            }else {
                Logger.logComment("User is not signed in. So no logout button is displayed in the sub menu screen");
            }
            scrollTheScreenDownwards();// This method is to set the menu bar in default state
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check all the sub menu options are displayed");
        }
    }

    /**
     * Tap on profile edit icon
     * @throws Exception
     */
    @Override
    public void tapOnProfileEditIcon() throws Exception{
        Logger.logAction("Tapping on profile edit icon");
        try{
            if (isElementDisplayedById(PROFILE_EDIT_ICON)){
                driver.findElementById(PROFILE_EDIT_ICON).click();
                Logger.logComment("Tapped on profile edit button");
            }else {
                Logger.logError(PROFILE_EDIT_ICON+" ;- element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to tap on profile edit icon");
        }
    }

    /**
     * Tap on Refer and earn icon in the menu screen
     */
    @Override
    public void tapOnReferAndEarnIcon(){
        Logger.logAction("Tapping on refer and earn icon in the menu screen");
        try{
            if (isElementEnabledById(REFER_AND_EARN_SUB_MENU_ICON)){
                Logger.logComment(REFER_AND_EARN_SUB_MENU_ICON+" :- sub menu element is enabled");
                driver.findElementById(REFER_AND_EARN_SUB_MENU_ICON).click();
                Logger.logStep("Tapped on refer and earn button");
            }else {
                Logger.logError(REFER_AND_EARN_SUB_MENU_ICON+" :- sub menu element is not enabled");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on refer and earn icon");
        }
    }

    /**
     * Tap on trips sub menu option
     */
    @Override
    public void tapOnMyTripsSubMenuButton(){
        Logger.logAction("Tapping on My Trips option in menu list");
        try{
            //Todo: This method need to be rechecked after implementation of new UI in iOS because MyTrips is displaying in menu screen in iOS and in main tab bar in Android app
            MenuScreen.navigateToFlightsTab();
            FlightsScreen.checkFlightsTabIsDisplayed();
            if (isElementEnabledById(MAIN_TAB_BAR)){
                List<WebElement> listOfTabs = driver.findElementById(MAIN_TAB_BAR).findElements(By.id(Labels.ANDROID_TEXT_VIEW));
                String tripsTabName = listOfTabs.get(3).getText();
                if (tripsTabName.equalsIgnoreCase(TRIPS_OPTION)){
                    listOfTabs.get(3).click();
                    Logger.logStep("Tapped on trips option");
                }else {
                    Logger.logError("Trips option is not displayed");
            }
            }else {
                Logger.logError("Tab bar is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on my trips sub menu button");
        }
    }

    /**
     * Tap on Arabic option in sub menu button
     */
    @Override
    public void tapOnArabicInSubMenuButton(){
        Logger.logAction("Tapping on Arabic option in menu list");
        try{
            if (isElementEnabledById(LANGUAGE_TITLE)){
                WebElement languageTitle = driver.findElementById(LANGUAGE_TITLE);
                String languageTitleName = languageTitle.getText();
                if (languageTitleName.equalsIgnoreCase(Labels.ARABIC_LANGUAGE)){
                    Logger.logComment(Labels.ARABIC_LANGUAGE+" :- sub menu element is displayed");
                    languageTitle.click();
                    Logger.logStep("Arabic option is tapped");
                }
            }else {
                Logger.logError(Labels.ARABIC_LANGUAGE+" sub menu element is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on my trips sub menu button");
        }
    }

    /**
     * Tap on English option in sub menu button
     */
    @Override
    public void tapOnEnglishInSubMenuButton(){
        Logger.logAction("Tapping on Arabic option in menu list");
        try{
            if (isElementEnabledById(LANGUAGE_TYPE)){
                WebElement languageTitle = driver.findElementById(LANGUAGE_TYPE);
                String languageTitleName = languageTitle.getText();
                if (languageTitleName.equalsIgnoreCase(Labels.ENGLISH_LANGUAGE)){
                    Logger.logComment(Labels.ENGLISH_LANGUAGE+" :- sub menu element is displayed");
                    languageTitle.click();
                    Logger.logStep("English option is tapped");
                }
            }else {
                Logger.logError(Labels.ENGLISH_LANGUAGE+" sub menu element is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on my trips sub menu button");
        }
    }


}
