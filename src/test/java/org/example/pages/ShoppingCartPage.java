package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="button#checkout")
    private WebElement buttonCheckout;

    @FindAll(@FindBy(css = ".cart_item"))
    private List<WebElement> cartItems;

    public CheckoutPrincipalPage checkout(){
        getWait().until(ExpectedConditions.elementToBeClickable(buttonCheckout));
        buttonCheckout.click();
        return new CheckoutPrincipalPage(getDriver());
    }

    public void removeProducts() {
        for (WebElement cartItem : cartItems) {
            WebElement removeButton = cartItem.findElement(By.xpath(".//button[@class='btn btn_secondary btn_small cart_button']"));
            removeButton.click();
        }
    }

    public boolean cartEmpty(){
        if(cartItems.isEmpty()){
            return true;
        }
        return false;
    }
}
