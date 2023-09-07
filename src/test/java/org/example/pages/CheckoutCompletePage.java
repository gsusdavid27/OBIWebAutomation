package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="h2.complete-header")
    private WebElement textMessage;

    public String getConfirmationMessage(){
        getWait().until(ExpectedConditions.visibilityOf(textMessage));
        return textMessage.getText();
    }
}
