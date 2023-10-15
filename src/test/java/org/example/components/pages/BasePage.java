package org.example.components.pages;

import org.example.InfoReporter;
import org.example.components.MyDriver;
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
        this.driver = MyDriver.getInstance("").getDriver();
        logInfo("+++Setting Up Factory+++");
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void elementLoad(WebElement element){
        logInfo("Loading Wait...");
        getWait().until(ExpectedConditions.visibilityOf(element));
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }
}
