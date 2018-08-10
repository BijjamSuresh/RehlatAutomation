package com.automation.rehlat.pages.interfaces;

public interface FlightsSearchResults {

    /**
     * Check flights search results screen is displayed or not
     * @throws Exception
     */
    void checkFlightsSearchResultsScreenIsDisplayed() throws Exception;

    /**
     * Tap on first cell in the flights search results screen
     * @throws Exception
     */
     void tapOnACellInFlightSearchResults(String flightSearchResultCellNumber) throws Exception;
}
