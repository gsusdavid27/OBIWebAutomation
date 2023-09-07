package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="img.inventory_details_img")
    private WebElement productImage;

    public String getProductImage(){
        return productImage.getAttribute("src");//Misma Imagen.
    }
}
