package com.automation.rehlat.pages.interfaces;

public interface ReviewBooking {
    /**
     * Check Review Booking screen is displayed or not
     * @throws Exception
     */
    void checkReviewBookingScreenIsDisplayed() throws Exception;

    /**
     * Tap on continue button
     * @throws Exception
     */
    void tapOnContinueButton() throws Exception;

    /**
     * Enable the security check in toggle button
     * @throws Exception
     */
    void enableSecurityCheckInToggle() throws Exception;

    /**
     * Disable the security check in toggle button
     * @throws Exception
     */
    void disableSecurityCheckInToggle() throws Exception;


    /**
     * Compare the selected booking seat cost in search results screen and displayed in review booking screen
     * @throws Exception
     */
    void compareTheSelectedBookingSeatCostInSearchResultsScreenDisplayedInReviewBookingScreen() throws Exception;

}
