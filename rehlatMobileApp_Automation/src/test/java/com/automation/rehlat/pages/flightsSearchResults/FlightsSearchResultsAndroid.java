package com.automation.rehlat.pages.flightsSearchResults;


import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.automation.rehlat.Labels.WAIT_TIME_MIN;

public class FlightsSearchResultsAndroid extends FlightsSearchResultsBase {
    public static final String XPATH_OF_ALL_AIRLINES_TAB_BAR = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView";
    public static final String XPATH_OF_CARD_VIEW_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.FrameLayout[";
    public static final String XPATH_OF_ONLY_DEPARTURE_CARD_PRICE_VIEW_WITHOUT_CARD_VIEW_XPATH = "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]";
    public static final String XPATH_OF_DEPARTURE_AND_RETURN_CARD_PRICE_VIEW_WITHOUT_CARD_VIEW_XPATH = "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView[2]";
    public static final String TWO_WAY_LIST_VIEW = "com.app.rehlat:id/internationalTwoWayListView";
    public static final String DOMESTIC_ONE_WAY_RECYCLER_VIEW = "com.app.rehlat:id/domesticOneWayRecyclerView";
    //    public WebElement EXPANDABLELIST;
    /**
     * Check flights search results screen is displayed or not
     */
    @Override
    public void checkFlightsSearchResultsScreenIsDisplayed() {
        Logger.logAction("Checking the flights search results screen is displayed or not");
        try {
            if (waitTillFlightsSearchResultsScreenIsDisplayed())
            {
                Logger.logComment("Flights search results screen is displayed");
            }else {
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
    public static boolean waitTillFlightsSearchResultsScreenIsDisplayed() {
        Logger.logAction("Waiting till the active screen is loaded");
        try{
            if (isElementDisplayedById(DOMESTIC_ONE_WAY_RECYCLER_VIEW)){
                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(DOMESTIC_ONE_WAY_RECYCLER_VIEW)));
                Logger.logStep("Active screen is loaded and moving to check the screen name");
                return true;
            }else {
                Logger.logStep("Active screen is loaded and moving to check the screen name");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the visibility of an element");
        }
        return false;
    }

    /**
     * Check the round trip details list view is displayed
     */
    public static boolean isRoundTripDetailsDisplayed() {
        Logger.logAction("Checking the round trip details is displayed");
        try {
            if (isElementDisplayedById(TWO_WAY_LIST_VIEW)){
                Logger.logComment("Two ways list view filters are displayed");
                return true;
            }else {
                Logger.logComment("One way list view filters are displayed");
                return false;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the type of flight search results");
        }
        return false;
    }

    /**
     * Tap on first cell in the flights search results screen
     */
    @Override
    public void tapOnACellInFlightSearchResults(String flightSearchResultCellNumber) {
        Logger.logAction("Tapping on "+ flightSearchResultCellNumber + " cell in the flights search results screen");
        try{
            if (isRoundTripDetailsDisplayed()){
                if (isElementDisplayedByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]")){
                    Logger.logStep(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
                    getTheBookingCostOfSelectingDepartureAndReturnFlightInSearchResults(flightSearchResultCellNumber);
                    driver.findElementByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]").click();
                }else{
                    scrollToTheParsingFlightBookingCard(flightSearchResultCellNumber,true);
                    if (isElementDisplayedByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]")){
                        Logger.logStep(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
                        getTheBookingCostOfSelectingDepartureAndReturnFlightInSearchResults(flightSearchResultCellNumber);
                        driver.findElementByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]").click();
                    }else {
                        Logger.logError(flightSearchResultCellNumber+" - cell number is not displayed in the search results screen");
                    }
                }
            }else {
                Logger.logComment("One way trip details are displayed "); // This logger needs to be an error but to make the flow continue making this logger as comment
                if (isElementDisplayedByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]")){
                    Logger.logStep(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
                    getTheBookingCostOfSelectingOnlyDepartureFlightInSearchResults(flightSearchResultCellNumber);
                    driver.findElementByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]").click();
                }else{
                    scrollToTheParsingFlightBookingCard(flightSearchResultCellNumber,true);
                    if (isElementDisplayedByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]")){
                        Logger.logStep(flightSearchResultCellNumber+" - cell number is displayed and tapping on it");
                        getTheBookingCostOfSelectingOnlyDepartureFlightInSearchResults(flightSearchResultCellNumber);
                        driver.findElementByXPath(XPATH_OF_CARD_VIEW_WITHOUT_INDEX+flightSearchResultCellNumber+"]").click();
                    }else {
                        Logger.logError(flightSearchResultCellNumber+" - cell number is not displayed in the search results screen");
                    }
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the "+ flightSearchResultCellNumber + "cell in Flights search results");
        }
    }

    /**
     * Get the booking cost of selecting flight in search results screen
     * @param parsingFlightCellTypeNumber
     * @return
     */
    public static String getTheBookingCostOfSelectingOnlyDepartureFlightInSearchResults(String parsingFlightCellTypeNumber) {
        Logger.logAction("Getting the booking cost of first flight in search results");
        String xPathOfBookingFlightCellType = XPATH_OF_CARD_VIEW_WITHOUT_INDEX+ parsingFlightCellTypeNumber + "]";
        String xPathOfBookingFlightPrice = xPathOfBookingFlightCellType+ XPATH_OF_ONLY_DEPARTURE_CARD_PRICE_VIEW_WITHOUT_CARD_VIEW_XPATH;
        try{
            scrollToTheParsingFlightBookingCard(parsingFlightCellTypeNumber,true);
            try{
                if (isElementDisplayedByXPath(xPathOfBookingFlightCellType)){
                    Logger.logStep("Selecting flights cell is displayed in the current search results and moving forward to get the booking seat cost of selected flight");
                    if (isElementDisplayedByXPath(xPathOfBookingFlightPrice)){
                        WebElement bookingFlightPriceXpath = driver.findElementByXPath(xPathOfBookingFlightPrice);
                        String bookingFlightPrice = bookingFlightPriceXpath.getText();
                        Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightPrice);
                        Labels.SELECTED_SEAT_BOOKING_COST = bookingFlightPrice;
                        return  Labels.SELECTED_SEAT_BOOKING_COST ;
                    }else {
                        scrollTheFlightSearchResultsScreenDownByACardGap_Android();
                        if (isElementDisplayedByXPath(xPathOfBookingFlightPrice)){
                            WebElement bookingFlightPriceXpath = driver.findElementByXPath(xPathOfBookingFlightPrice);
                            String bookingFlightPrice = bookingFlightPriceXpath.getText();
                            Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightPrice);
                            Labels.SELECTED_SEAT_BOOKING_COST = bookingFlightPrice;
                            return  Labels.SELECTED_SEAT_BOOKING_COST ;
                        }else {
                            Logger.logError("Tried two times but unable to get the flight cost of flight cell number:- " +parsingFlightCellTypeNumber);
                        }
                    }
                } else {
                    Logger.logComment("Selecting flights cell is not displayed in the current search results, so scrolling the search results screen for to find the needed flight cell");
                    scrollToTheParsingFlightBookingCard(parsingFlightCellTypeNumber,true);
                    if (isElementDisplayedByXPath(xPathOfBookingFlightCellType)){
                        Logger.logComment("Selecting flights cell is displayed in the current search results and moving forward to get the booking seat cost of selected flight");
                        if (isElementDisplayedByXPath(xPathOfBookingFlightPrice)){
                            WebElement bookingFlightPriceXpath = driver.findElementByXPath(xPathOfBookingFlightPrice);
                            String bookingFlightPrice = bookingFlightPriceXpath.getText();
                            Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightPrice);
                            Labels.SELECTED_SEAT_BOOKING_COST = bookingFlightPrice;
                            return  Labels.SELECTED_SEAT_BOOKING_COST ;
                        }else {
                            scrollTheFlightSearchResultsScreenDownByACardGap_Android();
                            if (isElementDisplayedByXPath(xPathOfBookingFlightPrice)){
                                WebElement bookingFlightPriceXpath = driver.findElementByXPath(xPathOfBookingFlightPrice);
                                String bookingFlightPrice = bookingFlightPriceXpath.getText();
                                Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightPrice);
                                Labels.SELECTED_SEAT_BOOKING_COST = bookingFlightPrice;
                                return  Labels.SELECTED_SEAT_BOOKING_COST ;
                            }else {
                                Logger.logError("Tried two times but unable to get the flight cost of flight cell number:- " +parsingFlightCellTypeNumber);
                            }
                        }
                    }else {
                        Logger.logError("Tried two times but unable to scroll to the flight cell number :- "+parsingFlightCellTypeNumber);
                    }
                }
            }catch (Exception exception){
                scrollTheFlightSearchResultsScreenDownByACardGap_Android();
                getTheBookingCostOfSelectingOnlyDepartureFlightInSearchResults(parsingFlightCellTypeNumber);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the booking cost of first flight in search results");
        }
        return Labels.SELECTED_SEAT_BOOKING_COST;
    }

    /**
     * Get the booking cost of selecting flight in search results screen
     * @param parsingFlightCellTypeNumber
     * @return
     */
    public static String getTheBookingCostOfSelectingDepartureAndReturnFlightInSearchResults(String parsingFlightCellTypeNumber) {
        Logger.logAction("Getting the booking cost of first flight in search results");
        String xPathOfBookingFlightCellType = XPATH_OF_CARD_VIEW_WITHOUT_INDEX+ parsingFlightCellTypeNumber + "]";
        String xPathOfBookingFlightPrice = xPathOfBookingFlightCellType+ XPATH_OF_DEPARTURE_AND_RETURN_CARD_PRICE_VIEW_WITHOUT_CARD_VIEW_XPATH;
        try{
            scrollToTheParsingFlightBookingCard(parsingFlightCellTypeNumber,true);
            try{
                if (isElementDisplayedByXPath(xPathOfBookingFlightCellType)){
                    Logger.logStep("Selecting flights cell is displayed in the current search results and moving forward to get the booking seat cost of selected flight");
                    if (isElementDisplayedByXPath(xPathOfBookingFlightPrice)){
                        WebElement bookingFlightPriceXpath = driver.findElementByXPath(xPathOfBookingFlightPrice);
                        String bookingFlightPrice = bookingFlightPriceXpath.getText();
                        Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightPrice);
                        Labels.SELECTED_SEAT_BOOKING_COST = bookingFlightPrice;
                        return  Labels.SELECTED_SEAT_BOOKING_COST ;
                    }else {
                        scrollTheFlightSearchResultsScreenDownByACardGap_Android();
                        if (isElementDisplayedByXPath(xPathOfBookingFlightPrice)){
                            WebElement bookingFlightPriceXpath = driver.findElementByXPath(xPathOfBookingFlightPrice);
                            String bookingFlightPrice = bookingFlightPriceXpath.getText();
                            Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightPrice);
                            Labels.SELECTED_SEAT_BOOKING_COST = bookingFlightPrice;
                            return  Labels.SELECTED_SEAT_BOOKING_COST ;
                        }else {
                            Logger.logError("Tried two times but unable to get the flight cost of flight cell number:- " +parsingFlightCellTypeNumber);
                        }
                    }
                } else {
                    Logger.logComment("Selecting flights cell is not displayed in the current search results, so scrolling the search results screen for to find the needed flight cell");
                    scrollToTheParsingFlightBookingCard(parsingFlightCellTypeNumber,true);
                    if (isElementDisplayedByXPath(xPathOfBookingFlightCellType)){
                        Logger.logComment("Selecting flights cell is displayed in the current search results and moving forward to get the booking seat cost of selected flight");
                        if (isElementDisplayedByXPath(xPathOfBookingFlightPrice)){
                            WebElement bookingFlightPriceXpath = driver.findElementByXPath(xPathOfBookingFlightPrice);
                            String bookingFlightPrice = bookingFlightPriceXpath.getText();
                            Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightPrice);
                            Labels.SELECTED_SEAT_BOOKING_COST = bookingFlightPrice;
                            return  Labels.SELECTED_SEAT_BOOKING_COST ;
                        }else {
                            scrollTheFlightSearchResultsScreenDownByACardGap_Android();
                            if (isElementDisplayedByXPath(xPathOfBookingFlightPrice)){
                                WebElement bookingFlightPriceXpath = driver.findElementByXPath(xPathOfBookingFlightPrice);
                                String bookingFlightPrice = bookingFlightPriceXpath.getText();
                                Logger.logComment("Booking seat cost of flight cell number "+parsingFlightCellTypeNumber+" :- " +bookingFlightPrice);
                                Labels.SELECTED_SEAT_BOOKING_COST = bookingFlightPrice;
                                return  Labels.SELECTED_SEAT_BOOKING_COST ;
                            }else {
                                Logger.logError("Tried two times but unable to get the flight cost of flight cell number:- " +parsingFlightCellTypeNumber);
                            }
                        }
                    }else {
                        Logger.logError("Tried two times but unable to scroll to the flight cell number :- "+parsingFlightCellTypeNumber);
                    }
                }
            }catch (Exception exception){
                scrollTheFlightSearchResultsScreenDownByACardGap_Android();
                getTheBookingCostOfSelectingDepartureAndReturnFlightInSearchResults(parsingFlightCellTypeNumber);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the booking cost of first flight in search results");
        }
        return Labels.SELECTED_SEAT_BOOKING_COST;
    }

    /**
     * Checking the parsing flight booking card is displayed
     * @param selectedFlightCellTypeNumber
     * @return
     */
    public static boolean isParsingFlightBookingCardIsDisplayed(String selectedFlightCellTypeNumber) {
        Logger.logAction("Checking the parsing calender month "+selectedFlightCellTypeNumber+" is displayed or not ?");
        String xPathOfBookingFlightCellType = XPATH_OF_CARD_VIEW_WITHOUT_INDEX+ selectedFlightCellTypeNumber + "]";
        try {
            Thread.sleep(WAIT_TIME_MIN);
            try{
                if(isElementDisplayedByXPath(xPathOfBookingFlightCellType)){
                    Logger.logComment(selectedFlightCellTypeNumber+" - Flight booking card is displayed");
                    return true;
                }else {
                    Logger.logComment(selectedFlightCellTypeNumber+" - Flight booking card not displayed in the current active screen");
                }
            }catch (Exception exception){
                scrollTheFlightSearchResultsScreenUpByACardGap_Android();
                isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll to the month :- " +selectedFlightCellTypeNumber);
        }
        return false;
    }

    /**
     * Scrolling to the parsing flight booking card
     * @param selectedFlightCellTypeNumber
     * @param down
     */
    public static void scrollToTheParsingFlightBookingCard(String selectedFlightCellTypeNumber, boolean down ) {
        Logger.logAction("Scrolling the flight search results view to the parsing flight booking card number :- " +selectedFlightCellTypeNumber);
        try {
            if(!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                int counter = 0;
                if (down) {
                    while (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                        Logger.logComment(counter + "  time trying to find the parsing flight booking card number :- " + selectedFlightCellTypeNumber +" - by scrolling up ");
                        scrollTheFlightSearchResultsScreenUpByThreeCardsGap_Android();
                        counter++;
                        if (counter > 6) {
                            break;
                        }
                    }
                    if (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                        while (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                            Logger.logComment(counter + "  time trying to find the parsing flight booking card number :- " + selectedFlightCellTypeNumber +" - by scrolling down ");
                            scrollTheFlightSearchResultsScreenDownByThreeCardsGap_Android();
                            counter++;
                            if (counter > 12) {
                                break;
                            }
                        }
                    }
                } else {
                    while (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                        Logger.logComment(counter + "  time trying to find the parsing flight booking card number :- " + selectedFlightCellTypeNumber +" - by scrolling down ");
                        scrollTheFlightSearchResultsScreenDownByThreeCardsGap_Android();
                        counter++;
                        if (counter > 6) {
                            break;
                        }
                    }
                    if (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                        Logger.logComment(counter + "  time trying to find the parsing flight booking card number :- " + selectedFlightCellTypeNumber +" - by scrolling up ");
                        while (!isParsingFlightBookingCardIsDisplayed(selectedFlightCellTypeNumber)) {
                            scrollTheFlightSearchResultsScreenUpByThreeCardsGap_Android();
                            counter++;
                            if (counter > 12) {
                                break;
                            }
                        }
                    }
                }
            }else {
                Logger.logComment("Parsing flight booking card number - "+selectedFlightCellTypeNumber+ " - is already displayed in the current calender view");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll to the parsing flight booking card number :- " +selectedFlightCellTypeNumber);
        }
    }

}
