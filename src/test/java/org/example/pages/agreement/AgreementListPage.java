package org.example.pages.agreement;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
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
        loadingIndicatorWait();
        return pageTitle.getText();
    }
    public CreateAgreementPage createNewAgreement() {
        getWait().until(ExpectedConditions.elementToBeClickable(newAgreementButton));
        newAgreementButton.click();
        loadingIndicatorWait();
        return new CreateAgreementPage();
    }
}