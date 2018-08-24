package com.automation.rehlat.pages.signIn;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInIos extends SignInBase {
    public static final String TOUCH_ID_ACCESS_MODAL_TITLE = "Would you like to login using your TouchID?";
    public static final String NO_BUTTON_ON_TOUCH_ID_ACCESS_MODAL = "No";
    public static final String LOGIN_BUTTON = "Login";
    public static final String CREATE_ACCOUNT_BUTTON = "Create Account";
    public static final String NOT_REGISTERED_LABEL = "Not registered?";
    public static final String EMAIL_TEXT_FIELD_OF_SIGN_IN_SCREEN = "Email";
    public static final String PASSWORD_TEXT_FIELD_OF_SIGN_IN_SCREEN = "Password";


    /**
     * Check sign in screen is displayed
     */
    @Override
    public void checkSignInScreenIsDisplayed() {
        Logger.logAction("Checking the sign in screen is displayed or not ?");
        try {
//            driverWait.withTimeout(5,TimeUnit.SECONDS);
            declineTheTouchIdAccessSetUpPopupIfDisplayed();
            if (isElementDisplayedByName(LOGIN_BUTTON) && isElementDisplayedByName(CREATE_ACCOUNT_BUTTON) && isElementDisplayedByName(NOT_REGISTERED_LABEL)){
                Logger.logStep("Sign In screen is displayed");
            }else {
                Logger.logError("Sign In screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Decline the touch id access set up Popup if displayed
     */
    @Override
    public void declineTheTouchIdAccessSetUpPopupIfDisplayed() {
        Logger.logAction("Declining the touch id access popup if displayed");
        try {
            Thread.sleep(2000);
            if (isElementDisplayedByName(TOUCH_ID_ACCESS_MODAL_TITLE)){
                Logger.logStep("Touch id access popup is displayed and going to decline it by tapping on no button");
                driver.findElementByName(NO_BUTTON_ON_TOUCH_ID_ACCESS_MODAL).click();
            }else {
                Logger.logComment("Touch id access alert is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Tap on create account button
     */
    @Override
    public void tapOnCreateAccountButton() {
        Logger.logAction("Taping on create account button");
        try {
            if (isElementDisplayedByName(CREATE_ACCOUNT_BUTTON)){
                driver.findElement(By.name(CREATE_ACCOUNT_BUTTON)).click();
            }else {
                Logger.logComment(CREATE_ACCOUNT_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on button name :- "+CREATE_ACCOUNT_BUTTON);
        }
    }

    /**
     * Entering login credentials
     */
    @Override
    public void enterLoginCredentials() {
        Logger.logAction("Entering login credentials");
        try {
            enterEmailId();
            enterPassword();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the login credentials");
        }
    }

    /**
     * Entering login credentials
     */
    public static void enterEmailId() {
        Logger.logAction("Entering email id :-"+Labels.EMAIL_ID_SIGN_IN);
        try {
            if (isElementDisplayedByName(EMAIL_TEXT_FIELD_OF_SIGN_IN_SCREEN)){
                driver.findElement(By.name(EMAIL_TEXT_FIELD_OF_SIGN_IN_SCREEN)).sendKeys(Labels.EMAIL_ID_SIGN_IN);
                closeTheKeyboard_iOS();
            }else {
                Logger.logError("unable to find the element name :- "+EMAIL_TEXT_FIELD_OF_SIGN_IN_SCREEN);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the login credentials");
        }
    }

    /**
     * Entering login credentials
     */
    public static void enterPassword() {
        Logger.logAction("Entering password :- "+Labels.PASSWORD);
        try {
            if (isElementDisplayedByName(PASSWORD_TEXT_FIELD_OF_SIGN_IN_SCREEN)){
                driver.findElement(By.name(PASSWORD_TEXT_FIELD_OF_SIGN_IN_SCREEN)).sendKeys(Labels.PASSWORD);
                closeTheKeyboard_iOS();
            }else {
                Logger.logError("unable to find the element name :- "+PASSWORD_TEXT_FIELD_OF_SIGN_IN_SCREEN);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the login credentials");
        }
    }

    /**
     * Tap on Login button
     */
    @Override
    public void tapOnLoginButton() {
        Logger.logAction("Tapping on Login button");
        try
        {
            if (isElementDisplayedByName(LOGIN_BUTTON)){
                driver.findElement(By.name(LOGIN_BUTTON)).click();
                waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
            }else {
                Logger.logError(LOGIN_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the element name :- "+LOGIN_BUTTON);
        }
    }

    /**
     * Checking all the fields are filled with information is valid or not
     */
    public static void checkAllTheFieldsAreFilledWithValidInformation() {
        Logger.logAction("Checking the entered information is valid or not");
        try {

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check all the fields are filled with valid information or not ?");
        }
    }
}
