package com.automation.rehlat.pages.flights;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.automation.rehlat.Labels.*;
import static com.automation.rehlat.Labels.SwipeDirection.DIRECTION_UP;
import static com.automation.rehlat.tests.BaseTest.SELECT_LANGUAGE;


public class FlightsAndroid extends FlightsBase{
    public static final String FROM_TEXTFIELD = "com.app.rehlat:id/fromAirportLinearLayout";
    public static final String TO_TEXTFIELD = "com.app.rehlat:id/toAirportLinearLayout";
    public static final String CONTINUE_BUTTON = "com.app.rehlat:id/domainDialogClose";
    public static final String DEPARTURE_BUTTON = "com.app.rehlat:id/departureLayout";
    public static final String RETURN_BUTTON = "com.app.rehlat:id/returnDayTextView";
    public static final String MENU_BUTTON = "com.app.rehlat:id/menuclick";
    public static final String DOMAIN_LIST_VIEW = "com.app.rehlat:id/domainListView";
    public static final String TEXT_VIEW = "android.widget.TextView";
    public static final String SEARCH_VIEW = "com.app.rehlat:id/dialog_search_layout";
    public static final String SEARCH_BUTTON = "com.app.rehlat:id/flightSearchTextView";
    public static final String SEARCH_FLIGHT_LISTVIEW_ID = "com.app.rehlat:id/searchFlightListView";
    public static final String CALENDER_VIEW_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ListView/";
    public static final String XPATH_OF_CALENDER_VIEW_LINEAR_LAYOUT = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.LinearLayout[1]";
    public static final String XPATH_OF_CALENDER_MONTH_AND_YEAR = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ListView";
    public static final String XPATH_OF_SEARCH_FLIGHT_IN_LISTVIEW = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[";
    public static final String XPATH_OF_COUNTRY_NAME = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[";
    public static final String CALENDER_MODAL_VIEW = "com.app.rehlat:id/calendar_view";
    public static final String SEARCH_TEXTFIELD = "com.app.rehlat:id/searchFlightEditText";

    /**
     * Check select language modal is displayed
     */
    @Override
    public void checkSelectLanguageModalIsDisplayed() {
        Logger.logAction("checking the select language modal is displayed or not");
        try{ if (isElementDisplayedByName(SELECT_LANGUAGE)){
                Logger.logStep("Select Language modal is displayed");
            }else {
                Logger.logWarning("Select Language modal is not displayed");
            }
        }catch (Exception e){
            Logger.logError("Select Language Modal is not displayed");
        }
    }

    /**
     * Check the flights tab is displayed
     */
    @Override
    public void checkFlightsTabIsDisplayed() {
        Logger.logAction("Checking flights screen tab is displayed");
        try {
            if (isElementDisplayedById(MENU_BUTTON)){
                    Logger.logStep("Flights Screen is displayed");
            }else{
                Logger.logError("Menu button is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to verify the flights screen name");
        }
    }

    /**
     * Tapping on menu button
     */
    @Override
    public void tapOnMenuButton() {
        Logger.logAction("Tapping on menu button");
        try {
            if (isElementDisplayedById(MENU_BUTTON)){
                driver.findElement(By.id(MENU_BUTTON)).click();
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
            if (isElementDisplayedById(DOMAIN_LIST_VIEW))
            {
                WebElement displayedCountriesListView = driver.findElement(By.id(DOMAIN_LIST_VIEW));
                List<WebElement> displayedCountriesList = displayedCountriesListView.findElements(By.className(TEXT_VIEW));
                for (int index=0; index <= displayedCountriesList.size(); index++){
                    WebElement countryNameTextView = displayedCountriesList.get(index);
                    String countryNameLabel = countryNameTextView.getText();
                    if (countryNameLabel.equals(userCountryName)){
                        Logger.logComment("Tapping on element - " +userCountryName);
                        index  = index + 1;
                        driver.findElement(By.xpath(XPATH_OF_COUNTRY_NAME+index+"]")).click();
                        break;
                    }else {
                        Logger.logComment(userCountryName + " and " +countryNameLabel + " is not matching");
                    }
                }
            }else {
                Logger.logError(DOMAIN_LIST_VIEW + " - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Error in selecting the user country from select country modal");
        }
    }

    /**
     * Tap on Continue button
     */
    public void tapOnContinueButton() {
        try{
            if (isElementDisplayedById(CONTINUE_BUTTON)){
                driver.findElementById(CONTINUE_BUTTON).click();
            }else{
                Logger.logError("Unable to tap on continue button");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error: Unable to tap on Continue button");
        }
    }

    /**
     * Select the country name and move to flights tab
     * @throws Exception
     */
    @Override
    public void selectCountryNameAndMoveToFlightsTab(String countryName) throws Exception{
        if (isElementDisplayedByName(SELECT_LANGUAGE)){
            selectCountryOfUser(countryName);
            tapOnContinueButton();
        }else{
            Logger.logComment("Select language modal is not displayed and moving to next test step");
        }
    }

    /**
     * Tap on From Text Field in flights tab
     */
    @Override
    public void tapOnFromTextField() {
        Logger.logAction("Tapping on From text field in flights tab");
        try {
            if (isElementDisplayedById(FROM_TEXTFIELD)){
                Logger.logComment("Tapping on element - " +FROM_TEXTFIELD);
                driver.findElementById(FROM_TEXTFIELD).click();
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
        Logger.logAction("Tapping on TO text field");
        try {
            if (isElementDisplayedById(TO_TEXTFIELD)){
                Logger.logComment("Tapping on element - " + TO_TEXTFIELD);
                driver.findElement(By.id(TO_TEXTFIELD)).click();
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
        Logger.logAction("Checking keyboard is triggered or not ");
        try {
//            String iOSKeyboard = driver.findElement(By.xpath(IOS_KEYBOARD_XPATH)).getAttribute("type");
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
        Logger.logAction("Checking search view screen is displayed or not ?");
        try{
            driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS); // Implemented wait time due to delay of search view displaying after tapping on TO/FROM airport button in flights tab
            if (isElementDisplayedById(SEARCH_VIEW)){
             Logger.logStep("Search view screen is displayed");
            }else {
                Logger.logError("Search view screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the screen name");
        }
    }

    /**
     *Enter From place in search view
     */
    @Override
    public void enterAirportName(String airportName) {
        Logger.logAction("Entering the airport name :- " +airportName);
        try{
            sendTextById(SEARCH_TEXTFIELD,airportName);
            driver.hideKeyboard();
            driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);// Implemented due to to delay in closing the keyboard and to find the filtered results displayed behind the keyboard also
        }catch (Exception nullPointerException){
            Logger.logError("Encountered error: Unable to enter from place name in the search view");
        }
    }

    /**
     * Select the place name from search results of search view
     * @param airportCode
     */
    @Override
    public void selectAirportCodeFromSearchResults(String airportCode) {
        try {
            if (isElementDisplayedById(SEARCH_FLIGHT_LISTVIEW_ID)){
                WebElement searchFlightListView = driver.findElement(By.id("com.app.rehlat:id/searchFlightListView"));
                List<WebElement> searchResultsAirportNamesListWithCodes = searchFlightListView.findElements(By.className(TEXT_VIEW));
                for (int index=0; index <= searchResultsAirportNamesListWithCodes.size();index++)
                {
                    String airportCodeFromSearchResults = searchResultsAirportNamesListWithCodes.get(index).getText();
                    if (airportCodeFromSearchResults.equals(airportCode)){
                        index = index+1;
                        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_OF_SEARCH_FLIGHT_IN_LISTVIEW+index+"]"))).click();
                        break;
                    }else {
                        Logger.logComment(" Searched Airport code - "+airportCode+ "- is not matching with the filtered result - "+airportCodeFromSearchResults+" -");
                    }
                }
            }else{
                Logger.logError("Unable to tap on the airport code - " +airportCode);
            }

        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to select the place name from search results");
        }
    }

    /**
     * Tap on Departure button in flights tab
     */
    @Override
    public void tapOnDepartureButton() throws Exception{
        try{
            if (isElementDisplayedById(DEPARTURE_BUTTON)){
                driver.findElementById(DEPARTURE_BUTTON).click();
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on Departure button");
        }
    }

    /**
     * Tap on return booking button in flights tab
     */
    @Override
    public void tapOnReturnDateBookingButton() throws Exception {
        try{
            if (isElementDisplayedById(RETURN_BUTTON)){
                driver.findElementById(RETURN_BUTTON).click();
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on Departure button");
        }
    }

    /**
     * Select Departure date
     */
    @Override
    public void selectDepartureDate(String departureMonthAndYear, String departureDay) {
        Logger.logAction("Selecting the departure date : Month & Year -" + departureMonthAndYear + ", Day - "+departureDay);
        try {
            if (isElementDisplayedById(CALENDER_MODAL_VIEW)){
                scrollToTheParsingCalendarMonthAndYear(departureMonthAndYear,true);
                if (isParsingCalenderMonthIsDisplayed(departureMonthAndYear)){
                    tapOnDayInTheCalender(departureMonthAndYear,departureDay);
                }else {
                    scrollToTheParsingCalendarMonthAndYear(departureMonthAndYear,false);
                    if (isParsingCalenderMonthIsDisplayed(departureMonthAndYear)){
                        tapOnDayInTheCalender(departureMonthAndYear,departureDay);
                    }else {
                        Logger.logWarning("Unable to select the accurate departure date :- " +departureDay+ "," + departureMonthAndYear+"..., Going with the default selected date");
                    }
                }
            }else{
                Logger.logError("Calendar view is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error: Unable to select the date in the date modal");
        }
    }

    /**
     * Select Return date
     */
    @Override
    public void selectReturnDate(String departureMonthAndYear, String departureDay) {
        Logger.logAction("Selecting the departure date : Month & Year -" + departureMonthAndYear + ", Day - "+departureDay);
        try {
            if (isElementDisplayedById(CALENDER_MODAL_VIEW)){
                scrollToTheParsingCalendarMonthAndYear(departureMonthAndYear,true);
                if (isParsingCalenderMonthIsDisplayed(departureMonthAndYear)){
                    tapOnDayInTheCalender(departureMonthAndYear,departureDay);
                }else {
                    scrollToTheParsingCalendarMonthAndYear(departureMonthAndYear,false);
                    if (isParsingCalenderMonthIsDisplayed(departureMonthAndYear)){
                        tapOnDayInTheCalender(departureMonthAndYear,departureDay);
                    }else {
                        Logger.logWarning("Unable to select the accurate return date :- " +departureDay+ "," + departureMonthAndYear+"..., Going with the default selected date");
                    }
                }
            }else{
                Logger.logError("Calendar view is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Encountered Error: Unable to select the date in the date modal");
        }
    }

    /**
     * Tap on the parsing day in the displayed calender
     * @param parsingMonthAndYear
     * @param parsingDay
     */
    public static void tapOnDayInTheCalender(String parsingMonthAndYear, String parsingDay) {
        Logger.logAction("Tapping on the day "+parsingDay+" in the calender view");
        try{
            Thread.sleep(WAIT_TIME_MIN);
            WebElement calenderView = driver.findElement(By.id(CALENDER_MODAL_VIEW));
            try {
                List<WebElement> monthTitle = calenderView.findElements(By.className("android.widget.LinearLayout"));
                for (int index = 0; index <= monthTitle.size()-1; index++) {
                    WebElement monthCalenderLayout = monthTitle.get(index);
                    WebElement monthCalenderTitleLayout = monthCalenderLayout.findElement(By.className(TEXT_VIEW));
                    String monthCalenderTitleValue = monthCalenderTitleLayout.getText();
                    if (monthCalenderTitleValue.equals(parsingMonthAndYear)){
                        WebElement daysCalenderLayout = monthCalenderLayout.findElement(By.className("android.view.ViewGroup"));
                        List<WebElement> groupViewOfDaysIncludingRows = daysCalenderLayout.findElements(By.className("android.view.ViewGroup"));
                        for (int row = 0; row <= groupViewOfDaysIncludingRows.size()-1; row++) {
                            WebElement eachRowInaGroupView = groupViewOfDaysIncludingRows.get(row);
                            List<WebElement> listOfRowsInMonthCalender = eachRowInaGroupView.findElements(By.className(TEXT_VIEW));
                            for (int text = 0; text <= listOfRowsInMonthCalender.size()-1; text++) {
                                String valueOfEachDay = listOfRowsInMonthCalender.get(text).getText();
                                if (valueOfEachDay.equals(parsingDay)){
                                    index = index+1;
                                    row = row+1;
                                    text = text+1;
                                    String xpathOfDay = CALENDER_VIEW_XPATH+"android.widget.LinearLayout["+index+"]/"+"android.view.ViewGroup/android.view.ViewGroup["+row+"]/"+"android.widget.TextView["+text+"]";
                                    WebElement locationOfDay = driver.findElement(By.xpath(xpathOfDay));
                                    Point table = locationOfDay.getLocation();
                                    int elementYAxisValue = table.getY();
                                    if (Labels.SCREEN_Y_AXIS_SIZE_OF_RANGE_OF_20_PERCENT <= elementYAxisValue){
                                        scrollTheCalenderPageUpByDaysGap();
                                        tapOnDayInTheCalender(parsingMonthAndYear,parsingDay);
                                    }else {
                                        driver.findElementByXPath(xpathOfDay).click();
                                        break;
                                    }
                                }else {
                                    continue;
                                }
                            }
                        }
                    }else {
                        continue;
                    }
                    Thread.sleep(WAIT_TIME_MIN);
                }
            }catch (Exception exception){
                scrollTheCalenderPageUpByDaysGap();
                tapOnDayInTheCalender(parsingMonthAndYear,parsingDay);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on the calender day");
        }
    }

    /**
     * Checking the parsing flight booking month and year is displayed or not
     * @param flightBookingMonthAndYear
     * @return
     */
    public static boolean isParsingCalenderMonthIsDisplayed(String flightBookingMonthAndYear) {
        Logger.logAction("Checking the parsing calender month "+flightBookingMonthAndYear+" is displayed or not ?");
        try {
            Thread.sleep(WAIT_TIME_MIN);
            WebElement calenderView = driver.findElement(By.id(CALENDER_MODAL_VIEW));
            try{
                List<WebElement> linearLayout = calenderView.findElements(By.className("android.widget.LinearLayout"));
                for (int index =0; index <= linearLayout.size()-1;index++){
                    if (linearLayout.get(index).findElement(By.className(TEXT_VIEW)).isDisplayed()){
                        WebElement calenderMonth = linearLayout.get(index).findElement(By.className(TEXT_VIEW));
                        String nameOfEachTextView = calenderMonth.getText();
                        if (nameOfEachTextView.equals(flightBookingMonthAndYear)){
                            Logger.logComment(flightBookingMonthAndYear+" - calender month is displayed");
                            return true;
                        }else {
                            Logger.logComment(flightBookingMonthAndYear+" - calender month is not matching with -"+nameOfEachTextView);
                        }
                    }else {
                        continue;
                    }
                }
            }catch (Exception exception){
                scrollTheCalenderPageUpByDaysGap();
                isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll to the month :- " +flightBookingMonthAndYear);
        }
        return false;
    }

    /**
     * Scrolling to the parsing flight booking month and year
     * @param flightBookingMonthAndYear
     * @param down
     */
    public static void scrollToTheParsingCalendarMonthAndYear(String flightBookingMonthAndYear, boolean down ) {
        Logger.logAction("Scrolling the calender view to the parsing flight booking month and year :- " +flightBookingMonthAndYear);
        try {
            if(!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                int counter = 0;
                if (down) {
                    while (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                        Logger.logComment(counter + "  time trying to find the calender month and year - " + flightBookingMonthAndYear +" - by scrolling down ");
                        scrollTheCalenderPageUpByAMonthGap();
                        counter++;
                        if (counter > 6) {
                            break;
                        }
                    }
                    if (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                        while (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                            Logger.logComment(counter + "  time trying to find the calender month and year - " + flightBookingMonthAndYear +" - by scrolling up ");
                            scrollTheCalenderPageDownAMonthGap();
                            counter++;
                            if (counter > 12) {
                                break;
                            }
                        }
                    }
                } else {
                    while (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                        Logger.logComment(counter + "  time trying to find the calender month and year - " + flightBookingMonthAndYear +" - by scrolling up ");
                        scrollTheCalenderPageDownAMonthGap();
                        counter++;
                        if (counter > 6) {
                            break;
                        }
                    }
                    if (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                        Logger.logComment(counter + "  time trying to find the calender month and year - " + flightBookingMonthAndYear +" - by scrolling down ");
                        while (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                            scrollTheCalenderPageUpByAMonthGap();
                            counter++;
                            if (counter > 12) {
                                break;
                            }
                        }
                    }
                }
            }else {
                Logger.logComment(flightBookingMonthAndYear+ " - Parsing  flight booking month is displayed in the current calender view");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to scroll to the parsing calendar month and year of :- " +flightBookingMonthAndYear);
        }
    }

    /**
     * Tap on Done button in calendar view
     */
    @Override
    public void tapOnDoneButton() {
        Logger.logAction("Tapping on Done button");
        try {
            if (isElementDisplayedById("com.app.rehlat:id/closeCalImageView")){
                driver.findElementById("com.app.rehlat:id/closeCalImageView").click();
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
            if (isElementDisplayedById("com.app.rehlat:id/flightSearchTextView")){
                driver.findElementById("com.app.rehlat:id/flightSearchTextView").click();
            }else {
                Logger.logError("Search button is not displayed in flights tab");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on search button in flights tab");
        }
    }
}
