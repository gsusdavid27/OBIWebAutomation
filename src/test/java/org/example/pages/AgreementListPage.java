package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AgreementListPage extends BasePage{
    public AgreementListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.mat-button.agreement__header__board-actions\n")
    private WebElement newAgreementButton;


    public void createNewAgreement() {
        getWait().until(ExpectedConditions.elementToBeClickable(newAgreementButton));
        newAgreementButton.click();
    }
}
