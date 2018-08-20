package com.automation.rehlat.pages.reviewBooking;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


public class ReviewBookingAndroid extends ReviewBookingBase {
    public static final String REVIEW_BOOKING_SCREEN_TITTLE = "com.app.rehlat:id/reviewBookingTextView";
    public static final String IN_PROGRESS_INDICATOR = "com.app.rehlat:id/journeContinueProgressBar";
    public static final String CONTINUE_BUTTON = "com.app.rehlat:id/countinue_text";
    public static final String TOGGLE_SWITCH = "com.app.rehlat:id/set_subscription_switch";


    /**
     * Check Review Booking screen is displayed or not
     */
    @Override
    public void checkReviewBookingScreenIsDisplayed() {
        Logger.logAction("Checking the review booking screen is displayed or not ?");
        try{
            if (isElementDisplayedById(REVIEW_BOOKING_SCREEN_TITTLE)){
                Logger.logStep("Review Booking screen is displayed");
            }else {
                Logger.logError("Review Booking screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to check the current active screen name");
        }
    }

    /**
     * Tap on continue button
     */
    @Override
    public void tapOnContinueButton() {
        Logger.logAction("Tapping on continue button");
        try{
            waitTillInProgressIndicatorIsInvisible();
            Logger.logAction("Tapping on continue button");
            if (isElementDisplayedById(CONTINUE_BUTTON)){
                driver.findElementById(CONTINUE_BUTTON).click();
            }else {
                Logger.logError("Continue button is not displayed in the current screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on continue button");
        }
    }

    /**
     * Wait till the loading in-progress indicator is in visible
     * @return
     */
    public static void waitTillInProgressIndicatorIsInvisible() {
        Logger.logAction("Waiting till In progress indicator is invisible");
        try{
            if (isElementDisplayedById(IN_PROGRESS_INDICATOR)){
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(IN_PROGRESS_INDICATOR)));
            }else {
                Logger.logStep("In progress indicator is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the visibility of an element");
        }
    }

    /**
     * Enable the security check in toggle button
     */
    @Override
    public void enableSecurityCheckInToggle() {
        Logger.logAction("Enabling the security check in toggle");
        try {
            if (isElementDisplayedByIdWithOneTimeChecking(TOGGLE_SWITCH)){
                WebElement toggleSwitch = driver.findElement(By.id(TOGGLE_SWITCH));
                String toggleSwitchValue = toggleSwitch.getText();
                if (toggleSwitchValue.equals(Labels.ANDROID_TOGGLE_TEXT_OFF)){
                    Logger.logStep("Toggle switch is disabled and making it to enable by tapping on it");
                    driver.findElementById(TOGGLE_SWITCH).click();
                }else if (toggleSwitchValue.equals(Labels.ANDROID_TOGGLE_TEXT_OFF)){
                    Logger.logStep("Toggle switch is already enabled");
                }
            }else {
                scrollToToggleButton();
                if (isElementDisplayedByIdWithOneTimeChecking(TOGGLE_SWITCH)){
                    WebElement toggleSwitch = driver.findElement(By.id(TOGGLE_SWITCH));
                    String toggleSwitchValue = toggleSwitch.getText();
                    if (toggleSwitchValue.equals(Labels.ANDROID_TOGGLE_TEXT_OFF)){
                        Logger.logStep("Toggle switch is disabled and making it to enable by tapping on it");
                        driver.findElementById(TOGGLE_SWITCH).click();
                    }else if (toggleSwitchValue.equals(Labels.ANDROID_TOGGLE_TEXT_OFF)){
                        Logger.logStep("Toggle switch is already enabled");
                    }
                }else {
                    Logger.logError("Tried two times scrolling to Toggle button but it is not displayed in the current active screen");
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element name - " + TOGGLE_SWITCH);
        }
    }

    /**
     * Disable the security check in toggle button
     */
    @Override
    public void disableSecurityCheckInToggle() {
        Logger.logAction("Disabling the security check in toggle");
        try {
            if (isElementDisplayedByIdWithOneTimeChecking(TOGGLE_SWITCH)){
                WebElement toggleSwitch = driver.findElement(By.id(TOGGLE_SWITCH));
                String toggleSwitchValue = toggleSwitch.getText();
                if (toggleSwitchValue.equalsIgnoreCase(Labels.ANDROID_TOGGLE_TEXT_ON)){
                    Logger.logStep("Toggle switch is enabled and making it to disable by tapping on it");
                    driver.findElement(By.id(TOGGLE_SWITCH)).click();
                }else if (toggleSwitchValue.equals(Labels.ANDROID_TOGGLE_TEXT_OFF)){
                    Logger.logStep("Toggle switch is already disabled");
                }
            }else {
                scrollToToggleButton();
                Thread.sleep(Labels.WAIT_TIME_MIN);
                if (isElementDisplayedByIdWithOneTimeChecking(TOGGLE_SWITCH)){
                    WebElement toggleSwitch = driver.findElementById(TOGGLE_SWITCH);
                    String toggleSwitchValue = toggleSwitch.getText();
                    if (toggleSwitchValue.equalsIgnoreCase(Labels.ANDROID_TOGGLE_TEXT_ON)){
                        Logger.logStep("Toggle switch is enabled and making it to disable by tapping on it");
                        driver.findElement(By.id(TOGGLE_SWITCH)).click();
                    }else if (toggleSwitchValue.equals(Labels.ANDROID_TOGGLE_TEXT_OFF)){
                        Logger.logStep("Toggle switch is already disabled");
                    }
                }
                else {
                    scrollTheScreenUpwards();
                    if (isElementDisplayedByIdWithOneTimeChecking(TOGGLE_SWITCH)){
                        WebElement toggleSwitch = driver.findElement(By.id(TOGGLE_SWITCH));
                        String toggleSwitchValue = toggleSwitch.getText();
                        if (toggleSwitchValue.equalsIgnoreCase(Labels.ANDROID_TOGGLE_TEXT_ON)){
                            Logger.logStep("Toggle switch is enabled and making it to disable by tapping on it");
                            driver.findElement(By.id(TOGGLE_SWITCH)).click();
                        }else if (toggleSwitchValue.equals(Labels.ANDROID_TOGGLE_TEXT_OFF)){
                            Logger.logStep("Toggle switch is already disabled");
                        }
                    }else {
                        Logger.logError("Tried two times scrolling to Toggle button but it is not displayed in the current active screen");
                    }
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element name - " + TOGGLE_SWITCH);
        }
    }

    /**
     * Scroll to the toggle button for Android
     */
    public static void scrollToToggleButton() throws Exception {
        Logger.logAction("Scrolling to toggle button");
        int counter = 0;
        WebElement element = null;
        while (counter < Labels.DEFAULT_SCROLL_ATTEMPTS) {
            try {
                Thread.sleep(3000);
                element = driver.findElementById(TOGGLE_SWITCH);
                if (element.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                driver.swipe(507,850,507,450,Labels.SWIPE_DURATION_MIN);
                Logger.logComment(counter + " time trying to find the element id of - " + TOGGLE_SWITCH);
            }
            Thread.sleep(Labels.WAIT_TIME_DEFAULT);
            counter++;
        }
        if (element.isDisplayed()) {
            Logger.logComment(TOGGLE_SWITCH + " - element id is displayed and moving forward to next step");
        }else {
            Logger.logWarning(TOGGLE_SWITCH + " - element id is not displayed in the current active screen");
        }
    }
//        try {
//            if (isElementDisplayedById(TOGGLE_SWITCH)){
//                Logger.logComment("Toggle button is already displayed, no need to scroll the screen");
//            }else {
//                scrollTheScreenUpwards();
//                scrollTheScreenUpwards();
//                driver.swipe(507,800,507,600,Labels.SWIPE_DURATION_MIN);
//            }
//        }catch (Exception exception){
//            exception.printStackTrace();
//            Logger.logError("Encountered error: Unable to scroll to toggle button");
//        }
//    }

    /**
     * Compare the selected booking seat cost in search results screen and displayed in review booking screen
     */
    @Override
    public void compareTheSelectedBookingSeatCostInSearchResultsScreenDisplayedInReviewBookingScreen() {
        Logger.logAction("Comparing the selected booking flight cost displayed in the search results screen and in the review booking screen");
        String bookingSeatCostDisplayedInReviewBookingScreen;
        try {
            bookingSeatCostDisplayedInReviewBookingScreen = getTheDisplayedTicketBookingValue();
            double selectedSeatBookingCostInFlightSearchResultsScreen = Double.parseDouble((Labels.SELECTED_SEAT_BOOKING_COST));
            double selectedSeatCostDisplayedInReviewBookingScreen = Double.parseDouble(bookingSeatCostDisplayedInReviewBookingScreen);
            Logger.logComment("Displayed flight booking cost in review booking screen is:- " +bookingSeatCostDisplayedInReviewBookingScreen+"\n"+"        -> Displayed flight booking cost in review booking screen is:- "+Labels.SELECTED_SEAT_BOOKING_COST );
            if (bookingSeatCostDisplayedInReviewBookingScreen.equals(Labels.SELECTED_SEAT_BOOKING_COST)){
                Labels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN = Labels.SELECTED_SEAT_BOOKING_COST;
                Logger.logStep("Selected seat booking cost is matches in review booking screen and in search results screen");
            } else if(selectedSeatBookingCostInFlightSearchResultsScreen <= selectedSeatCostDisplayedInReviewBookingScreen) {
                Logger.logComment("Selected flight booking cost in flight search results is lesser than the booking flight cost displayed in review booking screen.., So rechecking the flight cost by disabling the security check in toggle button");
                disableSecurityCheckInToggle();
                bookingSeatCostDisplayedInReviewBookingScreen = getTheDisplayedTicketBookingValue();
                if (bookingSeatCostDisplayedInReviewBookingScreen.contains(Labels.SELECTED_SEAT_BOOKING_COST)){
                    Labels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN = Labels.SELECTED_SEAT_BOOKING_COST;
                    Logger.logStep("Selected seat booking cost is matches in review booking screen and in search results screen");
                }else{
                    Logger.logError("Selected seat booking cost is not matches in review booking screen and in search results screen");
                }
            } else{
                Logger.logError("Selected seat booking cost is not matches in review booking screen and in search results screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the cost of selected booking seat in search results screen displayed in review booking screen");
        }
    }

    /**
     * Get the displayed ticket booking value
     * @return
     */
    public static String getTheDisplayedTicketBookingValue() {
        Logger.logAction("Getting the displayed ticket booking value");
        String flightCellTypeText = null;
        try {
//            WebElement footerView = driver.findElementById("com.app.rehlat:id/footer_view");
            if (isElementDisplayedById(IN_PROGRESS_INDICATOR)){
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(IN_PROGRESS_INDICATOR)));
            }else {
//                Thread.sleep(Labels.WAIT_TIME_MIN);
                if (isElementDisplayedById("com.app.rehlat:id/reviewbooking_price")){
                    WebElement reviewBookingPriceLabel = driver.findElementById("com.app.rehlat:id/reviewbooking_price");
                    String reviewBookingPrice = reviewBookingPriceLabel.getText();
//                if (reviewBookingPrice.contains(".")){
//                    Logger.logComment("Displayed booking cost is: " +reviewBookingPrice);
                    flightCellTypeText = reviewBookingPrice;
                    return flightCellTypeText;
//                }else{
//                    Logger.logStep("Booking flight cost is not displayed in the current active screen");
//                }
                }else {
                    Logger.logError("Review booking price element name is not displayed");
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the displayed ticket booking value");
        }
        return flightCellTypeText;
    }


}
