package com.automation.rehlat.pages.flightsSearchResults;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightsSearchResultsIos extends FlightsSearchResultsBase {

    public static final String XPATH_OF_FIRST_FLIGHT_CELL = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]";
    public static final String XPATH_OF_FLIGHT_SEARCH_RESULTS_CELL_WITHOUT_INDEX = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[";
//    public static final String XPATH_OF_BOOKING_COST_IN_FIRST_CELL_WITHOUT_SIMILAR_OPTIONS_IN_SEARCH_RESULTS = "//XCUIElementTypeApplication[@name=\\\"Rehlat\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[3]";
//    public static final String XPATH_OF_BOOKING_COST_IN_FIRST_CELL_WITH_SIMILAR_OPTIONS_IN_SEARCH_RESULTS = "//XCUIElementTypeApplication[@name=\\\"Rehlat\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[4]";
    public static final String PRICE_LABLE = "Price";



    /**
     * Check flights search results screen is displayed or not
     */
    @Override
    public void checkFlightsSearchResultsScreenIsDisplayed() {
        Logger.logAction("Checking the flights search results screen is displayed or not");
        try {
            waitTillFlightsSearchResultsScreenIsDisplayed();
            if (isElementEnabledByName(PRICE_LABLE) && isElementDisplayedByName(SRP_ONE_WAY_VIEW))
            {
                TRIP_TYPE = SRP_ONE_WAY_VIEW;
                Logger.logStep(" SRP One Way Flights search results screen is displayed");
            } else if (isElementEnabledByName(PRICE_LABLE) && isElementDisplayedByName(SRP_TWO_WAY_VIEW)){
                TRIP_TYPE = SRP_TWO_WAY_VIEW;
                Logger.logStep("SRP Two Way Flights search results screen is displayed");
            }
            else {
                Logger.logError("Flights search screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to check the current active screen name");
        }
    }


    /**
     * Wait till the flights search results screen is displayed
     * @return
     */
    public static void waitTillFlightsSearchResultsScreenIsDisplayed() {
        Logger.logAction("Waiting till the active screen is loaded");
        try{
            Thread.sleep(4000); // This code has to be replaced with the below logic

            // Below logic needs to update and make it enable after verifying with stable build
//            if (!isElementDisplayedByXPath(XPATH_OF_FIRST_FLIGHT_CELL)){
//                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_OF_FIRST_FLIGHT_CELL)));
//            }
            // Logic ends here

            Logger.logStep("Active screen is loaded and moving to check the screen name");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the visibility of an element");
        }
    }

    /**
     * Tap on a cell in the flights search results screen
     */
    @Override
    public void tapOnACellInFlightSearchResults(String flightSearchResultCellNumber) {
        Logger.logAction("Tapping on "+ flightSearchResultCellNumber + " cell in the flights search results screen");
        String xPathOfBookingFlightCellType = XPATH_OF_FLIGHT_SEARCH_RESULTS_CELL_WITHOUT_INDEX+ flightSearchResultCellNumber + "]";
        try{
            if (isElementDisplayedByXPath(xPathOfBookingFlightCellType)){
                getTheBookingCostOfSelectingFlightInSearchResults(flightSearchResultCellNumber);
                Logger.logComment(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
                driver.findElementByXPath(xPathOfBookingFlightCellType).click();
                Logger.logStep("Tapped on "+flightSearchResultCellNumber+" flight cell");
            }else{
                scrollToAnElementByXPath(xPathOfBookingFlightCellType,true);
                if (isElementDisplayedByXPath(xPathOfBookingFlightCellType)){
                    getTheBookingCostOfSelectingFlightInSearchResults(flightSearchResultCellNumber);
                    Logger.logComment(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
                    driver.findElementByXPath(xPathOfBookingFlightCellType).click();
                    Logger.logStep("Tapped on "+flightSearchResultCellNumber+" flight cell");
                }else {
                    Logger.logError(flightSearchResultCellNumber+" - cell number is not displayed in the search results screen");
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the "+ flightSearchResultCellNumber + "cell in Flights search results");

        }
    }

    /**
     * Get the booking cost of selecting flight in search results screen
     * @param selectedFlightCellTypeNumber
     * @return
     */
    public static String getTheBookingCostOfSelectingFlightInSearchResults(String selectedFlightCellTypeNumber) {
        Logger.logAction("Getting the booking cost of "+selectedFlightCellTypeNumber+" flight in search results");
        String xPathOfBookingFlightCellType = XPATH_OF_FLIGHT_SEARCH_RESULTS_CELL_WITHOUT_INDEX+ selectedFlightCellTypeNumber + "]";
        try{
//            if (isElementDisplayedByXPath(xPathOfBookingFlightCellType)){ // Enable this line of code when the below commented logic is enabled or re implemented
                Logger.logComment("Selecting flights cell is displayed in the current search results and moving forward to get the booking seat cost of selected flight");
                WebElement bookingFlightCell = driver.findElementByXPath(xPathOfBookingFlightCellType);
                List<WebElement> flightCellDetails = bookingFlightCell.findElements(By.className("XCUIElementTypeStaticText"));
                // This condition is to get the flight cost when the price value is double
                for (int cellIndex=0;cellIndex<flightCellDetails.size();cellIndex++){
                    WebElement flightCellType = flightCellDetails.get(cellIndex);
                    String flightCellTypeText = flightCellType.getAttribute(Labels.VALUE_ATTRIBUTE);
                    if (flightCellTypeText.contains(".")){
                        String bookingCostExcludingCurrencyName = flightCellTypeText.replace("KWD ", "");
                        Labels.SELECTED_SEAT_BOOKING_COST = bookingCostExcludingCurrencyName;
                        Logger.logComment("Booking cost of the flight cell number - " +selectedFlightCellTypeNumber + " is :- " + Labels.SELECTED_SEAT_BOOKING_COST);
                        return  Labels.SELECTED_SEAT_BOOKING_COST;
                    }else{
                        Logger.logComment("Flight cell number - "+selectedFlightCellTypeNumber+" and with index : " + cellIndex + " is not having any booking flight cost");
                    }
                }
                // This condition is to get the flight cost when the price value is integer
                if (Labels.SELECTED_SEAT_BOOKING_COST == null) {
                    Logger.logAction("Checking the flight cost is an integer or not? ");
                    for (int cellIndex = 0; cellIndex < flightCellDetails.size(); cellIndex++) {
                        WebElement flightCellType = flightCellDetails.get(cellIndex);
                        String flightCellTypeText = flightCellType.getAttribute(Labels.VALUE_ATTRIBUTE);
                        if (flightCellTypeText.contains(Labels.CURRENT_USER_CURRENCY_TYPE)) {
                            cellIndex = cellIndex + 1;
                            WebElement newFlightCellType = flightCellDetails.get(cellIndex);
                            String newFlightCellTypeText = newFlightCellType.getAttribute(Labels.VALUE_ATTRIBUTE);
                            String bookingCostExcludingCurrencyName = newFlightCellTypeText.replace("KWD ", "");
                            Labels.SELECTED_SEAT_BOOKING_COST = bookingCostExcludingCurrencyName;
                            Logger.logComment("Booking cost of the flight cell type number - " + selectedFlightCellTypeNumber + " is :- " + Labels.SELECTED_SEAT_BOOKING_COST);
                            return Labels.SELECTED_SEAT_BOOKING_COST;
                        } else {
                            Logger.logComment("Flight cell number - " + selectedFlightCellTypeNumber + " and with index : " + cellIndex + " is not having any booking flight cost");
                        }
                    }
                }
            // The below code that is moving to the parsing cell number is covered in the method "checkFlightsSearchResultsScreenIsDisplayed()".., When that logic didn't work this code has to be enabled till the logic ended line [Make sure you enabled the above if condition line of code in this method]

//            } else {
//                Logger.logComment("Selecting flights cell is not displayed in the current search results, so scrolling the results for to find the needed cell");
//                scrollToAnElementByXPath(xPathOfBookingFlightCellType,true);
//                // Implement if condition so that will check the status of the needed cell is displayed on the screen after scrolling the screen(scrolling is done in previous step)
//                WebElement bookingFlightCell = driver.findElementByXPath(xPathOfBookingFlightCellType);
//                List<WebElement> flightCellDetails = bookingFlightCell.findElements(By.className("XCUIElementTypeStaticText"));
//                // This condition is to get the flight cost when the price value is double
//                for (int cellIndex=0;cellIndex<flightCellDetails.size();cellIndex++){
//                    WebElement flightCellType = flightCellDetails.get(cellIndex);
//                    String flightCellTypeText = flightCellType.getAttribute(Labels.VALUE_ATTRIBUTE);
//                    if (flightCellTypeText.contains(".")){
//                        Labels.SELECTED_SEAT_BOOKING_COST = flightCellTypeText;
//                        Logger.logComment("Booking cost of the flight cell type number - " +selectedFlightCellTypeNumber + " is :- " + flightCellTypeText);
//                        return Labels.SELECTED_SEAT_BOOKING_COST;
//                    }
//                    else{
//                        Logger.logComment("Flight cell number - "+selectedFlightCellTypeNumber+" and with index : " + cellIndex + " is not having any booking flight cost");
//                    }
//                }
//                // This condition is to get the flight cost when the price value is integer
//                if (Labels.SELECTED_SEAT_BOOKING_COST == null){
//                    Logger.logAction("Checking the flight cost is an integer or not? ");
//                    for (int cellIndex=0;cellIndex<flightCellDetails.size();cellIndex++){
//                        WebElement flightCellType = flightCellDetails.get(cellIndex);
//                        String flightCellTypeText = flightCellType.getAttribute(Labels.VALUE_ATTRIBUTE);
//                        if(flightCellTypeText.contains(Labels.CURRENT_USER_CURRENCY_TYPE)){
//                            cellIndex = cellIndex+1;
//                            WebElement newFlightCellType = flightCellDetails.get(cellIndex);
//                            String newFlightCellTypeText = newFlightCellType.getAttribute(Labels.VALUE_ATTRIBUTE);
//                            Labels.SELECTED_SEAT_BOOKING_COST = newFlightCellTypeText;
//                            Logger.logComment("Booking cost of the flight cell type number - " +selectedFlightCellTypeNumber + " is :- " + Labels.SELECTED_SEAT_BOOKING_COST);
//                            return Labels.SELECTED_SEAT_BOOKING_COST;
//                        }
//                        else{
//                            Logger.logComment("Flight cell number - "+selectedFlightCellTypeNumber+" and with index : " + cellIndex + " is not having any booking flight cost");
//                        }
//                    }
//                }
//            }
            // This logic of code ends till here

// Alternate Method to get the flight booking cost

//            if (isElementDisplayedByXPath(XPATH_OF_BOOKING_COST_IN_FIRST_CELL_WITHOUT_SIMILAR_OPTIONS_IN_SEARCH_RESULTS)){
//                valueOfBookingSeatCostDisplayedInSearchResultsScreen = driver.findElementByXPath(XPATH_OF_BOOKING_COST_IN_FIRST_CELL_WITHOUT_SIMILAR_OPTIONS_IN_SEARCH_RESULTS).getAttribute(Labels.VALUE_ATTRIBUTE);
//                if (valueOfBookingSeatCostDisplayedInSearchResultsScreen.contains("similar option(s)")){
//                    valueOfBookingSeatCostDisplayedInSearchResultsScreen = driver.findElementByXPath(XPATH_OF_BOOKING_COST_IN_FIRST_CELL_WITH_SIMILAR_OPTIONS_IN_SEARCH_RESULTS).getAttribute(Labels.VALUE_ATTRIBUTE);
//                    valueOfBookingSeatCostDisplayedInSearchResultsScreen = Labels.SELECTED_SEAT_BOOKING_COST;
//                }else{
//                    valueOfBookingSeatCostDisplayedInSearchResultsScreen = Labels.SELECTED_SEAT_BOOKING_COST;
//                }
//            }
        }catch (Exception exception){
//            if (isElementDisplayedByXPath(XPATH_OF_BOOKING_COST_IN_FIRST_CELL_WITH_SIMILAR_OPTIONS_IN_SEARCH_RESULTS))
            Logger.logError("Encountered error: Unable to get the booking cost of first flight in search results");
        }
//        if (Labels.SELECTED_SEAT_BOOKING_COST.equals(null)){
//            Logger.logComment("Selecting the ");
//            String rechangedSelectingFlightCellTypeNumber = String.valueOf(Integer.valueOf(selectedFlightCellTypeNumber)-1);
//            getTheBookingCostOfSelectingFlightInSearchResults(rechangedSelectingFlightCellTypeNumber);
//        }
        return Labels.SELECTED_SEAT_BOOKING_COST;
    }

}
