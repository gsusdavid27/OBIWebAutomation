package org.example.pages;

import org.example.InfoReporter;
import org.example.MyDriver; // Importa la clase MyDriver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage extends InfoReporter {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = "circle.ng-star-inserted")
    public WebElement loadingIndicator;

    public BasePage() {
        this.driver = MyDriver.getInstance("").getDriver(); // Utiliza el Singleton de MyDriver
        logInfo("+++Setting Up Factory+++");
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void loadingIndicatorWait(){
        logInfo("Loading Wait...");
        getWait().until(ExpectedConditions.visibilityOf(loadingIndicator));
        getWait().until(ExpectedConditions.invisibilityOf(loadingIndicator));
    }
}
