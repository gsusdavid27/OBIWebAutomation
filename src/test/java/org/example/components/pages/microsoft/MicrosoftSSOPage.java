package org.example.components.pages.microsoft;

import org.example.components.pages.BasePage;
import org.example.components.pages.agreement.AgreementListPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Esta página es para el inicio de sesión con SSO.
 */
public class MicrosoftSSOPage extends BasePage {

    @FindBy(css = "input[type=\"email\"][name=\"loginfmt\"]")
    private WebElement userInput;

    @FindBy(css = "input[type=\"password\"][name=\"passwd\"]")
    private WebElement passwordField;

    @FindBy(css = "input.win-button[type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(css = "input[value='No']")
    private WebElement denyStay;

    public MicrosoftSSOPage(String url) {
        super.driver.get(url);
    }

    /**
     * Realiza la autenticación SSO.
     * @param username El nombre de usuario.
     * @param password La contraseña.
     * @return La página de lista de acuerdos.
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
