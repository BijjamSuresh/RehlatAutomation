package com.automation.rehlat.pages.bookingPage;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class BookingPageAndroid extends BookingPageBase {

    public static final String EMAIL_FIELD = "com.app.rehlat:id/travellerEmailEditText";
    public static final String PHONENUMBER_FIELD = "com.app.rehlat:id/phoneNumberEditText";
    public static final String PLACEHOLDER_TEXT_OF_PHONENUMBER_TEXTFIELD = "Phone Number";
    public static final String PLACEHOLDER_TEXT_OF_EMAILID_TEXTFIELD = "Please enter your email id";
    public static final String ADULT_BUTTON = "com.app.rehlat:id/adultCountImageView";
    public static final String BOOKING_PAGE_CONTINUE_BUTTON = "com.app.rehlat:id/traveller_details_continue_layout";
    public static final String CONTACT_DETAILS_VIEW ="com.app.rehlat:id/paymentContainer";
    public static final String SIGN_IN_OR_SIGN_UP_FOR_FAST_BOOKINGS_BUTTON = "com.app.rehlat:id/login_textview";
    public static final String ACTUAL_DISPLAYING_FARE = "com.app.rehlat:id/traveller_detail_onward_price_strikedoff";
    public static final String COUPON_AMOUNT = "com.app.rehlat:id/coupon_amount";
    public static final String KARAM_POINTS = "com.app.rehlat:id/walletPointsTextView";
    public static final String FINAL_FARE = "com.app.rehlat:id/final_fare_textview";
    public static final String KARAM_POINTS_TOGGLE_BUTTON = "com.app.rehlat:id/use_karm_checkbox";
    public static final String COUPON_CODE_TEXT_VIEW = "com.app.rehlat:id/enterCouponCodeTextViewEditText";
    public static final String APPLY_COUPON_CODE_BUTTON = "com.app.rehlat:id/coupon_apply";
    public static final String COUPON_CODE_VALIDATION_MESSAGE = "com.app.rehlat:id/coupon_validation_message";
    public static final String COUPON_INVALID_MESSAGE = "Coupon is invalid or expired";
    public static final String ONLINE_CHECKIN_TOGGLE_BUTTON = "com.app.rehlat:id/onlinecheckin_checkbox";
    public static final String REVIEW_BOOKING_PRICE_IN_FOOTER_VIEW_CELL = "com.app.rehlat:id/reviewbooking_price";
    public static Double displayedActualFare;
    public static Double couponAmount ;
    public static Double karamPoints;
    public static Double finalDisplayedFare;





    /**
     * Check booking page screen is displayed
     */
    @Override
    public void checkBookingPageScreenIsDisplayed() {
        Logger.logAction("Checking the Booking page screen is displayed or not ?");
        try{
            if (isElementDisplayedById(CONTACT_DETAILS_VIEW)){
                Logger.logStep("Booking Page screen is displayed");
            }else{
                Logger.logError("Booking page screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name");
        }
    }

    /**
     * Check booking page screen is displayed
     */
    @Override
    public boolean isUserIsSignedIn() {
        Logger.logAction("Checking the user is signed in or not ?");
        try{
            if (isElementDisplayedById(SIGN_IN_OR_SIGN_UP_FOR_FAST_BOOKINGS_BUTTON)){
                Logger.logStep("User is not signed in");
                return false;
            }else{
                Logger.logStep("User is signed in");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the user sign in status");
        }
        return true;
    }

    /**
     * Enter user booking information
     */
    @Override
    public void enterUserBookingInfo() {
        Logger.logAction("Entering the user information");
        try {
            if (isUserIsSignedIn()){
                enterTextInEmailTextField();
                enterTextInPhoneNumberTextField();
            }else{
                enterTextInEmailTextField();
                enterTextInPhoneNumberTextField();
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the user info in the respected fields");
        }
    }

    /**
     * Send keys to email text field
     */
    @Override
    public void enterTextInEmailTextField() {
        Logger.logAction("Entering the email id "+Labels.EMAIL_ID_SIGN_IN+" in email id text field");
        try{
            if (isElementDisplayedById(EMAIL_FIELD)){
                String emailField = driver.findElementById(EMAIL_FIELD).getText();
                if (emailField.equals(PLACEHOLDER_TEXT_OF_EMAILID_TEXTFIELD)){
                    Logger.logComment("Entering the email id:- "+Labels.EMAIL_ID_SIGN_IN);
                    WebElement textField = driver.findElement(By.id(EMAIL_FIELD));
                    tapOnElementBasedOnLocation(textField,"bottomRight");
//                    clearKeysByUsingKeycode(EMAIL_FIELD,EMAIL_FIELD.length());
                    sendTextById(EMAIL_FIELD,Labels.EMAIL_ID_SIGN_IN);
                    driver.hideKeyboard();
                }else if (emailField.equals(Labels.EMAIL_ID_SIGN_IN)){
                    Logger.logComment(Labels.EMAIL_ID_SIGN_IN+" :- Email id is already entered in the text field");
                }else {
                    Logger.logComment("Replacing current email id "+emailField+" with "+Labels.EMAIL_ID_SIGN_IN);
                    WebElement textField = driver.findElement(By.id(EMAIL_FIELD));
                    tapOnElementBasedOnLocation(textField,"bottomRight");
                    clearKeysByUsingKeycode(EMAIL_FIELD,EMAIL_FIELD.length());
                    sendTextById(EMAIL_FIELD,Labels.EMAIL_ID_SIGN_IN);
                    driver.hideKeyboard();
                }
            }else {
                Logger.logError(EMAIL_FIELD+" - text field is not displaying in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to send the keys to email text field");
        }
    }

    /**
     * Send keys to phone number text field
     */
    @Override
    public void enterTextInPhoneNumberTextField() {
        Logger.logAction("Entering the number "+Labels.phoneNumber+" in number text field");
        try{
            if (isElementDisplayedById(PHONENUMBER_FIELD)){
                String phoneNumberField = driver.findElementById(PHONENUMBER_FIELD).getText();
                if (phoneNumberField.equals(PLACEHOLDER_TEXT_OF_PHONENUMBER_TEXTFIELD)){
                    Logger.logComment("Entering the phone number:- "+Labels.phoneNumber);
                    WebElement textField = driver.findElementById(PHONENUMBER_FIELD);
                    tapOnElementBasedOnLocation(textField,"bottomRight");
                    sendTextById(PHONENUMBER_FIELD,Labels.phoneNumber);
                    driver.hideKeyboard();
                }else if (phoneNumberField.equals(Labels.phoneNumber)){
                    Logger.logComment(Labels.EMAIL_ID_SIGN_IN+" :- Email id is already entered in the text field");
                }else {
                    Logger.logComment("Replacing current phone number text "+phoneNumberField+" with "+Labels.phoneNumber);
                    WebElement textField = driver.findElementById(PHONENUMBER_FIELD);
                    tapOnElementBasedOnLocation(textField,"bottomRight");
                    clearKeysByUsingKeycode(PHONENUMBER_FIELD,PHONENUMBER_FIELD.length());
                    sendTextById(PHONENUMBER_FIELD,Labels.phoneNumber);
                    driver.hideKeyboard();
                }
            }else {
                Logger.logError(PHONENUMBER_FIELD+" - text field is not displaying in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to send the keys to phone number text field");
        }
    }

    /**
     * Tap on continue button
     */
    @Override
    public void tapOnContinueButton() {
        Logger.logAction("Tapping on continue button");
        try{
            compareFinalPriceDisplayedInFooterViewWithTheFinalFareDisplayedInOffersAndDiscountLayout(); // After iOS is implemented by "Online Check In toggle button", this method needs to be removed from here and call it as a step of TC from workflows directly
            if (isElementDisplayedById(BOOKING_PAGE_CONTINUE_BUTTON)){
                driver.findElementById(BOOKING_PAGE_CONTINUE_BUTTON).click();
                Logger.logComment("Tapped on continue button");
            }else{
                Logger.logError("Unable to tap on continue button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Continue button is not displayed in the current active screen");
        }
    }

    /**
     * Tap on add travellers details button
     */
    @Override
    public void tapOnAdultAddTravellersDetailsButton() {
        Logger.logAction("Tapping on adult add travellers details button");
        try{
            if (isElementDisplayedById(ADULT_BUTTON)){
                WebElement locationOfDay = driver.findElementById(ADULT_BUTTON);
                Point table = locationOfDay.getLocation();
                int elementYAxisValue = table.getY();
                if (Labels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT <= elementYAxisValue){
                    scrollTheCalenderPageUpByDaysGap_Android(); // scrolling values inside are hardcoded by screen basis
                }
                driver.findElementById(ADULT_BUTTON).click();
                Logger.logComment("Tapped on adult button");
            }else{
                scrollToAnElementById_ANDROID(ADULT_BUTTON,true);
                if (isElementDisplayedById(ADULT_BUTTON)){
                    WebElement locationOfDay = driver.findElementById(ADULT_BUTTON);
                    Point table = locationOfDay.getLocation();
                    int elementYAxisValue = table.getY();
                    if (Labels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT <= elementYAxisValue){
                        scrollTheCalenderPageUpByDaysGap_Android(); // scrolling values inside are hardcoded by screen basis
                    }
                    driver.findElementById(ADULT_BUTTON).click();
                    Logger.logComment("Tapped on adult button");
                }else{
                    scrollTheScreenDownwards();
                    if (isElementDisplayedById(ADULT_BUTTON)){
                        WebElement locationOfDay = driver.findElementById(ADULT_BUTTON);
                        Point table = locationOfDay.getLocation();
                        int elementYAxisValue = table.getY();
                        if (Labels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT <= elementYAxisValue){
                            scrollTheCalenderPageUpByDaysGap_Android(); // scrolling values inside are hardcoded by screen basis
                        }
                        driver.findElementById(ADULT_BUTTON).click();
                        Logger.logComment("Tapped on adult button");
                    }else{
                        Logger.logError("Unable to tap on add travellers details button");
                    }
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Add travellers details button is not displayed in the current active screen");
        }
    }

    /**
     * Tap on sign in for faster bookings button
     */
    @Override
    public void tapOnSignInForFasterBookingsButton() {
        try {
            if (isElementDisplayedById(SIGN_IN_OR_SIGN_UP_FOR_FAST_BOOKINGS_BUTTON)){
                driver.findElement(By.id(SIGN_IN_OR_SIGN_UP_FOR_FAST_BOOKINGS_BUTTON)).click();
                Logger.logComment("Tapped on sign in or sign up button");
            }else {
                Logger.logError(SIGN_IN_OR_SIGN_UP_FOR_FAST_BOOKINGS_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on Sign in for faster bookings button");
        }
    }

    /**
     * Check the final fare calculations are correct
     */
    @Override
    public void checkFinalFareCalculationIsCorrect() {
        Logger.logAction("Checking the final fare calculation is correct or not ?");
        try {
            driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
            Double bookingSeatCostInReviewBookingScreen = Double.valueOf(Labels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
            displayedActualFare = Double.valueOf(getDisplayedActualFare());
            couponAmount = Double.valueOf(getCouponAmount());
            karamPoints = Double.valueOf(getKaramPoints());
            finalDisplayedFare = Double.valueOf(getFinalDisplayedFare());
            Logger.logStep("Flights booking details are :- ");
            Logger.logComment("Actual Fare cost of booking flight :- "+displayedActualFare);
            Logger.logComment("Applied Coupon amount of booking flight :- "+couponAmount);
            Logger.logComment("Applied Karam points cost of booking flight :- "+karamPoints);
            Logger.logComment("Final Fare cost of booking flight :- "+finalDisplayedFare);
            if (finalDisplayedFare.equals(0.00)){
                finalDisplayedFare = displayedActualFare;
            }
            if (displayedActualFare.equals(bookingSeatCostInReviewBookingScreen)) {
                Double finalFareMathCalculation = displayedActualFare-couponAmount-karamPoints;
                Logger.logComment("Final fare math calculation value is :- "+finalFareMathCalculation);
                if (finalFareMathCalculation.equals(finalDisplayedFare)) {
                    Logger.logStep("Final fare calculation is correct");
                    Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = String.valueOf(finalFareMathCalculation);
                }else if (finalFareMathCalculation.toString().contains(finalDisplayedFare.toString())){ // This logic is because of internal math calculation is giving more than a digit after the decimal point eg: 14.10000000000000001 which is not matching with the actual value of Eg: 14.1
                    Logger.logStep("Final fare calculation is correct");
                    Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = String.valueOf(finalFareMathCalculation);
                } else if (finalFareMathCalculation.toString().contains(".0") && finalDisplayedFare.toString().contains("0.00")){ //This logic is because of showing final fare value as with two decimal values even though they are zeros eg: 16.00 but internal math calculation will shows only one decimal point (if is zero) eg: 16.0
                    finalFareMathCalculation = Double.valueOf(finalFareMathCalculation.toString().replace(".0",".00"));
                    if (finalFareMathCalculation.equals(finalDisplayedFare)) {
                        Logger.logStep("Final fare calculation is correct");
                        Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = String.valueOf(finalFareMathCalculation);
                    }else {
                        Logger.logError("Final calculation is incorrect in decimal values");
                    }
                }
                else {
                    Logger.logError("Final fare calculation is in correct");
                }
            }else {
                Logger.logError("Booking seat cost in review booking screen is not matching with the cost displaying in booking page..,i.e.., Booking seat cost in Booking page screen & Review Booking screen is:- "+displayedActualFare+" & "+Labels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the final fare calculation");
        }
    }

    /**
     * Get the actual displaying fare
     * @return
     */
    public static Double getDisplayedActualFare() {
        Logger.logAction("Getting the displayed actual fare");
        Double actualDisplayingFare = 0.00;
        try
        {
            if (isElementDisplayedById(ACTUAL_DISPLAYING_FARE)){
                String amount = driver.findElementById(ACTUAL_DISPLAYING_FARE).getText();
                actualDisplayingFare = Double.valueOf(amount);
                return actualDisplayingFare;
            }else {
                Logger.logError(ACTUAL_DISPLAYING_FARE+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the actual displayed fare");
        }
        return actualDisplayingFare;
    }

    /**
     * Get the coupon applied amount
     * @return
     */
    public Double getCouponAmount() {
        Logger.logAction("Getting the coupon amount");
        Double couponAmount = 0.00;
        try
        {
            if (isCouponCodeAppliedSuccessfully()){
                if (isElementDisplayedById(COUPON_AMOUNT)){
                    String amount = driver.findElementById(COUPON_AMOUNT).getText();
                    couponAmount = Double.valueOf(amount);
                    Logger.logComment("Applied coupon amount is :- "+couponAmount);
                    return couponAmount;
                }else {
                    Logger.logError(COUPON_AMOUNT+" - element name is not displayed in the current active screen");
                }
            }else {
                Logger.logComment("Coupon code is not applied.., So coupon amount applied is :- "+couponAmount);
                return couponAmount;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the Coupon amount");
        }
        return couponAmount;
    }

    /**
     * Get the applied karam points
     * @return
     */
    public Double getKaramPoints() {
        Logger.logAction("Getting the karam points");
        Double karamPoints = 0.00;
        try
        {
            if (isUserIsSignedIn()) {
                if (isKaramPointsToggleSwitchEnabled()){
                    if (isElementDisplayedById(KARAM_POINTS)){
                        String amount = driver.findElementById(KARAM_POINTS).getText();
                        karamPoints = Double.valueOf(amount);
                        return karamPoints;
                    }else {
                        Logger.logError(KARAM_POINTS+" - element name is not displayed in the current active screen");
                    }
                }else {
                    Logger.logComment("Karam points toggle switch is disabled, so applied karam points are:- "+karamPoints);
                    return karamPoints;
                }
            }else {
                Logger.logComment("Karam points are applicable only for signed in users, currently user is not signed so applied karam points are:- "+karamPoints);
                return karamPoints;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the karam points");
        }
        return karamPoints;
    }

    /**
     * Get the final displaying fare
     * @return
     */
    public Double getFinalDisplayedFare() {
        Logger.logAction("Getting the displayed final fare");
        Double finalDisplayedFare = 0.00;
        try {
            if (isUserIsSignedIn() && isCouponCodeAppliedSuccessfully()){
                if (isElementDisplayedById(FINAL_FARE)) {
                    String amount = driver.findElementById(FINAL_FARE).getText();
                    finalDisplayedFare = Double.valueOf(amount);
                    return finalDisplayedFare;
                } else {
                    Logger.logError(FINAL_FARE + " - element name is not displayed in the current active screen");
                    return finalDisplayedFare;
                }
            }else if (isUserIsSignedIn() && !isCouponCodeAppliedSuccessfully()){
                if (isElementDisplayedById(FINAL_FARE)) {
                    String amount = driver.findElementById(FINAL_FARE).getText();
                    finalDisplayedFare = Double.valueOf(amount);
                    return finalDisplayedFare;
                } else {
                    Logger.logComment(FINAL_FARE + " - element name is not displayed in the current active screen");
                    return finalDisplayedFare;
                }
            }
            else if (!isUserIsSignedIn() && isCouponCodeAppliedSuccessfully()){
                if (isElementDisplayedById(FINAL_FARE)) {
                    String amount = driver.findElementById(FINAL_FARE).getText();
                    finalDisplayedFare = Double.valueOf(amount);
                    return finalDisplayedFare;
                } else {
                    Logger.logComment(FINAL_FARE + " - element name is not displayed in the current active screen");
                    return finalDisplayedFare;
                }
            }
            else {
                Logger.logComment("User is neither signed in nor applied coupon code .., So the final fare will not be displayed in the current active screen");
                finalDisplayedFare = displayedActualFare;
                return finalDisplayedFare;
            }
        } catch (Exception OtherThanElementNotFoundException) {
            Logger.logError("Encountered error: Unable to find the displayed final fare amount in the current active screen");
        }
        return finalDisplayedFare;
    }

    /**
     * Check karam points toggle is enabled
     * @return
     */
    public static boolean isKaramPointsToggleSwitchEnabled() {
        Logger.logAction("Checking the karam points toggle is enabled");
        try
        {
            if (isElementDisplayedById(KARAM_POINTS_TOGGLE_BUTTON)){
                String karamPointsToggleStatus = driver.findElementById(KARAM_POINTS_TOGGLE_BUTTON).getAttribute(Labels.CHECKED_ATTRIBUTE);
                return karamPointsToggleStatus.equals(Labels.STATUS_TRUE);
            }else {
                Logger.logError(KARAM_POINTS_TOGGLE_BUTTON+" - element id is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the karam points toggle button status");
        }
        return false;
    }

    /**
     * Enable the karam points toggle
     * @return
     */
    public static void enableKaramPointsToggleSwitch() {
        Logger.logAction("Enabling the karam points toggle");
        try
        {
            if (isKaramPointsToggleSwitchEnabled()){
                Logger.logComment("karam points toggle button is already enabled");
            }else {
                WebElement karamPointsToggleSwitch = driver.findElementById(KARAM_POINTS_TOGGLE_BUTTON);
                karamPointsToggleSwitch.click();
                Logger.logComment("Karam points toggle button is enabled");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enable the karam points toggle button");
        }
    }

    /**
     * Apply coupon code
     */
    @Override
    public void applyTheCouponCode() {
        Logger.logAction("Applying the coupon code");
        try {
            sendKeysToCouponCodeTextField();
            tapOnApplyCouponCodeButton();
            if (isCouponCodeAppliedSuccessfully()){
                Logger.logComment("Coupon code is applied successfully");
            }else {
                Logger.logError("Coupon code is not applied successfully");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to apply the coupon code");
        }
    }

    /**
     * Send keys to coupon code text field
     */
    public void sendKeysToCouponCodeTextField() {
        Logger.logAction("Sending the keys to coupon code text field");
        try {
            if (isElementDisplayedById(COUPON_CODE_TEXT_VIEW)){
                driver.findElementById(COUPON_CODE_TEXT_VIEW).sendKeys(Labels.COUPON_CODE);
                Logger.logComment(Labels.COUPON_CODE+":- coupon code is parsed");
                driver.hideKeyboard();
            }else {
                Logger.logError(COUPON_CODE_TEXT_VIEW+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to send keys to apply coupon code text field");
        }
    }

    /**
     * Tap on apply coupon code button
     */
    public void tapOnApplyCouponCodeButton() {
        Logger.logAction("Tapping on apply coupon code button");
        try {
            if (isElementDisplayedById(APPLY_COUPON_CODE_BUTTON)){
                driver.findElementById(APPLY_COUPON_CODE_BUTTON).click();
                Logger.logComment("Tapped on apply coupon button");
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(Labels.ANDROID_ACTIVITY_INDICATOR))); // Before running check this activity indicator label is correct or not?
            }else {
                Logger.logError(APPLY_COUPON_CODE_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to tap on apply coupon code button");
        }
    }

    /**
     * Check the coupon code is applied successfully
     */
    public boolean isCouponCodeAppliedSuccessfully() {
        Logger.logAction("Checking coupon code is applied or not ?");
        try {
            if(isElementDisplayedById(COUPON_AMOUNT)){
                Logger.logComment("Coupon code is applied successfully");
                return true;
            }else if(isElementDisplayedById(COUPON_CODE_TEXT_VIEW)){
                if (isElementDisplayedById(COUPON_CODE_VALIDATION_MESSAGE)){
                    String couponValidationMessage = driver.findElementById(COUPON_CODE_VALIDATION_MESSAGE).getText();
                    if (couponValidationMessage.equals(COUPON_INVALID_MESSAGE)){
                        Logger.logComment("Coupon code is not applied because of incorrect coupon code");
                        return false;
                    }else {
                        Logger.logComment("Coupon code is not applied due to the reason :- "+couponValidationMessage);
                        return false;
                    }
                }else if (isElementDisplayedById(COUPON_AMOUNT)) {
                    Logger.logComment("Coupon code is applied successfully");
                    return true;
                }
                else {
                    Logger.logComment("Coupon code is not yet applied");
                    return false;
                }
            }else {
                Logger.logError(COUPON_CODE_TEXT_VIEW+" Or "+COUPON_AMOUNT+" element names are not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check whether the coupon is applied or not ?");
        }
        return false;
    }

    /**
     * Disable the online check in toggle button
     */
    public static void disableOnlineCheckInToggleButton(){
        Logger.logAction("Disabling the online check in toggle button");
        try{
            scrollToAnElementById_ANDROID(ONLINE_CHECKIN_TOGGLE_BUTTON,true);
            if(isElementDisplayedByIdWithOneTimeChecking(ONLINE_CHECKIN_TOGGLE_BUTTON)){
                WebElement locationOfDay = driver.findElementById(ONLINE_CHECKIN_TOGGLE_BUTTON);
                Point table = locationOfDay.getLocation();
                int elementYAxisValue = table.getY();
                if (Labels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT <= elementYAxisValue){
                    scrollTheCalenderPageUpByDaysGap_Android(); // scrolling values inside are hardcoded by screen basis
                }
                WebElement onlineCheckInToggleButton = driver.findElementById(ONLINE_CHECKIN_TOGGLE_BUTTON);
                String checkedAttribute = onlineCheckInToggleButton.getAttribute(Labels.CHECKED_ATTRIBUTE);
                if (checkedAttribute.equals(Labels.STATUS_TRUE)){
                    Logger.logComment("Online check in toggle button is enabled.., Going to disable by tapping on it");
                    onlineCheckInToggleButton.click();
                }else {
                    Logger.logComment("Online check in toggle button is already disabled");
                }
            }else {
                scrollToAnElementById_ANDROID(ONLINE_CHECKIN_TOGGLE_BUTTON,false);
                if(isElementDisplayedById(ONLINE_CHECKIN_TOGGLE_BUTTON)){
                    WebElement locationOfDay = driver.findElementById(ONLINE_CHECKIN_TOGGLE_BUTTON);
                    Point table = locationOfDay.getLocation();
                    int elementYAxisValue = table.getY();
                    if (Labels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT <= elementYAxisValue){
                        scrollTheCalenderPageUpByDaysGap_Android(); // scrolling values inside are hardcoded by screen basis
                    }
                    WebElement onlineCheckInToggleButton = driver.findElementById(ONLINE_CHECKIN_TOGGLE_BUTTON);
                    String checkedAttribute = onlineCheckInToggleButton.getAttribute(Labels.CHECKED_ATTRIBUTE);
                    if (checkedAttribute.equals(Labels.STATUS_TRUE)){
                        Logger.logComment("Online check in toggle button is enabled.., Going to disable by tapping on it");
                        onlineCheckInToggleButton.click();
                    }else {
                        Logger.logComment("Online check in toggle button is already disabled");
                    }
                }else {
                    Logger.logWarning("Online check in button is not visible in the current active screen");
                }
            }
        }catch(Exception exception){
            Logger.logError("Encountered error: Unable to disable the online check in toggle button");
        }
    }

    /**
     * Compare the final price displayed in footer view with the final fare displayed in offers and discounts layout
     */
    public static void compareFinalPriceDisplayedInFooterViewWithTheFinalFareDisplayedInOffersAndDiscountLayout() {
        Logger.logAction("Comparing the final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
        try{
            disableOnlineCheckInToggleButton();
            Double reviewBookingPriceInFooterView = getTheBookingPriceDisplayedInFooterView();
            Logger.logComment("Review Booking price in footer view :- "+reviewBookingPriceInFooterView);
            String finalLetterInFinalFareAmountInBookingPage = Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN.substring(Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN.length()-1);
            if (finalLetterInFinalFareAmountInBookingPage.equals("0")){
                String finalFarePayablePriceInBookingPage = Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN.replace("0","");
                Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = finalFarePayablePriceInBookingPage;
            }
            Logger.logComment("Final Fare displayed in the offers and discounts layout :- "+Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN);
            if (Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN.equals(String.valueOf(reviewBookingPriceInFooterView))){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else if(reviewBookingPriceInFooterView == Double.valueOf(Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN)){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else if(reviewBookingPriceInFooterView.toString().contains(Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN)){
                Logger.logStep("Final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
            }else {
                Logger.logError("Final price displayed in footer view is not matches with the final fare displayed in offers and discounts layout");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to compare the final price displayed in footer view with the final fare displayed in the offers and discounts layout");
        }
    }

    /**
     * Get the booking price displayed in the footer view layout
     * @return
     */
    public static Double getTheBookingPriceDisplayedInFooterView(){
        Logger.logAction("Getting the booking price displayed in footer view");
        try{
            if (isElementDisplayedById(REVIEW_BOOKING_PRICE_IN_FOOTER_VIEW_CELL)){
                Double reviewBookingPriceInFooterView = Double.valueOf(driver.findElementById(REVIEW_BOOKING_PRICE_IN_FOOTER_VIEW_CELL).getText());
                return reviewBookingPriceInFooterView;
            }else {
                Logger.logError(REVIEW_BOOKING_PRICE_IN_FOOTER_VIEW_CELL+" :- element is not displayed in the current screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the booking price displayed in footer view");
        }
        return null;
    }
}
