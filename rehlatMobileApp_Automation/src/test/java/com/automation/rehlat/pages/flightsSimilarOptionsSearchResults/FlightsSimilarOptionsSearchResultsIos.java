package com.automation.rehlat.pages.flightsSimilarOptionsSearchResults;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;

import static com.automation.rehlat.pages.flightsSearchResults.FlightsSearchResultsIos.SRP_ONE_WAY_VIEW;

public class FlightsSimilarOptionsSearchResultsIos extends FlightsSimilarOptionsSearchResultsBase {

//    public static String TRIP_TYPE ;
    public static final String TOTAL_AIR_FARE = "Total Airfare";
    public static final String COMBINATIONS_AVAILABLE_AT_SAME_PRICE_LABEL_WITHOUT_SIMILAR_FLIGHTS_NUMBER  = "combinations available at same price";
    public static final String XPATH_OF_FIRST_SIMILAR_OPTION_CELL_ONE_WAY_TRIP = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[1]";
    public static final String XPATH_OF_FIRST_SIMILAR_OPTION_CELL_TWO_WAY_TRIP = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[1]";
    public static final String XPATH_OF_COMBINATIONS_AVAILABLE_AT_SAME_PRICE_LABEL= "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeStaticText";
    /**
     * Check flights similar screen is displayed
     */
    @Override
    public boolean checkFlightsSimilarOptionsSearchResultsScreenIsDisplayed() {
        Logger.logAction("Checking the flights similar option search results screen is displayed or not?");
        try {
            if (isElementDisplayedByName(TOTAL_AIR_FARE)){
                Logger.logStep("Flights similar search results screen is displayed");
                return true;
            }else if (isElementDisplayedByXPath(XPATH_OF_COMBINATIONS_AVAILABLE_AT_SAME_PRICE_LABEL)){
                String nameInTheXpath = driver.findElementByXPath(XPATH_OF_COMBINATIONS_AVAILABLE_AT_SAME_PRICE_LABEL).getAttribute(Labels.VALUE_ATTRIBUTE);
                if (nameInTheXpath.contains(COMBINATIONS_AVAILABLE_AT_SAME_PRICE_LABEL_WITHOUT_SIMILAR_FLIGHTS_NUMBER)){
                    Logger.logStep("Flights similar search results screen is displayed");
                    return true;
                }else {
                    Logger.logError("Flights screen is displayed but the combination available at same price label is changed..,!!!");
                }
            }else{
                Logger.logWarning("Flights similar search results screen is not displayed and moving forward");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the current active screen");
        }
        return false;
    }

    /**
     * Tap on first similar option cell
     */
    @Override
    public void tapOnFirstSimilarOptionCell() {
        Logger.logAction("Tapping on first similar Option cell");
        try{
            if (TRIP_TYPE.equalsIgnoreCase(SRP_ONE_WAY_VIEW)) {
                if (isElementDisplayedByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_ONE_WAY_TRIP)) {
                    Logger.logComment("First similar option cell is displayed and moving to tapping action on that element");
                    driver.findElementByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_ONE_WAY_TRIP).click();
                    Logger.logStep("Tapped on First similar cell");
                }else{
                    Logger.logError("Unable to tap on the first similar option cell");
                }
            } else if (TRIP_TYPE.equalsIgnoreCase(SRP_TWO_WAY_VIEW)){
                if (isElementDisplayedByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_TWO_WAY_TRIP)) {
                    Logger.logComment("First similar option cell is displayed and moving to tapping action on that element");
                    driver.findElementByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_TWO_WAY_TRIP).click();
                    Logger.logStep("Tapped on First similar cell");
                }else {
                    Logger.logError("Unable to tap on the first similar option cell");
                }
            } else {
                Logger.logError(TRIP_TYPE+" :- is not matching with one way or two way trips");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element status by using the XPath");
        }
    }
 }
