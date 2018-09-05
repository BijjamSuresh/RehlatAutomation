package com.automation.rehlat.pages.myTrips;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTripsAndroid extends MyTripsBase {

    public static final String MY_TRIPS_SCREEN_TITLE = "MY TRIPS";
    public static final String XPATH_OF_FLIGHTS_BUTTON = "(//XCUIElementTypeButton[@name=\"Button\"])[1]";
    public static final String XPATH_OF_HOTELS_BUTTON = "(//XCUIElementTypeButton[@name=\"Button\"])[2]";
    public static final String UPCOMING_BUTTON = "UPCOMING";
    public static final String COMPLETED_BUTTON = "COMPLETED";
    public static final String NO_DATA_FOUND_BUTTON = "NO DATA FOUND";
    public static final String MORE_BUTTON = "moreHorizontal";
    public static final String XPATH_OF_FLIGHTS_TRAVELLING_DETAILS_TABLE = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable";

    /**
     * Check my trips screen is displayed
     * @throws Exception
     */
    @Override
    public void checkMyTripsScreenIsDisplayed() throws Exception{
        Logger.logAction("Checking my profile screen is displayed or not ?");
        try{
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
            if (isElementDisplayedByName(MY_TRIPS_SCREEN_TITLE)){
                Logger.logStep("My Trips screen is displayed");
            }else {
                Logger.logError("My Trips screen is not displayed");
            }
        }catch (Exception Exception){
            Logger.logError("Encountered error: Unable to check the profile screen is displayed or not?");
        }
    }

    /**
     * Tap on flights button
     */
    @Override
    public void tapOnFlightsButton(){
        try{
            findElementByXPathAndClick(XPATH_OF_FLIGHTS_BUTTON);
            Logger.logStep("Tapped on flights button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the flights tab");
        }
    }

    /**
     * Tap on upcoming button
     */
    @Override
    public void tapOnUpcomingButton(){
        try{
            findElementByNameAndClick(UPCOMING_BUTTON);
            Logger.logStep("Tapped on upcoming button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the upcoming button");
        }
    }

    /**
     * Tap on completed button
     */
    @Override
    public void tapOnCompletedButton(){
        try{
            findElementByNameAndClick(COMPLETED_BUTTON);
            Logger.logStep("Tapped on completed button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the completed button");
        }
    }

    /**
     * Check upcoming flights travel information is displayed
     */
    @Override
    public void checkUpcomingFlightsTravelInformationIsDisplayed(){
        try {
            checkBookedFlightsInformationIsDisplayed("UpcomingFlightType");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the upcoming flights travel information is displayed");
        }
    }

    /**
     * Check completed flights travel information is displayed
     */
    @Override
    public void checkCompletedFlightsTravelInformationIsDisplayed(){
        try {
            checkBookedFlightsInformationIsDisplayed("CompletedFlightType");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the completed flights travel information is displayed");
        }
    }

    /**
     * Check the booked flights information is displayed or not ?
     */
    public static void checkBookedFlightsInformationIsDisplayed(String parsingFlightType){
        try {
            if (isElementDisplayedByXPath(XPATH_OF_FLIGHTS_TRAVELLING_DETAILS_TABLE)){
                WebElement xcuiElementTypeCell = driver.findElementByXPath(XPATH_OF_FLIGHTS_TRAVELLING_DETAILS_TABLE).findElement(By.className(Labels.IOS_XCUI_ELEMENT_TYPE_CELL));
                WebElement xcuiElementStaticText = xcuiElementTypeCell.findElement(By.className(Labels.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT));
                String elementNameInTheCell = xcuiElementStaticText.getAttribute(Labels.VALUE_ATTRIBUTE);
                if (elementNameInTheCell.equalsIgnoreCase(NO_DATA_FOUND_BUTTON)){
                    Logger.logComment(NO_DATA_FOUND_BUTTON+" :- element name is displayed.. So till now no flight bookings for "+parsingFlightType+" days");
                }else if (isElementDisplayedByName(MORE_BUTTON)){
                    Logger.logComment(MORE_BUTTON+" :- element name is displayed.. So flight bookings are displayed for "+parsingFlightType+" days");
                }else {
                    Logger.logError("No flight bookings nor suggestion message is displayed in "+parsingFlightType+" days");
                }
            }else {
                Logger.logError("Flights travelling details table is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the booked flights information");
        }
    }

}
