package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @FindBy(css = "input#user-name")
    private WebElement username;

    @FindBy(css = "input#password")
    private WebElement password;
    @FindBy(css="div.error-message-container")
    private WebElement errorMessage;//para verificar que hizo logout.

    @FindBy(css = "input#login-button")
    private  WebElement login_button;

    public InventoryPage login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        getWait().until(ExpectedConditions.elementToBeClickable(login_button));
        login_button.click();
        return new InventoryPage(getDriver());
    }
}
