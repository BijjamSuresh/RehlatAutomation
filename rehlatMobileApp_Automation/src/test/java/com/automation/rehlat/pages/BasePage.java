package com.automation.rehlat.pages;

import com.automation.rehlat.Base;
import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.pages.bookingPage.BookingPageBase;
import com.automation.rehlat.pages.flights.FlightsBase;
import com.automation.rehlat.pages.flightsSearchResults.FlightsSearchResultsBase;
import com.automation.rehlat.pages.flightsSimilarOptionsSearchResults.FlightsSimilarOptionsSearchResultsBase;
import com.automation.rehlat.pages.menu.MenuBase;
import com.automation.rehlat.pages.paymentOptions.PaymentOptionsBase;
import com.automation.rehlat.pages.reviewBooking.ReviewBookingBase;
import com.automation.rehlat.pages.signIn.SignInBase;
import com.automation.rehlat.pages.signUp.SignUpBase;
import com.automation.rehlat.pages.travellerDetails.TravellerDetailsBase;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;

public class BasePage extends Base {

    ////////////////////////////// Initialising The Screen Names W.R.T. The Screen Base Names //////////////////////////////////////
    public static FlightsBase FlightsScreen;
    public static MenuBase MenuScreen;
    public static SignInBase SignInScreen;
    public static SignUpBase SignUpScreen;
    public static FlightsSearchResultsBase FlightsSearchResultsScreen;
    public static FlightsSimilarOptionsSearchResultsBase FlightsSimilarOptionsSearchResultsScreen;
    public static ReviewBookingBase ReviewBookingScreen;
    public static BookingPageBase BookingPageScreen;
    public static TravellerDetailsBase TravellerDetailsScreen;
    public static PaymentOptionsBase PaymentOptionsScreen;


    ////////////////////////////// Strings Related To The Methods In Base Page //////////////////////////////////////
    public static final String IOS_DONE_BUTTON = "Done";
    public static final String IOS_DATE_PICKER = "XCUIElementTypeDatePicker";
    public static final String TOGGLE_SWITCH = "XCUIElementTypeSwitch";
    public static final String MODAL_VIEW = "com.app.rehlat:id/networkErrormsgTextview";
    public static final String SYNC_PREVIOUS_MODAL_VIEW_DATA = "Do you want to sync previous travellers data to your account?";
    public static final String DONT_SYNC_PREVIOUS_TRAVELLERS_DATA = "com.app.rehlat:id/noBtn";


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                                                                                         //Android Methods //

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Scroll the calender page upwards //Below values are hardcoded values of calender view because of having not showing the full calender months names [Displays only two months names]
     */
    public static void scrollTheCalenderPageUpByAMonthGap() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(459, 658).moveTo(454, 620).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the calender page downwards //Below values are hardcoded values of calender view because of having not showing the full calender months names [Displays only two months names]
     */
    public static void scrollTheCalenderPageDownAMonthGap() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(459, 620).moveTo(454, 658).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the calender page upwards by days gap //Below values are hardcoded values of calender view because of having not showing the full calender months names [Displays only two months names]
     */
    public static void scrollTheCalenderPageUpByDaysGap() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(512, 967).moveTo(512, 932).release().perform();
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }
    /**
     * Scroll the calender page downwards by days gap //Below values are hardcoded values of calender view because of having not showing the full calender months names [Displays only two months names]
     */
    public static void scrollTheCalenderPageDownByDaysGap() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(459, 932).moveTo(454, 967).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the flights search results screen up by a card gap //Below values are hardcoded values of flight search results view because of having not showing the full flights search results names [Displays only three flight search cards at a time]
     */
    public static void scrollTheFlightSearchResultsScreenUpByACardGap() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(512, 967).moveTo(512, 932).release().perform();
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the flights search results screen down by a card gap //Below values are hardcoded values of flight search results view because of having not showing the full flights search results names [Displays only three flight search cards at a time]
     */
    public static void scrollTheFlightSearchResultsScreenDownByACardGap() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(459, 932).moveTo(454, 967).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the flights search results screen down by three cards gap //Below values are hardcoded values of flight search results view because of having not showing the full flights search results names [Displays only three flight search cards at a time]
     */
    public static void scrollTheFlightSearchResultsScreenDownByThreeCardsGap() {
        try {
            TouchAction action = new TouchAction(driver);
            action.press(507, 663).moveTo(507, 709).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the flights search results screen up by three cards gap //Below values are hardcoded values of flight search results view because of having not showing the full flights search results names [Displays only three flight search cards at a time]
     */
    public static void scrollTheFlightSearchResultsScreenUpByThreeCardsGap() {
        try {
            TouchAction action = new TouchAction(driver);
            Thread.sleep(Labels.WAIT_TIME_MIN);
            action.press(507, 709).moveTo(507, 663).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Scroll the screen upwards
     */
    public static void scrollTheScreenUpwards() {
        try {
            TouchAction action = new TouchAction(driver);
            Thread.sleep(Labels.WAIT_TIME_MIN);
            action.press(459, 658).moveTo(454, 600).release().perform();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
    }

    /**
     * Decline the sync previous travellers data modal view
     * @throws Exception
     */
    public static void declineTheSyncPreviousTravellersDataModalView() throws Exception{
        Logger.logAction("Declining the sync previous travellers data modal view ");
        try{
            if (isElementDisplayedById(MODAL_VIEW)){
                String modalViewName = driver.findElementById(MODAL_VIEW).getText();
                if (modalViewName.equals(SYNC_PREVIOUS_MODAL_VIEW_DATA)){
                    if (isElementDisplayedById(DONT_SYNC_PREVIOUS_TRAVELLERS_DATA)){
                        driver.findElementById(DONT_SYNC_PREVIOUS_TRAVELLERS_DATA).click();
                    }else {
                        Logger.logError(" - element id is not displayed in the current active screen");
                    }
                }
                Logger.logError("Sync previous travellers data modal view is not displayed but another modal view is displayed");
            }else {
                Logger.logComment("No modal view is displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to decline the sync travellers data modal view");
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                                                                            //iOS Methods //

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Disable toggle switch in iOS platform
     */
    public void disableToggleSwitch() {
        Logger.logAction("Disabling the toggle button");
        try {
            if (isElementEnabledByClassName(TOGGLE_SWITCH)){
                WebElement toggleSwitch = driver.findElementByClassName(TOGGLE_SWITCH);
                String toggleSwitchValue = toggleSwitch.getAttribute(Labels.VALUE_ATTRIBUTE);
                if (toggleSwitchValue.equals(Labels.VALUE_ONE)){
                    Logger.logStep("Toggle switch is enabled and making it to disable by tapping on it");
                    driver.findElementByClassName(TOGGLE_SWITCH).click();
                }else if (toggleSwitchValue.equals(Labels.VALUE_ZERO)){
                    Logger.logStep("Toggle switch is already disabled");
                }
            }else {
                Logger.logError("Toggle switch is not displayed in the current active screen");
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element name - " + TOGGLE_SWITCH);
        }
    }

    /**
     * Enable the toggle switch in iOS platform
     */
    public void enableToggleSwitch() {
        Logger.logAction("Enabling the toggle button");
        try {
            if (isElementEnabledByClassName(TOGGLE_SWITCH)){
                WebElement toggleSwitch = driver.findElementByClassName(TOGGLE_SWITCH);
                String toggleSwitchValue = toggleSwitch.getAttribute(Labels.VALUE_ATTRIBUTE);
                if (toggleSwitchValue.equals(Labels.VALUE_ZERO)){
                    Logger.logStep("Toggle switch is disabled and making it to enable by tapping on it");
                    driver.findElementByClassName(TOGGLE_SWITCH).click();
                }else if (toggleSwitchValue.equals(Labels.VALUE_ONE)){
                    Logger.logStep("Toggle switch is already enabled");
                }
            }else {
                Logger.logError("Toggle switch is not displayed in the current active screen");
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element name - " +TOGGLE_SWITCH);
        }
    }

    /**
     * Close the keyboard for iOS Platform
     */
    public static void closeTheKeyboard() {
        try{
            if (isElementDisplayedByName(IOS_DONE_BUTTON)){
                driver.findElementByName(IOS_DONE_BUTTON).click();
            }else{
                Logger.logStep("Keyboard is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to close the keyboard");
        }
    }

    /**
     * Close the date picker for iOS Platform
     */
    public static void closeTheDatePicker() {
        try{
            if (isElementDisplayedByClassName(IOS_DATE_PICKER)){
                driver.findElementByName(IOS_DONE_BUTTON).click();
            }else{
                Logger.logStep("Date picker is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to close the keyboard");
        }
    }


}