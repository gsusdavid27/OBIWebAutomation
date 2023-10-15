package org.example.components;

import org.example.InfoReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver extends InfoReporter {
    private static MyDriver instance; // Instancia única
    private WebDriver driver;

    private MyDriver(String browser) {
        logInfo("SetUp the Browser");
        try {
            switch (browser.toLowerCase()) {
                case "firefox":
                    this.driver = new FirefoxDriver();
                    break;
                case "chrome":
                    this.driver = new ChromeDriver();
                    break;
                default:
                    logWarning("Stopped->Invalid Browser"+browser);
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }
        } catch (Exception e) {
            logError("Error initializing WebDriver: " + e.getMessage());
            throw new RuntimeException("WebDriver initialization failed", e);
        }
    }

    public static MyDriver getInstance(String browser) {
        if (instance == null) {
            synchronized (MyDriver.class) {
                if (instance == null) {
                    instance = new MyDriver(browser);
                }
            }
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            logWarning("El controlador no se ha inicializado correctamente.");
        }
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
