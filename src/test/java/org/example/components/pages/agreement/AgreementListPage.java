package org.example.components.pages.agreement;

import org.example.components.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * AgreementListPage represents the page for managing agreements.
 */
public class AgreementListPage extends BasePage {
    public AgreementListPage() {}

    @FindBy(css = ".xpo-BoardHeader-title.xpo-BoardHeader-title")
    private WebElement pageTitle;

    @FindBy(css = "button.mat-button.agreement__header__board-actions")
    private WebElement newAgreementButton;

    /**
     * Check the title of the page.
     *
     * @return The text of the page title.
     */
    public String checkTitle() {
        elementLoad(loadingIndicator);
        return pageTitle.getText();
    }

    /**
     * Create a new agreement.
     *
     * @return A new instance of CreateAgreementPage.
     */
    public CreateAgreementPage createNewAgreement() {
        getWait().until(ExpectedConditions.elementToBeClickable(newAgreementButton));
        newAgreementButton.click();
        elementLoad(loadingIndicator);
        return new CreateAgreementPage();
    }
}
