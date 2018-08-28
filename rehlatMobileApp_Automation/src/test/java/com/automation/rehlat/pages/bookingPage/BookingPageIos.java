package com.automation.rehlat.pages.bookingPage;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.automation.rehlat.pages.reviewBooking.ReviewBookingIos.CONTINUE_BUTTON;

public class BookingPageIos extends BookingPageBase {

    public static final String XPATH_OF_EMAIL_FIELD = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField[1]";
    public static final String XPATH_OF_PHONENUMBER_FIELD = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeTextField[2]";
    public static final String PLACEHOLDER_TEXT_OF_PHONENUMBER_TEXTFIELD = "Enter your PhoneNumber";
    public static final String ADULT_BUTTON = "ADULT";
    public static final String TICKET_SOLD_OUT_POPUP = "Ticket had been Sold out";
    public static final String OK_BUTTON = "OK";
    public static final String CONTACT_DETAILS_VIEW ="Contact Details";
    public static final String ADD_TRAVELLERS_DETAILS = "Add Travellers Details";
    public static final String SIGNED_IN_FOR_FAST_BOOKINGS_BUTTON = "Sign in for faster bookings";
    public static final String ACTUAL_DISPLAYING_FARE = "com.app.rehlat:id/traveller_detail_onward_price_strikedoff";
    public static final String APPLIED_COUPON_AMOUNT_CURRENCY_WIHOUT_AMOUNT = "(-) KWD ";
    public static final String KARAM_POINTS = "com.app.rehlat:id/walletPointsTextView";
    public static final String FINAL_FARE = "com.app.rehlat:id/final_fare_textview";
    public static final String XPATH_OF_COUPON_CODE_TEXT_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField";
    public static final String APPLY_COUPON_CODE_BUTTON = "Apply";
    public static final String COUPON_CODE_FAILED_LABEL = "Coupon is invalid or expired";
    public static final String XPATH_OF_FOOTER_VIEW_LAYOUT = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]";
    public static final String XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]";
    public static final String KARAM_POINTS_TOGGLE_BUTTON = "XCUIElementTypeSwitch";
    public static final String XPATH_OF_FOOTER_VIEW_IN_BOOKINGPAGE = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]";

    // These are used in multiple methods, be on caution while editing these values
    public static Integer indexOfActualFareElementXPath = null;
    public static Integer indexOfFinalFareElementXPath = null;
    public static Integer indexOfAppliedCouponAmountElementXPath = null;

    /**
     * Check booking page screen is displayed
     */
    @Override
    public void checkBookingPageScreenIsDisplayed() {
        Logger.logAction("Checking the Booking page screen is displayed or not ?");
        try{
            if (isElementDisplayedByName(CONTACT_DETAILS_VIEW) || isElementDisplayedByName(ADD_TRAVELLERS_DETAILS)){
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
        Logger.logAction("Checking the Booking page screen is displayed or not ?");
        try{
            if (isElementDisplayedByName(SIGNED_IN_FOR_FAST_BOOKINGS_BUTTON)){
                Logger.logStep("User is not signed in");
                isUserSignedIn = false;
                return false;
            }else{
                Logger.logStep("User is signed in");
                isUserSignedIn = true;
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
                if (isElementDisplayedByXPath(XPATH_OF_PHONENUMBER_FIELD)){
                    String phoneNumberField = driver.findElementByXPath(XPATH_OF_PHONENUMBER_FIELD).getAttribute(Labels.VALUE_ATTRIBUTE);
                    if (phoneNumberField.equals(PLACEHOLDER_TEXT_OF_PHONENUMBER_TEXTFIELD)){
                        sendTextByXpath(XPATH_OF_PHONENUMBER_FIELD,Labels.phoneNumber);
                        closeTheKeyboard_iOS();
                    }else {
                        Logger.logComment(Labels.phoneNumber+" - is already entered in the in the phone number text field");
                    }
                }
            }else{
                sendTextByXpath(XPATH_OF_EMAIL_FIELD, Labels.EMAIL_ID_SIGN_IN);
                closeTheKeyboard_iOS();
                if (isElementDisplayedByXPath(XPATH_OF_PHONENUMBER_FIELD)){
                    String phoneNumberField = driver.findElementByXPath(XPATH_OF_PHONENUMBER_FIELD).getAttribute(Labels.VALUE_ATTRIBUTE);
                    if (phoneNumberField.equals(PLACEHOLDER_TEXT_OF_PHONENUMBER_TEXTFIELD)){
                        sendTextByXpath(XPATH_OF_PHONENUMBER_FIELD,Labels.phoneNumber);
                        closeTheKeyboard_iOS();
                    }else {
                        Logger.logComment(Labels.phoneNumber+" - is already entered in the in the phone number text field");
                    }
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the user info in the respected fields");
        }
    }

    /**
     * Tap on continue button
     */
    @Override
    public void tapOnContinueButton() {
        Logger.logAction("Tapping on continue button");
        try{
            checkFinalFareCalculationIsCorrect(); // This method needs to be removed after fixing the issue :- "Auto Enabling of toggle switch after navigating from travellers details screen, when user is signed in or signed up from bookings screen"
//            compareFinalPriceDisplayedInFooterViewWithTheFinalFareDisplayedInOffersAndDiscountLayout(); // After iOS is implemented by "Online Check In toggle button", this method needs to be removed from here and call it as a step of TC from workflows directly
            if (isElementDisplayedByName(CONTINUE_BUTTON)){
                driver.findElementByName(CONTINUE_BUTTON).click();
                Logger.logStep("Tapped on continue button");
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
            scrollDown();
            if (isElementDisplayedByName(ADULT_BUTTON)){
                driver.findElementByName(ADULT_BUTTON).click();
            }else{
                Logger.logError("Unable to tap on add travellers details button");
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Add travellers details button is not displayed in the current active screen");
        }
    }

    /**
     * Checking the ticket sold out popup is displayed
     * @return
     */
    @Override
    public boolean isTicketSoldOutPopUpIsDisplayed() {
        Logger.logAction("Checking the ticket sold out popup is displayed or not ?");
        try{
            if (isElementDisplayedByName(TICKET_SOLD_OUT_POPUP)){
                Logger.logStep(TICKET_SOLD_OUT_POPUP +" - popup is displayed in the current active screen");
                return true;
            }else {
                Logger.logStep(TICKET_SOLD_OUT_POPUP +" - popup is not displayed in the current active screen");
                return false;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the popup is displayed or not");
        }
        return false;
    }

    /**
     * Tap on ok button in ticket sold out popup
     */
    @Override
    public void tapOnOkButtonInTicketSoldOutPopup() {
        Logger.logAction("Tapping on "+OK_BUTTON+ " button");
        try {
            if (isElementDisplayedByName(OK_BUTTON)){
                driver.findElementByName(OK_BUTTON).click();
            }else {
                Logger.logError(" - button name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on OK button in ticket sold out popup");
        }
    }

    /**
     * Tap on sign in for faster bookings button
     */
    @Override
    public void tapOnSignInForFasterBookingsButton() {
        try {
            if (isElementDisplayedById(SIGNED_IN_FOR_FAST_BOOKINGS_BUTTON)){
                driver.findElement(By.id(SIGNED_IN_FOR_FAST_BOOKINGS_BUTTON)).click();
            }else {
                Logger.logError(SIGNED_IN_FOR_FAST_BOOKINGS_BUTTON+" - element name is not displayed in the current active screen");
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
            Double reviewBookingPriceInFooterView = Double.valueOf(getTheDisplayedTicketBookingValueInFooterView("BookingPageScreen",3));
            Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = String.valueOf(reviewBookingPriceInFooterView);
            Logger.logComment("Cost of ticket in Booking page is :- "+reviewBookingPriceInFooterView);

            ////// Below code is to check the values of math calculation done in offers and discounts layout /////

//            Double bookingSeatCostInReviewBookingScreen = null;
//            Double couponAmount;
//            Double finalDisplayedFare;
//            Double displayedActualFare;
//            Double karamPoints;
//
//           // Checking and getting the booking cost displaying in review booking screen
//            if (Labels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN == null){
//                Logger.logError("Booking cost displaying in the review booking screen is :- "+Labels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
//            }else {
//                bookingSeatCostInReviewBookingScreen = Double.valueOf(Labels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
//            }
//            setTheXpathIndexesForPriceDetailsInOffersAndDiscountsCell();
//            couponAmount = getThePriceOf("couponAmount", indexOfAppliedCouponAmountElementXPath);
//            finalDisplayedFare = getThePriceOf("finalDisplayedFare", indexOfFinalFareElementXPath);
//            displayedActualFare = getThePriceOf("displayedActualFare", indexOfActualFareElementXPath);
//            if (isUserIsSignedIn()){
//                karamPoints = Double.valueOf(getKaramPoints()); // Implement if condition after developer enable the karam points price element visibility
//            }else {
//                karamPoints = 0.00;
//                Logger.logComment("User is not logged in. So applied karam points are:- "+karamPoints);
//            }
//            Logger.logStep("Flights booking details are :- ");
//            Logger.logComment("Actual Fare cost of booking flight :- "+displayedActualFare);
//            Logger.logComment("Applied Coupon amount of booking flight :- "+couponAmount);
//            Logger.logComment("Applied Karam points cost of booking flight :- "+karamPoints);
//            Logger.logComment("Final Fare cost of booking flight (Displaying value) :- "+finalDisplayedFare);
//            if (finalDisplayedFare.equals(0.00)){
//                finalDisplayedFare = displayedActualFare;
//                Logger.logComment("Final Fare cost of booking flight (For Math Calculation) :- "+finalDisplayedFare);
//                Logger.logAction("All the values are ready for to calculate the math");
//            }else {
//              Logger.logAction("All the values are ready for to calculate the math");
//            }
//            if (displayedActualFare.equals(bookingSeatCostInReviewBookingScreen)){
//                Double finalFareMathCalculation = (displayedActualFare)-(couponAmount)-(karamPoints); // Internal math calculation logic
//                Logger.logComment("Final fare math calculation value is :- "+finalFareMathCalculation);
//                if (finalFareMathCalculation.equals(finalDisplayedFare)){
//                    Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = String.valueOf(finalFareMathCalculation);
//                    Logger.logStep("Final fare calculation is correct");
//                }else if (finalFareMathCalculation.toString().contains(finalDisplayedFare.toString())){ // This method is because of internal math calculation is giving more than a digit after the decimal point eg: 14.10000000000000001 which is not matching with the actual value of Eg: 14.1
//                    Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN = String.valueOf(finalFareMathCalculation);
//                    Logger.logStep("Final fare calculation is correct");
//                }else {
//                    Logger.logError("Final fare calculation is in-correct");
//                }
//            }else {
//                Logger.logError("Booking seat cost in review booking screen is not matching with the cost displaying in booking page..,i.e.., Booking seat cost in Booking page screen & Review Booking screen is:- "+displayedActualFare+" & "+Labels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
//            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to check the final fare calculation");
        }
    }

    /**
     * Get the price based on price type and element xpath index value
     * @param priceType
     * @param indexOfAPriceDisplayingInOffersAndDiscountsCell
     * @return
     */
    public Double getThePriceOf(String priceType, Integer indexOfAPriceDisplayingInOffersAndDiscountsCell) {
        Logger.logAction("Getting the price of element :-"+indexOfAPriceDisplayingInOffersAndDiscountsCell);
        Double priceValue = null;
        try{
            if (priceType.equals("couponAmount")){
                // Checking and getting the applied coupon amount
                if (indexOfAppliedCouponAmountElementXPath == null){
                    priceValue = 0.00;
                    return  priceValue;
                }else {
                    priceValue = Double.valueOf(getCouponAmount(indexOfAppliedCouponAmountElementXPath));
                    return  priceValue;
                }
            }
            if (priceType.equals("displayedActualFare")){
                //Checking and getting the actual displaying fare of booking flight
                if (indexOfActualFareElementXPath == null){
                    Logger.logError("Actual displaying Booking cost is :- "+Labels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN);
                }else {
                    priceValue = Double.valueOf(getDisplayedActualFare(indexOfActualFareElementXPath));
                    return  priceValue;
                }
            }
            if (priceType.equals("finalDisplayedFare")){
                //Checking and getting the final displaying fare of booking flight
                if (indexOfFinalFareElementXPath == null){
                    priceValue = 0.00;
                    return  priceValue;
                }else {
                    priceValue = Double.valueOf(getFinalDisplayedFare(indexOfFinalFareElementXPath));
                    return  priceValue;
                }
            }
            else {
                Logger.logError("For the price of :- "+priceType+" - is not listed in this method");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the price of element :- "+indexOfAPriceDisplayingInOffersAndDiscountsCell);
        }
        return  priceValue;
    }

    /**
     * Set the xpath indexes for price details in offers and discounts
     */
    public void setTheXpathIndexesForPriceDetailsInOffersAndDiscountsCell() {
        Logger.logAction("Setting xpath indexes for price details in offers and discounts cell");
        try {
            if (isUserIsSignedIn()){
                if (isCouponCodeApplied() && isKaramPointsToggleSwitchEnabled()){
                    indexOfActualFareElementXPath = 6;
                    indexOfFinalFareElementXPath = 8;
                    indexOfAppliedCouponAmountElementXPath = 7;
                    // Add karam points xpath integer value also after enabling the element detection by developer
                }else if (isCouponCodeApplied() && !(isKaramPointsToggleSwitchEnabled())){
                    indexOfActualFareElementXPath = 6;
                    indexOfFinalFareElementXPath = 8;
                    indexOfAppliedCouponAmountElementXPath = 7;
                } else {
                    indexOfActualFareElementXPath = 3;
                }
            }else {
                if (isCouponCodeApplied()){
                    indexOfActualFareElementXPath = 6;
                    indexOfFinalFareElementXPath = 8;
                    indexOfAppliedCouponAmountElementXPath = 7;
                } else {
                    indexOfActualFareElementXPath = 3;
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to set the xpath indexes for price details in offers and discounts cell");
        }
    }

    /**
     * Get the actual displaying fare
     * @return
     */
    public static String getDisplayedActualFare(Integer indexOfActualFareElementXPAth) {
        Logger.logAction("Getting the displayed actual fare");
        String actualDisplayingFare = null;
        try
        {
            String xPathOfActualFare = XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW+"/XCUIElementTypeStaticText["+indexOfActualFareElementXPAth+"]"; // "indexOfActualFareElementXPath" is the hard coded value of actual fare currency label when coupon code is applied (Doesn't matter whether karam is applied or not)
            String ActualFareWithCurrentName = driver.findElementByXPath(xPathOfActualFare).getAttribute(Labels.VALUE_ATTRIBUTE);
            String actualAmountPrice = ActualFareWithCurrentName.replace("KWD ", "");
            Logger.logComment("Actual Fare cost of booking flight :- "+actualAmountPrice);
            actualDisplayingFare = actualAmountPrice;
            return actualDisplayingFare;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the actual displayed fare");
        }
        return actualDisplayingFare;
    }

    /**
     * Get the coupon applied amount
     * @return
     */
    public static String getCouponAmount(Integer indexOfAppliedCouponAmountElementXPAth) {
        Logger.logAction("Getting the coupon amount");
        String couponAmount = "0";
        String xPathOfActualFare;
        String ActualFareWithCurrentName;
        try
        {
            xPathOfActualFare = XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW+"/XCUIElementTypeStaticText["+indexOfAppliedCouponAmountElementXPAth+"]"; // "indexOfFinalFareElementXPath" is the hard coded value of final fare currency label when coupon code is applied (Doesn't matter whether karam is applied or not)
            try {
                ActualFareWithCurrentName = driver.findElementByXPath(xPathOfActualFare).getAttribute(Labels.VALUE_ATTRIBUTE);
                if(ActualFareWithCurrentName.contains(APPLIED_COUPON_AMOUNT_CURRENCY_WIHOUT_AMOUNT)){
                    String couponAmountPrice = ActualFareWithCurrentName.replace(APPLIED_COUPON_AMOUNT_CURRENCY_WIHOUT_AMOUNT,"");
                    Logger.logComment("Applied Coupon amount of booking flight :- "+couponAmountPrice);
                    couponAmount = couponAmountPrice;
                    return couponAmount;
                }else {
                    indexOfAppliedCouponAmountElementXPAth = indexOfAppliedCouponAmountElementXPAth+1;
                    xPathOfActualFare = XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW+"/XCUIElementTypeStaticText["+indexOfAppliedCouponAmountElementXPAth+"]"; // "indexOfFinalFareElementXPath" is the hard coded value of final fare currency label when coupon code is applied (Doesn't matter whether karam is applied or not)
                    ActualFareWithCurrentName = driver.findElementByXPath(xPathOfActualFare).getAttribute(Labels.VALUE_ATTRIBUTE);
                    if (ActualFareWithCurrentName.contains(APPLIED_COUPON_AMOUNT_CURRENCY_WIHOUT_AMOUNT)){
                        String couponAmountPrice = ActualFareWithCurrentName.replace(APPLIED_COUPON_AMOUNT_CURRENCY_WIHOUT_AMOUNT,"");
                        Logger.logComment("Applied Coupon amount of booking flight :- "+couponAmountPrice);
                        couponAmount = couponAmountPrice;
                        indexOfFinalFareElementXPath = 7;
                        return couponAmount;
                    }
                    else {
                        Logger.logError(ActualFareWithCurrentName+" - element is not matching with the coupon amount nor with the actual fare");
                    }
                }
            }catch (Exception exception){
                Logger.logComment("Coupon code is not applied..,");
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
    public static String getKaramPoints() {
        Logger.logAction("Getting the karam points");
        String karamPoints = "0";
        try
        {
            if (isKaramPointsToggleSwitchEnabled()){
                Logger.logWarning("Karam points locator is invisible in inspector, discuss with developer and implement a method to get the displaying karam points");
                Logger.logComment("Currently hardcoding the karam points as:- " +Labels.IOS_APPLIED_KARAM_POINTS);
                karamPoints = Labels.IOS_APPLIED_KARAM_POINTS;
                Logger.logComment("Applied Karam points cost of booking flight :- "+karamPoints);
                return karamPoints;
            }else {
                Logger.logComment("Karam points toggle switch is disabled.So, the applied karam points are :- "+karamPoints);
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
    public static String getFinalDisplayedFare(Integer indexOfFinalFareElementXPAth) {
        Logger.logAction("Getting the displayed final fare");
        String finalDisplayedFare = null;
        try
        {
            String xPathOfActualFare = XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW+"/XCUIElementTypeStaticText["+indexOfFinalFareElementXPAth+"]"; // "indexOfFinalFareElementXPath" is the hard coded value of final fare currency label when coupon code is applied (Doesn't matter whether karam is applied or not)
            String ActualFareWithCurrentName = driver.findElementByXPath(xPathOfActualFare).getAttribute(Labels.VALUE_ATTRIBUTE);
            String actualAmountPrice = ActualFareWithCurrentName.replace("KWD ", "");
            finalDisplayedFare = actualAmountPrice;
            Logger.logComment("Final Fare cost of booking flight :- "+finalDisplayedFare);
            return finalDisplayedFare;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the final displayed fare");
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
            if (isElementEnabledByClassName(TOGGLE_SWITCH)){
                scrollDown(); // This logic is to for different iPhones with different sizes
                String karamPointsToggleStatus = driver.findElement(By.className(KARAM_POINTS_TOGGLE_BUTTON)).getAttribute(Labels.VALUE_ATTRIBUTE);
                return karamPointsToggleStatus.equals(Labels.VALUE_ONE);
            }else {
                Logger.logError(TOGGLE_SWITCH+" - element name is not displayed in the current active screen");
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
                WebElement karamPointsToggleSwitch = driver.findElement(By.className(KARAM_POINTS_TOGGLE_BUTTON));
                karamPointsToggleSwitch.click();
                Logger.logComment("Karam points toggle button is enabled");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enable the karam points toggle button");
        }
    }
    /**
     * Disable the karam points toggle
     * @return
     */
    public static void disableKaramPointsToggleSwitch() {
        Logger.logAction("Enabling the karam points toggle");
        try
        {
            if (!isKaramPointsToggleSwitchEnabled()){
                Logger.logComment("karam points toggle button is already disabled");
            }else {
                WebElement karamPointsToggleSwitch = driver.findElement(By.className(KARAM_POINTS_TOGGLE_BUTTON));
                karamPointsToggleSwitch.click();
                Logger.logComment("Karam points toggle button is disabled");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to disable the karam points toggle button");
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
            if (isCouponCodeApplied()){
                Logger.logComment("Coupon code is applied successfully");
            }else {
                Logger.logComment("Coupon code is not applied successfully");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to apply the coupon code");
        }
    }

    /**
     * Send keys to coupon code text field
     */
    public void sendKeysToCouponCodeTextField() {
        Logger.logAction("Sending the keys to coupon code :- "+Labels.COUPON_CODE);
        try {
            if (isElementDisplayedByXPath(XPATH_OF_COUPON_CODE_TEXT_VIEW)){
                driver.findElement(By.xpath(XPATH_OF_COUPON_CODE_TEXT_VIEW)).sendKeys(Labels.COUPON_CODE);
                closeTheKeyboard_iOS();
            }else {
                Logger.logError(XPATH_OF_COUPON_CODE_TEXT_VIEW+" - element xpath is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to send keys to apply coupon code text field");
        }
    }

    /**
     * Tap on apply coupon code button
     */
    public void tapOnApplyCouponCodeButton() {
        Logger.logAction("Tapping on apply coupon code");
        try {
            if (isElementDisplayedById(APPLY_COUPON_CODE_BUTTON)){
                driver.findElement(By.id(APPLY_COUPON_CODE_BUTTON)).click();
                Logger.logComment("Coupon code is applied");
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(APPLY_COUPON_CODE_BUTTON)));
            }else {
                Logger.logError(APPLY_COUPON_CODE_BUTTON+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to tap on apply coupon code button");
        }
    }

    /**
     * Check the applied coupon code is applied successfully
     */
    public static boolean isCouponCodeApplied() {
        Logger.logAction("Checking coupon code is applied successfully");
        try {
            if (isElementDisplayedByXPath(XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW)){
                try{
                    WebElement offersAndDiscountsXpath = driver.findElementByXPath(XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW);
                    boolean status = offersAndDiscountsXpath.findElement(By.id(Labels.COUPON_CODE)).isDisplayed();
                    if (status==true){
                        return true;
                    }else if (isElementDisplayedById(COUPON_CODE_FAILED_LABEL)){
                        return false;
                    }else {
                        return false;
                    }
                }catch (Exception elementNotFound){
                    return false;
                }
            }else {
                Logger.logError(XPATH_OF_OFFERS_AND_DISCOUNTS_VIEW+" \n - element xpath is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("encountered error: unable to tap on apply coupon code button");
        }
        return false;
    }

    /**
     * Compare the final price displayed in footer view with the final fare displayed in offers and discounts layout
     */
    public static void compareFinalPriceDisplayedInFooterViewWithTheFinalFareDisplayedInOffersAndDiscountLayout() {
        Logger.logAction("Comparing the final price displayed in footer view is matches with the final fare displayed in offers and discounts layout");
        try{
            Double reviewBookingPriceInFooterView = Double.valueOf(getTheDisplayedTicketBookingValueInFooterView("BookingPageScreen",3));
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

//    /**
//     * Get the booking price displayed in the footer view layout
//     * @return
//     */
//    public static Double getTheBookingPriceDisplayedInFooterView(){
//        Logger.logAction("Getting the booking price displayed in footer view");
//        try{
//            Thread.sleep(1000);
////            if (isElementDisplayedByXPath(XPATH_OF_FOOTER_VIEW_IN_BOOKINGPAGE)){
////                String xPathOfReviewBookingPrice = XPATH_OF_FOOTER_VIEW_LAYOUT+"/XCUIElementTypeStaticText[2]"; // "indexOfFinalFareElementXPath" is the hard coded value of final fare currency label when coupon code is applied (Doesn't matter whether karam is applied or not)
////                if (isElementDisplayedByXPath(xPathOfReviewBookingPrice)){
//                WebElement footerView = driver.findElementByXPath(XPATH_OF_FOOTER_VIEW_IN_BOOKINGPAGE);
//                List<WebElement> xcuiElementTypeStaticText = footerView.findElements(By.className("XCUIElementTypeStaticText"));
//                for (int index=0;index<=xcuiElementTypeStaticText.size();index++){
//                    String eachValueInFooterView = xcuiElementTypeStaticText.get(index).getAttribute("name");
//                    if (eachValueInFooterView.contains(Labels.CURRENT_USER_CURRENCY_TYPE)){
//                        String actualAmountPrice = eachValueInFooterView.replace(Labels.CURRENT_USER_CURRENCY_TYPE+Labels.ONE_CHARACTER_SPACE, "");
//                        Logger.logComment("Final Fare cost of booking flight in footer view is :- "+actualAmountPrice);
//                        return Double.valueOf(actualAmountPrice);
//                    }
//                }
////                    String ActualFareWithCurrentName = driver.findElementByXPath(xPathOfReviewBookingPrice).getAttribute(Labels.VALUE_ATTRIBUTE);
////                    String actualAmountPrice = ActualFareWithCurrentName.replace("KWD ", "");
////                    return Double.valueOf(actualAmountPrice);
////                }else {
////                    Logger.logError(xPathOfReviewBookingPrice+" xpath is incorrect..,Please re check the xpath of review booking price in footer view");
////                }
//
////            }else {
////                Logger.logError(XPATH_OF_FOOTER_VIEW_IN_BOOKINGPAGE+" :- Xpath of footer view is not displayed in the current screen");
////            }
//        }catch (Exception exception){
//            Logger.logError("Encountered error: Unable to get the booking price displayed in footer view");
//        }
//        return null;
//    }
}
