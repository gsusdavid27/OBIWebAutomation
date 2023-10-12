package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = "circle.ng-star-inserted")
    public WebElement loadingIndicator;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void loadingIndicatorWait(){
        getWait().until(ExpectedConditions.visibilityOf(loadingIndicator));
        getWait().until(ExpectedConditions.invisibilityOf(loadingIndicator));
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void dispose() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                // Manejo de excepciones en caso de problemas al cerrar el navegador
                e.printStackTrace();
            }
        }
    }
}
