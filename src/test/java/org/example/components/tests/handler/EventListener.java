package org.example.components.tests.handler;

import org.example.components.MyDriver;
import org.example.components.tests.BaseTest;
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

/**
 * EventListener is a test listener to capture events and take snapshots on test failures.
 */
public class EventListener extends BaseTest implements ITestListener {
    protected WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        logInfo(format("Test: %s - [FAIL]", result.getName()));
        takeSnapshot(result.getName());
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

    private void takeSnapshot(String testName) {
        this.driver = MyDriver.getInstance("").getDriver(); // Use the Singleton instance of MyDriver

        if (driver instanceof TakesScreenshot) {
            File snapshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String formattedDate = dateFormat.format(new Date());
            File folder = new File("info/bugs/" + testName);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String snapshotName = formattedDate + ".png"; // Image name

            try {
                FileHandler.copy(snapshot, new File(folder, snapshotName));
                logInfo("Snapshot saved in: " + testName + "/" + snapshotName);
            } catch (IOException e) {
                logInfo("Failed to capture and save the snapshot: " + e.getMessage());
            }
        } else {
            logInfo("Driver doesn't support snapshots.");
        }
    }
}
