package com.automation.rehlat.pages.paymentOptions;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class PaymentOptionsIos extends PaymentOptionsBase {

    public static final String PAYMENT_OPTIONS_TITLE = "Payment Options";
    public static final String KNET_PAYMENT_GATEWAY_OPTION = "KnetPayment";
    public static final String KNET_PAYMENT_GATEWAY_TITLE = "Knet Payment Gateway";
    public static final String PIN_TEXTFIELD = "XCUIElementTypeSecureTextField";
    public static final String SELECT_YOUR_BANK = "Select Your Bank";
    public static final String SUBMIT_BUTTON = "Submit";
    public static final String CONFIRM_BUTTON = "Confirm";
    public static final String SELECT_YOUR_BANK_PICKER_WHEEL ="XCUIElementTypePickerWheel";
    public static final String TRANSACTION_IN_PROGRESS = "Transaction in progress...";
    public static final String PAYMENT_SUCCESS = "Payment Success Please wait for a while and do not refresh the page..........";
    public static final String BOOKING_SUCCESS = "BOOKING SUCCESS";
    public static final String POST_TRANSACTIONS_SCREEN = "Posted Transaction Filter";
    public static final String XPATH_OF_CARD_NUMBER_VIEW = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
    public static final String XPATH_OF_CARDNUMBER = "//XCUIElementTypeApplication[@name=\\\"Rehlat\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField[2]";
    public static final String XPATH_OF_CREDIT_OR_DEBIT_CARD_TEXT_FIELD = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeTextField";
    public static final String XPATH_OF_CREDIT_OR_DEBIT_CARD_EXPIRY_MONTH_AND_YEAR_TEXT_FIELD = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeTextField";
    public static final String XPATH_OF_CREDITOR_DEBIT_CARD_CVV_TEXT_FIELD = "//XCUIElementTypeApplication[@name=\\\"Rehlat\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[4]/XCUIElementTypeTextField";
    public static final String XPATH_OF_CREDIT_OR_DEBIT_CARD_HOLDER_NAME_TEXT_FIELD = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[5]/XCUIElementTypeTextField";
    public static final String PAY_SECURELY_BUTTON = "PAY SECURELY";
    public static final String XPATH_OF_PASSWORD_FIELD_IN_3D_SECURE_DEBIT_OR_CREDIT_PAYMENT_SCREEN = "//XCUIElementTypeOther[@name=\"Checkout 3D Simulator\"]/XCUIElementTypeOther[5]/XCUIElementTypeSecureTextField";
    public static final String CONTINUE_BUTTON_IN_3D_SECURE_CREDIT_OR_DEBIT_CHECK_OUT_PAYMENT_SCREEN = "Continue";


    /**
     * Check the payment options screen is displayed
     */
    @Override
    public void checkPaymentOptionsScreenIsDisplayed() {
        Logger.logAction("Checking payment option screen is displayed or not ?");
        try{
//            driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
            if (isElementDisplayedByClassName(Labels.IOS_ACTIVITY_INDICATOR)){
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(Labels.IOS_ACTIVITY_INDICATOR)));
            }else {
                if (isElementDisplayedByName(PAYMENT_OPTIONS_TITLE)){
                    Logger.logStep("Payment options screen is displayed and moving to next step");
                }else {
                    Logger.logError("Payment options screen is not displayed");
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name - " + PAYMENT_OPTIONS_TITLE);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                                                                                        //** KNET PAYMENT METHODS **\\

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Tap on KNET payment gateway
     */
    @Override
    public void tapOnKnetPaymentGateWay() {
        Logger.logAction("Tapping on KNET payment gateway");
        try{
            if (isElementDisplayedByName(KNET_PAYMENT_GATEWAY_OPTION)){
                driver.findElementByName(KNET_PAYMENT_GATEWAY_OPTION).click();
            }else {
                Logger.logError("KNET Payment gateway option is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name - " + KNET_PAYMENT_GATEWAY_OPTION);
        }
    }

    /**
     * Check KNET payment gateway screen is displayed
     */
    @Override
    public void checkKnetPaymentOptionsScreenIsDisplayed() {
        Logger.logAction("Checking KNET payment gateway screen is displayed or not ?");
        try{
            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(Labels.IOS_ACTIVITY_INDICATOR)));
            Thread.sleep(Labels.WAIT_TIME_MIN);
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(KNET_PAYMENT_GATEWAY_TITLE)));
            if (isElementDisplayedByName(KNET_PAYMENT_GATEWAY_TITLE)){
                Logger.logStep("KNET Payment gateway screen is displayed and moving to next step");
            }else {
                Logger.logError("KNET Payment screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name - " + KNET_PAYMENT_GATEWAY_TITLE);
        }
    }

    /**
     * Selecting bank name
     */
    @Override
    public void selectingBankName(String bankName) {
        Logger.logAction("Selecting bank name - " + bankName );
        try{
            if (isElementDisplayedByName(SELECT_YOUR_BANK)){
//                Logger.logStep("KNET Payment gateway screen is displayed and moving to next step");
                driver.findElementByName(SELECT_YOUR_BANK).click();
                selectBankNameFromBankPicker(bankName);
            }else {
                Logger.logError("Select your bank option is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the field name - " + "Select Your Bank");
        }
    }

    /**
     * Selecting the bank name from the picker wheel
     */
    public static void selectBankNameFromBankPicker(String bankName) {
        try {
            if(isElementDisplayedByClassName(SELECT_YOUR_BANK_PICKER_WHEEL)){
                IOSElement banksPickerView = (IOSElement) driver.findElement(By.className(SELECT_YOUR_BANK_PICKER_WHEEL));
                banksPickerView.sendKeys(bankName);
                closeTheKeyboard();
            }else {
                Logger.logError("Picker view is not displayed to select the bank name");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the bank picker");
        }
    }

    /**
     * Enter the card number
     */
    @Override
    public void enterCardNumber() {
        Logger.logAction("Tapping on card number text field");
        String xPathOfCardNumberTextField = null;
        try{
            if (isElementEnabledByXpath(XPATH_OF_CARD_NUMBER_VIEW))
            {
                WebElement cardNumberLayout = driver.findElementByXPath(XPATH_OF_CARD_NUMBER_VIEW);
                List<WebElement> listOfTextFields = cardNumberLayout.findElements(By.className("XCUIElementTypeTextField"));
                Logger.logStep("Entering the card number");
                xPathOfCardNumberTextField =  XPATH_OF_CARD_NUMBER_VIEW+"/XCUIElementTypeTextField["+(listOfTextFields.size())+"]";
                driver.findElement(By.xpath(xPathOfCardNumberTextField)).sendKeys(Labels.KNET_PAYMENT_CARD_NUMBER);
                closeTheKeyboard();
            }else {
                Logger.logError("Card number field is not displayed" + xPathOfCardNumberTextField);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name by Xpath :- \n" + xPathOfCardNumberTextField);
        }
    }

    /**
     * Enter the Pin number
     */
    @Override
    public void enterPinNumber() {
        Logger.logAction("Tapping on pin number text field");
        try{
            if (isElementDisplayedByClassName(PIN_TEXTFIELD)){
                WebElement pinNumberTextField = driver.findElementByClassName(PIN_TEXTFIELD);
                pinNumberTextField.click();
//                driver.getKeyboard().pressKey(IOSKeyCode.); // Implement keycode method to parse the values in to the card text field
                Logger.logStep("Entering the pin number");
                pinNumberTextField.sendKeys(Labels.KNET_PAYMENT_CARD_PIN_NUMBER);
                closeTheKeyboard();
            }else {
                Logger.logError("Card number field is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name by Xpath :- \n" + XPATH_OF_CARDNUMBER);
        }
    }

    /**
     * Tap on Submit button
     */
    @Override
    public void tapOnSubmitButton() {
        Logger.logAction("Tapping on submit button");
        try{
            if (isElementDisplayedByName(SUBMIT_BUTTON)){
             driver.findElementByName(SUBMIT_BUTTON).click();
            }else {
                Logger.logError("Submit button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name :- \n" + SUBMIT_BUTTON);
        }
    }

    /**
     * Check post transactions screen is displayed
     */
    @Override
    public void checkPostTransactionScreenIsDisplayed() {
        Logger.logAction("Checking post transactions screen is displayed or not ?");
        try{
//            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(Labels.IOS_ACTIVITY_INDICATOR)));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(POST_TRANSACTIONS_SCREEN)));
            if (isElementDisplayedByName(POST_TRANSACTIONS_SCREEN)){
                Logger.logStep("Post transactions screen is displayed and moving to next step");
            }else {
                Logger.logError("Post transactions screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name - " + POST_TRANSACTIONS_SCREEN);
        }
    }

    /**
     * Tap on Confirm button
     */
    @Override
    public void tapOnConfirmButton() {
        Logger.logAction("Tapping on Confirm button");
        try{
            if (isElementDisplayedByName(CONFIRM_BUTTON)){
                driver.findElementByName(CONFIRM_BUTTON).click();
            }else {
                Logger.logError("Confirm button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name :- \n" + CONFIRM_BUTTON);
        }
    }

    /**
     * Check the booking is success
     */
    @Override
    public void checkTheKnetBookingProcessIsSuccess() {
        Logger.logAction("Checking Booking is success or not ?");
        try {
            if (isElementDisplayedByClassName(Labels.IOS_ACTIVITY_INDICATOR)){
                Logger.logComment("Booking process is started");
                if (isElementDisplayedByName(TRANSACTION_IN_PROGRESS)){
                    Logger.logComment(TRANSACTION_IN_PROGRESS);
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }else {
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+PAYMENT_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }
            }else if (isElementDisplayedByName(TRANSACTION_IN_PROGRESS)){
                    Logger.logComment(TRANSACTION_IN_PROGRESS);
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+PAYMENT_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }else if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+PAYMENT_SUCCESS+"////////////////////////////////////////////////////\n"+
                                        "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
            }
//            if (isElementDisplayedByClassName(IOS_ACTIVITY_INDICATOR)){
//                Logger.logComment("Booking process is started");
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(IOS_ACTIVITY_INDICATOR)));
////                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(TRANSACTION_IN_PROGRESS)));
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(TRANSACTION_IN_PROGRESS)));
//                Logger.logComment(TRANSACTION_IN_PROGRESS);
////                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(PAYMENT_SUCCESS)));
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(PAYMENT_SUCCESS)));
//                Logger.logComment(PAYMENT_SUCCESS);
//                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(BOOKING_SUCCESS)));
//                Logger.logComment(PAYMENT_SUCCESS);
//            }else {
//                Logger.logError("Activity indicator is not displayed, looks like booking process is not started");
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the booking status");
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                                                                                      //** CREDIT OR DEBIT CARD METHODS **\\

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Enter credit or debit card details
     */
    @Override
    public void enterCreditOrDebitCardDetails() {
        Logger.logAction("Entering the credit or debit card details");
        try {
            enterCreditOrDebitCardNumber();
            enterCreditOrDebitCardExpiryMonthAndYearAndCvvNumber();
//            enterCreditOrDebitCardExpiryYear();
//            enterCreditOrDebitCardCvvNumber();
            enterCreditOrDebitCardPlaceHolderName();
            tapOnCreditOrDebitCardCheckOutPaymentButton();
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter the credit or debit card number
     */
    public static void enterCreditOrDebitCardNumber() {
        Logger.logAction("Entering the credit or debit card number");
        try {
            if (isElementDisplayedByXPath(XPATH_OF_CREDIT_OR_DEBIT_CARD_TEXT_FIELD)){
                driver.findElement(By.xpath(XPATH_OF_CREDIT_OR_DEBIT_CARD_TEXT_FIELD)).sendKeys(Labels.CREDIT_OR_DEBIT_CARD_NUMBER);
                Thread.sleep(Labels.WAIT_TIME_MIN);
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- "+XPATH_OF_CREDIT_OR_DEBIT_CARD_TEXT_FIELD);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter credit or debit expiry month and year
     */
    public static void enterCreditOrDebitCardExpiryMonthAndYearAndCvvNumber() {
        Logger.logAction("Entering the credit or debit card Expiry month");
        try {
            if (isElementDisplayedByXPath(XPATH_OF_CREDIT_OR_DEBIT_CARD_EXPIRY_MONTH_AND_YEAR_TEXT_FIELD)){
                driver.findElement(By.xpath(XPATH_OF_CREDIT_OR_DEBIT_CARD_EXPIRY_MONTH_AND_YEAR_TEXT_FIELD)).sendKeys(Labels.CREDIT_OR_DEBIT_CARD_EXPIRY_MONTH_AND_YEAR_AND_CVV_NUMBER);
                Thread.sleep(Labels.WAIT_TIME_MIN);
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- "+XPATH_OF_CREDIT_OR_DEBIT_CARD_EXPIRY_MONTH_AND_YEAR_TEXT_FIELD);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    // IMPLEMENT THIS METHOD SUCH THAT PARSING THE CVV NUMBER SHOULD BE DONE INDEPENDENTLY NOT WITH EXPIRY MONTH AND YEAR
    /**
     * Enter credit or debit card cvv number
     */
    public static void enterCreditOrDebitCardCvvNumber() {
        Logger.logAction("Entering the credit or debit card CVV number");
        try {
            if (isElementDisplayedByXPath(XPATH_OF_CREDITOR_DEBIT_CARD_CVV_TEXT_FIELD)){
                driver.findElement(By.xpath(XPATH_OF_CREDITOR_DEBIT_CARD_CVV_TEXT_FIELD)).sendKeys(Labels.CREDIT_OR_DEBIT_CARD_CVV_NUMBER);
                Thread.sleep(Labels.WAIT_TIME_MIN);
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- "+XPATH_OF_CREDITOR_DEBIT_CARD_CVV_TEXT_FIELD);
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter credit or debit card place holder name
     */
    public static void enterCreditOrDebitCardPlaceHolderName() {
        Logger.logAction("Entering the credit or debit card holder name");
        try {
            if (isElementDisplayedByXPath(XPATH_OF_CREDIT_OR_DEBIT_CARD_HOLDER_NAME_TEXT_FIELD))
            {
                driver.findElement(By.xpath(XPATH_OF_CREDIT_OR_DEBIT_CARD_HOLDER_NAME_TEXT_FIELD)).sendKeys(Labels.CREDIT_OR_DEBIT_CARD_HOLDER_NAME);
                Thread.sleep(Labels.WAIT_TIME_MIN);
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- "+XPATH_OF_CREDIT_OR_DEBIT_CARD_HOLDER_NAME_TEXT_FIELD);
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Tap on credit or debit checkout payment button
     */
    public static void tapOnCreditOrDebitCardCheckOutPaymentButton() {
        Logger.logAction("Tapping on pay securely check out button");
        try {
            if (isElementDisplayedById(PAY_SECURELY_BUTTON)){
                driver.findElement(By.id(PAY_SECURELY_BUTTON)).click();
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- "+PAY_SECURELY_BUTTON);
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter keys in the password field of 3D secure credit or debit checkout payment
     */
    @Override
    public void enterKeysInThePasswordFieldOf3DSecureCreditOrDebitCardCheckOutPayment() {
            Logger.logAction("Tapping on pay securely check out button");
            try {
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(Labels.IOS_ACTIVITY_INDICATOR)));
                if (isElementDisplayedByXPath(XPATH_OF_PASSWORD_FIELD_IN_3D_SECURE_DEBIT_OR_CREDIT_PAYMENT_SCREEN)){
                    driver.findElement(By.xpath(XPATH_OF_PASSWORD_FIELD_IN_3D_SECURE_DEBIT_OR_CREDIT_PAYMENT_SCREEN)).sendKeys(Labels.PASSWORD_OF_3D_SECURE_DEBIT_OR_CREDIT_PAYMENT);
                    Thread.sleep(Labels.WAIT_TIME_MIN);
                }else {
                    Logger.logError("Element name is not displayed in the current active screen:- "+XPATH_OF_PASSWORD_FIELD_IN_3D_SECURE_DEBIT_OR_CREDIT_PAYMENT_SCREEN);
                }
            } catch (Exception exception) {
                Logger.logError("Encountered error: Unable to enter the credit or debit card details");
            }
        }

    /**Tap on continue button in 3D secure credit or debit checkout payment screen
     */
    @Override
    public  void tapOnContinueButtonIn3DSecurePaymentScreenOfCreditOrDebitCardCheckOutPayment() {
        Logger.logAction("Tapping on pay securely check out button");
        try {
            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(Labels.IOS_ACTIVITY_INDICATOR)));
            if (isElementDisplayedById(CONTINUE_BUTTON_IN_3D_SECURE_CREDIT_OR_DEBIT_CHECK_OUT_PAYMENT_SCREEN)){
                driver.findElement(By.id(CONTINUE_BUTTON_IN_3D_SECURE_CREDIT_OR_DEBIT_CHECK_OUT_PAYMENT_SCREEN)).click();
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- "+CONTINUE_BUTTON_IN_3D_SECURE_CREDIT_OR_DEBIT_CHECK_OUT_PAYMENT_SCREEN);
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }
    /**
     * Check the booking is success
     */
    @Override
    public void checkTheCreditOrDebitCardBookingProcessIsSuccess() {
        Logger.logAction("Checking Booking is success or not ?");
        try {
            if (isElementDisplayedByClassName(Labels.IOS_ACTIVITY_INDICATOR)){
                Logger.logComment("Booking process is started");
                if (isElementDisplayedByName(TRANSACTION_IN_PROGRESS)){
                    Logger.logComment(TRANSACTION_IN_PROGRESS);
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }else {
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }
            }else if (isElementDisplayedByName(TRANSACTION_IN_PROGRESS)){
                Logger.logComment(TRANSACTION_IN_PROGRESS);
                if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                    Logger.logComment(PAYMENT_SUCCESS);
                    if (isElementDisplayedByName(BOOKING_SUCCESS)){
                        System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                    }else {
                        Logger.logError("Booking process is failed");
                    }
                }else {
                    if (isElementDisplayedByName(BOOKING_SUCCESS)){
                        System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                                "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                    }else {
                        Logger.logError("Booking process is unsuccessful");
                    }
                }
            }else if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                Logger.logComment(PAYMENT_SUCCESS);
                if (isElementDisplayedByName(BOOKING_SUCCESS)){
                    System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                            "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                            "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                }else {
                    Logger.logError("Booking process is failed");
                }
            }else {
                if (isElementDisplayedByName(BOOKING_SUCCESS)){
                    System.out.println( "////////////////////////////////////////////////////////////////////////////////////\n" +
                            "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                            "///////////////////////////////////////////////////////////////////////////////////////////////////////");
                }else {
                    Logger.logError("Booking process is unsuccessful");
                }
            }
//            if (isElementDisplayedByClassName(IOS_ACTIVITY_INDICATOR)){
//                Logger.logComment("Booking process is started");
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(IOS_ACTIVITY_INDICATOR)));
////                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(TRANSACTION_IN_PROGRESS)));
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(TRANSACTION_IN_PROGRESS)));
//                Logger.logComment(TRANSACTION_IN_PROGRESS);
////                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(PAYMENT_SUCCESS)));
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(PAYMENT_SUCCESS)));
//                Logger.logComment(PAYMENT_SUCCESS);
//                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(BOOKING_SUCCESS)));
//                Logger.logComment(PAYMENT_SUCCESS);
//            }else {
//                Logger.logError("Activity indicator is not displayed, looks like booking process is not started");
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the booking status");
        }
    }

}