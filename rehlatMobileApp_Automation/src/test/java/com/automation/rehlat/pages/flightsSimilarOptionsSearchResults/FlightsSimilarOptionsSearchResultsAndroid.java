package com.automation.rehlat.pages.flightsSimilarOptionsSearchResults;

import com.automation.rehlat.libCommon.Logger;

public class FlightsSimilarOptionsSearchResultsAndroid extends FlightsSimilarOptionsSearchResultsBase {
    public static final String SEARCH_RESULTS_DISPLAY = "com.app.rehlat:id/searchResultsDisplayLayout";
    public static final String FILTERS_BUTTON  = "com.app.rehlat:id/international_filterFabIcon";
    public static final String XPATH_OF_FIRST_SIMILAR_OPTION_CELL = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.FrameLayout[1]";

    /**
     * Check flights similar screen is displayed
     */
    @Override
    public boolean checkFlightsSimilarOptionsSearchResultsScreenIsDisplayed() {
        try {
            if ( isElementDisplayedById(SEARCH_RESULTS_DISPLAY) && ! isElementDisplayedById(FILTERS_BUTTON)){
                Logger.logComment("Flights similar search results screen is displayed");
                return true;
            }else{
                Logger.logWarning("Flights similar search results screen is not displayed");
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
