package com.automation.rehlat.tests;

import com.automation.rehlat.Base;
import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.pages.BasePage;
import com.automation.rehlat.pages.bookingPage.BookingPageBase;
import com.automation.rehlat.pages.flights.FlightsBase;
import com.automation.rehlat.pages.flightsSearchResults.FlightsSearchResultsBase;
import com.automation.rehlat.pages.flightsSimilarOptionsSearchResults.FlightsSimilarOptionsSearchResultsBase;
import com.automation.rehlat.pages.menu.MenuBase;
import com.automation.rehlat.pages.myProfile.MyProfileBase;
import com.automation.rehlat.pages.myTrips.MyTripsBase;
import com.automation.rehlat.pages.paymentOptions.PaymentOptionsBase;
import com.automation.rehlat.pages.referYourFriends.ReferYourFriendsBase;
import com.automation.rehlat.pages.reviewBooking.ReviewBookingBase;
import com.automation.rehlat.pages.settings.SettingsBase;
import com.automation.rehlat.pages.signIn.SignInBase;
import com.automation.rehlat.pages.signUp.SignUpBase;
import com.automation.rehlat.pages.travellerDetails.TravellerDetailsBase;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.automation.rehlat.Labels.setCountryLanguageAndAirportFromAndToLabels;
import static com.automation.rehlat.pages.constructors.PageConstructor.initializePageObject;


/**
 * Basic actions to be done before the test script execution starts
 */
public class BaseTest extends Base {
    ////////////////////////////// Common Strings Used In All The Tests //////////////////////////////////////
    public static final String SELECT_LANGUAGE = "Select Language";
    public static final String IOS_USER_LOCATION_ACCESS = "Allow “Rehlat” to access your location while you are using the app?";
    public static final String ANDROID_PERMISSION_ALERT_ID = "ccom.android.packageinstaller:id/perm_desc_root";
    public static final String ANDROID_ALLOW_PERMISSION_POPUP_BUTTON = "com.android.packageinstaller:id/permission_allow_button";
    public static final String ANDROID_USER_LOCATION_ACCESS = "Allow Rehlat to access this device's location?";
    public static final String NOTIFICATION_ACCEPTANCE = "“Rehlat” Would Like to Send You Notifications";
    public static final String IOS_ALLOW_BUTTON = "Allow";
    public static final String ANDROID_ALLOW_BUTTON = "com.android.packageinstaller:id/permission_allow_button";
    public static final String DONT_ALLOW_BUTTON = "Don’t Allow";
    public static final String DENY = "DENY";
    public static final String ANDROID_SPLASH_SCREEN = "com.app.rehlat:id/splash_please_wait_dots";
    public static final String SPLASH_SCREEN_ID = "com.app.rehlat:id/splash_please_wait_dots";
    public static final String SPLASH_SCREEN = "android.widget.ImageView";

    ////////////////////////////// Strings Related To The WorkFlows //////////////////////////////////////
    public static final String INTERNATIONALS_TRAVELLERS_COUNTRY_NAME = "Kuwait";
    public static final String DOMESTIC_TRAVELLERS_COUNTRY_NAME = "India";

    public static final String KUWAIT_AIRPORT_NAME_XPATH_IN_SEARCH_RESULTS = "//XCUIElementTypeStaticText[@name=\"Kuwait - Kuwait Intl - Kuwait\"]";
    public static final String DEPARTURE_DAY = "2";
    public static final String RETURN_DAY = "5";
    public static final String CELL_NUMBER_OF_FLIGHT_SEARCH_RESULTS = "2"; // For Android should give number less than 3, because flight card ids/xpaths are reset to 1 to 4 only
    public static final String CELL_NUMBER_OF_FLIGHT_SEARCH_RESULTS_WHEN_SOLDOUT_POPUP_INTERRUPTRED = "1"; // For Android should give number less than 3, because flight card ids/xpaths are reset to 1 to 4 only
    public static final String TESTING_BANK_CARD = "Knet Test Card [KNET1]";



    ////////////////////////////// Initialising The Screen Names W.R.T. The Screen Base Names //////////////////////////////////////
    public static FlightsBase FlightsScreen;
    public static MenuBase MenuScreen;
    public static SignInBase SignInScreen;
    public static SignUpBase SignUpScreen;
    public static FlightsSearchResultsBase FlightsSearchResultsScreen;
    public static FlightsSimilarOptionsSearchResultsBase FlightsSimilarOptionsSearchResultsScreen;
    public static ReviewBookingBase ReviewBookingScreen;
    public static BookingPageBase BookingPageScreen;
    public static TravellerDetailsBase TravellerDetailsScreen;
    public static PaymentOptionsBase PaymentOptionsScreen;
    public static MyProfileBase MyProfileScreen;
    public static ReferYourFriendsBase ReferYourFriendsScreen;
    public static MyTripsBase MyTripsScreen;
    public static SettingsBase SettingsScreen;





    ////////////////////////////// Before Class For All The Base Tests Folder //////////////////////////////////////
    @BeforeClass
    public static void setUp() throws Exception{
        Base.setUp();
        BasePage.setUp();

        initializePageObject("signIn", Labels.platform);
        initializePageObject("flights", Labels.platform);
        initializePageObject("menu", Labels.platform);
        initializePageObject("signUp", Labels.platform);
        initializePageObject("flightsSearchResults", Labels.platform);
        initializePageObject("flightsSimilarOptionsSearchResultsScreen", Labels.platform);
        initializePageObject("reviewBookingScreen", Labels.platform);
        initializePageObject("bookingPageScreen", Labels.platform);
        initializePageObject("travellerDetailsScreen", Labels.platform);
        initializePageObject("paymentOptionsScreen", Labels.platform);
        initializePageObject("myProfileScreen", Labels.platform);
        initializePageObject("referYourFriendsScreen", Labels.platform);
        initializePageObject("myTrips", Labels.platform);
        initializePageObject("settings", Labels.platform);





        checkAndWaitTillTheSplashScreenIsInvisible();
        setCountryLanguageAndAirportFromAndToLabels();
//        runTheLiveApp();
//        acceptAutoAlertsIfDisplayed();
    }

//    /**
//     *Run the live app by pushing the testing build to background
//     */
//    public static void runTheLiveApp() throws Exception{
//        try {
////            driver.runAppInBackground(800);
//            if (Labels.platform.equals(Labels.ANDROID)){
//
//            }else if (Labels.platform.equals(Labels.IOS)){
//            {
//
//                }
//            }
//        }catch (Exception exception){
//            Logger.logError("Unable to run the live app");
//        }
//    }
    /**
     * Auto accepting the alerts
     */
    public static void acceptAutoAlertsIfDisplayed() {
        Logger.logStep("Auto accepting alerts if displayed");
        try
        {
        if (Labels.platform.equals(Labels.IOS))
        {
            acceptUserLocationAlertInIos();
            acceptNotificationAlertInIos();
        }else if (Labels.platform.equals(Labels.ANDROID))
        {
            checkAndWaitTillTheSplashScreenIsInvisible();
            acceptUserLocationAlertInAndroid();
//            acceptNotificationAlertInAndroid(); // Notifications alert is by default allowed in the android app [While installing the app from google store user needs to accept notifications alert]
        }else {
                Logger.logWarning("The platform mentioned for the test script is neither iOS or Android");
        }
        }catch (Exception elementNotFound){
            Logger.logError("Alerts are causing problems and not able to execute the test script");
        }
    }

    /**
     * Creating new sign up email id every time when the new test script run...,Logic: Base email id should be changed in between the range of 101 to 109..,Eg: Base-101 then for every test script should create one new signup email id as 111,121,131,141,..,191..[Formula: Base Email id + 10]
     */
    public static void createNewSignUpEmailId() {
        Logger.logStep("Creating new sign up email id for the current test run");
        Integer newEmailNumber ;
        try {
            if (Labels.WDA_LOCAL_PORT=="8001" || Labels.WDA_LOCAL_PORT=="8010" ){
                String BASE_EMAIL_ID_FOR_SIGN_UP = "rehlatAutomationPort1TestingEmail";
                String MAIL_OPERATOR = "@gmail.com";
                String currentEmailIdForSignUp = Labels.EMAIL_ID_SIGN_UP_PORT_1;
                Integer currentEmailIdNumber = Integer.valueOf(currentEmailIdForSignUp.substring(33, 36));
                for (int index = 0; index <= 999; index++) {
                    Integer settingEmailValue = index;
                    if (settingEmailValue == currentEmailIdNumber) {
                        newEmailNumber = settingEmailValue + 1;
                        String newEmailId = BASE_EMAIL_ID_FOR_SIGN_UP + newEmailNumber + MAIL_OPERATOR;
                        Labels.EMAIL_ID_SIGN_UP = newEmailId;
                        Labels.EMAIL_ID_SIGN_UP_PORT_1 = newEmailId;
                        break;
                    }
                }
                Logger.logComment("Newly created email id for to the current test run is :-  " + Labels.EMAIL_ID_SIGN_UP);
            }else if(Labels.WDA_LOCAL_PORT =="8005"|| Labels.WDA_LOCAL_PORT=="8015"){
                String BASE_EMAIL_ID_FOR_SIGN_UP = "rehlatAutomationPort2TestingEmail";
                String MAIL_OPERATOR = "@gmail.com";
                String currentEmailIdForSignUp = Labels.EMAIL_ID_SIGN_UP_PORT_2;
                Integer currentEmailIdNumber = Integer.parseInt(currentEmailIdForSignUp.substring(33, 36));
                for (int index = 0; index <= 999; index++) {
                    Integer settingEmailValue = index;
                    if (settingEmailValue == currentEmailIdNumber) {
                        newEmailNumber = settingEmailValue + 1;
                        String newEmailId = BASE_EMAIL_ID_FOR_SIGN_UP + newEmailNumber + MAIL_OPERATOR;
                        Labels.EMAIL_ID_SIGN_UP = newEmailId;
                        Labels.EMAIL_ID_SIGN_UP_PORT_2 = newEmailId;
                        break;
                    }
                }
                Logger.logComment("Newly created email id for to the current test run is :-  " + Labels.EMAIL_ID_SIGN_UP);
            }else {
                Logger.logError("Encountered error: Unable to get the current WDA LOCAL PORT..,");
            }
        }catch (Exception elementNotFound){
            Logger.logError("Encountered error: Unable to create new email id");
        }
    }

    /**
     * Accepting the User location alerts in iOS
     * @throws Exception
     */
    public static void acceptUserLocationAlertInIos() throws Exception {
        Logger.logStep("Accepting location alert");
        if (isElementDisplayedByName(SELECT_LANGUAGE)) {
            Logger.logComment("Location alert is not displayed, moving to test case execution");
        } else {
            if (isElementDisplayedByName(IOS_USER_LOCATION_ACCESS)) {
                Logger.logComment("Location access alert is displayed and accepting it");
                driver.findElement(By.name(IOS_ALLOW_BUTTON)).click();
                Logger.logComment("Tapped on Allow button");
            } else {
                Logger.logComment("Location alert is not displayed, moving to next alert verification");
            }
        }
    }

    /**
     * Decline the User location alerts in iOS
     * @throws Exception
     */
    public static void declineUserLocationAlertInIos() throws Exception {
        Logger.logStep("Accepting location alert");
        if (isElementDisplayedByName(SELECT_LANGUAGE)) {
            Logger.logComment("Location alert is not displayed, moving to test case execution");
        } else {
            if (isElementDisplayedByName(IOS_USER_LOCATION_ACCESS)) {
                Logger.logComment("Location access alert is displayed and declining it");
                driver.findElement(By.name(DONT_ALLOW_BUTTON)).click();
                Logger.logComment("Tapped on don't allow button");
            } else {
                Logger.logComment("Location alert is not displayed, moving to next alert verification");
            }
        }
    }

    /**
     * Accepting the User location in iOS
     * @throws Exception
     */
     public static void acceptNotificationAlertInIos() throws Exception{
         Logger.logStep("Accepting notification alert");
         if(isElementDisplayedByName(SELECT_LANGUAGE)){
             Logger.logComment("Location alert is not displayed, moving to test script execution");
         }else{
             if (isElementDisplayedByName(NOTIFICATION_ACCEPTANCE)){
                 Logger.logComment("Notification Acceptance access alert is displayed and accepting it");
                 driver.findElement(By.name(IOS_ALLOW_BUTTON)).click();
                 Logger.logComment("Tapped on allow button");
             }else{
                 Logger.logComment("Notification alert is not displayed, moving to test script execution");
             }
         }
     }

    /**
     * Decline the User location in iOS
     * @throws Exception
     */
    public static void declineNotificationAlertInIos() throws Exception{
        Logger.logStep("Accepting notification alert");
        if(isElementDisplayedByName(SELECT_LANGUAGE)){
            Logger.logComment("Location alert is not displayed, moving to test script execution");
        }else{
            if (isElementDisplayedByName(NOTIFICATION_ACCEPTANCE)){
                Logger.logComment("Notification Acceptance access alert is displayed and declining it");
                driver.findElement(By.name(DONT_ALLOW_BUTTON)).click();
                Logger.logComment("Tapped on don't allow button");
            }else{
                Logger.logComment("Notification alert is not displayed, moving to test script execution");
            }
        }
    }

    /**
     * Accepting the User location alerts in Android
     * @throws Exception
     */
    public static void acceptUserLocationAlertInAndroid() throws Exception {
        Logger.logStep("Accepting location alert");
        if (isElementDisplayedByName(SELECT_LANGUAGE)) {
            Logger.logComment("Location alert is not displayed, moving to test case execution");
        } else {
            if (isElementDisplayedById("com.android.packageinstaller:id/permission_message")){
                String permissionAlert = driver.findElementById("com.android.packageinstaller:id/permission_message").getText();
                if (permissionAlert.equals(ANDROID_USER_LOCATION_ACCESS)) {
                    Logger.logComment("Location access alert is displayed and accepting it");
                    driver.findElement(By.id(ANDROID_ALLOW_BUTTON)).click();
                    Logger.logComment("Tapped on allow button");
                } else {
                    Logger.logComment("Location alert is not displayed, moving to next alert verification");
                }
            }else {
                Logger.logComment("Location alert is not displayed and moving to next step");
            }

        }
    }

    /**
     * Accepting the User location in Android
     * @throws Exception
     */
    public static void acceptNotificationAlertInAndroid() throws Exception{
        Logger.logStep("Accepting notification alert");
        if(isElementDisplayedByName(SELECT_LANGUAGE)){
            Logger.logComment("Location alert is not displayed, moving to test script execution");
        }else{
            if (isElementDisplayedByName(NOTIFICATION_ACCEPTANCE)){
                Logger.logComment("Notification Acceptance access alert is displayed and accepting it");
                driver.findElement(By.id(ANDROID_ALLOW_BUTTON)).click();
                Logger.logComment("Tapped on allow button");
            }else{
                Logger.logComment("Notification alert is not displayed, moving to test script execution");
            }
        }
    }

    /**
     * Check the splash screen is displayed and waits till invisibility of the splash screen (Implemented only for android platform)
     */
    public static void checkAndWaitTillTheSplashScreenIsInvisible() {
        Logger.logStep("Checking splash screen is displayed or not ?");
        try {
            if (Labels.platform.equals(Labels.ANDROID)){
                if (isElementDisplayedById(ANDROID_SPLASH_SCREEN)){
                    Logger.logComment("Splash screen is displayed and waiting till the screen is invisible");
                    driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(ANDROID_SPLASH_SCREEN)));
                }else {
                    Logger.logComment("Splash screen is not displayed and moving forward to basic test(s)");
                }
            }else if (Labels.platform.equals(Labels.IOS)) {
                Logger.logComment("No Splash screen for iOS Device on launching multiple times");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the current active screen name");
        }
    }

    /**
     * Used to take a screen shot of the screen when ever sold out popup is is displayed.
     * @return void
     */
    public static void takeScreenshotAndSaveInSoldOutsFolder() {
        try {
            Logger.logComment(" Failure in the script, so taking the screenshot");
            String nameOfTestCase = getTestCaseName();
            String pathOfScreenshot = "Screenshots/SoldOut"+ nameOfTestCase + "_" + getPlatform();
            String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            System.out.println(new File(pathOfScreenshot + "_" + time + ".jpg"));
            File screenshot = driver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(pathOfScreenshot + "_" + time + ".jpg"));
        } catch (Exception e) {
            Logger.logWarning(" couldn't take screenshot");
        }
    }
}
