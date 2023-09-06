package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.title")
    private WebElement title;
    @FindBy(css="div.inventory_item_name ")
    private WebElement aProductName;

    @FindBy(css="div.inventory_item_img")
    private WebElement aProductImage;
    @FindBy(css = "button.btn_primary")
    private  WebElement buttonAddToCart; //para cualquiera

    private String getProductNameAddedToCart(){
        WebElement productInfoElement = buttonAddToCart.findElement(By.xpath("./ancestor::div[@class='inventory_item']"));
        WebElement productNameElement = productInfoElement.findElement(By.className("inventory_item_name"));
        return productNameElement.getText();
    }

    public String getPageTitle(){
        return title.getText();//Que diga "Products"
    }





}
