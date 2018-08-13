package com.automation.rehlat.pages.signUp;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.pages.flights.FlightsIos;
import org.openqa.selenium.By;

public class SignUpIos extends SignUpBase {

    public static final String TOUCH_ID__AS_SIGN_UP_BUTTON = "USE TOUCHID FOR SIGN UP";
    public static final String SIGN_UP_BUTTON = "Sign Up";
    public static final String FIRST_NAME_TEXT_FIELD = "First Name";
    public static final String LAST_NAME_TEXT_FIELD = "Last Name";
    public static final String EMAIL_TEXT_FIELD = "Email";
    public static final String PASSWORD_TEXT_FIELD = "Password";
    public static final String REPEAT_PASSWORD_TEXT_FIELD = "Repeat Password";
    public static final String SELECT_DOMAIN_TEXT_FIELD = "Select Domain";
    public static final String REFERRAL_CODE_TEXT_FIELD = "Referral Code (Optional)";


    /**
     * Check sign up screen is displayed
     */
    @Override
    public void checkSignUpScreenIsDisplayed() {
        Logger.logAction("Checking the sign in or sign up screen is displayed or not ?");
        try {
            if (isElementDisplayedByName(SIGN_UP_BUTTON) && isElementDisplayedByName(REPEAT_PASSWORD_TEXT_FIELD) && isElementDisplayedByName(TOUCH_ID__AS_SIGN_UP_BUTTON)){
                Logger.logStep("Sign Up screen is displayed");
            }else {
                Logger.logError("Sign Up screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter sign up credentials
     */
    @Override
    public void enterSignUpCredentials() {
        Logger.logAction("Entering Sign up credentials");
        try {
            enterUserFirstName();
            enterUserLastName();
            enterUserEmailId();
            enterUserPassword();
            enterUserRepeatPassword();
            selectDomain();
            enterReferralCode();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter user first name
     */
    @Override
    public void enterUserFirstName() {
        Logger.logAction("Entering user first name");
        try {
            if (isElementDisplayedByName(FIRST_NAME_TEXT_FIELD)){
                driver.findElement(By.name(FIRST_NAME_TEXT_FIELD)).sendKeys(Labels.FIRST_NAME);
                closeTheKeyboard();
            }else {
                Logger.logError(FIRST_NAME_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter user last name
     */
    @Override
    public void enterUserLastName() {
        Logger.logAction("Entering user last name");
        try {
            if (isElementDisplayedByName(LAST_NAME_TEXT_FIELD)){
                driver.findElement(By.name(LAST_NAME_TEXT_FIELD)).sendKeys(Labels.LAST_NAME);
                closeTheKeyboard();
            }else {
                Logger.logError(LAST_NAME_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter user email id
     */
    @Override
    public void enterUserEmailId() {
        Logger.logAction("Entering user email id");
        try {
            if (isElementDisplayedByName(EMAIL_TEXT_FIELD)){
                driver.findElement(By.name(EMAIL_TEXT_FIELD)).sendKeys(Labels.EMAIL_ID_SIGN_UP);
                closeTheKeyboard();
            }else {
                Logger.logError(EMAIL_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter user password for sign up
     */
    @Override
    public void enterUserPassword() {
        Logger.logAction("Entering user sign up password");
        try {
            if (isElementDisplayedByName(PASSWORD_TEXT_FIELD)){
                driver.findElement(By.name(PASSWORD_TEXT_FIELD)).sendKeys(Labels.PASSWORD);
                closeTheKeyboard();
            }else {
                Logger.logError(PASSWORD_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter user sign up repeat password
     */
    @Override
    public void enterUserRepeatPassword() {
        Logger.logAction("Entering user sign up repeat password");
        try {
            if (isElementDisplayedByName(REPEAT_PASSWORD_TEXT_FIELD)){
                driver.findElement(By.name(REPEAT_PASSWORD_TEXT_FIELD)).sendKeys(Labels.REPEAT_PASSWORD);
                closeTheKeyboard();
            }else {
                Logger.logError(REPEAT_PASSWORD_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Select the user domain (Country domain)
     */
    @Override
    public void selectDomain() {
        Logger.logAction("Selecting user country domain");
        try {
            if (isElementDisplayedByName(SELECT_DOMAIN_TEXT_FIELD)){
                driver.findElement(By.name(SELECT_DOMAIN_TEXT_FIELD)).click();
                selectCountryNameAndTapOnContinueButton();
            }else {
                Logger.logError(SELECT_DOMAIN_TEXT_FIELD+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Select the country domain and tap on Continue button
     */
    public static void selectCountryNameAndTapOnContinueButton() {
        Logger.logAction("Selecting user country domain and tap on tap on continue button");
        try {
            if (isElementDisplayedByName(Labels.KUWAIT_LANGUAGE_COUNTRY_LABEL)){
                driver.findElement(By.name(Labels.KUWAIT_LANGUAGE_COUNTRY_LABEL)).click();
                driver.findElement(By.name(FlightsIos.CONTINUE_BUTTON)).click();
            }else {
                Logger.logError(Labels.KUWAIT_LANGUAGE_COUNTRY_LABEL+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Enter referral code
     */
    @Override
    public void enterReferralCode() {
        Logger.logAction("Entering referral code");
        try {
            if (isElementDisplayedByName(REFERRAL_CODE_TEXT_FIELD)){
                driver.findElement(By.name(REFERRAL_CODE_TEXT_FIELD)).sendKeys(Labels.REFERRAL_CODE);
                closeTheKeyboard();
            }else {
                Logger.logError(REFERRAL_CODE_TEXT_FIELD +" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current active screen name");
        }
    }

    /**
     * Tap on Sign Up button
     */
    @Override
    public void tapOnSignUpButton() {
        Logger.logAction("Taping on create account button");
        try {
            if (isElementDisplayedByName(SIGN_UP_BUTTON)){
                driver.findElement(By.name(SIGN_UP_BUTTON)).click();
            }else {
                Logger.logError(SIGN_UP_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on button name :- "+SIGN_UP_BUTTON);
        }
    }

    /**
     * Checking all the fields are filled with information is valid or not
     */
    public static void checkAllTheFieldsAreFilledWithValidInformation() throws Exception{
        Logger.logAction("Checking the entered information is valid or not");
        try {


        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check all the fields are filled with valid information or not ?");
        }
    }
}
