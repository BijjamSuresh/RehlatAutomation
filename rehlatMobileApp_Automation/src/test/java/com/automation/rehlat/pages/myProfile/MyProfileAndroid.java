package com.automation.rehlat.pages.myProfile;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyProfileAndroid extends MyProfileBase {

    public static final String MY_PROFILE_TITLE = "My Profile";
    public static final String XPATH_OF_KARAM_POINTS_AND_TRIPS_LAYOUT = "//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther";

    /**
     * Check my profile screen is displayed
     *
     * @throws Exception
     */
    @Override
    public void checkMyProfileScreenIsDisplayed() throws Exception {
        Logger.logAction("Checking my profile screen is displayed or not ?");
        try {
            if (isElementDisplayedByName(MY_PROFILE_TITLE)) {
                Logger.logStep("My profile screen is displayed");
            } else {
                Logger.logError("My profile screen is not displayed");
            }
        } catch (Exception Exception) {
            Logger.logError("Encountered error: Unable to chekc the profile screen is displayed or not?");
        }
    }

    /**
     * Get the karam points displayed in the karam and trips layout
     *
     * @throws Exception
     */
    @Override
    public void getTheKaramPointsDisplayedInKaramPointsAndTripsLayout() throws Exception {
        Logger.logAction("Get the karam points displayed in the karam and trips layout");
        try {
            if (isElementEnabledByXpath(XPATH_OF_KARAM_POINTS_AND_TRIPS_LAYOUT)) {
                WebElement karamPointsAndTripsLayout = driver.findElementByXPath(XPATH_OF_KARAM_POINTS_AND_TRIPS_LAYOUT);
                List<WebElement> staticTextLists = karamPointsAndTripsLayout.findElements(By.className(Labels.IOS_XCUI_ELEMENT_TYPE_STATIC_TEXT));
                for (int count = 0; count <= staticTextLists.size(); count++) {
                    String eachStaticTextValue = staticTextLists.get(count).getAttribute(Labels.VALUE_ATTRIBUTE);
                    if (eachStaticTextValue.contains(Labels.DOT_STRING)) {
                        Logger.logComment("Karam points cell is displayed");
                        Double karamPoints = Double.valueOf(eachStaticTextValue);
                        Logger.logComment("Displaying karam points are :- " + karamPoints);
                        break;
                    }
                }
            } else {
                Logger.logError("Karam points and trips layout cell is not displayed");
            }
        } catch (Exception exception) {
            Logger.logError("Encountered error:- Unable to get the karam points displayed in karam points and trips layout");
        }
    }
}
