package com.automation.rehlat.libCommon;

import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.automation.rehlat.Base;

public class Logger extends Base {

    private static String prefix = "- - - - - - - - - - ";
    private static String suffix = "- - - - - - - - - - ";
    private static String banner = "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ";
    private static String step = "==========================================================";
    private static String warning = "#######################";
    private static String error = "*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*";
    private static Date theTimeTheTestBegan;
    private static Date theTimeTheTestEnded;



    //These methods below are the most used in the suite. Proceed with caution if editing
    public static void beginTest(final String testName) {

        theTimeTheTestBegan = new Date();
        System.out.println(banner);
        System.out.println("                       Beginning test " + testName + " at " + theTimeTheTestBegan);
        System.out.println(banner);
        System.out.println();
        System.out.println();
        Base.setTestCaseName(testName);
    }

    public static void endTest(final String testName) {
        theTimeTheTestEnded = new Date();
        System.out.println();
        System.out.println();
        System.out.println(banner);
        try {
            totalTimeTakenForScriptToFinish();
        }catch (Exception exception){
            Logger.logComment("unable to print the time taken to complete the current script");
        }
        System.out.println("                       Finishing test " + testName + " at " + theTimeTheTestEnded);
        System.out.println(banner);
    }

    public static void logAction(final String msg) {
        //System.out.println(prefix);
        System.out.println("  " + msg);
        System.out.println("  " + suffix);
    }

    public static void logComment(final String msg) {
        //System.out.println(prefix);
        System.out.println("        -> " + msg);
        System.out.println("  " + suffix);
    }

    public static void logStep(final String stepMsg) {
        System.out.println(step);
        System.out.println(stepMsg);
        System.out.println(step);

    }

    public static void logWarning(final String msg) {
        System.out.println(warning);
        System.out.println("### WARNING: " + msg);
        System.out.println(warning);
    }


    public static void logError(final String msg) {
        System.out.println(error);
        System.out.println("### Error: " + msg);
        System.out.println(error);
        Assert.fail(msg);
    }

    /**
     * Total time taken for script to finish
     */
    public static void totalTimeTakenForScriptToFinish() {
        Integer minutesTime = null;
        Integer secondsTime = null;
        try{
            Integer minutesTimeWhileTestScriptBegan = Integer.valueOf(new SimpleDateFormat("mm").format(theTimeTheTestBegan));
            Integer secondsTimeWhileTestScriptBegan = Integer.valueOf(new SimpleDateFormat("ss").format(theTimeTheTestBegan));
            Integer minutesTimeWhileTestScriptEnded = Integer.valueOf(new SimpleDateFormat("mm").format(theTimeTheTestEnded));
            Integer secondsTimeWhileTestScriptEnded = Integer.valueOf(new SimpleDateFormat("ss").format(theTimeTheTestEnded));
            if (minutesTimeWhileTestScriptBegan > minutesTimeWhileTestScriptEnded){
                Integer finalMinutesTime  = 60-minutesTimeWhileTestScriptBegan;
                minutesTime = finalMinutesTime + minutesTimeWhileTestScriptEnded;
            }else if (minutesTimeWhileTestScriptEnded > minutesTimeWhileTestScriptBegan){
                minutesTime = minutesTimeWhileTestScriptEnded - minutesTimeWhileTestScriptBegan;
            }
            if (secondsTimeWhileTestScriptBegan > secondsTimeWhileTestScriptEnded){
                Integer finalSecondsTime  = 60-secondsTimeWhileTestScriptBegan;
                secondsTime = finalSecondsTime + secondsTimeWhileTestScriptEnded;
            }else if (secondsTimeWhileTestScriptEnded > secondsTimeWhileTestScriptBegan){
                secondsTime = secondsTimeWhileTestScriptEnded - secondsTimeWhileTestScriptBegan;
            }
            Logger.logComment("Time taken to complete to complete the test script is :- " +minutesTime+ " minutes & " +secondsTime+" seconds");
        }catch (Exception exception){
            Logger.logError("Encountered error: Unable to get the total time for the script to finish");
        }
    }
}
