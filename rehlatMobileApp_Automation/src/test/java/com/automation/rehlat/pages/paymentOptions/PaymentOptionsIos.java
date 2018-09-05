package com.automation.rehlat.pages.paymentOptions;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class PaymentOptionsIos extends PaymentOptionsBase {

    public static final String PAYMENT_OPTIONS_TITLE = "Payment Options";
    public static final String KNET_PAYMENT_GATEWAY_OPTION = "KNET";
    public static final String KNET_PAYMENT_GATEWAY_TITLE = "Knet Payment Gateway";
    public static final String PIN_TEXTFIELD = "XCUIElementTypeSecureTextField";
    public static final String SELECT_YOUR_BANK = "Select Your Bank";
    public static final String PAYMENT_FAILED = "Payment Failed";
    public static final String SUBMIT_BUTTON = "Submit";
    public static final String CONFIRM_BUTTON = "Confirm";
    public static final String SELECT_YOUR_BANK_PICKER_WHEEL ="XCUIElementTypePickerWheel";
    public static final String TRANSACTION_IN_PROGRESS = "Transaction in progress...";
    public static final String PAYMENT_SUCCESS = "Payment Success Please wait for a while and do not refresh the page..........";
    public static final String BOOKING_SUCCESS = "BOOKING SUCCESS";
    public static final String FARE_DIFFER_ALERT_XPATH = "//XCUIElementTypeStaticText[@name=\"The ticket price has changed. Do you wish to continue? \"]";
    public static final String YES_BUTTON_IN_FARE_DIFFER_ALERT = "Yes";
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
    public static final String XPATH_OF_FINAL_PAYMENT_CELL_IN_PAYMENT_OPTIONS_SCREEN = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]";
    public static final String TICKET_SOLD_OUT_POPUP = "Ticket had been Sold out";
    public static final String OK_BUTTON = "OK";

    /**
     * Check the payment options screen is displayed
     */
    @Override
    public void checkPaymentOptionsScreenIsDisplayed() {
        Logger.logAction("Checking payment option screen is displayed or not ?");
        try{
//            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
//            if (isElementDisplayedByClassName(Labels.IOS_ACTIVITY_INDICATOR)){
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(Labels.IOS_ACTIVITY_INDICATOR)));
                acceptTheFareDifferAlert();
//            }else {
//                acceptTheFareDifferAlert();
//            }
            if (isElementDisplayedByName(PAYMENT_OPTIONS_TITLE)){
                Logger.logStep("Payment options screen is displayed and moving to next step");
            }else {
                Logger.logError("Payment options screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name - " + PAYMENT_OPTIONS_TITLE);
        }
    }

    /**
     * Check the auto fare differ information popup is displayed
     */
    public void acceptTheFareDifferAlert() {
        Logger.logAction("Accepting the fare differ alert if displayed");
        try {
            if (isElementDisplayedByXPath(FARE_DIFFER_ALERT_XPATH)){
                Logger.logStep("Fare differ alert is displayed and going to accept it by tapping on yes button");
                driver.findElementByName(YES_BUTTON_IN_FARE_DIFFER_ALERT).click();
                Logger.logComment("Tapped on yes button in the fare differ alert");
            }
            else {
                Logger.logStep(FARE_DIFFER_ALERT_XPATH+" :- element xpath is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the fare differ alert is displayed or not");
        }
    }

    /**
     * Compare the final payment displayed in payment checkout screen with the amount displayed in review booking screen
     */
    @Override
    public void compareTheFinalPaymentDisplayedInPaymentsCheckOutScreenWithPaymentDisplayedInReviewBookingScreen() {
        Logger.logAction("Comparing the final payment displayed in payment checkout screen with the amount displayed in review booking screen");
        try {
            if (isElementDisplayedByXPath(XPATH_OF_FINAL_PAYMENT_CELL_IN_PAYMENT_OPTIONS_SCREEN)){
                Logger.logAction("Total amount payable price linear layout is displayed");
                String xPathOfFinalPaymentPrice = XPATH_OF_FINAL_PAYMENT_CELL_IN_PAYMENT_OPTIONS_SCREEN+"/XCUIElementTypeStaticText[3]";
                if (isElementDisplayedByXPath(xPathOfFinalPaymentPrice)){
                    Double finalAmountPayablePriceInPaymentCheckOutScreen = Double.parseDouble(driver.findElementByXPath(xPathOfFinalPaymentPrice).getText());
                    Double ticketAmountDisplayedInBookingPageScreen = Double.parseDouble(Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN);
                    Logger.logComment("Final Amount displayed in the payment check out screen is :- "+finalAmountPayablePriceInPaymentCheckOutScreen);
                    Logger.logComment("Booking cost displayed in review booking screen is :- "+Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN);
                    if (finalAmountPayablePriceInPaymentCheckOutScreen.equals(ticketAmountDisplayedInBookingPageScreen)) {
                        Logger.logStep("Final Amount displayed in the payment check out screen is matches with booking cost displayed in review booking screen");
                    }else if (finalAmountPayablePriceInPaymentCheckOutScreen == ticketAmountDisplayedInBookingPageScreen) {
                        Logger.logStep("Final Amount displayed in the payment check out screen is matches with booking cost displayed in review booking screen");
                    }
//                    else if (Labels.BOOKING_COST_DISPLAYING_IN_BOOKING_PAGE_SCREEN.contains(finalAmountPayablePriceInPaymentCheckOutScreen)) {
//                        Logger.logStep("Final Amount displayed in the payment check out screen is matches with booking cost displayed in review booking screen");
//                    }
                    else {
                        Logger.logError("Final Amount displayed in the payment check out screen is not matches with booking cost displayed in review booking screen");
                    }
                }else {
                    Logger.logError("Total amount payable price is not displaying in payment checkout screen");
                }
            }else {
                Logger.logError("Total amount payable cell is not displaying in payment checkout screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to compare the final payment price in payment list screen with the price dispalyed in review booking screen");
        }
    }

    /**
     * Checking the ticket sold out popup is displayed
     * @return
     */
    @Override
    public boolean isTicketSoldOutPopUpIsDisplayed() {
        Logger.logAction("Checking the ticket sold out popup is displayed or not ?");
        try{
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
            if (isElementDisplayedByName(TICKET_SOLD_OUT_POPUP)){
                BaseTest.takeScreenshotAndSaveInSoldOutsFolder();
                Logger.logStep(TICKET_SOLD_OUT_POPUP +" - popup is displayed in the current active screen");
                return true;
            }else {
                Logger.logStep(TICKET_SOLD_OUT_POPUP +" - popup is not displayed in the current active screen");
                return false;
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the popup is displayed or not");
        }
        return false;
    }

    /**
     * Tap on ok button in ticket sold out popup
     */
    @Override
    public void tapOnOkButtonInTicketSoldOutPopup() {
        Logger.logAction("Tapping on "+OK_BUTTON+ " button");
        try {
            if (isElementDisplayedByName(OK_BUTTON)){
                driver.findElementByName(OK_BUTTON).click();
                Logger.logComment("Tapped on ok button in the ticket sold out popup");
            }else {
                Logger.logError(" - button name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on OK button in ticket sold out popup");
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
            if (isElementEnabledByName(KNET_PAYMENT_GATEWAY_OPTION)){
                driver.findElementByName(KNET_PAYMENT_GATEWAY_OPTION).click();
                Logger.logComment("Tapped on kent payment option");
//                if (isElementDisplayedByClassName(Labels.IOS_ACTIVITY_INDICATOR)){
//                    driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(Labels.IOS_ACTIVITY_INDICATOR)));
//                }else {
                    Logger.logComment("KNEY payment gateway is selected and moving to next step");
//                }
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
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
//            if (isElementDisplayedByClassName(Labels.IOS_ACTIVITY_INDICATOR)){
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(Labels.IOS_ACTIVITY_INDICATOR)));
//            }
            if (isElementDisplayedById(PAYMENT_FAILED)){
                System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                        "//////////////////////////////////////////  "+PAYMENT_FAILED+"////////////////////////////////////////////////////\n"+
                        "        ////////////////////////////////////////////////////////////////////////////////////");
                Logger.logError("Payment Failed screen is displayed");
            }else if (isElementDisplayedByName(KNET_PAYMENT_GATEWAY_TITLE)){
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
                Logger.logComment(SELECT_YOUR_BANK+" :- element is displayed and moving to next step");
                driver.findElementByName(SELECT_YOUR_BANK).click();
                Logger.logComment("Tapped on select your bank button");
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
            Thread.sleep(4000);
            if(isElementDisplayedByClassName(SELECT_YOUR_BANK_PICKER_WHEEL)){
                IOSElement banksPickerView = (IOSElement) driver.findElementByClassName(SELECT_YOUR_BANK_PICKER_WHEEL);
                banksPickerView.sendKeys(bankName);
                Logger.logComment(bankName+" :- is Parsed");
                closeTheKeyboard_iOS();
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
//        String xPathOfCardNumberTextField = null;
        try{
            if (isElementEnabledByXpath(XPATH_OF_CARD_NUMBER_VIEW))
            {
                WebElement cardNumberLayout = driver.findElementByXPath(XPATH_OF_CARD_NUMBER_VIEW);
                List<WebElement> listOfTextFields = cardNumberLayout.findElements(By.className(Labels.IOS_XCUI_ELEMENT_TYPE_TEXT_FIELD));
                for (int index =0; index <= listOfTextFields.size()-1;index++){
                    String elementVisibilityStatus = listOfTextFields.get(index).getAttribute(Labels.VISIBLE_ATTRIBUTE);
                    if (elementVisibilityStatus.equalsIgnoreCase(Labels.STATUS_TRUE)) {
//                        index = index +1;
//                        xPathOfCardNumberTextField =  XPATH_OF_CARD_NUMBER_VIEW+"/"+Labels.IOS_XCUI_ELEMENT_TYPE_TEXT_FIELD+"["+index+"]";
                        Logger.logStep("Entering the card number");
                        listOfTextFields.get(index).sendKeys(Labels.KNET_PAYMENT_CARD_NUMBER);
//                        driver.findElementByXPath(xPathOfCardNumberTextField).sendKeys(Labels.KNET_PAYMENT_CARD_NUMBER);
                        Logger.logComment(Labels.KNET_PAYMENT_CARD_NUMBER+" :- is Parsed");
                        closeTheKeyboard_iOS();
                    }else {
                        Logger.logComment("Card number text field of type XCUIElementTypeTextField with index - "+index+" is not visible");
                    }
//                    if (isKeyboardDisplayed()){
//                        Logger.logError("Card number fields all are invisible");
//                    }else {
//                        Logger.logComment("Entered the card number :- "+Labels.KNET_PAYMENT_CARD_NUMBER);
//                    }
                }
            }else {
                Logger.logError("Card number field is not displayed" + XPATH_OF_CARD_NUMBER_VIEW);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to check the element name by Xpath :- " + XPATH_OF_CARD_NUMBER_VIEW);
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
                Logger.logComment(Labels.KNET_PAYMENT_CARD_PIN_NUMBER+" :- is Parsed");
                closeTheKeyboard_iOS();
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
             Logger.logComment("Tapped on submit button");
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
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
//            Thread.sleep(4000);
//            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(Labels.IOS_ACTIVITY_INDICATOR)));
//            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(POST_TRANSACTIONS_SCREEN)));
            if (isElementEnabledByName(POST_TRANSACTIONS_SCREEN)){
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
                Logger.logComment("Tapped on confirm button");
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
                waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
                Logger.logComment("Booking process is started");
                if (isElementDisplayedByName(TRANSACTION_IN_PROGRESS)){
                    Logger.logComment(TRANSACTION_IN_PROGRESS);
                    waitForAnElementToDisappear_ByName(TRANSACTION_IN_PROGRESS);
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        Logger.logStep("Payment success screen is displayed, waiting till the screen is invisible");
                        waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "        ////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "        ////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }else {
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        Logger.logStep("Payment success screen is displayed, waiting till the screen is invisible");
                        waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "        ////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "        ////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }
            }else if (isElementDisplayedByName(TRANSACTION_IN_PROGRESS)){
                    Logger.logComment(TRANSACTION_IN_PROGRESS);
                    waitForAnElementToDisappear_ByName(TRANSACTION_IN_PROGRESS);
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        Logger.logStep("Payment success screen is displayed, waiting till the screen is invisible");
                        waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "        ////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "        ////////////////////////////////////////////////////////////////////////////////////");
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }else if (isElementDisplayedByName(PAYMENT_SUCCESS)) {
                    Logger.logComment(PAYMENT_SUCCESS);
                    Logger.logStep("Payment success screen is displayed, waiting till the screen is invisible");
                    waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                    if (isElementDisplayedByName(BOOKING_SUCCESS)){
                        System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                "        ////////////////////////////////////////////////////////////////////////////////////");
                    }
                    else {
                        Logger.logError("Booking process is failed");
                    }
                }
                else {
                if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "        ////////////////////////////////////////////////////////////////////////////////////");
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
                Logger.logComment(Labels.CREDIT_OR_DEBIT_CARD_NUMBER+" :- is parsed");
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
                Logger.logComment(Labels.CREDIT_OR_DEBIT_CARD_EXPIRY_MONTH_AND_YEAR_AND_CVV_NUMBER+" :- is parsed");
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
                Logger.logComment(Labels.CREDIT_OR_DEBIT_CARD_CVV_NUMBER+" :- is parsed");
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
                Logger.logComment(Labels.CREDIT_OR_DEBIT_CARD_HOLDER_NAME+" :- is parsed");
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
                Logger.logComment("Tapped on pay securely button");
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
                waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
                waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
                if (isElementDisplayedByXPath(XPATH_OF_PASSWORD_FIELD_IN_3D_SECURE_DEBIT_OR_CREDIT_PAYMENT_SCREEN)){
                    driver.findElementByXPath(XPATH_OF_PASSWORD_FIELD_IN_3D_SECURE_DEBIT_OR_CREDIT_PAYMENT_SCREEN).sendKeys(Labels.PASSWORD_OF_3D_SECURE_DEBIT_OR_CREDIT_PAYMENT);
                    Logger.logComment(Labels.PASSWORD_OF_3D_SECURE_DEBIT_OR_CREDIT_PAYMENT+" :- is parsed");
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
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
            if (isElementDisplayedById(CONTINUE_BUTTON_IN_3D_SECURE_CREDIT_OR_DEBIT_CHECK_OUT_PAYMENT_SCREEN)){
                driver.findElement(By.id(CONTINUE_BUTTON_IN_3D_SECURE_CREDIT_OR_DEBIT_CHECK_OUT_PAYMENT_SCREEN)).click();
                Logger.logComment("Tapped on continue button in  3D pay securely payment button");
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
                    Logger.logComment(TRANSACTION_IN_PROGRESS + " is displayed");
                    waitForAnElementToDisappear_ByName(TRANSACTION_IN_PROGRESS);
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        Logger.logStep("Payment success screen is displayed, waiting till the screen is invisible");
                        waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "        ////////////////////////////////////////////////////////////////////////////////////\n");
                        }else {
                            Logger.logError("Booking process is failed or stuck");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "        ////////////////////////////////////////////////////////////////////////////////////\n");
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }else {
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        Logger.logStep("Payment success screen is displayed, waiting till the screen is invisible");
                        waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "        ////////////////////////////////////////////////////////////////////////////////////\n");
                        }else {
                            Logger.logError("Booking process is failed or stuck");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                    "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                    "        ////////////////////////////////////////////////////////////////////////////////////\n");
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }
            }else if (isElementDisplayedByName(TRANSACTION_IN_PROGRESS)){
                Logger.logComment(TRANSACTION_IN_PROGRESS);
                if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                    Logger.logComment(PAYMENT_SUCCESS);
                    Logger.logStep("Payment success screen is displayed, waiting till the screen is invisible");
                    waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                    if (isElementDisplayedByName(BOOKING_SUCCESS)){
                        System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                "        ////////////////////////////////////////////////////////////////////////////////////\n");
                    }else {
                        Logger.logError("Booking process is failed or stuck");
                    }
                }else {
                    if (isElementDisplayedByName(BOOKING_SUCCESS)){
                        System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                                "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                                "        ////////////////////////////////////////////////////////////////////////////////////\n");
                    }else {
                        Logger.logError("Booking process is unsuccessful");
                    }
                }
            }else if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                Logger.logComment(PAYMENT_SUCCESS);
                Logger.logStep("Payment success screen is displayed, waiting till the screen is invisible");
                waitForAnElementToDisappear_ByName(PAYMENT_SUCCESS);
                if (isElementDisplayedByName(BOOKING_SUCCESS)){
                    System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                            "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                            "        ////////////////////////////////////////////////////////////////////////////////////\n");
                }else {
                    Logger.logError("Booking process is failed or stuck");
                }
            }else {
                if (isElementDisplayedByName(BOOKING_SUCCESS)){
                    System.out.println( "        ////////////////////////////////////////////////////////////////////////////////////\n" +
                            "//////////////////////////////////////////  "+BOOKING_SUCCESS+"////////////////////////////////////////////////////\n"+
                            "        ////////////////////////////////////////////////////////////////////////////////////\n");
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
