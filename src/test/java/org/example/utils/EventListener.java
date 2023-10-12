package org.example.utils;

import org.example.tests.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.format;

public class EventListener extends BaseTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        logInfo(format("Test: %s - [FAIL]", result.getName()));
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
}
