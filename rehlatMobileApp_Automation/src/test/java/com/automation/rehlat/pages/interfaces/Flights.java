package com.automation.rehlat.pages.interfaces;

public interface Flights {
    /**
     * Check select language modal is displayed
     */
    void checkSelectLanguageModalIsDisplayed() throws Exception;

    /**
     * Check the flights tab is displayed
     * @throws Exception
     */
    void checkFlightsTabIsDisplayed() throws Exception;

    /**
     * Tapping on menu button
     */
    void tapOnMenuButton() throws Exception;
    /**
     * Selects the country name of the user
     * @param userCountryName
     * @throws Exception
     */
    void selectCountryOfUser(String userCountryName) throws Exception;

    /**
     * Tap on Continue button
     * @throws Exception
     */
     void tapOnContinueButton() throws Exception;

    /**
     * Select the country name and move to flights tab
     * @throws Exception
     */
     void selectCountryNameAndMoveToFlightsTab(String countryName) throws Exception;

    /**
     * Tap on From text field in flights tab
     * @throws Exception
     */
     void tapOnFromTextField() throws Exception;

    /**
     * Tap on TO text field in flights tab
     * @throws Exception
     */
     void tapOnToTextField() throws Exception;

    /**
     * Check keyboard is triggered or not
     * @throws Exception
     */
     void checkKeyboardIsDisplayed() throws Exception;

    /**
     * Check the search view screen is displayed or not
     * @throws Exception
     */
    void checkSearchViewScreenIsDisplayed() throws Exception;

    /**
     * Enter From place in search view
     * @throws Exception
     */
     void enterAirportName(String fromPlace) throws Exception;

    /**
     * Select the place name from search results of search view
     * @param placeName
     * @throws Exception
     */
     void selectAirportCodeFromSearchResults(String placeName) throws Exception;

    /**
     * Tap on Departure button in flights tab
     * @throws Exception
     */
     void tapOnDepartureButton() throws Exception;

     /**
     * Tap on return booking button in flights tab
     */
    void tapOnReturnDateBookingButton() throws Exception;

    /**
     * selectDeparture date
     * @throws Exception
     */
     void selectDepartureDate(String departureMonthAndYear, String departureDay) throws Exception;

    /**
     * Select Return date
     */
    void selectReturnDate(String departureMonthAndYear, String departureDay);

    /**
     * Tap on Done button in calendar view
     * @throws Exception
     */
     void tapOnDoneButton() throws Exception;

    /**
     * Tap on search button in flights tab
     * @throws Exception
     */
     void tapOnSearchButton() throws Exception;
    }
