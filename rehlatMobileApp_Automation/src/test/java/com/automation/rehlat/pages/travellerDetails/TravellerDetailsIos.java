package com.automation.rehlat.pages.travellerDetails;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public class TravellerDetailsIos extends TravellerDetailsBase {

    public static final String TRAVELLERS_FIRST_NAME="First Name";
    public static final String TRAVELLERS_MIDDLE_NAME="Middle Name";
    public static final String TRAVELLERS_LAST_NAME="Last Name";
    public static final String TRAVELLERS_DATEOFBIRTH_NAME="Date Of Birth";
    public static final String TRAVELLERS_PASSPORT_NUMBER="Passport Number";
    public static final String TRAVELLERS_PASSPORT_EXPIRY_NUMBER="Passport Expiry Date";
    public static final String TRAVELLERS_PASSPORT_ISSUING_COUNTRY="Issuing Country";
    public static final String TRAVELLERS_NATIONALITY="Nationality";
    public static final String CHOOSE_COUNTRY_MODAL="Choose Country";
    public static final String SAVE_BUTTON="Save";
    public static final String PICKER_WHEEL = "XCUIElementTypePickerWheel";
    public static final String TRAVELLERS_DETAILS_SCREEN_TITLE ="Traveller Details";
    public static final String TRAVELLERS_PRE_POPULLATE_MODAL_VIEW = "Populate the fields with your previous inputs?";
    public static final String XPATH_OF_TRAVELLERS_DETAILS_MODAL ="//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";


    /**
     * Check the travellers details screen is displayed
     */
    @Override
    public void checkTravellersDetailsScreenIsDisplayed() {
        Logger.logAction("Checking the travellers details screen is displayed or not ?");
        try {
            if (isElementDisplayedByName(TRAVELLERS_DETAILS_SCREEN_TITLE)){
                Logger.logStep("Travellers details screen is displayed");
            } else {
                Logger.logError("Travellers details screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the current active screen name");
        }
    }

    /**
     * Accept the auto fill populate modal if displayed
     */
    @Override
    public boolean acceptAutoFillPopulateModalIfDisplayed() {
        Logger.logAction("Accepting the auto fill popup if displayed");
        try{
            if (isElementDisplayedByClassName(Labels.IOS_XCUI_ELEMENT_TYPE_SHEET)){
                WebElement popUpModal = driver.findElementByClassName(Labels.IOS_XCUI_ELEMENT_TYPE_SHEET);
                String popUpModalTitle = popUpModal.findElement(By.className(Labels.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT)).getAttribute(Labels.NAME_ATTRIBUTE);
                if (popUpModalTitle.equals(TRAVELLERS_PRE_POPULLATE_MODAL_VIEW)){
                    Logger.logStep("Auto fill popup modal is displayed and going to accept it");
                    if (isElementDisplayedByName(YES_BUTTON)){
                        driver.findElementByName(YES_BUTTON).click();
                        Logger.logComment("Tapped on yes button");
                        return true;
                    }else{
                        Logger.logError("Button with - Yes - name is not displayed in the popup");
                    }
                }else{
                    Logger.logError("Auto fill PopUp is not displayed but a popup is displayed with different title");
                }
            } else {
                Logger.logComment("PopUp modal is not displayed in the current active screen and moving to next test step");
                return false;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to decline the auto fill popup ");
        }
        return false;
    }
    /**
     * Decline the auto fill populate modal if displayed
     */
    @Override
    public void declineAutoFillPopulateModalIfDisplayed() {
        Logger.logAction("Declining the auto fill popup if displayed");
        try{
            if (isElementDisplayedByClassName(Labels.IOS_XCUI_ELEMENT_TYPE_SHEET)){
                WebElement popUpModal = driver.findElementByClassName(Labels.IOS_XCUI_ELEMENT_TYPE_SHEET);
                String popUpModalTitle = popUpModal.findElement(By.className(Labels.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT)).getAttribute(Labels.NAME_ATTRIBUTE);
                if (popUpModalTitle.equals(TRAVELLERS_PRE_POPULLATE_MODAL_VIEW)){
                    Logger.logStep("Auto fill popup modal is displayed and going to decline it");
                    if (isElementDisplayedByName(NO_BUTTON)){
                        driver.findElementByName(NO_BUTTON).click();
                        Logger.logComment("Tapped on no button");
                    }else{
                        Logger.logError("Button with - No - name is not displayed in the popup");
                    }
                }else{
                    Logger.logError("Auto fill PopUp is not displayed but a popup is displayed with different title");
                }
            } else {
                Logger.logComment("PopUp modal is not displayed in the current active screen and moving to next test step");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to decline the auto fill popup ");
        }
    }


    /**
     * Enter adult travellers details
     */
    @Override
    public void enterAdultTravellersDetails(String travellersCountry) {
        Logger.logStep("Entering the adult travellers details");
        try{
            if (isElementDisplayedByXPath(XPATH_OF_TRAVELLERS_DETAILS_MODAL)){
                Logger.logStep("Travellers details modal is displayed and moving to next step");
                enterTravellersDetails(travellersCountry);
            }else {
                Logger.logError("Travellers details modal is not displayed or interactions are not available for the current active screen");
            }
        } catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the adult travellers details in the current active screen");
        }
    }

    /**
     * Enter the travellers details
     */
    public static void enterTravellersDetails(String travellersCountry) {
        Logger.logAction("Entering travellers details");
        try{
            enterTravellersFirstName();
            enterTravellersMiddleName();
            enterTravellersLastName();
            if (Labels.FLIGHT_BOOKING_TYPE.equals(Labels.INTERNATIONAL_FLIGHT_BOOKING)){
                enterTravellersDateOfBirth();
                enterTravellersPassportNumber();
                enterTravellersPassportExpiryDate();
                selectPassportIssuingCountry(travellersCountry);
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                selectTravellersNationality(travellersCountry);
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
            }else if (Labels.FLIGHT_BOOKING_TYPE.equals(Labels.DOMESTIC_FLIGHT_BOOKING)){
                Logger.logStep("For domestic flights DOB, Passport and its expiry date and passport issuing country are might or might not necessary.., So filling the necessary information for the current flight ...,");
                if (isElementDisplayedByName(TRAVELLERS_DATEOFBIRTH_NAME)){
                    enterTravellersDateOfBirth();
                }
                if (isElementDisplayedByName(TRAVELLERS_PASSPORT_NUMBER)){
                    enterTravellersPassportNumber();
                }
                if (isElementDisplayedByName(TRAVELLERS_PASSPORT_EXPIRY_NUMBER)){
                    enterTravellersPassportExpiryDate();
                }
                if (isElementDisplayedByName(TRAVELLERS_PASSPORT_ISSUING_COUNTRY)){
                    selectPassportIssuingCountry(travellersCountry);
                    TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                }
                if (isElementDisplayedByName(TRAVELLERS_NATIONALITY)){
                    selectTravellersNationality(travellersCountry);
                    TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                }
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to enter the travellers details");
        }
    }

    /**
     * Enter the travellers first name
     */
    public static void enterTravellersFirstName() {
        Logger.logAction("Entering travellers first name");
        try{
            if (isElementDisplayedByName(TRAVELLERS_FIRST_NAME)){
                driver.findElementByName(TRAVELLERS_FIRST_NAME).sendKeys(Labels.TRAVELLERS_FIRST_NAME);
                Logger.logComment(Labels.TRAVELLERS_FIRST_NAME+" :- is parsed");
                closeTheKeyboard_iOS();
            }else {
                Logger.logError("Travellers first name field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers first name");
        }
    }

    /**
     * Enter the travellers middle name
     */
    public static void enterTravellersMiddleName() {
        Logger.logAction("Entering travellers middle name");
        try{
            if (isElementDisplayedByName(TRAVELLERS_MIDDLE_NAME)){
                driver.findElementByName(TRAVELLERS_MIDDLE_NAME).sendKeys(Labels.TRAVELLERS_MIDDLE_NAME);
                Logger.logComment(Labels.TRAVELLERS_MIDDLE_NAME+" :- is parsed");
                closeTheKeyboard_iOS();
            }else {
                Logger.logError("Travellers middle name field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers middle name");
        }
    }

    /**
     * Enter the travellers last name
     */
    public static void enterTravellersLastName() {
        Logger.logAction("Entering travellers last name");
        try{
            if (isElementDisplayedByName(TRAVELLERS_LAST_NAME)){
                driver.findElementByName(TRAVELLERS_LAST_NAME).sendKeys(Labels.TRAVELLERS_LAST_NAME);
                Logger.logComment(Labels.TRAVELLERS_LAST_NAME+" :- is parsed");
                driver.hideKeyboard();
            }else {
                Logger.logError("Travellers last name field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers last name");
        }
    }
    /**
     * Enter the travellers Date of Birth
     */
    public static void enterTravellersDateOfBirth() {
        Logger.logAction("Entering travellers Date of Birth");
        try{
            if (isElementDisplayedByName(TRAVELLERS_DATEOFBIRTH_NAME)){
                driver.findElementByName(TRAVELLERS_DATEOFBIRTH_NAME).click();
                Logger.logComment("Tapped on Travellers date of birth field");
                if (isDatePickerDisplayed()){
                    List<IOSElement> wheels = (List) driver.findElements(By.className(PICKER_WHEEL));
                    wheels.get(0).sendKeys(Labels.DAY_IN_TRAVELLERS_DATEOFBIRTH_IOS);
                    Logger.logComment("Selected the day "+Labels.DAY_IN_TRAVELLERS_DATEOFBIRTH_IOS+" in travellers date of birth");
                    wheels.get(1).sendKeys(Labels.MONTH_IN_TRAVELLERS_DATEOFBIRTH_IOS);
                    Logger.logComment("Selected the month "+Labels.MONTH_IN_TRAVELLERS_DATEOFBIRTH_IOS+" in travellers date of birth");
                    wheels.get(2).sendKeys(Labels.YEAR_IN_TRAVELLERS_DATEOFBIRTH_IOS);
                    Logger.logComment("Selected the year "+Labels.YEAR_IN_TRAVELLERS_DATEOFBIRTH_IOS+" in travellers date of birth");
                    closeTheDatePicker_iOS();
                }else {
                    Logger.logError("Date picker is not displayed");
                }
            }else {
                Logger.logError("Travellers date of birth field is not displayed in the current active screen");
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers date of birth");
        }
    }

    /**
     * Enter the travellers passport number
     */
    public static void enterTravellersPassportNumber() {
        Logger.logAction("Entering travellers passport number");
        try{
            if (isElementDisplayedByName(TRAVELLERS_PASSPORT_NUMBER)){
                driver.findElementByName(TRAVELLERS_PASSPORT_NUMBER).sendKeys(Labels.TRAVELLERS_PASSPORT_NUMBER);
                Logger.logComment(Labels.TRAVELLERS_PASSPORT_NUMBER+" :- is parsed");
                driver.hideKeyboard();
            }else {
                Logger.logError("Travellers passport field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers passport number");
        }
    }
    /**
     * Enter the travellers passport expiry date
     */
    public static void enterTravellersPassportExpiryDate() {
        Logger.logAction("Entering travellers passport expiry date");
        try{
            if (isElementDisplayedByName(TRAVELLERS_PASSPORT_EXPIRY_NUMBER)){
                driver.findElementByName(TRAVELLERS_PASSPORT_EXPIRY_NUMBER).click();
                Logger.logComment("Tapped on Travellers passport expiry text field");
                if (isDatePickerDisplayed()){
                    List<IOSElement> wheels = (List) driver.findElements(By.className(PICKER_WHEEL));
                    wheels.get(0).sendKeys(Labels.DAY_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS);
                    Logger.logComment("Selected the day "+Labels.DAY_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS+" in travellers passport expiry day");
                    wheels.get(1).sendKeys(Labels.MONTH_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS);
                    Logger.logComment("Selected the month "+Labels.MONTH_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS+" in travellers passport expiry month");
                    wheels.get(2).sendKeys(Labels.YEAR_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS);
                    Logger.logComment("Selected the year "+Labels.YEAR_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_IOS+" in travellers passport expiry year");
                    closeTheDatePicker_iOS();
                }else {
                    Logger.logError("Date picker is not displayed");
                }
            }else {
                Logger.logError("Travellers passport expiry field is not displayed in the current active screen");
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the travellers passport expiry field");
        }
    }

    /**
     * Select passport issuing country name
     */
    public static void selectPassportIssuingCountry(String passportIssuingCountryName) {
        Logger.logAction("Selecting the passport issuing country");
        try{
            if (isElementDisplayedByName(TRAVELLERS_PASSPORT_ISSUING_COUNTRY)){
                driver.findElementByName(TRAVELLERS_PASSPORT_ISSUING_COUNTRY).click();
                Logger.logComment("Tapped on Issuing country text field");
                if (isElementDisplayedByName(CHOOSE_COUNTRY_MODAL)) {
                    chooseCountry(passportIssuingCountryName);
                }else{
                    Logger.logError("Choose country modal is not displayed in the current active screen");
                }
            }else{
                Logger.logError("Passport issuing field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the passport issuing country");
        }
    }

    /**
     * Select traveller nationality
     */
    public static void selectTravellersNationality(String travellersNationality) {
        Logger.logAction("Selecting the travellers nationality");
        try{
            if (isElementDisplayedByName(TRAVELLERS_NATIONALITY)){
                driver.findElementByName(TRAVELLERS_NATIONALITY).click();
                Logger.logComment("Tapped on travellers nationality country field");
                if (isElementDisplayedByName(CHOOSE_COUNTRY_MODAL)) {
                    chooseCountry(travellersNationality);
                }else{
                    Logger.logError("Choose country modal is not displayed in the current active screen");
                }
            }else{
                Logger.logError("Nationality field is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the Nationality field");
        }
    }

    /**
     * Select the country name from choose country modal
     * @param countryName
     */
    // To do: Implement a method such that automatically select the country name (if country name is not on visible list scroll to that element and click on it)
    public static void chooseCountry(String countryName) {
        Logger.logAction("Choosing the country name :- "+countryName);
        try{
            if (isElementDisplayedByName(countryName)){
                driver.findElementByName(countryName).click();
                Logger.logComment(countryName+" :- country name is selected");
            }else {
                Logger.logError(countryName+ " - is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to choose the country name");
        }
    }

    /**
     * Tap on save button
     */
    @Override
    public void tapOnSaveButton() {
        Logger.logAction("Tapping on save button");
        try{
            if (isElementDisplayedByName(SAVE_BUTTON)){
                driver.findElementByName(SAVE_BUTTON).click();
                Logger.logComment("Tapped on save button");
            }else {
//                if (isElementDisplayedByName("Next")) // Implement a method such that should verify multiple travellers info (Verify the save button name if it is NEXT, return false and call a method that enters the other travellers info), this process needs to be continued till save button is displayed.
                Logger.logError("Save button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the save button in the current active screen");
        }
    }

}
