package org.example.pages;

import io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AgreementListPage extends BasePage{
    public AgreementListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.mat-button.agreement__header__board-actions")
    private WebElement newAgreementButton;


    public void createNewAgreement() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("circle.ng-star-inserted")));
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("circle.ng-star-inserted")));
        WebElement button = getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.mat-button.agreement__header__board-actions")));
        button.click();
    }
}
