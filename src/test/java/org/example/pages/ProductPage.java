package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="div.inventory_details_name")
    private WebElement productName;
    @FindBy(css="img.inventory_details_img")
    private WebElement productImage;

    @FindBy(css = "button.btn_primary")
    private  WebElement buttonAddToCart;

    public String getProductImage(){
        return productImage.getAttribute("src");//Misma Imagen.
    }

    public String getProductName(){
        return productImage.getText();//Mismo producto.
    }
}
