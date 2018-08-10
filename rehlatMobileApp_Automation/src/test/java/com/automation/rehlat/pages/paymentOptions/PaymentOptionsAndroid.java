package com.automation.rehlat.pages.paymentOptions;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PaymentOptionsAndroid extends PaymentOptionsBase {
    public static final String PAYMENT_OPTIONS_TITLE = "com.app.rehlat:id/paymntgatewayListView";
    public static final String PAYMENT_GATEWAY_SCREEN_TITLE = "com.app.rehlat:id/transactionHeaderBck";
    public static final String ACTIVITY_INDICATOR = "com.app.rehlat:id/flight_search_progressbar";
    public static final String XPATH_OF_SELECT_YOUR_BANK_BUTTON = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[5]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.GridView/android.view.View[2]/android.view.View/android.view.View/android.view.View[6]/android.view.View[2]/android.widget.Spinner";
    public static final String XPATH_OF_CARD_NUMBER_VIEW = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[5]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.GridView/android.view.View[3]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]";
    public static final String PIN_TEXTFIELD = "Ecom_Payment_Pin_id";
    public static final String SUBMIT_BUTTON = "EntrySubmitAction_id";
    public static final String CONFIRM_BUTTON = "ConfirmAction_id";
    public static final String SELECT_YOUR_BANK_MODAL_SHEET = "android:id/customPanel";
    public static final String TRANSACTION_IN_PROGRESS = "Transaction in progress...";
    public static final String PAYMENT_SUCCESS = "Payment Success Please wait for a while and do not refresh the page..........";
    public static final String BOOKING_SUCCESS = "BOOKING SUCCESS";
    public static final String POST_TRANSACTIONS_SCREEN = "form1";
    public static final String XPATH_OF_KNET_PAYMENT_OPTION = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView";
    public static final String XPATH_OF_PAYMENT_BANK_WITHOUT_INDEX = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[";
    /**
     * Check the payment options screen is displayed
     */
    @Override
    public void checkPaymentOptionsScreenIsDisplayed() {
        Logger.logAction("Checking payment option screen is displayed or not ?");
        try{
            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ACTIVITY_INDICATOR)));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PAYMENT_OPTIONS_TITLE)));
            if (isElementDisplayedById(PAYMENT_OPTIONS_TITLE)){
                Logger.logStep("Payment options screen is displayed and moving to next step");
            }else {
                Logger.logError("Payment options screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name");
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
            if (isElementDisplayedByXPath(XPATH_OF_KNET_PAYMENT_OPTION)){
                WebElement paymentGateWay = driver.findElementByXPath(XPATH_OF_KNET_PAYMENT_OPTION);
                if (paymentGateWay.getText().equals("Knet")){
                    paymentGateWay.click();
                    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
                }else {
                    Logger.logError("Knet Payment gateway xpath is not changed, please do re check the KNET xpath and re-run again");
                }
            }else {
                Logger.logError("KNET Payment gateway option is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name - " + XPATH_OF_KNET_PAYMENT_OPTION);
        }
    }

    /**
     * Check KNET payment gateway screen is displayed
     */
    @Override
    public void checkKnetPaymentOptionsScreenIsDisplayed() {
        Logger.logAction("Checking KNET payment gateway screen is displayed or not ?");
        try{
            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ACTIVITY_INDICATOR)));
            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            if (isElementDisplayedById(PAYMENT_GATEWAY_SCREEN_TITLE) && (isElementDisplayedById(SUBMIT_BUTTON))){
                Logger.logStep("KNET Payment gateway screen is displayed and moving to next step");
            }else {
                Logger.logError("Payment payment screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name - " + PAYMENT_GATEWAY_SCREEN_TITLE +","+CONFIRM_BUTTON);
        }
    }

    /**
     * Selecting bank name
     */
    @Override
    public void selectingBankName(String bankName) {
        Logger.logAction("Selecting bank name - " + bankName );
        try{
            if (isElementDisplayedByXPath(XPATH_OF_SELECT_YOUR_BANK_BUTTON)){
//                Logger.logStep("KNET Payment gateway screen is displayed and moving to next step");
                driver.findElementByXPath(XPATH_OF_SELECT_YOUR_BANK_BUTTON).click();
                selectBankNameFromBankPicker(bankName);
            }else {
                Logger.logError("Select your bank option is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the field name xpath:- " +XPATH_OF_SELECT_YOUR_BANK_BUTTON);
        }
    }

    /**
     * Selecting the bank name from the picker wheel
     */
    public static void selectBankNameFromBankPicker(String bankName) {
        WebElement nameOfTheCell;
        Logger.logAction("Selecting the bank :- "+bankName);
        try {
            if(isElementDisplayedById(SELECT_YOUR_BANK_MODAL_SHEET)){
                int cellNumber = scrollToTheBankName(bankName)+1;
                nameOfTheCell = driver.findElementByXPath(XPATH_OF_PAYMENT_BANK_WITHOUT_INDEX+cellNumber+"]");
                if (nameOfTheCell.getText().equals(bankName)){
                    driver.findElementByXPath(XPATH_OF_PAYMENT_BANK_WITHOUT_INDEX+cellNumber+"]").click();
                }else {
                    scrollTheScreenUpwards();
                    nameOfTheCell = driver.findElementByXPath(XPATH_OF_PAYMENT_BANK_WITHOUT_INDEX+cellNumber+"]");
                    if (nameOfTheCell.getText().equals(bankName)){
                        driver.findElementByXPath(XPATH_OF_PAYMENT_BANK_WITHOUT_INDEX+cellNumber+"]").click();
                    }else {
                        Logger.logError("Tried scrolling the modal view thrice, but didn't find the bank name:-"+bankName);
                    }
                }
            }else {
                Logger.logError("Banks list modal view is not displayed to select the bank name:-" +bankName);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the bank picker");
        }
    }

    /**
     * Scroll to the bank name
     * @param bankName
     */
    public static int scrollToTheBankName(String bankName) {
        Logger.logAction("Scrolling to the bank name :- "+bankName);
        Integer bankCellNumber=8;
        List<WebElement> listOfBanksDisplayed = null;
        Logger.logAction("Scrolling to the bank name:-" +bankName);
        try {
            Thread.sleep(Labels.WAIT_TIME_MIN);
            listOfBanksDisplayed = driver.findElements(By.className("android.widget.CheckedTextView"));
            for (int index=0; index<=listOfBanksDisplayed.size()-1;index++) {
                String eachCellName = listOfBanksDisplayed.get(index).getText();
                if (eachCellName.equals(bankName)) {
                    Logger.logComment(bankName + " is displayed and tapping on it");
                    bankCellNumber = index;
                    return bankCellNumber;
                } else {
                    Logger.logComment(index+" - times trying to find the element name:-" +bankName);
                }
            }
            scrollTheScreenUpwards();
            Logger.logComment("Unable to find the element -"+bankName+" - so scrolling the screen upwards");
            listOfBanksDisplayed = driver.findElements(By.className("android.widget.CheckedTextView"));
            for (int indexCount = 0; indexCount <= listOfBanksDisplayed.size()-1; indexCount++) {
                String eachCellCountName = listOfBanksDisplayed.get(indexCount).getText();
                if (eachCellCountName.equals(bankName)) {
                    Logger.logComment(bankName + " is displayed and tapping on it");
                    bankCellNumber = indexCount;
                    return bankCellNumber;
                } else {
                    Logger.logComment(indexCount+" - times trying to find the element name:-" +bankName);
                }
        }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll the screen");
        }
        return  bankCellNumber;
    }

    /**
     * Enter the card number
     */
    @Override
    public void enterCardNumber() {
        Logger.logAction("Tapping on card number text field");
        try{
            Thread.sleep(Labels.WAIT_TIME_MIN);
            if (isElementDisplayedByXPath(XPATH_OF_CARD_NUMBER_VIEW)){
                WebElement cardNumberView = driver.findElementByXPath(XPATH_OF_CARD_NUMBER_VIEW);
                List<WebElement> getTheCardNumberTextFieldId = cardNumberView.findElements(By.className("android.widget.EditText"));
                String xPathOfCardNumberTextField = XPATH_OF_CARD_NUMBER_VIEW+"/android.widget.EditText["+getTheCardNumberTextFieldId.size()+"]";
                Thread.sleep(Labels.WAIT_TIME_MIN);
//                ((WebDriver)driver).findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[5]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.GridView/android.view.View[3]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText["+getTheCardNumberTextFieldId.size()+"]")).sendKeys("0000000001");

//                if (isElementDisplayedByXPath(xPathOfCardNumberTextField)){
                    Logger.logStep("Entering the card number");
//                    MobileDriver mobileDiver = new Driver();
                    // Logic one
//                    MobileElement cardNumberTextField = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(xPathOfCardNumberTextField));
////                    driver.tap(1,cardNumberTextField,Labels.DEFAULT_TAP_DURATION);
////                    cardNumberTextField.sendKeys(Labels.KNET_PAYMENT_CARD_NUMBER);
//                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0);
//                    ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0);
//
//                ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.ACTION_DOWN);
//                ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.ACTION_DOWN);


//                    cardNumberTextField.setId(Labels.KNET_PAYMENT_CARD_NUMBER);
//                    cardNumberTextField.sendKeys(Labels.KNET_PAYMENT_CARD_NUMBER);
//
//                    MobileElement cardNumberTextField2 = (MobileElement) driver.findElementByXPath(xPathOfCardNumberTextField);
//                    cardNumberTextField2.setId(Labels.KNET_PAYMENT_CARD_NUMBER);
//                    cardNumberTextField2.setId(Labels.KNET_PAYMENT_CARD_NUMBER);
//                    cardNumberTextField2.setId(Labels.KNET_PAYMENT_CARD_NUMBER);


                    // Logic two
                    Set<String> contextName = driver.getContextHandles();
                    if (contextName.contains("WEBVIEW_chrome")){
//                        driver.context("WEBVIEW_chrome");
//                        ChromeDriver driverdriver = new ChromeDriver(ChromeDriverService.createDefaultService());
//                        driverdriver = new ChromeDriver(new URL(Labels.ANDROID_CAPABILITIES_URL), capabilities);
                        driver.findElement(By.xpath(xPathOfCardNumberTextField)).click();
                        driver.context("WEBVIEW_chrome").findElement(By.xpath(xPathOfCardNumberTextField)).sendKeys("0000000001");

//                    String cardNumber = driver.findElement(By.xpath(xPathOfCardNumberTextField)).getAttribute("resource-id");
//                    ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiSelector().id(\"" + xPathOfCardNumberTextField + "\")").sendKeys(Labels.KNET_PAYMENT_CARD_NUMBER);
//                        driver.findElementByXPath(xPathOfCardNumberTextField).sendKeys(Labels.KNET_PAYMENT_CARD_NUMBER);
//                    driver.context("NATIVE_APP");

                    }else {
//                        ((ChromeDriver) driver).findElement(By.xpath(xPathOfCardNumberTextField)).sendKeys("0000000001");

                        driver.findElementByXPath(xPathOfCardNumberTextField).sendKeys(Labels.KNET_PAYMENT_CARD_NUMBER);
                    }


//                    driver.findElementByXPath(xPathOfCardNumberTextField).click();
//                    driver.getKeyboard().sendKeys(Labels.KNET_PAYMENT_CARD_NUMBER);
//                    driver.findElementByXPath(xPathOfCardNumberTextField).sendKeys(Labels.KNET_PAYMENT_CARD_NUMBER);
//                    Thread.sleep(Labels.WAIT_TIME_MIN);
//                    driver.hideKeyboard();
//                }
//                else {
//                    Logger.logError("Card number text field index is incorrect");
//                }
            }else {
                Logger.logError("Card number field is not displayed");
            }
        }catch (Exception exception){
            exception.printStackTrace();
            Logger.logError("Encountered error: Unable to check the element name by Xpath :- \n" + XPATH_OF_CARD_NUMBER_VIEW);
        }
    }
    /**
     * Enter the Pin number
     */
    @Override
    public void enterPinNumber() {
        Logger.logAction("Tapping on pin number text field");
        try{
            if (isElementDisplayedById(PIN_TEXTFIELD)){
                WebElement pinNumberTextField = driver.findElementById(PIN_TEXTFIELD);
//                pinNumberTextField.click();
                Logger.logStep("Entering the pin number");
                pinNumberTextField.sendKeys(Labels.KNET_PAYMENT_CARD_PIN_NUMBER);
                Thread.sleep(Labels.WAIT_TIME_MIN);
                driver.hideKeyboard();
            }else {
                Logger.logError("Card number field is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name by Xpath :- \n" + PIN_TEXTFIELD);
        }
    }

    /**
     * Tap on Submit button
     */
    @Override
    public void tapOnSubmitButton() {
        Logger.logAction("Tapping on submit button");
        try{
            if (isElementDisplayedById(SUBMIT_BUTTON)){
                driver.findElementById(SUBMIT_BUTTON).click();
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
            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ACTIVITY_INDICATOR)));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(POST_TRANSACTIONS_SCREEN)));
            if (isElementDisplayedById(POST_TRANSACTIONS_SCREEN)){
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
            if (isElementDisplayedById(CONFIRM_BUTTON)){
                driver.findElementById(CONFIRM_BUTTON).click();
            }else {
                Logger.logError("Confirm button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the element name :- " + CONFIRM_BUTTON);
        }
    }

    /**
     * Check the booking is success
     */
    @Override
    public void checkTheKnetBookingProcessIsSuccess() {
        Logger.logAction("Checking Booking is success or not ?");
        try {
            if (isElementDisplayedByName(ACTIVITY_INDICATOR)){
                Logger.logComment("Booking process is started");
                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ACTIVITY_INDICATOR)));
                if (isElementDisplayedById("com.app.rehlat:id/paymentDoneLayout")){
                    Logger.logStep("Payment is success");
                }else if (isElementDisplayedById("com.app.rehlat:id/paymentFailureLayout")){
                    String errorCause = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]").getText();
                    Logger.logComment("Payment id failed due to :- " +errorCause);
                }
//                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(TRANSACTION_IN_PROGRESS)));
//                Logger.logComment(TRANSACTION_IN_PROGRESS);
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(TRANSACTION_IN_PROGRESS)));
//                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(PAYMENT_SUCCESS)));
//                Logger.logComment(PAYMENT_SUCCESS);
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(PAYMENT_SUCCESS)));
//                driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(BOOKING_SUCCESS)));
//                Logger.logComment(PAYMENT_SUCCESS);
            }else {
                Logger.logError("Activity indicator is not displayed, looks like booking process is not started");
            }
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
            enterCreditOrDebitCardExpiryMonth();
            enterCreditOrDebitCardExpiryYear();
            enterCreditOrDebitCardCvvNumber();
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
            if (isElementDisplayedById("com.app.rehlat:id/numberTextInputLayout")){
                driver.findElement(By.id("com.app.rehlat:id/numberTextInputLayout")).sendKeys("4242424242424242");
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- ");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter credit or debit expiry month and year
     */
    public static void enterCreditOrDebitCardExpiryMonth() {
        Logger.logAction("Entering the credit or debit card Expiry month");
        try {
            if (isElementDisplayedById("com.app.rehlat:id/mmEditText")){
                driver.findElement(By.id("com.app.rehlat:id/mmEditText")).sendKeys("05");
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- ");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter credit or debit expiry year
     */
    public static void enterCreditOrDebitCardExpiryYear() {
        Logger.logAction("Entering the credit or debit card Expiry year");
        try {
            if (isElementDisplayedById("com.app.rehlat:id/yearEditText")){
                driver.findElement(By.id("com.app.rehlat:id/yearEditText")).sendKeys("2021");
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- ");
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error: Unable to enter the credit or debit card details");
        }
    }

    /**
     * Enter credit or debit card cvv number
     */
    public static void enterCreditOrDebitCardCvvNumber() {
        Logger.logAction("Entering the credit or debit card CVV number");
        try {
            if (isElementDisplayedById("com.app.rehlat:id/cvv")){
                driver.findElement(By.id("com.app.rehlat:id/cvv")).sendKeys("100");
            }else {
                Logger.logError("Element name is not displayed in the current active screen:- ");
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
                if (isElementDisplayedById("com.app.rehlat:id/nameTextInputLayout")){
                    driver.findElement(By.id("com.app.rehlat:id/nameTextInputLayout")).sendKeys("rehlatAutomation");
                }else {
                    Logger.logError("Element name is not displayed in the current active screen:- ");
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
            if (isElementDisplayedById("com.app.rehlat:id/checkoutPayButton")){
                driver.findElement(By.id("com.app.rehlat:id/checkoutPayButton")).click();
            }else {
                driver.findElement(By.id("com.app.rehlat:id/checkoutPayButton")).click();
//                Logger.logError("Element name is not displayed in the current active screen:- ");
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
            if (isElementDisplayedByXPath("//XCUIElementTypeOther[@name=\"Checkout 3D Simulator\"]/XCUIElementTypeOther[5]/XCUIElementTypeSecureTextField")){
                driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Checkout 3D Simulator\"]/XCUIElementTypeOther[5]/XCUIElementTypeSecureTextField")).sendKeys("Checkout1!");
            }else {
                driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Checkout 3D Simulator\"]/XCUIElementTypeOther[5]/XCUIElementTypeSecureTextField")).sendKeys("Checkout1!");
//                Logger.logError("Element name is not displayed in the current active screen:- ");
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
            if (isElementDisplayedById("PAY SECURELY")){
                driver.findElement(By.id("PAY SECURELY")).click();
            }else {
                driver.findElement(By.id("PAY SECURELY")).click();
//                Logger.logError("Element name is not displayed in the current active screen:- ");
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
            if (isElementDisplayedByClassName(ACTIVITY_INDICATOR)){
                Logger.logComment("Booking process is started");
                if (isElementDisplayedByName(TRANSACTION_IN_PROGRESS)){
                    Logger.logComment(TRANSACTION_IN_PROGRESS);
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            Logger.logComment(PAYMENT_SUCCESS);
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            Logger.logComment(PAYMENT_SUCCESS);
                        }else {
                            Logger.logError("Booking process is unsuccessful");
                        }
                    }
                }else {
                    if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            Logger.logComment(PAYMENT_SUCCESS);
                        }else {
                            Logger.logError("Booking process is failed");
                        }
                    }else {
                        if (isElementDisplayedByName(BOOKING_SUCCESS)){
                            Logger.logComment(BOOKING_SUCCESS);
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
                        Logger.logComment(PAYMENT_SUCCESS);
                    }else {
                        Logger.logError("Booking process is failed");
                    }
                }else {
                    if (isElementDisplayedByName(BOOKING_SUCCESS)){
                        Logger.logComment(PAYMENT_SUCCESS);
                    }else {
                        Logger.logError("Booking process is unsuccessful");
                    }
                }
            }else if (isElementDisplayedByName(PAYMENT_SUCCESS)){
                Logger.logComment(PAYMENT_SUCCESS);
                if (isElementDisplayedByName(BOOKING_SUCCESS)){
                    Logger.logComment(PAYMENT_SUCCESS);
                }else {
                    Logger.logError("Booking process is failed");
                }
            }else {
                if (isElementDisplayedByName(BOOKING_SUCCESS)){
                    Logger.logComment(BOOKING_SUCCESS);
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
