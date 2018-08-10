package com.automation.rehlat.pages.interfaces;

public interface PaymentOptions {

    /**
     * Check the payment options screen is displayed
     * @throws Exception
     */
    void checkPaymentOptionsScreenIsDisplayed() throws Exception;

    /**
     * Tap on KNET payment gateway
     * @throws Exception
     */
    void tapOnKnetPaymentGateWay() throws Exception;

    /**
     * Check KNET payment gateway screen is displayed
     * @throws Exception
     */
    void checkKnetPaymentOptionsScreenIsDisplayed() throws Exception;

    /**
     * Selecting bank name
     * @throws Exception
     */
    void selectingBankName(String bankName) throws Exception;

    /**
     * Enter the card number
     * @throws Exception
     */
    void enterCardNumber() throws Exception;

    /**
     * Enter the Pin number
     * @throws Exception
     */
    void enterPinNumber() throws Exception;

    /**
     * Check post transactions screen is displayed
     * @throws Exception
     */
    void checkPostTransactionScreenIsDisplayed() throws Exception;

    /**
     * Tap on Confirm button
     * @throws Exception
     */
    void tapOnConfirmButton() throws Exception;

    /**
     * Tap on Submit button
     * @throws Exception
     */
    void tapOnSubmitButton() throws Exception;

    /**
     * Check the booking is success
     * @throws Exception
     */
    void checkTheKnetBookingProcessIsSuccess() throws Exception;

    /**
     * Enter credit or debit card details
     * @throws Exception
     */
    void enterCreditOrDebitCardDetails() throws Exception;

    /**
     * Enter keys in the password field of 3D secure credit or debit checkout payment
     * @throws Exception
     */
    void enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment() throws Exception;

    /**Tap on continue button in 3D secure credit or debit checkout payment screen
     * @throws Exception
     */
    void tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment() throws Exception;

    /**
     * Check the booking is success
     * @throws Exception
     */
    void checkTheCreditOrDebitCardBookingProcessIsSuccess() throws Exception;

}