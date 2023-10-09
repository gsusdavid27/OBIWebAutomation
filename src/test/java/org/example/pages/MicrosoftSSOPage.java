package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This Page is For the Login With SSO
 */
public class MicrosoftSSOPage extends BasePage{

    public MicrosoftSSOPage(WebDriver driver) {
        super(driver);
        driver.get("https://obi-g.dev-ltl-xpo.com/");
    }

    @FindBy(css = "input[type=\"email\"][name=\"loginfmt\"]\n")
    private WebElement userInput;

    @FindBy(css = "input[type=\"password\"][name=\"passwd\"]\n")
    private WebElement passwordField;

    @FindBy(css = "input.win-button[type=\"submit\"]\n")
    private  WebElement submitButton;

    @FindBy(css = "input[value='No']\n")
    private  WebElement denyStay;

/*
    public InventoryPage login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        getWait().until(ExpectedConditions.elementToBeClickable(login_button));
        login_button.click();
        return new InventoryPage(getDriver());
    }
*/

    public void doSSO(String username, String password){
        getWait().until(ExpectedConditions.elementToBeClickable(userInput));
        userInput.sendKeys(username);
        submitButton.click();
        getWait().until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
        submitButton.click();
        getWait().until(ExpectedConditions.elementToBeClickable(denyStay));
        denyStay.click();

    }
/*
    public String getTitle(){
        getWait().until(ExpectedConditions.visibilityOf(title));
        return title.getText();
    }
*/
}

