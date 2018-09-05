package com.automation.rehlat.pages.interfaces;

public interface MyTrips {

    /**
     * Check my trips screen is displayed
     * @throws Exception
     */
    void checkMyTripsScreenIsDisplayed() throws Exception;

    /**
     * Tap on flights button
     */
    void tapOnFlightsButton();

    /**
     * Tap on upcoming button
     */
    void tapOnUpcomingButton();

    /**
     * Tap on completed button
     */
    void tapOnCompletedButton();

    /**
     * Check upcoming flights travel information is displayed
     */
    void checkUpcomingFlightsTravelInformationIsDisplayed();

    /**
     * Check completed flights travel information is displayed
     */
    void checkCompletedFlightsTravelInformationIsDisplayed();
}
