package com.automation.rehlat.pages.flights;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.automation.rehlat.Labels.*;
import static com.automation.rehlat.tests.BaseTest.SELECT_LANGUAGE;


public class FlightsAndroid extends FlightsBase{
    public static final String FROM_TEXTFIELD = "com.app.rehlat:id/fromAirportLinearLayout";
    public static final String TO_TEXTFIELD = "com.app.rehlat:id/toAirportLinearLayout";
    public static final String CONTINUE_BUTTON = "com.app.rehlat:id/domainDialogClose";
    public static final String SELECT_DOMAIN_LAYOUT = "com.app.rehlat:id/domainDialogLinearLayout";
    public static final String DEPARTURE_BUTTON = "com.app.rehlat:id/departureLayout";
    public static final String RETURN_BUTTON = "com.app.rehlat:id/returnJourneyLayout";
    public static final String MENU_BUTTON = "com.app.rehlat:id/menuclick";
    public static final String TRIP_RADIO_BUTTON = "com.app.rehlat:id/tripradioGroup";
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
    public static final String OTHER_COUNTRY_OPTION ="Other";
    public static final String DONE_BUTTON_IN_CALENDAR_VIEW = "com.app.rehlat:id/closeCalImageView";
    public static final String SEARCH_BUTTON_IN_FLIGHTS_TAB = "com.app.rehlat:id/flightSearchTextView";
    public static final String ONE_WAY_IN_ARABIC_LANGUAGE = "رحلة الذهاب";
    public static final String ONE_WAY_IN_ENGLISH_LANGUAGE = "One way";
    public static final String ONE_WAY_SEGMENT_CONTROL_BUTTON = "com.app.rehlat:id/oneway_rb";
    public static final String[] listOfElementsInFlightsTab = {"com.app.rehlat:id/oneway_rb","com.app.rehlat:id/roundtrip_rb","com.app.rehlat:id/fromCity","com.app.rehlat:id/toCity","com.app.rehlat:id/departureLayout","com.app.rehlat:id/returnJourneyLayout","com.app.rehlat:id/pax_search_icon","com.app.rehlat:id/travellers_class_type","com.app.rehlat:id/flightSearchTextView"};
    public static final String SWAP_BUTTON = "com.app.rehlat:id/journeyIndicationImageView";
    public static final String PASSENGER_ICON = "com.app.rehlat:id/pax_search_icon";

    /**
     * Check select language modal is displayed
     */
    @Override
    public boolean isSelectLanguageModalIsDisplayed() {
        Logger.logAction("checking the select language modal is displayed or not");
        try{
            if (isElementDisplayedById(SELECT_DOMAIN_LAYOUT)){
                Logger.logStep("Select Language modal is displayed");
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            Logger.logError("Select Language Modal is not displayed");
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
            if (isElementDisplayedByXPath(DOMAIN_LIST_VIEW)){
                WebElement selectCountrySheet = driver.findElementByXPath(DOMAIN_LIST_VIEW);
                List<WebElement> listOfCountries = selectCountrySheet.findElements(By.className(TEXT_VIEW));
                String nameOfTheLastLabel = listOfCountries.get(listOfCountries.size()-1).getAttribute(Labels.VALUE_ATTRIBUTE);
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
     * Check the flights tab is displayed
     */
    @Override
    public void checkFlightsTabIsDisplayed() {
        Logger.logAction("Checking flights screen tab is displayed");
        try {
            Thread.sleep(1000);
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
                Logger.logStep("Menu button is tapped");
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
            if (isElementDisplayedById(DOMAIN_LIST_VIEW)) {
                WebElement displayedCountriesListView = driver.findElementById(DOMAIN_LIST_VIEW);
                if (userCountryName.equals(Labels.INDIA_LANGUAGE_COUNTRY_LABEL)) {
                    List<WebElement> displayedCountriesList = displayedCountriesListView.findElements(By.className(TEXT_VIEW));
                    for (int index = 0; index <= displayedCountriesList.size(); index++) {
                        WebElement countryNameTextView = displayedCountriesList.get(index);
                        String countryNameLabel = countryNameTextView.getText();
                        if (countryNameLabel.equalsIgnoreCase(userCountryName) || countryNameLabel.equalsIgnoreCase(OTHER_COUNTRY_OPTION)) {
                            Logger.logComment("Tapping on element - " + userCountryName);
                            index = index + 1;
                            driver.findElement(By.xpath(XPATH_OF_COUNTRY_NAME + index + "]")).click();
                            Logger.logStep("Tapped on element - "+userCountryName);
                            break;
                        } else {
                            continue;
                        }
                    }
                } else {
                    List<WebElement> displayedCountriesList = displayedCountriesListView.findElements(By.className(TEXT_VIEW));
                    for (int index = 0; index <= displayedCountriesList.size(); index++) {
                        WebElement countryNameTextView = displayedCountriesList.get(index);
                        String countryNameLabel = countryNameTextView.getText();
                        if (countryNameLabel.equalsIgnoreCase(userCountryName)) {
                            Logger.logComment("Tapping on element - " + userCountryName);
                            index = index + 1;
                            driver.findElement(By.xpath(XPATH_OF_COUNTRY_NAME + index + "]")).click();
                            Logger.logStep("Tapped on element - "+userCountryName);
                            break;
                        } else {
                            continue;
                        }
                    }
                }
            }else {
                Logger.logError(DOMAIN_LIST_VIEW+" - element name is not displayed in the current active screen");
            }
        }catch (Exception exception){
            Logger.logError("Error in selecting the user country from select country modal");
        }
    }

    /**
     * Tap on Continue button
     */
    public void tapOnContinueButton() {
        Logger.logAction("Tapping on continue button");
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
     */
    @Override
    public void selectCountryNameInSelectLanguageModal(String countryName) {
        Logger.logAction("Selecting the country name and move to the flights tab");
        if (isSelectLanguageModalIsDisplayed()){
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
        Logger.logAction("Tapping on FROM text field in flights tab");
        try {
            if (isElementDisplayedById(FROM_TEXTFIELD)){
                Logger.logComment("Tapping on element - " +FROM_TEXTFIELD);
                driver.findElementById(FROM_TEXTFIELD).click();
                Logger.logStep("FROM text field is tapped");
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
                Logger.logStep("TO text field is tapped");
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
            Thread.sleep(1000);
//            String iOSKeyboard = driver.findElement(By.xpath(IOS_KEYBOARD_XPATH)).getAttribute("type");
            if (isKeyboardDisplayed()){
                Logger.logComment("Keyboard is triggered");
            }
            else{
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
            Thread.sleep(1000); // Implemented wait time due to delay of search view displaying after tapping on TO/FROM airport button in flights tab
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
        Logger.logAction("Selecting the airport code -"+airportCode+"- from search results");
        try {
            if (isElementDisplayedById(SEARCH_FLIGHT_LISTVIEW_ID)){
                WebElement searchFlightListView = driver.findElement(By.id(SEARCH_FLIGHT_LISTVIEW_ID));
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
//                // This logic is an work around for android app in Samsung devices...Issue is mentioned inside the logger.logStep messages, please read them for more information..,
//                // Todo:- Discuss this issue with developers and implement final solution if there is no way to fix this issue
//                Logger.logStep("Current test running device is a Samsung device.., After navigating from FROM search list screen (or from departure calendar view) flights tab elements visibility is showing as invisible in samsung devices.., To make flights tab elements visible we are pushing the app for a second and getting it back to foreground");
//                Logger.logStep("This is just an work around yet to discuss with the developers for better solution");
//                runAppInBackground(1);
//                // The workaround logic ends here
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
    public void tapOnDepartureDateBookingButton() {
        Logger.logAction("Tapping on departure button");
        try{
            if (isElementDisplayedById(DEPARTURE_BUTTON)){
                driver.findElementById(DEPARTURE_BUTTON).click();
                Logger.logStep("Departure button is tapped");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to tap on Departure button");
        }
    }

    /**
     * Tap on return booking button in flights tab
     */
    @Override
    public void tapOnReturnDateBookingButton() {
        Logger.logAction("Tapping on return button");
        try{
            if (isElementDisplayedById(RETURN_BUTTON)){
                driver.findElementById(RETURN_BUTTON).click();
                Logger.logStep("Return button is tapped");
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
        Logger.logAction("Trying to tap on the day "+parsingDay+" in the calender view");
        try{
            Thread.sleep(WAIT_TIME_MIN);
            WebElement calenderView = driver.findElement(By.id(CALENDER_MODAL_VIEW));
            try {
                List<WebElement> monthTitle = calenderView.findElements(By.className(ANDROID_LINEAR_LAYOUT));
                for (int index = 0; index <= monthTitle.size()-1; index++) {
                    WebElement monthCalenderLayout = monthTitle.get(index);
                    WebElement monthCalenderTitleLayout = monthCalenderLayout.findElement(By.className(TEXT_VIEW));
                    String monthCalenderTitleValue = monthCalenderTitleLayout.getText();
                    if (monthCalenderTitleValue.equals(parsingMonthAndYear)){
                        WebElement daysCalenderLayout = monthCalenderLayout.findElement(By.className(ANDROID_VIEW_GROUP));
                        List<WebElement> groupViewOfDaysIncludingRows = daysCalenderLayout.findElements(By.className(ANDROID_VIEW_GROUP));
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
                                        scrollTheCalenderPageUpByDaysGap_Android();
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
                scrollTheCalenderPageUpByDaysGap_Android();
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
                List<WebElement> linearLayout = calenderView.findElements(By.className(ANDROID_LINEAR_LAYOUT));
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
                scrollTheCalenderPageUpByDaysGap_Android();
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
                        scrollTheCalenderPageUpByAMonthGap_Android();
                        counter++;
                        if (counter > 6) {
                            break;
                        }
                    }
                    if (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                        while (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                            Logger.logComment(counter + "  time trying to find the calender month and year - " + flightBookingMonthAndYear +" - by scrolling up ");
                            scrollTheCalenderPageDownAMonthGap_Android();
                            counter++;
                            if (counter > 12) {
                                break;
                            }
                        }
                    }
                } else {
                    while (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                        Logger.logComment(counter + "  time trying to find the calender month and year - " + flightBookingMonthAndYear +" - by scrolling up ");
                        scrollTheCalenderPageDownAMonthGap_Android();
                        counter++;
                        if (counter > 6) {
                            break;
                        }
                    }
                    if (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                        Logger.logComment(counter + "  time trying to find the calender month and year - " + flightBookingMonthAndYear +" - by scrolling down ");
                        while (!isParsingCalenderMonthIsDisplayed(flightBookingMonthAndYear)) {
                            scrollTheCalenderPageUpByAMonthGap_Android();
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
            if (isElementDisplayedById(DONE_BUTTON_IN_CALENDAR_VIEW)){
                driver.findElementById(DONE_BUTTON_IN_CALENDAR_VIEW).click();
                Logger.logStep("Tapped on Done button");

//                // This logic is an work around for android app in Samsung devices...Issue is mentioned inside the logger.logStep messages, please read them for more information..,
//                // Todo:- Discuss this issue with developers and implement final solution if there is no way to fix this issue
//                Logger.logStep("Current test running device is a Samsung device.., After navigating from FROM search list screen (or from departure calendar view) flights tab elements visibility is showing as invisible in samsung devices.., To make flights tab elements visible we are pushing the app for a second and getting it back to foreground");
//                Logger.logStep("This is just an work around yet to discuss with the developers for better solution");
//                runAppInBackground(1);
//                // The workaround logic ends here

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
            if (isElementDisplayedById(SEARCH_BUTTON_IN_FLIGHTS_TAB)){
                driver.findElementById(SEARCH_BUTTON_IN_FLIGHTS_TAB).click();
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
            if (isElementDisplayedById(ONE_WAY_SEGMENT_CONTROL_BUTTON)){
                String oneWayButtonLanguageInFlightsTab = driver.findElementById(ONE_WAY_SEGMENT_CONTROL_BUTTON).getText();
                if (oneWayButtonLanguageInFlightsTab.equalsIgnoreCase(ONE_WAY_IN_ENGLISH_LANGUAGE)){
                    return Labels.ENGLISH_LANGUAGE;
                }else if (oneWayButtonLanguageInFlightsTab.equalsIgnoreCase(ONE_WAY_IN_ARABIC_LANGUAGE)){
                    return Labels.ARABIC_LANGUAGE;
                }
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
                if (isElementEnabledById(elementName)){
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
            findElementByIdAndClick(PASSENGER_ICON);
            Logger.logComment("Tapped on passenger icon");
            WebElement adultNumberPickerView = driver.findElementById("com.app.rehlat:id/adultNumberPicker");
            tapOnElementBasedOnLocation(adultNumberPickerView,"bottomRight");
            Logger.logComment("Tapped on adult plus button");
            findElementByIdAndClick("com.app.rehlat:id/travellersLayoutPassengersDone");
            Logger.logComment("Tapped on done button");
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
            findElementByIdAndClick(PASSENGER_ICON);
            Logger.logComment("Tapped on passenger icon");
            WebElement adultNumberPickerView = driver.findElementById("com.app.rehlat:id/childNumberPicker");
            tapOnElementBasedOnLocation(adultNumberPickerView,"bottomRight");
            Logger.logComment("Tapped on children plus button");
            findElementByIdAndClick("com.app.rehlat:id/travellersLayoutPassengersDone");
            Logger.logComment("Tapped on done button");
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
            findElementByIdAndClick(PASSENGER_ICON);
            Logger.logComment("Tapped on passenger icon");
            WebElement adultNumberPickerView = driver.findElementById("com.app.rehlat:id/infantNumberPicker");
            tapOnElementBasedOnLocation(adultNumberPickerView,"bottomRight");
            Logger.logComment("Tapped on infants plus button");
            findElementByIdAndClick("com.app.rehlat:id/travellersLayoutPassengersDone");
            Logger.logComment("Tapped on done button");
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
            WebElement locationOfFromAirportName = driver.findElementById(FROM_TEXTFIELD);
            if (parsingFromFlightName.equalsIgnoreCase(locationOfFromAirportName.getText())){
                Point table = locationOfFromAirportName.getLocation();
                int elementXAxisValue = table.getX();
                int elementYAxisValue = table.getY();
                Integer [] elementLocation = new Integer[] { elementXAxisValue,elementYAxisValue};
                return elementLocation;
            }else {
                Logger.logError("From airport id is incorrect");
            }
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
            WebElement locationOfToAirportName = driver.findElementById(FROM_TEXTFIELD);
            if (parsingToFlightName.equalsIgnoreCase(locationOfToAirportName.getText())){
                Point table = locationOfToAirportName.getLocation();
                int elementXAxisValue = table.getX();
                int elementYAxisValue = table.getY();
                Integer [] elementLocation = new Integer[] { elementXAxisValue,elementYAxisValue};
                return elementLocation;
            }else {
                Logger.logError("To airport id is incorrect");
            }
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
            findElementByIdAndClick(SWAP_BUTTON);
            Logger.logComment("Tapped on swap button");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the location from airport name");
        }
    }
}
