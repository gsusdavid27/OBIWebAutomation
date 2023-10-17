package org.example.components;

import org.example.InfoReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * MyDriver class for managing the Selenium WebDriver.
 */
public class MyDriver extends InfoReporter {
    private static MyDriver instance; // Singleton instance
    private WebDriver driver;

    /**
     * Private constructor to ensure a single instance of the driver.
     *
     * @param browser The browser to use ("chrome" or "firefox").
     */
    private MyDriver(String browser) {
        logInfo("Setting up the browser");
        try {
            switch (browser.toLowerCase()) {
                case "firefox":
                    this.driver = new FirefoxDriver();//hay que modificar funcionamiento
                    break;
                case "chrome":
                    this.driver = new ChromeDriver();
                    break;
                case "edge":
                    this.driver = new EdgeDriver();//hay que modificar funcionamiento
                    break;
                default:
                    logWarning("Stopped -> Invalid browser: " + browser);
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }
        } catch (Exception e) {
            logError("Error initializing WebDriver: " + e.getMessage());
            throw new RuntimeException("WebDriver initialization failed", e);
        }
    }

    /**
     * Get a single instance of MyDriver.
     *
     * @param browser The browser to use ("chrome" or "firefox").
     * @return The unique instance of MyDriver.
     */
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

    /**
     * Get the WebDriver instance.
     *
     * @return The WebDriver instance.
     */
    public WebDriver getDriver() {
        if (driver == null) {
            logWarning("The driver has not been initialized correctly.");
        }
        return driver;
    }

    /**
     * Close the WebDriver if it is open.
     */
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
