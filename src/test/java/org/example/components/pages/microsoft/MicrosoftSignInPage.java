package org.example.components.pages.microsoft;

import org.example.components.pages.BasePage;
import org.example.components.pages.agreement.AgreementListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This page is for Single Sign-On (SSO) login.
 */
public class MicrosoftSignInPage extends BasePage {

    @FindBy(css = "input[type=\"email\"][name=\"loginfmt\"]")
    private WebElement userInput;

    @FindBy(css = "input[type=\"password\"][name=\"passwd\"]")
    private WebElement passwordField;

    @FindBy(css = "input.win-button[type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(css = "input[value='No']")
    private WebElement denyStay;

    public MicrosoftSignInPage(String url) {
        super.driver.get(url);
    }

    /**
     * Perform Single Sign-On (SSO) authentication.
     * @param username The username.
     * @param password The password.
     * @return The AgreementListPage.
     */
    public AgreementListPage doSSO(String username, String password) {
        getWait().until(ExpectedConditions.elementToBeClickable(userInput));
        userInput.sendKeys(username);
        submitButton.click();

        getWait().until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
        submitButton.click();

        getWait().until(ExpectedConditions.elementToBeClickable(denyStay));
        denyStay.click();

        return new AgreementListPage();
    }
}
