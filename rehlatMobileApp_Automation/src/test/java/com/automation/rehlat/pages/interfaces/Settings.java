package com.automation.rehlat.pages.interfaces;

public interface Settings {

    /**
     * Check the settings screen is displayed
     * @throws Exception
     */
    void checkSettingsScreenIsDisplayed();

    /**
     * Get the current domain
     */
    String getTheCurrentDomain();

    /**
     * Get the current currency
     */
    String getTheCurrentCurrencyType();

    /**
     * Change the domain
     * @param parsingDomainName
     */
    void selectTheDomain(String parsingDomainName);

    /**
     * Tap on change currency option
     */
    void tapOnChangeCurrencyOption();

    /**
     * Tap on change country option
     */
    void tapOnChangeCountryOption();

    /**
     * Tap on continue button
     */
    void tapOnContinueButton();

    /**
     * Change the domain
     * @param parsingCurrencyName
     */
    void selectTheCurrencyName(String parsingCurrencyName);
}
