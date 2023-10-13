package org.example.utils;

import org.example.MyDriver;
import org.example.tests.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.format;

public class EventListener extends BaseTest implements ITestListener {

    MyDriver currentDriver = MyDriver.getInstance(""); // Reemplaza "chrome" con el navegador deseado

    @Override
    public void onTestFailure(ITestResult result) {
        logInfo(format("Test: %s - [FAIL]", result.getName() ));
        takeSnapShot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logWarning(format("Test: %s - [SKIPPED]", result.getName()));
    }

    @Override
    public void onTestStart(ITestResult result) {
        logInfo(format("Test: %s - [Starting...]", result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logInfo(format("Test: %s - [PASSED]", result.getName()));
    }

    private void takeSnapShot(String testName) {
        if (currentDriver.getDriver() instanceof TakesScreenshot) {
            File snapshot = ((TakesScreenshot) currentDriver.getDriver()).getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String snapShotName = testName + timeStamp + ".png";

            try {
                FileHandler.copy(snapshot, new File("src/info/bugs/" + snapShotName));
                logInfo("Snapshot name: " + snapShotName);
            } catch (IOException e) {
                logInfo("Failed to capture the snapshot: " + e.getMessage());
            }
        } else {
            logInfo("Driver doesn't support snapshots.");
        }
    }
}
