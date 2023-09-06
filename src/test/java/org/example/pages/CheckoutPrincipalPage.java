package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPrincipalPage extends BasePage{

    public CheckoutPrincipalPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="input[data-test=firstName]")
    private WebElement inputFirstName;
    @FindBy(css="input[data-test=lastName]")
    private WebElement inputLastName;
    @FindBy(css="input[data-test=postalCode]")
    private WebElement inputPostalCode;
    @FindBy(css="input[data-test=continue]")
    private WebElement buttonContinue;


}
