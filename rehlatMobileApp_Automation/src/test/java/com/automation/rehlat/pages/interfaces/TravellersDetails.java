package com.automation.rehlat.pages.interfaces;

public interface TravellersDetails {

    /**
     * Check the travellers details screen is displayed
     * @throws Exception
     */
    void checkTravellersDetailsScreenIsDisplayed() throws Exception;

    /**
     * Decline the auto fill populate modal if displayed
     * @throws Exception
     */
    void declineAutoFillPopulateModalIfDisplayed() throws Exception;

    /**
     * Enter adult travellers details
     * @throws Exception
     */
    void enterAdultTravellersDetails(String travellersCountryName) throws Exception;

    /**
     * Tap on save button
     * @throws Exception
     */
    void tapOnSaveButton() throws Exception;
}
