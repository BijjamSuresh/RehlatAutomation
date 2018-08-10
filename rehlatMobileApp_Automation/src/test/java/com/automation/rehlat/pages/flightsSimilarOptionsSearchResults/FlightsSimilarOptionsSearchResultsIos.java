package com.automation.rehlat.pages.flightsSimilarOptionsSearchResults;

import com.automation.rehlat.libCommon.Logger;

public class FlightsSimilarOptionsSearchResultsIos extends FlightsSimilarOptionsSearchResultsBase {

    public static final String PASSENGER_ICON = "passenger";
    public static final String CHAIR_ICON = "chair";
    public static final String FILTERS_BUTTON  = "Filters";
    public static final String XPATH_OF_FIRST_SIMILAR_OPTION_CELL = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]";


    /**
     * Check flights similar screen is displayed
     */
    @Override
    public boolean checkFlightsSimilarOptionsSearchResultsScreenIsDisplayed() {
        Logger.logAction("Checking the flights similar option search results screen is displayed or not?");
        try {
            if ( isElementDisplayedByName(PASSENGER_ICON) && isElementDisplayedByName(CHAIR_ICON) && ! isElementDisplayedByName(FILTERS_BUTTON)){
                Logger.logComment("Flights similar search results screen is displayed");
                return true;
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
            if (isElementDisplayedByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL)){
                Logger.logStep("First similar option cell is displayed and moving to tapping action on that element");
                driver.findElementByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL).click();
            }else {
                Logger.logError("Unable to tap on the first similar option cell");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element status by using the following XPath: " + XPATH_OF_FIRST_SIMILAR_OPTION_CELL);
        }
    }
 }
