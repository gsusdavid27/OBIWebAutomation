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

    protected WebDriver driver;

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
        takeSnapShot(result.getName());
    }

    private void takeSnapShot(String testName) {
        this.driver = MyDriver.getInstance("").getDriver(); // Utiliza el Singleton de MyDriver

        if (driver instanceof TakesScreenshot) {
            File snapshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String formattedDate = dateFormat.format(new Date());
            File folder = new File("src/info/bugs/" + testName);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String snapShotName = formattedDate + ".png"; // Nombre de la imagen

            try {
                FileHandler.copy(snapshot, new File(folder, snapShotName));
                logInfo("Snapshot saved in: " + testName + "/" + snapShotName);
            } catch (IOException e) {
                logInfo("Failed to capture and save the snapshot: " + e.getMessage());
            }
        } else {
            logInfo("Driver doesn't support snapshots.");
        }
    }
}
