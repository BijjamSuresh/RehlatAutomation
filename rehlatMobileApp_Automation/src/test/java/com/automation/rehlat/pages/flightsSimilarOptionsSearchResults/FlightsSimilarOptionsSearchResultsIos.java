package com.automation.rehlat.pages.flightsSimilarOptionsSearchResults;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;

import static com.automation.rehlat.pages.flightsSearchResults.FlightsSearchResultsIos.SRP_ONE_WAY_VIEW;

public class FlightsSimilarOptionsSearchResultsIos extends FlightsSimilarOptionsSearchResultsBase {

//    public static String TRIP_TYPE ;
    public static final String TOTAL_AIR_FARE = "Total Price";
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
            Thread.sleep(Labels.WAIT_TIME_DEFAULT);
            if (isElementEnabledByName(TOTAL_AIR_FARE)){
                Logger.logStep("Flights similar search results screen is displayed");
                return true;
            }
            //Todo: Below logic is an alternate method to check the similar flight search results screen is displayed or not
//            else if (isElementDisplayedByXPath(XPATH_OF_COMBINATIONS_AVAILABLE_AT_SAME_PRICE_LABEL)){
//                String nameInTheXpath = driver.findElementByXPath(XPATH_OF_COMBINATIONS_AVAILABLE_AT_SAME_PRICE_LABEL).getAttribute(Labels.VALUE_ATTRIBUTE);
//                if (nameInTheXpath.contains(COMBINATIONS_AVAILABLE_AT_SAME_PRICE_LABEL_WITHOUT_SIMILAR_FLIGHTS_NUMBER)){
//                    Logger.logStep("Flights similar search results screen is displayed");
//                    return true;
//                }else {
//                    Logger.logError("Flights screen is displayed but the combination available at same price label is changed..,!!!");
//                }
//            }
            // Logic ends here
            else{
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
//                scrollToAnElementByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_ONE_WAY_TRIP,true); //This code is needed when the tapping similar search result is not in the visual screen list [When scrolling the need]
                findElementByXPathAndClick(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_ONE_WAY_TRIP);

//                Todo: - Below code is very important on tapping on the flight cell more than 2..,For to reduce the execution time implemented the above logic is implemented
//                 The below logic is find the parsing similar flight cell number is displayed and if displayed and then search for the element and tap on it else scroll to the element and then check the element is displayed and if displayed find the element and tap on it else throw error//                scrollToAnElementByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_ONE_WAY_TRIP,true); //This code is needed when the tapping similar search result is not in the visual screen list [When scrolling the need]
//                if (isElementDisplayedByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_ONE_WAY_TRIP)) {
//                    Logger.logComment("First similar option cell is displayed and moving to tapping action on that element");
//                    driver.findElementByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_ONE_WAY_TRIP).click();
//                    Logger.logStep("Tapped on First similar cell");
//                }else{
//                    Logger.logError("Unable to tap on the first similar option cell");
//                }
                // Logic ends here

            } else if (TRIP_TYPE.equalsIgnoreCase(SRP_TWO_WAY_VIEW)){

//                scrollToAnElementByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_ONE_WAY_TRIP,true); //This code is needed when the tapping similar search result is not in the visual screen list [When scrolling the need]
                findElementByXPathAndClick(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_TWO_WAY_TRIP);

//                Todo: - Below code is very important on tapping on the flight cell more than 2..,For to reduce the execution time implemented the above logic is implemented
//                 The below logic is find the parsing similar flight cell number is displayed and if displayed and then search for the element and tap on it else scroll to the element and then check the element is displayed and if displayed find the element and tap on it else throw error//                scrollToAnElementByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_ONE_WAY_TRIP,true); //This code is needed when the tapping similar search result is not in the visual screen list [When scrolling the need]
//                if (isElementDisplayedByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_TWO_WAY_TRIP)) {
//                    Logger.logComment("First similar option cell is displayed and moving to tapping action on that element");
//                    driver.findElementByXPath(XPATH_OF_FIRST_SIMILAR_OPTION_CELL_TWO_WAY_TRIP).click();
//                    Logger.logStep("Tapped on First similar cell");
//                }else {
//                    Logger.logError("Unable to tap on the first similar option cell");
//                }
                // Logic ends here
            } else {
                Logger.logError(TRIP_TYPE+" :- is not matching with one way or two way trips");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the element status by using the XPath");
        }
    }
 }
