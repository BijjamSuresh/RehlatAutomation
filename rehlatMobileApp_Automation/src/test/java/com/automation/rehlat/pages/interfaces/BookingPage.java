package com.automation.rehlat.pages.interfaces;

public interface BookingPage {

    /**
     * Check booking page screen is displayed
     * @throws Exception
     */
    void checkBookingPageScreenIsDisplayed() throws Exception;

    /**
     * Enter user booking information
     * @throws Exception
     */
    void enterUserBookingInfo() throws Exception;

    /**
     * Tap on continue button
     * @throws Exception
     */
    void tapOnContinueButton()throws Exception;

    /**
     * Tap on add travellers details button
     * @throws Exception
     */
    void tapOnAdultAddTravellersDetailsButton()throws Exception;


    /**
     * Tap on sign in for faster bookings button
     * @throws Exception
     */
    void tapOnSignInForFasterBookingsButton() throws Exception;

    /**
     * Check booking page screen is displayed
     * @throws Exception
     */
    boolean isUserIsSignedIn() throws Exception;

    /**
     * Check the final fare calculations are correct
     * @throws Exception
     */
    void checkFinalFareCalculationIsCorrect() throws Exception;

    /**
     * Apply coupon code
     * @throws Exception
     */
    void applyTheCouponCode() throws Exception;

    /**
     * Enter the text in phone number text field
     */
    void enterTextInPhoneNumberTextField();

    /**
     * Enter the text in email text field
     */
    void enterTextInEmailTextField();

}
