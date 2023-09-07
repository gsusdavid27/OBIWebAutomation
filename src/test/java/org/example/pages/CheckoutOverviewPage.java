package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BasePage{
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="button#finish")
    private WebElement buttonFinish;

    public CheckoutCompletePage finishProcess(){
        getWait().until(ExpectedConditions.elementToBeClickable(buttonFinish));
        buttonFinish.click();
        return new CheckoutCompletePage(getDriver());
    }
}
