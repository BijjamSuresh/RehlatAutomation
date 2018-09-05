package com.automation.rehlat.pages.referYourFriends;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReferYourFriendsAndroid extends ReferYourFriendsBase {

    public static String REFER_YOUR_FRIENDS_LABEL = "REFER YOUR FRIENDS";
    public static final String XPATH_OF_REFERRAL_CODE_CELL ="//XCUIElementTypeApplication[@name=\"Rehlat\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]";

    /**
     * Check refer your friends screen id displayed or not?
     */
    @Override
    public void checkReferYourFriendsScreenIsDisplayed(){
        Logger.logAction("Refer your friends screen is displayed or not?");
        try{
            if(isElementDisplayedByName(REFER_YOUR_FRIENDS_LABEL)){
                Logger.logComment("Refer your friends screen is displayed");
            }else{
                Logger.logError("Refer your friends screen is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current screen name");
        }
    }

    /**
     * Check refer your friends screen id displayed or not?
     */
    @Override
    public void checkReferralCodeIsDisplayed(){
        Logger.logAction("Refer your friends screen is displayed or not?");
        try{
            String referralCode = getTheReferralCode();
            if (!(referralCode==null)){
                Logger.logStep("Referral code is visible to the user and the displaying referral code is :- " +referralCode);
            }else {
                Logger.logError("Referral code is not visible to the user and the displaying referral code is :- " +referralCode);
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to check the current screen name");
        }
    }

    /**
     * Get the referral code
     * @return
     * @throws Exception
     */
    public static String getTheReferralCode() throws Exception{
        try{
            if(isElementDisplayedByXPath(XPATH_OF_REFERRAL_CODE_CELL)){
                Logger.logComment("Referral code cell is displayed");
                WebElement referralCodeCell = driver.findElementByXPath(XPATH_OF_REFERRAL_CODE_CELL).findElement(By.className(Labels.IOS_XCUI_ELEMENT_TYPE_TEXT_FIELD));
                String referralCodeValue = referralCodeCell.getAttribute(Labels.VALUE_ATTRIBUTE);
                if (!(referralCodeValue == null)){
                    return referralCodeValue;
                }
            }else{
                Logger.logError("Referral code cell is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the referral code");
        }
        return null;
    }

    /**
     * Get the referral code
     * @return
     * @throws Exception
     */
    public static String updateTheReferralCode(String parsingReferralCode) throws Exception{
        try{
            if(isElementDisplayedByXPath(XPATH_OF_REFERRAL_CODE_CELL)){
                Logger.logComment("Referral code cell is displayed");
                WebElement referralCodeCell = driver.findElementByXPath(XPATH_OF_REFERRAL_CODE_CELL).findElement(By.className(Labels.IOS_XCUI_ELEMENT_TYPE_TEXT_FIELD));
                referralCodeCell.sendKeys(parsingReferralCode);
                Logger.logComment("Parsed the referral code as :- "+parsingReferralCode);
            }else{
                Logger.logError("Referral code cell is not displayed");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the referral code");
        }
        return null;
    }

    /**
     * Edit the referral code
     */
    @Override
    public void editTheReferralCode() {
        try{
            String currentReferralCode = getTheReferralCode();
            int randomValue = getTheRandomValue(2);
            String latestReferralBeforeEditing = Labels.REFERRAL_CODE.concat(String.valueOf(randomValue));
            updateTheReferralCode(latestReferralBeforeEditing);
            String latestReferralCodeAfterEditing = getTheReferralCode();
            if (!currentReferralCode.equalsIgnoreCase(latestReferralCodeAfterEditing)){
                Logger.logStep("Referral code text field is edited");
            }else {
                Logger.logError("Referral code text field is not editable");
            }
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to edit the referral code");
        }
    }
}
