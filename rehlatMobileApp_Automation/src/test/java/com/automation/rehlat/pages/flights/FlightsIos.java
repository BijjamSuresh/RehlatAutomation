package com.automation.rehlat.pages.flights;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import static com.automation.rehlat.tests.BaseTest.SELECT_LANGUAGE;


public class FlightsIos extends FlightsBase {

    public static final String FROM_TEXTFIELD = "FROM";
    public static final String TO_TEXTFIELD = "TO";
    public static final String IOS_KEYBOARD = "XCUIElementTypeKeyboard";
    public static final String IOS_KEYBOARD_XPATH = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeKeyboard";
    public static final String SEARCH_VIEW = "Rehlat.SearchView";
    public static final String IN_PROGRESS_LOADING_INDIACATOR = "In progress";
    public static final String SEARCH_TEXTFIELD = "Kuwait - Kuwait Intl - Kuwait";
    public static final String SEARCH_TEXTFIELD_XPATH = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
    public static final String CONTINUE_BUTTON = "CONTINUE";
    public static final String MENU_BUTTON = "menu";
    public static final String SEARCH_BUTTON = "Search";
    public static final String DEPARTURE_BUTTON = "Departure";
    public static final String RETURN_BUTTON = "Return";
    public static final String DONE_BUTTON_IN_CALENDAR_VIEW = "Done";
    public static final String ONE_WAY_IN_ARABIC_LANGUAGE = "الذهاب فقط";
    public static final String ONE_WAY_IN_ENGLISH_LANGUAGE = "ONE-WAY";
    public static final String XPATH_OF_SELECT_COUNTRY_SHEET = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeTable";
    public static final String XPATH_OF_MONTH_AND_DAY_DEPARTURE_IN_CALENDAR_VIEW = "(//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther";
    public static final String XPATH_OF_MONTH_DEPARTURE_IN_CALENDAR_VIEW = "(//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther";
    public static final String CALENDER_MODAL_VIEW_XPATH = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeCollectionView";
    protected static String CURRENT_MONTH = "Jul";
    public static final String[] listOfElementsInFlightsTab = {"ONE-WAY","ROUND-TRIP","FROM","TO","Departure","Return","ADULTS","CHILDREN","INFANTS","ECONOMY","BUSINESS","FIRST","Search"};
    public static final String XPATH_OF_ADULTS_PLUS_BUTTON = "(//XCUIElementTypeButton[@name=\"+\"])[1]";
    public static final String XPATH_OF_CHILDREN_PLUS_BUTTON = "(//XCUIElementTypeButton[@name=\"+\"])[2]";
    public static final String XPATH_OF_INFANTS_PLUS_BUTTON = "(//XCUIElementTypeButton[@name=\"+\"])[3]";
    public static final String SWAP_BUTTON = "rotationalSearch";



    /**
     * Check select language modal is displayed
     */
    @Override
    public boolean isSelectLanguageModalIsDisplayed() {
        Logger.logAction("checking the select language modal is displayed or not ?");
        try{
            if (isElementDisplayedByName(SELECT_LANGUAGE)){
                Logger.logStep("Select Language modal is displayed");
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            Logger.logWarning("Select Language Modal is not displayed");
        }
        return false;
    }

    /**
     * Get the position of current active user location country name
     * @return
     */
    @Override
    public String getTheLastPositionCountryNameInSelectCountryLayout(){
        Logger.logAction("Getting the position of current active user location country name");
        try{
            if (isElementDisplayedByXPath(XPATH_OF_SELECT_COUNTRY_SHEET)){
                WebElement selectCountrySheet = driver.findElementByXPath(XPATH_OF_SELECT_COUNTRY_SHEET);
                List<WebElement> listOfCountries = selectCountrySheet.findElements(By.className(Labels.IOS_XCUI_ELEMENT_TYPE_CELL));
                String nameOfTheLastLabel = listOfCountries.get(listOfCountries.size()-1).findElement(By.className(Labels.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT)).getAttribute(Labels.VALUE_ATTRIBUTE);
                if (nameOfTheLastLabel.equalsIgnoreCase(Labels.INDIA_LANGUAGE_COUNTRY_LABEL) || nameOfTheLastLabel.equalsIgnoreCase(Labels.OTHERS_COUNTRY_LABEL)){
                    return nameOfTheLastLabel;
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the position of India country Name");
        }
        return null;
    }

    /**
     * Tapping on menu button
     */
    @Override
    public void tapOnMenuButton() {
        Logger.logAction("Tapping on menu button");
        try {
            if (isElementDisplayedByName(MENU_BUTTON)){
                driver.findElement(By.name(MENU_BUTTON)).click();
                Logger.logStep("Tapped on Menu button");
            }else{
                Logger.logError("Menu button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the flights screen name");
        }
    }

    /**
     * Check the flights tab is displayed
     */
    @Override
    public void checkFlightsTabIsDisplayed() {
        Logger.logAction("Checking flights screen tab is displayed");
        try {
            Thread.sleep(Labels.WAIT_TIME_MIN);
            if (isElementDisplayedByName(MENU_BUTTON)){
                String menuButton = driver.findElementByName(MENU_BUTTON).getAttribute(Labels.VISIBLE_ATTRIBUTE);
                if (menuButton.equals(Labels.STATUS_TRUE)){
                    Logger.logStep("Flights Screen is displayed");
                }else{
                    Logger.logError("Flights screen is not displayed");
                }
            }else{
                Logger.logError("Menu button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the flights screen name");
        }
    }

    /**
     * Selects the country name of the user
     * @param userCountryName
     */
    public void selectCountryOfUser(String userCountryName) {
        Logger.logAction("selecting the country of user");
        try{
            if (userCountryName.equals(Labels.INDIA_LANGUAGE_COUNTRY_LABEL)){
                if (isElementDisplayedByName(Labels.INDIA_LANGUAGE_COUNTRY_LABEL)){
                    driver.findElementByName(userCountryName).click();
                    Logger.logStep("Tapped on element - " +userCountryName);
                }else if (isElementDisplayedByName(Labels.OTHERS_COUNTRY_LABEL)){
                    driver.findElementByName(Labels.OTHERS_COUNTRY_LABEL).click();
                    Logger.logStep("Tapped on element - " +Labels.OTHERS_COUNTRY_LABEL);
                }else {
                    Logger.logError(userCountryName+" :- element name is not displaying in the current active screen");
                }
            } else if (isElementDisplayedByName(userCountryName)){
                driver.findElementByName(userCountryName).click();
                Logger.logStep("Tapped on element - " +userCountryName);
            }else {
                Logger.logError(userCountryName+" :- element name is not displaying in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the user country from select country modal");
        }
    }

    /**
     * Tap on Continue button
     */
    public void tapOnContinueButton() {
        try{
            if (isElementDisplayedByName(CONTINUE_BUTTON)){
                driver.findElementByName(CONTINUE_BUTTON).click();
                Logger.logStep("Tapped on Continue button");
            }else{
                Logger.logError("Unable to tap on continue button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error: Unable to tap on Continue button");
        }
    }

    /**
     * Select the country name and move to flights tab
     */
    @Override
    public void selectCountryNameInSelectLanguageModal(String countryName) {
        if (isSelectLanguageModalIsDisplayed()){
            selectCountryOfUser(countryName);
            tapOnContinueButton();
        }else{
            Logger.logStep("Select language modal is not displayed and moving to next test step");
        }
    }

    /**
     * Tap on From Text Field in flights tab
     */
    @Override
    public void tapOnFromTextField() {
        Logger.logAction("Tapping on From text field in flights tab");
        try {
            if (isElementEnabledById(FROM_TEXTFIELD)){
                driver.findElement(By.id(FROM_TEXTFIELD)).click();
                Logger.logStep("Tapped on FROM text field button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on From text field in flights tab ");
        }
    }

    /**
     * Tap on TO text field in flights tab
     */
    @Override
    public void tapOnToTextField() {
        try {
            if (isElementEnabledById(TO_TEXTFIELD)){
                driver.findElement(By.id(TO_TEXTFIELD)).click();
                Logger.logStep("Tapped on TO text field button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error: Unable to tap on TO text field");
        }
    }

    /**
     * Check keyboard is triggered or not
     */
    @Override
    public void checkKeyboardIsDisplayed() {
        Logger.logAction("Checking keyboard is triggered or not ?");
        try {
            // Commented code is used to handle the loading indicator displayed on first time navigating to search flight screen after fresh installation
//            if (isElementDisplayedByClassName(Labels.IOS_ACTIVITY_INDICATOR)){
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(Labels.IOS_ACTIVITY_INDICATOR)));
//            }else {
//                Logger.logAction("Activity indicator is not displayed in the current active screen");
//            }
            if (isKeyboardDisplayed()){
                Logger.logComment("Keyboard is triggered");
            }else{
                Logger.logError("Keyboard is not triggered");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify keyboard status");
        }
    }

    /**
     * Check the search view screen is displayed or not
     */
    @Override
    public void checkSearchViewScreenIsDisplayed() {
        Logger.logAction("Checking search view screen is displayed or not?");
        try{
            waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR);
            // Below if condition is added because on first launch loading indicator is displaying after tapping on FROM text field
//            if (isElementDisplayedByClassName(Labels.IOS_ACTIVITY_INDICATOR)){
//                driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(Labels.IOS_ACTIVITY_INDICATOR)));
//                Logger.logStep("Waiting till the loading indicator is invisible");
//                isElementDisplayedByName(SEARCH_VIEW);
//            }
//            else {
                if(isElementDisplayedByName(SEARCH_VIEW)){
                    Logger.logStep("Search view screen is displayed");
                }else {
                    Logger.logError("Search view screen is not displayed");
                }
//            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name");
        }
    }

    /**
     * Enter From place in search view
     */
    @Override
    public void enterAirportName(String fromPlace) {
        Logger.logAction("Entering the airport name :-"+fromPlace);
        try{
            sendTextByXpath(SEARCH_TEXTFIELD_XPATH,fromPlace);
            Logger.logComment(fromPlace+" :- value is parsed");
            closeTheKeyboard_iOS();
        }catch (Exception nullPointerException){
            Logger.logError("Encountered error: Unable to enter from place name in the search view");
        }
    }

    /**
     * Select the place name from search results of search view
     * @param airPortCodeOfPlaceName
     */
    @Override
    public void selectAirportCodeFromSearchResults(String airPortCodeOfPlaceName) {
        Logger.logAction("Selecting the airport code :-"+airPortCodeOfPlaceName);
        try {
            if (isElementDisplayedByName(airPortCodeOfPlaceName)){
                driver.findElementByName(airPortCodeOfPlaceName).click();
                Logger.logStep("Tapped on airport code :- "+airPortCodeOfPlaceName);
            }else{
                Logger.logError("Unable to tap on the airport code of place - " +airPortCodeOfPlaceName);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the airport code of place name from search results");
        }
    }

    /**
     * Tap on Departure button in flights tab
     */
    @Override
    public void tapOnDepartureDateBookingButton() {
        Logger.logAction("Tapping on departure button");
        try{
            if (isElementEnabledByName(DEPARTURE_BUTTON)){
                driver.findElement(By.name(DEPARTURE_BUTTON)).click();
                Logger.logStep("Tapped on departure button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on Departure button");
        }
    }

    /**
     * Tap on Return date booking button in flights tab
     */
    @Override
    public void tapOnReturnDateBookingButton() {
        Logger.logAction("Tapping on return button");
        try{
            if (isElementEnabledByName(RETURN_BUTTON)){
                driver.findElementByName(RETURN_BUTTON).click();
                Logger.logStep("Tapped on return button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on Departure button");
        }
    }

    /**
     * Select the departure date
     * @param departureMonthAndYear
     * @param departureDay
     */
    @Override
    public void selectDepartureDate(String departureMonthAndYear, String departureDay) {
        Logger.logAction("Selecting the departure date : Month & Year -" + departureMonthAndYear + ", Day - "+departureDay);
        try {
            if (isElementDisplayedByXPath(CALENDER_MODAL_VIEW_XPATH)){
                scrollToAnElementByName(departureMonthAndYear,true);
                // yet to implement an proper method to select the accurate departure date when multiple days with same name are displaying
                //                scrollToElementById("Dec 2018", true);
                //                scrollDown();
                //                scrollUp();
                if (isElementDisplayedByName(departureMonthAndYear)){
                    if (isElementEnabledByName(departureDay)) {
                        WebElement  calenderView = driver.findElementByClassName(Labels.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                        List<WebElement> departureDays = calenderView.findElements(By.name(departureDay));
                        int departureDaysSize = departureDays.size();
                        if (departureDaysSize >= 2){
                            Logger.logComment("More than one similar departure days are displayed in the calender view with same departure day: "+departureDay+"");
                            // Implement a logic that exactly taps on accurate day when there are multiple days with same name
//                            scr
//                            swipeOnElement(calenderView,DIRECTION_UP);
//                            swipeOnElement(calenderView,DIRECTION_DOWN);
                            if (departureDaysSize >= 2){
                                Logger.logWarning("More than one similar dates are displayed in the departure calender, so tapping on nearest possible date");
                                for (int count =0;count<=departureDays.size()-1;count++){
                                    WebElement visibleDepartureDay = departureDays.get(count);
                                    if (visibleDepartureDay.isDisplayed()){
                                        visibleDepartureDay.click();
                                        Logger.logComment("Tapped on day:- "+departureDay);
//                                        break;
                                    }else
                                    {
                                        continue;
                                    }
                                }
                            }else {
                                driver.findElementByName(departureDay).click();
                                Logger.logComment("Tapped on day:- "+departureDay);
                            }
                        }else {
                            Logger.logComment("One departure day is displayed in the calender: "+departureDay+"");
                            driver.findElementByName(departureDay).click();
                            Logger.logComment("Tapped on day:- "+departureDay);
                        }
                    }else {
                        Logger.logError("Accurate Date is not displayed in the departure");
                    }
                }else{
                    scrollToAnElementByName(departureMonthAndYear,false);
                    if (isElementDisplayedByName(departureMonthAndYear)){
                        if (isElementDisplayedByName(departureDay)) {
                            WebElement  calenderView = driver.findElementByClassName(Labels.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                            List<WebElement> departureDays = calenderView.findElements(By.name(departureDay));
                            int departureDaysSize = departureDays.size();
                            if (departureDaysSize >= 2){
                                Logger.logComment("More than one similar dates are displayed in the calender view with same departure day: "+departureDay+"");
                                // Implement a logic that exactly taps on accurate day when there are multiple days with same name
//                            scr
//                            swipeOnElement(calenderView,DIRECTION_UP);
//                            swipeOnElement(calenderView,DIRECTION_DOWN);
                                if (departureDaysSize >= 2){
                                    Logger.logWarning("More than one similar dates are displayed in the departure calender, so tapping on nearest possible date");
                                    for (int count =0;count<=departureDays.size()-1;count++){
                                        WebElement visibleDepartureDay = departureDays.get(count);
                                        if (visibleDepartureDay.isDisplayed()){
                                            visibleDepartureDay.click();
                                            Logger.logComment("Tapped on day:- "+departureDay);
                                            break;
                                        }else
                                        {
                                            continue;
                                        }
                                    }
                                }else {
                                    driver.findElementByName(departureDay).click();
                                    Logger.logComment("Tapped on day:- "+departureDay);
                                }
                            }else {
                                Logger.logComment("One departure day is displayed in the calender: "+departureDay+"");
                                driver.findElementByName(departureDay).click();
                                Logger.logComment("Tapped on day:- "+departureDay);
                            }
                        }else {
                            Logger.logError("Accurate Date is not displayed in the departure");
                        }
                    }else{
                    Logger.logWarning("Two accurate dates are displayed in the departure calender, so tapping on nearest possible date");
                    scrollToAnElementByName(departureMonthAndYear,true);
                    if (isElementDisplayedByName(departureDay)) {
                        driver.findElementByName(departureDay).click();
                    }else {
                        Logger.logError("Accurate Date is not displayed in the departure");
                    }
                }


//                if (isElementDisplayedByName("20")){
//                    driver.findElementByName("20").click();
//                    WebElement selectedDepartureDateMonthOne = driver.findElement(By.xpath(XPATH_OF_MONTH_AND_DAY_DEPARTURE_IN_CALENDAR_VIEW));
//                    String monthNameOne = selectedDepartureDateMonthOne.findElement(By.xpath(XPATH_OF_MONTH_DEPARTURE_IN_CALENDAR_VIEW)).getAttribute("name");
//                    if (monthNameOne.equals("Dec")){
//                        Logger.logComment("Departure date is accurately selected");
//                    }else{
//                        scrollDown();
//                        driver.findElementByName("20").click();
//                        WebElement selectedDepartureDateMonthTwo = driver.findElement(By.xpath(XPATH_OF_MONTH_AND_DAY_DEPARTURE_IN_CALENDAR_VIEW));
//                        String monthNameTwo = selectedDepartureDateMonthTwo.findElement(By.xpath(XPATH_OF_MONTH_DEPARTURE_IN_CALENDAR_VIEW)).getAttribute("name");
//                        if (monthNameTwo.equals("Dec")){
//                            Logger.logComment("Departure date is accurately selected");
//                        }else{
//                            scrollUp();
//                            driver.findElementByName("20").click();
//                            WebElement selectedDepartureDateMonthThree = driver.findElement(By.xpath(XPATH_OF_MONTH_AND_DAY_DEPARTURE_IN_CALENDAR_VIEW));
//                            String monthNameThree = selectedDepartureDateMonthThree.findElement(By.xpath(XPATH_OF_MONTH_DEPARTURE_IN_CALENDAR_VIEW)).getAttribute("name");
//                            if (monthNameThree.equals("Dec")){
//                                Logger.logComment("Departure date is accurately selected");
//                            }else{
//                                Logger.logError("Unable to tap on accurate departure date");
//                            }
//                        }
//                        }
//                    }else {
//                    scrollDown();
//                    driver.findElementByName("20").click();
                }
            }else{
                Logger.logError("Calendar view is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error: Unable to select the date in the date modal");
        }
    }

    /**
     * Select the return date
     * @param returnMonthAndYear
     * @param returnDay
     */
    @Override
    public void selectReturnDate(String returnMonthAndYear, String returnDay) {
        Logger.logAction("Selecting the return date : Month & Year -" + returnMonthAndYear + ", Day - "+returnDay);
        try {
            if (isElementDisplayedByXPath(CALENDER_MODAL_VIEW_XPATH)){
                scrollToAnElementByName(returnMonthAndYear,true);
                // yet to implement an proper method to select the accurate departure date when multiple days with same name are displaying
                //                scrollToElementById("Dec 2018", true);
                //                scrollDown();
                //                scrollUp();
                if (isElementDisplayedByName(returnMonthAndYear)){
                    if (isElementEnabledByName(returnDay)) {
                        WebElement  calenderView = driver.findElementByClassName(Labels.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                        List<WebElement> returnDays = calenderView.findElements(By.name(returnDay));
                        int returnDaysSize = returnDays.size();
                        if (returnDaysSize >= 2){
                            Logger.logComment("Two departure days are displayed in the calender view with same return day: "+returnDay+"");
                            // Implement a logic that exactly taps on accurate day when there are multiple days with same name
//                            scr
//                            swipeOnElement(calenderView,DIRECTION_UP);
//                            swipeOnElement(calenderView,DIRECTION_DOWN);
                            if (returnDaysSize >= 2){
                                Logger.logWarning("Two accurate dates are displayed in the return calender, so tapping on nearest possible date");
                                for (int count =0;count<=returnDays.size()-1;count++){
                                    WebElement visibleReturnDay = returnDays.get(count);
                                    if (visibleReturnDay.isDisplayed()){
                                        visibleReturnDay.click();
                                        Logger.logComment("Tapped on day:- "+visibleReturnDay);
                                    }else
                                    {
                                        continue;
                                    }
                                }
                            }else {
                                driver.findElementByName(returnDay).click();
                            }
                        }else {
                            Logger.logComment("One return day is displayed in the return calender: "+returnDay+"");
                            driver.findElementByName(returnDay).click();
                        }
                    }else {
                        Logger.logError("Accurate Date is not displayed in the departure");
                    }
                }else{
                    scrollToAnElementByName(returnMonthAndYear,false);
                    if (isElementDisplayedByName(returnMonthAndYear)){
                        if (isElementEnabledByName(returnDay)) {
                            WebElement  calenderView = driver.findElementByClassName(Labels.IOS_XCUI_ELEMENT_TYPE_COLLECTION_VIEW);
                            List<WebElement> returnDays = calenderView.findElements(By.name(returnDay));
                            int returnDaysSize = returnDays.size();
                            if (returnDaysSize >= 2){
                                Logger.logComment("Two departure days are displayed in the calender view with same return day: "+returnDay+"");
                                // Implement a logic that exactly taps on accurate day when there are multiple days with same name
//                            scr
//                            swipeOnElement(calenderView,DIRECTION_UP);
//                            swipeOnElement(calenderView,DIRECTION_DOWN);
                                if (returnDaysSize >= 2){
                                    Logger.logWarning("Two accurate dates are displayed in the return calender, so tapping on nearest possible date");
                                    for (int count =0;count<=returnDays.size()-1;count++){
                                        WebElement visibleReturnDay = returnDays.get(count);
                                        if (visibleReturnDay.isDisplayed()){
                                            visibleReturnDay.click();
                                            Logger.logComment("Tapped on day:- "+visibleReturnDay);
                                        }else
                                        {
                                            continue;
                                        }
                                    }
                                }else {
                                    driver.findElementByName(returnDay).click();
                                }
                            }else {
                                Logger.logComment("One return day is displayed in the return calender: "+returnDay+"");
                                driver.findElementByName(returnDay).click();
                            }
                        }else {
                            Logger.logError("Accurate Date is not displayed in the departure");
                        }
                    }else{
                        Logger.logWarning("Two accurate dates are displayed in the return calender, so tapping on nearest possible date");
                        scrollToAnElementByName(returnMonthAndYear,true);
                        if (isElementDisplayedByName(returnDay)) {
                            driver.findElementByName(returnDay).click();
                        }else {
                            Logger.logError("Accurate Date is not displayed in the return");
                        }
                    }

//                if (isElementDisplayedByName("20")){
//                    driver.findElementByName("20").click();
//                    WebElement selectedDepartureDateMonthOne = driver.findElement(By.xpath(XPATH_OF_MONTH_AND_DAY_DEPARTURE_IN_CALENDAR_VIEW));
//                    String monthNameOne = selectedDepartureDateMonthOne.findElement(By.xpath(XPATH_OF_MONTH_DEPARTURE_IN_CALENDAR_VIEW)).getAttribute("name");
//                    if (monthNameOne.equals("Dec")){
//                        Logger.logComment("Departure date is accurately selected");
//                    }else{
//                        scrollDown();
//                        driver.findElementByName("20").click();
//                        WebElement selectedDepartureDateMonthTwo = driver.findElement(By.xpath(XPATH_OF_MONTH_AND_DAY_DEPARTURE_IN_CALENDAR_VIEW));
//                        String monthNameTwo = selectedDepartureDateMonthTwo.findElement(By.xpath(XPATH_OF_MONTH_DEPARTURE_IN_CALENDAR_VIEW)).getAttribute("name");
//                        if (monthNameTwo.equals("Dec")){
//                            Logger.logComment("Departure date is accurately selected");
//                        }else{
//                            scrollUp();
//                            driver.findElementByName("20").click();
//                            WebElement selectedDepartureDateMonthThree = driver.findElement(By.xpath(XPATH_OF_MONTH_AND_DAY_DEPARTURE_IN_CALENDAR_VIEW));
//                            String monthNameThree = selectedDepartureDateMonthThree.findElement(By.xpath(XPATH_OF_MONTH_DEPARTURE_IN_CALENDAR_VIEW)).getAttribute("name");
//                            if (monthNameThree.equals("Dec")){
//                                Logger.logComment("Departure date is accurately selected");
//                            }else{
//                                Logger.logError("Unable to tap on accurate departure date");
//                            }
//                        }
//                        }
//                    }else {
//                    scrollDown();
//                    driver.findElementByName("20").click();
                }
            }else{
                Logger.logError("Calendar view is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error: Unable to select the date in the date modal");
        }
    }

    /**
     * Finds the current month and return it.
     * @return the CURRENT MONTH.
     */
    public static String findCurrentMonth() {
        Calendar now = Calendar.getInstance();
        return new SimpleDateFormat("MMMM").format(now.getTime());
    }

    /**
     * Verify Calender view default current month
     * @throws Exception
     */
    public void verifyCalendarDefaultCurrentMonth() throws Exception {
        CURRENT_MONTH = findCurrentMonth();
        String CALENDAR_DEFAULT_DATE = driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"Jul\"])[2]")).getAttribute("name");
        Logger.logAction("Verifying Calendar page default current month");
        Thread.sleep(7000);
        if(!CALENDAR_DEFAULT_DATE.toLowerCase().contains(CURRENT_MONTH.toLowerCase())){
            Logger.logWarning("Calendar view is not displayed with default current month.");
            Logger.logComment("Calendar view default Month is Current Month - i.e. -- " + CURRENT_MONTH);
        }else{
            Logger.logComment("Calendar view default Month is Current Month - i.e. -- " + CURRENT_MONTH);
        }
    }

    /**
     * Tap on Done button in calendar view
     */
    @Override
    public void tapOnDoneButton() {
        Logger.logAction("Tapping on Done button");
        try {
            if (isElementDisplayedByName(DONE_BUTTON_IN_CALENDAR_VIEW)){
                driver.findElementByName(DONE_BUTTON_IN_CALENDAR_VIEW).click();
                Logger.logStep("Tapped on Done button");
            }else {
                Logger.logError("Done button is not displayed in the calendar view");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: unable to tap on Done button in calendar view");
        }
    }

    /**
     * Tap on search button in flights tab
     */
    @Override
    public void tapOnSearchButton() {
        Logger.logAction(" Tapping on Search button in flights tab");
        try {
            if (isElementDisplayedByName(SEARCH_BUTTON)){
                driver.findElementByName(SEARCH_BUTTON).click();
                waitTillTheProgressIndicatorIsInvisibleByClassName_IOS(Labels.IOS_ACTIVITY_INDICATOR); //Todo:- Remove this line code after implementing the progress indicator in SRP page
                Logger.logStep("Tapped on Search button");
            }else {
                Logger.logError("Search button is not displayed in flights tab");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on search button in flights tab");
        }
    }

    /**
     * Check the app localization in flights tab
     * @return
     */
    @Override
    public String checkAppLocalizationInFlightsTab(){
        Logger.logAction("Check the app localization in flights tab");
        try {
            if (isElementDisplayedByName(ONE_WAY_IN_ENGLISH_LANGUAGE)){
                return Labels.ENGLISH_LANGUAGE;

            }else if (isElementDisplayedByName(ONE_WAY_IN_ARABIC_LANGUAGE)){
                return Labels.ARABIC_LANGUAGE;
            }else {
                Logger.logError("The localization displayed in the app is neither English nor Arabic");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error:- Unable to check the flights tab localization");
        }
        return null;
    }

    /**
     * Check all the fields are visible in flights tab
     */
    @Override
    public void checkAllTheFieldsAreVisibleInFlightsTab(){
        Logger.logAction("Verify all the fields are visible in flights tab");
        try {
            for (int index=0;index<=listOfElementsInFlightsTab.length-1;index++){
                String elementName = listOfElementsInFlightsTab[index];
                if (isElementEnabledByName(elementName)){
                    Logger.logComment(elementName+" :- element is enabled in the flight tabs screen");
                }else {
                    Logger.logError(elementName+" :- element is not enabled in the flight tabs screen");
                }
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to find the fields are visible in flights tab");
        }
    }

    /**
     * Tap on adult plus button
     */
    @Override
    public void tapOnAdultPlusButton(){
        Logger.logAction("Tapping on adult plus button");
        try {
            findElementByXPathAndClick(XPATH_OF_ADULTS_PLUS_BUTTON);
            Logger.logStep("Tapped on adult plus button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on adult plus button");
        }
    }

    /**
     * Tap on children plus button
     */
    @Override
    public void tapOnChildrenPlusButton(){
        Logger.logAction("Tapping on adult plus button");
        try {
            findElementByXPathAndClick(XPATH_OF_CHILDREN_PLUS_BUTTON);
            Logger.logStep("Tapped on children plus button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on children plus button");
        }
    }

    /**
     * Tap on infants plus button
     */
    @Override
    public void tapOnInfantsPlusButton(){
        Logger.logAction("Tapping on adult plus button");
        try {
            findElementByXPathAndClick(XPATH_OF_INFANTS_PLUS_BUTTON);
            Logger.logStep("Tapped on infants plus button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on infants plus button");
        }
    }

    /**
     * Get the location of From airport name
     * @return
     */
    @Override
    public Integer[] getTheLocationOfFromAirPortName(String parsingFromFlightName){
        Logger.logAction("Getting the location of From airport name");
        try {
            WebElement locationOfFromAirportName = driver.findElementByName(parsingFromFlightName);
            Point table = locationOfFromAirportName.getLocation();
            int elementXAxisValue = table.getX();
            int elementYAxisValue = table.getY();
            Integer [] elementLocation = new Integer[] { elementXAxisValue,elementYAxisValue};
            return elementLocation;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the location from airport name");
        }
        return null;
    }

    /**
     * Get the location of To airport name
     * @return
     */
    @Override
    public Integer[] getTheLocationOfToAirPortName(String parsingToFlightName){
        Logger.logAction("Getting the location of To airport name");
        try {
            WebElement locationOfToAirportName = driver.findElementByName(parsingToFlightName);
            Point table = locationOfToAirportName.getLocation();
            int elementXAxisValue = table.getX();
            int elementYAxisValue = table.getY();
            Integer [] elementLocation = new Integer[] { elementXAxisValue,elementYAxisValue};
            return elementLocation;
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the location from airport name");
        }
        return null;
    }

    /**
     * Tap on swap button
     * @return
     */
    @Override
    public void tapOnSwapButton(){
        Logger.logAction("Tapping on swap button");
        try {
            findElementByNameAndClick(SWAP_BUTTON);
            Logger.logComment("Tapped on swap button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the location from airport name");
        }
    }

}
