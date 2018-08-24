package com.automation.rehlat.pages.reviewBooking;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ReviewBookingIos extends ReviewBookingBase {

    public static final String REVIEW_BOOKING_SCREEN_TITTLE = "Review booking";
    public static final String IN_PROGRESS_INDICATOR = "In progress";
    public static final String CONTINUE_BUTTON = "CONTINUE";



    /**
     * Check Review Booking screen is displayed or not
     */
    @Override
    public void checkReviewBookingScreenIsDisplayed() {
        Logger.logAction("Checking the review booking screen is displayed or not ?");
        try{
            if (isElementDisplayedByName(REVIEW_BOOKING_SCREEN_TITTLE)){
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
        try{
            if (waitTillInProgressIndicatorIsInvisible()){
                Logger.logAction("Tapping on continue button");
                if (isElementDisplayedByName(CONTINUE_BUTTON)){
                    driver.findElementByName(CONTINUE_BUTTON).click();
                }else {
                    Logger.logError("Continue button is not displayed in the current screen");
                }
            }else {
                Logger.logError("In progress indicator is still visible");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on continue button");
        }
    }

    /**
     * Wait till the loading in-progress indicator is in visible
     * @return
     */
    public static boolean waitTillInProgressIndicatorIsInvisible() {
        Logger.logAction("Waiting till In progress indicator is invisible");
        try{
            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(IN_PROGRESS_INDICATOR)));
            Logger.logStep("In progress indicator is not visible");
            return true;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the visibility of an element");
        }
        return false;
    }

    /**
     * Enable the security check in toggle button
     */
    @Override
    public void enableSecurityCheckInToggle() {
        Logger.logAction("Enabling the security check in toggle");
        try {
            enableToggleSwitch_iOS();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enable the toggle switch");
        }
    }

    /**
     * Disable the security check in toggle button
     */
    @Override
    public void disableSecurityCheckInToggle() {
        Logger.logAction("Disabling the security check in toggle");
        try {
            if (isElementEnabledByClassName(TOGGLE_SWITCH)){
                disableToggleSwitch_iOS();
            }else {
                scrollDown();
                disableToggleSwitch_iOS();
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to disable the security toggle switch");
        }
    }

    /**
     * Compare the selected booking seat cost in search results screen and displayed in review booking screen
     */
    @Override
    public void compareTheSelectedBookingSeatCostInSearchResultsScreenDisplayedInReviewBookingScreen() {
        Logger.logAction("Comparing the selected booking seat cost in search results screen displayed in review booking screen");
        String bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen;
        try {
             bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen = getTheDisplayedTicketBookingValue();
            if (bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen.contains(Labels.SELECTED_SEAT_BOOKING_COST)){
                String bookingCostIncludingCurrencyName = Labels.SELECTED_SEAT_BOOKING_COST;
                String bookingCostExcludingCurrencyName = bookingCostIncludingCurrencyName.replace("KWD ", "");
                Labels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN = bookingCostExcludingCurrencyName;
                Logger.logComment("Booking seat cost in Review booking screen :- "+Labels.SELECTED_SEAT_BOOKING_COST + "\n" +"        -> Booking seat cost in Flights Search results screen :- "+bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen);
                Logger.logStep("Selected seat booking cost is matches in review booking screen and in search results screen");
            } else {
                Logger.logComment("Booking seat cost in Review booking screen : "+Labels.SELECTED_SEAT_BOOKING_COST + "\n" +"        -> Booking seat cost in Flights Search results screen :- "+bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen);
                Logger.logStep("Selected seat booking cost is not matches in review booking screen and in search results screen.., So checking the booking flight cost again by disabling the toggle button");
                disableSecurityCheckInToggle();
//                Thread.sleep(Labels.WAIT_TIME_MIN);
                bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen = getTheDisplayedTicketBookingValue();
                if (bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen.contains(Labels.SELECTED_SEAT_BOOKING_COST)){
                    String bookingCostIncludingCurrencyName = Labels.SELECTED_SEAT_BOOKING_COST;
                    String bookingCostExcludingCurrencyName = bookingCostIncludingCurrencyName.replace("KWD ", "");
                    Labels.BOOKING_COST_DISPLAYING_IN_REVIEW_BOOKING_SCREEN = bookingCostExcludingCurrencyName;
                    Logger.logComment("Booking seat cost in Review booking screen : "+Labels.SELECTED_SEAT_BOOKING_COST + "\n" +"        -> Booking seat cost in Flights Search results screen :- "+bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen);
                    Logger.logStep("Selected seat booking cost is matches in review booking screen and in search results screen");
                }else{
                    Logger.logComment("Booking seat cost in Review booking screen : "+Labels.SELECTED_SEAT_BOOKING_COST + "\n" +"        -> Booking seat cost in Flights Search results screen :- "+bookingSeatCostWithCurrencyTypeDisplayedInReviewBookingScreen);
                    Logger.logError("Selected seat booking cost is not matches in review booking screen and in search results screen");
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the cost of selected booking seat in search results screen displayed in review booking screen");
        }
    }

    /**
     * Get the displayed ticket booking value
     * @return
     * @throws Exception
     */
    public static String getTheDisplayedTicketBookingValue() throws Exception{
        Logger.logAction("Getting the ticket cost displayed at footer view of the screen");
        String flightCellTypeText = null;
        WebElement bookingFlightCell;
        WebElement flightCellType;
        List<WebElement> flightCellDetails;
        int cellIndex;
        bookingFlightCell = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]");
        flightCellDetails = bookingFlightCell.findElements(By.className("XCUIElementTypeStaticText"));
        for (cellIndex=0;cellIndex<flightCellDetails.size();cellIndex++){
            flightCellType = flightCellDetails.get(cellIndex);
            flightCellTypeText = flightCellType.getAttribute(Labels.VALUE_ATTRIBUTE);
            if (flightCellTypeText.contains(Labels.CURRENT_USER_CURRENCY_TYPE) && flightCellTypeText.contains(".")){
                String actualAmountPrice = flightCellTypeText.replace(Labels.CURRENT_USER_CURRENCY_TYPE+Labels.ONE_CHARACTER_SPACE, "").trim();
                Logger.logComment("Final Fare cost of booking flight in footer view is :- "+actualAmountPrice);
                return actualAmountPrice;
            }else if(flightCellTypeText.contains(Labels.CURRENT_USER_CURRENCY_TYPE)){
                String actualAmountPrice = flightCellTypeText.replace(Labels.CURRENT_USER_CURRENCY_TYPE+Labels.ONE_CHARACTER_SPACE, "").trim();
                Logger.logComment("Final Fare cost of booking flight in footer view is :- "+actualAmountPrice);
                return actualAmountPrice;
            }else if(flightCellTypeText.contains("updating...") || flightCellTypeText.contains("updating.") || flightCellTypeText.contains("updating..")){
//                Thread.sleep(Labels.WAIT_TIME_MIN);
//                Logger.logStep("Booking flight cost is not displayed, price label is still loading");
//                bookingFlightCell = driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]");
//                flightCellDetails = bookingFlightCell.findElements(By.className("XCUIElementTypeStaticText"));
//                for (cellIndex=0;cellIndex<flightCellDetails.size();cellIndex++) {
//                    flightCellType = flightCellDetails.get(cellIndex);
//                    flightCellTypeText = flightCellType.getAttribute(Labels.VALUE_ATTRIBUTE);
//                    if (flightCellTypeText.contains(".")){
//                        Logger.logComment("Displayed booking cost is: " +flightCellTypeText);
//                        return flightCellTypeText;
//                    } else if(flightCellTypeText.contains(Labels.CURRENT_USER_CURRENCY_TYPE)){
//                        String actualAmountPrice = flightCellTypeText.replace(Labels.CURRENT_USER_CURRENCY_TYPE+Labels.ONE_CHARACTER_SPACE, "").trim();
//                        Logger.logComment("Final Fare cost of booking flight in footer view is :- "+actualAmountPrice);
//                        return actualAmountPrice;
//                    }else{
//                        Logger.logError("Booking flight cost is not displayed in the current active screen");
//                    }
//                }
            }else
            {
                Logger.logStep(cellIndex+" time finding the booking flight cost");
            }
        }
        if (flightCellTypeText==null){
            Logger.logError("Booking flight cost is not displayed in the current active screen");
        }
        return flightCellTypeText;
    }


}
