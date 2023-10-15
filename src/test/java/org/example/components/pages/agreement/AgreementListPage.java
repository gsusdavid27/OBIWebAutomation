package org.example.components.pages.agreement;

import org.example.components.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

//https://obi-g.dev-ltl-xpo.com/obi-agreement/list-page
public class AgreementListPage extends BasePage {
    public AgreementListPage() {}

    @FindBy(css = ".xpo-BoardHeader-title.xpo-BoardHeader-title")
    private WebElement pageTitle;

    @FindBy(css = "button.mat-button.agreement__header__board-actions")
    private WebElement newAgreementButton;

    public String checkTitle(){
        elementLoad(loadingIndicator);
        return pageTitle.getText();
    }
    public CreateAgreementPage createNewAgreement() {
        getWait().until(ExpectedConditions.elementToBeClickable(newAgreementButton));
        newAgreementButton.click();
        elementLoad(loadingIndicator);
        return new CreateAgreementPage();
    }
}