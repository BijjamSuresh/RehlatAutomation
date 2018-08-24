package com.automation.rehlat.pages.travellerDetails;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TravellerDetailsAndroid extends TravellerDetailsBase {
    public static final String TRAVELLERS_FIRST_NAME="com.app.rehlat:id/travellerFirstNameEditText";
    public static final String TRAVELLERS_MIDDLE_NAME="com.app.rehlat:id/travellerMiddleNameEditText";
    public static final String TRAVELLERS_LAST_NAME="com.app.rehlat:id/travellerLastNameEditText";
    public static final String TRAVELLERS_DATEOFBIRTH_NAME="com.app.rehlat:id/travellerDobDateEditText";
    public static final String TRAVELLERS_PASSPORT_TEXTFIELD="com.app.rehlat:id/travellerPassportNumberEditText";
    public static final String TRAVELLERS_PASSPORT_EXPIRY_TEXTFIELD="com.app.rehlat:id/travellerExpirtyDateEditText";
    public static final String TRAVELLERS_PASSPORT_ISSUING_COUNTRY="com.app.rehlat:id/issuecountry_textview";
    public static final String TRAVELLERS_NATIONALITY="com.app.rehlat:id/travellerNationalitytextview";
    public static final String SELECT_COUNTRY_MODAL="SELECT COUNTRY";
    public static final String TRAVELLERS_DETAILS_SCREEN_TITLE_LAYOUT="com.app.rehlat:id/addTravellersLayoutHeadingView";
    public static final String TRAVELLERS_DETAILS_SCREEN_TITLE="Traveller Details";
    public static final String SAVE_BUTTON="com.app.rehlat:id/addTravellerDone";
    public static final String SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL="com.app.rehlat:id/searchFlightEditText";
    public static final String HEADER_TITLE = "com.app.rehlat:id/joinHeaderTitle";
    public static final String CALENDAR_OK_BUTTON="android:id/button1";
    public static final String PREVIOUS_MONTH_BUTTON ="android:id/prev";
    public static final String FUTURE_MONTH_BUTTON ="android:id/next"; //check this element name in inspector.., all are set...,
    public static final String CALENDER_MONTH_VIEW_ANDROID ="android:id/month_view";
    public static final String TRAVELLERS_DETAILS_MODAL ="com.app.rehlat:id/travellers_details_viewpager";
    public static final String XPATH_OF_FIRST_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]";
    public static final String XPATH_OF_SECOND_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]";
    public static final String[] monthsList = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    /**
     * Check the travellers details screen is displayed
     */
    @Override
    public void checkTravellersDetailsScreenIsDisplayed() {
        Logger.logAction("Checking the travellers details screen is displayed or not ?");
        try {
            if (isElementDisplayedById(TRAVELLERS_DETAILS_SCREEN_TITLE_LAYOUT)){
                String screenTittle = driver.findElement(By.id(TRAVELLERS_DETAILS_SCREEN_TITLE_LAYOUT)).getText();
                if (screenTittle.matches(TRAVELLERS_DETAILS_SCREEN_TITLE)){
                    Logger.logStep("Travellers details screen is displayed");
                }else {
                    Logger.logComment("Screen name are :- "+TRAVELLERS_DETAILS_SCREEN_TITLE+" , "+screenTittle);
                    Logger.logError("Travellers details screen is not displayed");
                }
            } else {
                Logger.logError("Travellers details screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the current active screen name");
        }
    }

    /**
     * Decline the auto fill populate modal if displayed
     */
    @Override
    public void declineAutoFillPopulateModalIfDisplayed() {
        Logger.logAction("Declining the auto fill popup if displayed");
        try{
            if (isElementDisplayedById("com.app.rehlat:id/traveller_prepopulated_list_layout")){
                if (isElementDisplayedById("com.app.rehlat:id/traveller_prepopulated_close_dialog")){
                    WebElement closeButton = driver.findElementById("com.app.rehlat:id/traveller_prepopulated_close_dialog");
                    closeButton.click();
                    }else {
                    Logger.logError("Close button is not displayed in the pre populated list layout");
                }
            } else {
                Logger.logComment("PopUp modal is not displayed in the current active screen and moving to next test step");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to decline the auto fill popup ");
        }
    }

    /**
     * Accept the auto fill populate modal if displayed
     */
    @Override
    public boolean acceptAutoFillPopulateModalIfDisplayed() {
        Logger.logAction("Accepting the auto fill popup if displayed");
        try{
            if (isElementDisplayedById("com.app.rehlat:id/traveller_prepopulated_list_layout")){
                if (isElementDisplayedById("com.app.rehlat:id/item_traveller_prepopulated_travellerName")){
                    WebElement closeButton = driver.findElementById("com.app.rehlat:id/item_traveller_prepopulated_travellerName");
                    closeButton.click();
                    return true;
                }else {
                    Logger.logError("Travellers data is not displayed in the pre populated list layout");
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
     * Enter adult travellers details
     */
    @Override
    public void enterAdultTravellersDetails(String travellersCountry) {
        Logger.logAction("Entering the adult travellers details");
        try{
            if (isElementDisplayedById(TRAVELLERS_DETAILS_MODAL)){
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
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                selectTravellersNationality(travellersCountry);
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                enterTravellersPassportNumber();
                scrollTheScreenUpwards();
                selectPassportIssuingCountry(travellersCountry);
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                selectTravellersPassportExpiryDate();
                TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
            }else if (Labels.FLIGHT_BOOKING_TYPE.equals(Labels.DOMESTIC_FLIGHT_BOOKING)){
                Logger.logStep("For domestic flights DOB, Passport and its expiry date and passport issuing country are might or might not necessary.., So filling the necessary information for the current flight ...,");
                if (isElementDisplayedById(TRAVELLERS_DATEOFBIRTH_NAME)){
                    enterTravellersDateOfBirth();
                    TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                }if (isElementDisplayedById(TRAVELLERS_NATIONALITY)){
                    selectTravellersNationality(travellersCountry);
                    TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                }if (isElementDisplayedById(TRAVELLERS_PASSPORT_TEXTFIELD)){
                    enterTravellersPassportNumber();
                    scrollTheScreenUpwards();
                }if (isElementDisplayedById(TRAVELLERS_PASSPORT_ISSUING_COUNTRY)){
                    selectPassportIssuingCountry(travellersCountry);
                    TravellerDetailsScreen.checkTravellersDetailsScreenIsDisplayed();
                }if (isElementDisplayedById(TRAVELLERS_PASSPORT_EXPIRY_TEXTFIELD)){
                    selectTravellersPassportExpiryDate();
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
        Logger.logStep("Entering travellers first name");
        try{
            if (isElementDisplayedById(TRAVELLERS_FIRST_NAME)){
                String firstName = driver.findElementById(TRAVELLERS_FIRST_NAME).getText();
                if (firstName.equals(Labels.STRING_NULL)){
                    driver.findElementById(TRAVELLERS_FIRST_NAME).sendKeys(Labels.TRAVELLERS_FIRST_NAME);
                    driver.hideKeyboard();
                }else {
                    clearKeysByUsingKeycode(TRAVELLERS_FIRST_NAME,firstName.length());
                    driver.findElementById(TRAVELLERS_FIRST_NAME).sendKeys(Labels.TRAVELLERS_FIRST_NAME);
                    driver.hideKeyboard();
                }
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
        Logger.logStep("Entering travellers middle name");
        try{
            if (isElementDisplayedById(TRAVELLERS_MIDDLE_NAME)){
                String middleName = driver.findElementById(TRAVELLERS_MIDDLE_NAME).getText();
                if (middleName.equals(Labels.STRING_NULL)){
                    driver.findElementById(TRAVELLERS_MIDDLE_NAME).sendKeys(Labels.TRAVELLERS_MIDDLE_NAME);
                    driver.hideKeyboard();
                }else {
                    clearKeysByUsingKeycode(TRAVELLERS_MIDDLE_NAME,middleName.length());
                    driver.findElementById(TRAVELLERS_MIDDLE_NAME).sendKeys(Labels.TRAVELLERS_FIRST_NAME);
                    driver.hideKeyboard();
                }
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
        Logger.logStep("Entering travellers last name");
        try{
            if (isElementDisplayedById(TRAVELLERS_LAST_NAME)){
                String lastName = driver.findElementById(TRAVELLERS_LAST_NAME).getText();
                if (lastName.equals(Labels.STRING_NULL)){
                    driver.findElementById(TRAVELLERS_LAST_NAME).sendKeys(Labels.TRAVELLERS_LAST_NAME);
                    driver.hideKeyboard();
                }else {
                    clearKeysByUsingKeycode(TRAVELLERS_LAST_NAME,lastName.length());
                    driver.findElementById(TRAVELLERS_LAST_NAME).sendKeys(Labels.TRAVELLERS_LAST_NAME);
                    driver.hideKeyboard();
                }
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
        Logger.logStep("Entering travellers Date of Birth");
        try{
            if (isElementDisplayedById(TRAVELLERS_DATEOFBIRTH_NAME)){
                driver.findElementById(TRAVELLERS_DATEOFBIRTH_NAME).click();
                closeAutoTutorialDialog();
                if (isDatePickerDisplayed()){
                    swipeTheCalendarViewToDate(Labels.DATEOFBIRTH_CALENDAR,Labels.TRAVELLERS_DATEOFBIRTH_ANDROID);
                    if (isElementDisplayedById(Labels.TRAVELLERS_DATEOFBIRTH_ANDROID)){
                        driver.findElementById(Labels.TRAVELLERS_DATEOFBIRTH_ANDROID).click();
                        closeTheCalendarView();
                    }else {
                        driver.findElementById(CALENDER_MONTH_VIEW_ANDROID).click();
                        closeTheCalendarView();
                    }
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
     * Swipe the calender view to a particular date based on calendar type
     * @param parsingDate
     */
    public static void swipeTheCalendarViewToDate(String dateType, String parsingDate) {
        Logger.logAction("Swiping the calendar view to date:- "+parsingDate);
        try {
            if (dateType.equals(Labels.DATEOFBIRTH_CALENDAR)){
                swipeDateOfBirthCalendar(parsingDate);
            }
            else if (dateType.equals(Labels.PASSPORT_EXPIRY_CALENDAR)){
                swipePassportExpiryCalendar(parsingDate);
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the travellers date of birth");
        }
    }

    /**
     * Swipe the date of birth calendar // For now only adult Date of birth logic is implemented, yet to implement for infant and child type also
     */
    public static void swipeDateOfBirthCalendar(String parsingDate) {
        int monthValueOfParsingYear = 0;
        int currentMonthValueInThePreviousYearOfParsingYear = 0;
        int totalTapsOnForwardButtonInPreviousYearOfParsingYear = 0;
        try {
            String time = new SimpleDateFormat("yyyy").format(new Date());
            Integer currentCalendarYear = Integer.valueOf(time);
            Integer displayedAdultCalendar = currentCalendarYear-12;
            Integer parsingCalenderYear = Integer.valueOf(Labels.YEAR_IN_TRAVELLERS_DATEOFBIRTH_ANDROID);
            if (displayedAdultCalendar >= parsingCalenderYear){
                Integer numberOfTapsTobeDoneOnPastMonthButtonTillToOneYearBeforeToParsingYear = ((displayedAdultCalendar-parsingCalenderYear-1)*(12));
                if (isElementDisplayedById(PREVIOUS_MONTH_BUTTON)){
                    // Logic to go to one year before to parsing date year
                    // No need to add "1" tap extra which we did it in future parsing calender because we are using the departure date to swipe to the parsing calendar
                    for (int tapCount = 0; tapCount <numberOfTapsTobeDoneOnPastMonthButtonTillToOneYearBeforeToParsingYear;tapCount++) {
                        driver.findElementById(PREVIOUS_MONTH_BUTTON).click();
                    }
                    // Logic to go to exact parsing month from one year before to the parsing date year
                    for (int index =0; index<=monthsList.length-1;index++){
                        String monthName = monthsList[index];
                        if (parsingDate.contains(monthName)){
                            index = 11-index;
                            monthValueOfParsingYear = index;
                            break;
                        }
                    }
                    for (int index =0; index<=monthsList.length-1;index++){
                        String monthName = monthsList[index];
                        if (monthName.equals(Labels.MONTH_IN_TRAVELLERS_DEPARTURE_DATE_FOR_ANDROID)){
                            currentMonthValueInThePreviousYearOfParsingYear = index;
                            break;
                        }
                    }
                    totalTapsOnForwardButtonInPreviousYearOfParsingYear = monthValueOfParsingYear+currentMonthValueInThePreviousYearOfParsingYear;
                    for (int tapMonthCount = 0; tapMonthCount <=totalTapsOnForwardButtonInPreviousYearOfParsingYear;tapMonthCount++){
                        driver.findElementById(PREVIOUS_MONTH_BUTTON).click();
                    }
                    // Checking the parsing date is displayed according to the logic
                    if (isElementDisplayedByIdWithOneTimeChecking(parsingDate)){
                        Logger.logComment("Swiped the calendar view to date:- "+parsingDate);
                    }else {
                        Logger.logError(parsingDate+" - element id is not displayed in the current active screen");
                    }
                }else {
                    Logger.logError("Previous Month button is not displayed in the current calender view");
                }
            }else {
                Logger.logComment("Current Year & adult date of birth year dates are :- "+currentCalendarYear+","+Labels.YEAR_IN_TRAVELLERS_DATEOFBIRTH_ANDROID);
                Logger.logError("Adult date of birth should be less than 12 years to the current Year");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to swipe the calendar view");
        }
    }

    /**
     * Swipe the date of birth calendar // For now only adult Date of birth logic is implemented, yet to implement for infant and child type also
     */
    public static void swipePassportExpiryCalendar(String parsingDate) {
        int monthValueOfParsingYear = 0;
        int currentMonthValueInThePreviousYearOfParsingYear = 0;
        int totalTapsOnForwardButtonInPreviousYearOfParsingYear = 0;
        try {
            String time = new SimpleDateFormat("yyyy").format(new Date());
            Integer currentCalendarYear = Integer.valueOf(time);
            Integer displayedAdultCalendar = currentCalendarYear;
            Integer parsingCalenderYear = Integer.valueOf(Labels.YEAR_IN_TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID);
            if (displayedAdultCalendar <= parsingCalenderYear){
                Integer numberOfTapsTobeDoneOnNextMonthButtonTillToOneYearBeforeToParsingYear = ((parsingCalenderYear-displayedAdultCalendar-1)*(12));
                if (isElementDisplayedById(FUTURE_MONTH_BUTTON)){
                    // Logic to go to one year before to parsing date year
                    for (int tapCount = 0; tapCount <=numberOfTapsTobeDoneOnNextMonthButtonTillToOneYearBeforeToParsingYear;tapCount++){
                        driver.findElementById(FUTURE_MONTH_BUTTON).click();
                    }
                    // Logic to go to exact parsing month from one year before to the parsing date year
                    for (int index =0; index<=monthsList.length-1;index++){
                        String monthName = monthsList[index];
                        if (parsingDate.contains(monthName)){
                            monthValueOfParsingYear = index;
                            break;
                        }
                    }
                    String currentMonth = new SimpleDateFormat("MMMMM").format(new Date());
                    for (int index =0; index<=monthsList.length-1;index++){
                        String monthName = monthsList[index];
                        if (monthName.equals(currentMonth)){
                            index = 11 - index -1; // "1" tap is added extra because to see the future month we are using the current month name (Which we didn't use extra tap in past calendar swiping)
                            currentMonthValueInThePreviousYearOfParsingYear = index;
                            break;
                        }
                    }
                    totalTapsOnForwardButtonInPreviousYearOfParsingYear = monthValueOfParsingYear+currentMonthValueInThePreviousYearOfParsingYear;
                    for (int tapMonthCount = 0; tapMonthCount <=totalTapsOnForwardButtonInPreviousYearOfParsingYear;tapMonthCount++){
                        driver.findElementById(FUTURE_MONTH_BUTTON).click();
                    }
                    // Checking the parsing date is displayed according to the logic
                    if (isElementDisplayedByIdWithOneTimeChecking(parsingDate)){
                        Logger.logComment("Swiped the calendar view to date:- "+parsingDate);
                    }else {
                        Logger.logError(parsingDate+" - element id is not displayed in the current active screen");
                    }
                }else {
                    Logger.logError("Future Month button is not displayed in the current calender view");
                }
            }else {
                Logger.logComment("Current Year & adult passport expiry year dates are :- "+currentCalendarYear+","+Labels.YEAR_IN_TRAVELLERS_DATEOFBIRTH_ANDROID);
                Logger.logError("Adult passport expiry year date should be greater than the current Year");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to swipe the calendar view");
        }
    }

    /**
     * Close the date picker for Android Platform
     */
    public static void closeTheCalendarView() {
        try{
            if (isElementDisplayedById(CALENDAR_OK_BUTTON)){
                driver.findElementById(CALENDAR_OK_BUTTON).click();
            }else{
                Logger.logStep("Date picker is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to close the keyboard");
        }
    }

    /**
     * Close the auto tutorial dialog of calendar
     */
    public static void closeAutoTutorialDialog() {
        try{
            if (isElementDisplayedById("com.app.rehlat:id/tutorialDialog")){
                Logger.logComment("Tutorial is displayed and going to close it by tapping on it");
                driver.findElementById("com.app.rehlat:id/tutorialDialog").click();
            }else {
                Logger.logComment("No tutorials are displayed and moving forward to next step");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the auto swipe suggestion");
        }
    }

    /**
     * Enter the travellers passport number
     */
    public static void enterTravellersPassportNumber() {
        Logger.logStep("Entering travellers passport number");
        try{
            if (isElementDisplayedById(TRAVELLERS_PASSPORT_TEXTFIELD)){
                String passportName = driver.findElementById(TRAVELLERS_PASSPORT_TEXTFIELD).getText();
                if (passportName.equals(Labels.STRING_NULL)){
                    driver.findElementById(TRAVELLERS_PASSPORT_TEXTFIELD).sendKeys(Labels.TRAVELLERS_PASSPORT_NUMBER);
                    driver.hideKeyboard();
                }else {
                    clearKeysByUsingKeycode(TRAVELLERS_PASSPORT_TEXTFIELD,passportName.length());
                    driver.findElementById(TRAVELLERS_PASSPORT_TEXTFIELD).sendKeys(Labels.TRAVELLERS_PASSPORT_NUMBER);
                    driver.hideKeyboard();
                }
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
    public static void selectTravellersPassportExpiryDate() {
        Logger.logStep("Selecting travellers passport expiry date");
        try{
            if (isElementDisplayedById(TRAVELLERS_PASSPORT_EXPIRY_TEXTFIELD)){
                driver.findElementById(TRAVELLERS_PASSPORT_EXPIRY_TEXTFIELD).click();
                closeAutoTutorialDialog();
                if (isDatePickerDisplayed()){
                    swipeTheCalendarViewToDate(Labels.PASSPORT_EXPIRY_CALENDAR,Labels.TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID);
                    if (isElementDisplayedById(Labels.TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID)){
                        driver.findElementById(Labels.TRAVELLERS_PASSPORT_EXPIRY_DATE_ANDROID).click();
                        closeTheCalendarView();
                    }else {
                        driver.findElementById(CALENDER_MONTH_VIEW_ANDROID).click();
                        closeTheCalendarView();
                    }
                }else {
                    Logger.logError("Date picker is not displayed");
                }
            }else {
                Logger.logError("Travellers date of birth field is not displayed in the current active screen");
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
            if (isElementDisplayedById(TRAVELLERS_PASSPORT_ISSUING_COUNTRY)){
                Logger.logStep("Tapping on Issuing country field");
                driver.findElementById(TRAVELLERS_PASSPORT_ISSUING_COUNTRY).click();
                if (isElementDisplayedById(HEADER_TITLE)) {
                    String headerTitle = driver.findElement(By.id(HEADER_TITLE)).getText();
                    if (headerTitle.matches(SELECT_COUNTRY_MODAL)){
                        selectCountry(passportIssuingCountryName);
                    }
                }else{
                    Logger.logError("Choose country modal is not displayed in the current active screen");
                }
            }else{
                Logger.logError("Passport Issuing country field is not displayed in the current active screen");
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
            if (isElementDisplayedById(TRAVELLERS_NATIONALITY)){
                Logger.logStep("Tapping on Issuing country field");
                driver.findElementById(TRAVELLERS_NATIONALITY).click();
                if (isElementDisplayedById(HEADER_TITLE)) {
                    String headerTitle = driver.findElement(By.id(HEADER_TITLE)).getText();
                    if (headerTitle.matches(SELECT_COUNTRY_MODAL)){
                        selectCountry(travellersNationality);
                    }
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
    public static void selectCountry(String countryName) {
        Logger.logAction("Selecting the country :- "+countryName);
        try{
            if (isElementDisplayedById(SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL)){
                driver.findElementById(SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL).sendKeys(countryName);
                if (isElementDisplayedByXPath(XPATH_OF_FIRST_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN)){
                    WebElement firstSearchResult = driver.findElementByXPath(XPATH_OF_FIRST_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN);
                    if (firstSearchResult.getText().equals(countryName)){
                        firstSearchResult.click();
                    }else {
                        WebElement secondSearchResult = driver.findElementByXPath(XPATH_OF_SECOND_FILTER_RESULT_IN_SELECT_COUNTRY_SCREEN);
                        if (secondSearchResult.getText().equals(countryName)){
                            secondSearchResult.click();
                        }else {
                            Logger.logError(countryName+" - is not matched with the displayed country name in second search cell :- "+firstSearchResult.getText());
                        }
                    }
                }else {
                    Logger.logError(countryName+" is not displaying in the current active screen");
                }
            }else {
                Logger.logError(SEARCH_TEXTFIELD_IN_SELECT_COUNTRY_MODAL+ " - is not displayed in the current active screen");
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
        Logger.logAction("Tapping on save travellers details button");
        try{
            if (isElementDisplayedById(SAVE_BUTTON)){
                driver.findElementById(SAVE_BUTTON).click();
            }else {
//                if (isElementDisplayedByName("Next")) // Implement a method such that should verify multiple travellers info (Verify the save button name if it is NEXT, return false and call a method that enters the other travellers info), this process needs to be continued till save button is displayed.
                Logger.logError("Save button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the save button in the current active screen");
        }
    }

}
