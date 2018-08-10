package com.automation.rehlat.libCommon;

import com.automation.rehlat.Base;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.automation.rehlat.Labels.IOS_BUNDLE_ID;

public class General extends Base {

    /**
     *  Creates array of words from string which contains multiple words using single white space as identifier to differentiate words
     *  @param sentence of type String which contains multiple words
     */
    public static String[] createArrayOfWordFromString(String sentence) {
        String[] arrayOfWords = new String[0];
        try {
            Logger.logAction("Convert the sentence to array of words");
            arrayOfWords = sentence.split("\\s+");
        }
        catch (Exception exceptionDetail)   {
            Logger.logWarning("Failed to convert sentence into array of words");
        }
        return arrayOfWords;
    }


    /**
     * Executes the terminal command and returns its output
     * @param terminalCommand the command which is to be ran in the terminal
     * @return String the output of the ran command
     */
    public static String executeTerminalCommandArray(String[] terminalCommand) {
        // Escape special characters
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(terminalCommand);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    /**
     * Executes the terminal command and returns its output
     * @param terminalCommand the command which is to be ran in the terminal
     * @return String the output of the ran command
     */
    public static String executeTerminalCommand(String terminalCommand) {
        // Escape special characters
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(terminalCommand);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    /**
     * Method to uninstall the app
     */
    public static void uninstallIosApp() {
        Logger.logAction("Uninstalling the App");
        try {
            driver.removeApp(IOS_BUNDLE_ID);
        } catch (Exception exception) {
            Logger.logError("Unable to uninstall the app ");
        }
    }

    /**
     * Method to install the app
     */
    public static void installIosApp() {
        Logger.logAction("Installing the App");
        try {
            driver.installApp("/Users/Rehlat/IdeaProjects/Rehlat.app");
        } catch (Exception exception) {
            Logger.logError("Unable to install the app, Please find the below error");
        }
    }

    /**
     * Method to launch the app
     */
    public static void launchApp() {
        Logger.logAction("Launch the App");
        try {
            driver.launchApp();
        } catch (Exception exception) {
            Logger.logError("unable to Launch the app ");
        }
    }
}
