package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver extends InfoReporter {
    private static MyDriver instance; // Instancia única
    private WebDriver driver;

    private MyDriver(String browser) {
        logInfo("SetUp the Browser");
        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                logWarning("Stopped->Invalid Browser");
        }
    }

    public static MyDriver getInstance(String browser) {
        if (instance == null) {
            instance = new MyDriver(browser);
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            logWarning("El controlador no se ha inicializado correctamente.");
        }
        return driver;
    }
}
