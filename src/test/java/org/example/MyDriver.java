package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
    private WebDriver driver;

    public MyDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Navegador no válido: " + browser);
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("El controlador no se ha inicializado correctamente.");
        }
        return driver;
    }
}
