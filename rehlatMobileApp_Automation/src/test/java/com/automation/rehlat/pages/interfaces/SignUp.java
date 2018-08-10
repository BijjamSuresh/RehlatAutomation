package com.automation.rehlat.pages.interfaces;

public interface SignUp {
    /**
     * Check sign up screen is displayed
     * @throws Exception
     */
    void checkSignUpScreenIsDisplayed() throws Exception;

    /**
     * Enter sign up credentials
     * @throws Exception
     */
    void enterSignUpCredentials() throws Exception;

    /**
     * Enter user first name
     * @throws Exception
     */
    void enterUserFirstName() throws Exception;

    /**
     * Enter user last name
     * @throws Exception
     */
    void enterUserLastName() throws Exception;

    /**
     * Enter user email id
     * @throws Exception
     */
    void enterUserEmailId() throws Exception;

    /**
     * Enter user password for sign up
     * @throws Exception
     */
    void enterUserPassword() throws Exception;

    /**
     * Enter user sign up repeat password
     * @throws Exception
     */
    void enterUserRepeatPassword() throws Exception;

    /**
     * Select the user domain (Country domain)
     * @throws Exception
     */
    void selectDomain() throws Exception;

    /**
     * Enter referral code
     * @throws Exception
     */
    void enterReferralCode() throws Exception;

    /**
     * Tap on Sign Up button
     * @throws Exception
     */
    void tapOnSignUpButton() throws Exception;


}
