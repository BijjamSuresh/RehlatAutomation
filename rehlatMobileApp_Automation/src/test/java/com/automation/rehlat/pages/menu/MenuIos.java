package com.automation.rehlat.pages.menu;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.pages.interfaces.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MenuIos extends MenuBase {

    public static final String TRIPS_OPTION = "Trips";
    public static final String SETTINGS_OPTION = "Settings";
    public static final String TWENTY_FOUR_BAR_SEVEN_SUPPORT_OPTION = "Rehlat 24X 7 Support";
    public static final String SIGN_IN_OR_SIGN_UP_BUTTON = "Sign In/Sign Up";
    public static final String REFER_AND_EARN_SUB_MENU_ICON = "com.app.rehlat:id/sidemenu_referllyt";
    public static final String LOGOUT_BUTTON = "Logout";
    public static final String ARABIC_OPTION = "Arabic";
    public static final String ENGLISH_OPTION = "English";
    public static final String PROFILE_EDIT_ICON = "profile edit icon";
    public static final String XPATH_OF_MENU_SCREEN = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]";
    public static final String[] listOfSubMenuOptions= {"Sign In/Sign Up","Trips","Rehlat 24X 7 Support","Arabic","Settings","Privacy Policy"};

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
                Logger.logAction("Tapped on signin or sign up button");
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
//            Thread.sleep(Labels.WAIT_TIME_MIN);
            if (isElementDisplayedByXPath(XPATH_OF_MENU_SCREEN)){
                WebElement xpathOfMenuScreen = driver.findElementByXPath(XPATH_OF_MENU_SCREEN);
                tapOnElementBasedOnLocation(xpathOfMenuScreen,"bottomRight");
                Logger.logComment("Naviagted from menu screen");
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
            if (! isElementDisplayedByAccessibilityId(SIGN_IN_OR_SIGN_UP_BUTTON)){
                Logger.logStep("User is signed in");
                return true;
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
            if (isElementDisplayedById(SETTINGS_OPTION)){
                driver.findElementById(SETTINGS_OPTION).click();
            }else {
                Logger.logError(SETTINGS_OPTION+" :- element name is not displayed in the current active screen");
            }
        } catch (Exception exception){
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
            if (isElementDisplayedById(LOGOUT_BUTTON)){
                driver.findElement(By.id(LOGOUT_BUTTON)).click();
                Logger.logComment("Tapped on logout button");
            }else {
                Logger.logError("Logout button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on the logout button");
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
            for (int count = 0 ; count<= listOfSubMenuOptions.length-1;count++){
                String elementName = listOfSubMenuOptions[count];
                if (count==0){
                    if (isUserSignedIn()){
                        Logger.logComment("User is signed in.So, no sign in or sign up button");
                    }else
                    {
                        if (isElementDisplayedByName(elementName)){
                            Logger.logComment(elementName+" :- sub menu element is displayed");
                        }else {
                            Logger.logError(elementName+" sub menu element is not displayed");
                        }
                    }
                }else {
                    if (isElementDisplayedByName(elementName)){
                        Logger.logComment(elementName+" :- sub menu element is displayed");
                    }else {
                        Logger.logError(elementName+" sub menu element is not displayed");
                    }
                }
            }if (isElementEnabledByName(REFER_AND_EARN_SUB_MENU_ICON)){
                Logger.logComment(REFER_AND_EARN_SUB_MENU_ICON+" :- sub menu element is enabled");
            }else {
                Logger.logError(REFER_AND_EARN_SUB_MENU_ICON+" :- sub menu element is not enabled");
            }
            if (isUserSignedIn()){
                if (isElementDisplayedById(LOGOUT_BUTTON)){
                    Logger.logComment(LOGOUT_BUTTON+" :- sub menu element id is displayed");
                }else {
                    Logger.logError(LOGOUT_BUTTON+" :- sub menu element id is not displayed");
                }
            }else {
                Logger.logComment("User is not signed in. So no logout button is displayed in the sub menu screen");
            }
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
            if (isElementDisplayedByName(PROFILE_EDIT_ICON)){
                driver.findElementByName(PROFILE_EDIT_ICON).click();
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
            if (isElementEnabledByName(REFER_AND_EARN_SUB_MENU_ICON)){
                Logger.logComment(REFER_AND_EARN_SUB_MENU_ICON+" :- sub menu element is enabled");
                driver.findElementByName(REFER_AND_EARN_SUB_MENU_ICON).click();
                Logger.logStep("Tapped on refer and earn button");
            }else {
                Logger.logError(REFER_AND_EARN_SUB_MENU_ICON+" :- sub menu element is not enabled");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on refer and earn icon");
        }
    }

    /**
     * Tap on my trips sub menu option
     */
    @Override
    public void tapOnMyTripsSubMenuButton(){
        Logger.logAction("Tapping on My Trips option in menu list");
        try{
            if (isElementDisplayedByName(TRIPS_OPTION)){
                Logger.logComment(TRIPS_OPTION+" :- sub menu element is displayed");
                driver.findElementByName(TRIPS_OPTION).click();
                Logger.logStep("Trips option is tapped");
            }else {
                Logger.logError(TRIPS_OPTION+" sub menu element is not displayed");
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
            if (isElementDisplayedByName(ARABIC_OPTION)){
                Logger.logComment(ARABIC_OPTION+" :- sub menu element is displayed");
                driver.findElementByName(ARABIC_OPTION).click();
                Logger.logStep("Arabic option is tapped");
            }else {
                Logger.logError(ARABIC_OPTION+" sub menu element is not displayed");
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
            if (isElementDisplayedByName(ENGLISH_OPTION)){
                Logger.logComment(ENGLISH_OPTION+" :- sub menu element is displayed");
                driver.findElementByName(ENGLISH_OPTION).click();
                Logger.logStep("English option is tapped");
            }else {
                Logger.logError(ENGLISH_OPTION+" sub menu element is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on my trips sub menu button");
        }
    }

}
