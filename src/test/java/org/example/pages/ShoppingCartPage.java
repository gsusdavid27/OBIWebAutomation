package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="button#checkout")
    private WebElement buttonCheckout;

    @FindBy(css="button.btn_secondary.btn_small.cart_button")
    private WebElement buttonRemove;
}
