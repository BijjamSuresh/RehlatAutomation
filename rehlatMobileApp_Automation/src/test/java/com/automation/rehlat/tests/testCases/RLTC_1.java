package com.automation.rehlat.tests.testCases;

import com.automation.rehlat.Labels;
import com.automation.rehlat.libCommon.Logger;
import com.automation.rehlat.tests.BaseTest;
import org.junit.Test;

public class RLTC_1 extends BaseTest {
    @Test
    // Implementation is not yet finished. Will do once all the workflows are cleared
    public void testRLTC_1() {
        Logger.beginTest("Verify that application is installed successfully");
        checkAppInstallation(Labels.IOS);
        Logger.endTest("Verify that application is installed successfully");
    }
}
