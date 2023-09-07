package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.title")
    private WebElement title;
    @FindBy(css="div.inventory_item_name ")
    private WebElement aProductName;

    @FindAll(@FindBy(css = ".inventory_item"))
    private List<WebElement> inventoryItems;

    @FindBy(css="img[src*='sauce-backpack']")
    private WebElement aProductImage;
    @FindBy(css = "button.btn_primary")
    private  WebElement buttonAddToCart; //para cualquiera

    public String getProductImageSRC(){
        return aProductImage.getAttribute("src");//Devuelve la referencia del recurso.
    }

    public ProductPage details(){
        getWait().until(ExpectedConditions.elementToBeClickable(aProductName));
        aProductName.click();
        return new ProductPage(getDriver());
    }

    public void selectProducts(int n) {
        for (int i = 0; i < n; i++) {
            WebElement product = inventoryItems.get(i);
            WebElement addToCartButton = product.findElement(By.xpath(".//button[@class='btn btn_primary btn_small btn_inventory']"));
            addToCartButton.click();
        }
    }

    public ShoppingCartPage goToCart(){
        getWait().until(ExpectedConditions.elementToBeClickable(shoppingCart));
        shoppingCart.click();
        return new ShoppingCartPage(getDriver());
    }

    public HomePage logOut(){
        getWait().until(ExpectedConditions.elementToBeClickable(burgerMenu));
        burgerMenu.click();
        getWait().until(ExpectedConditions.elementToBeClickable(logOut));
        logOut.click();
        return new HomePage(getDriver());
    }
}
