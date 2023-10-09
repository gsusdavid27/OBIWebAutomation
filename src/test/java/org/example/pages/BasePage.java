package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Elementos comunes
    /*
    @FindBy(css = "a.shopping_cart_link")
    public WebElement shoppingCart;//Para algunas páginas

    @FindBy(css="button#react-burger-menu-btn")
    public WebElement burgerMenu;

    @FindBy(css="a#logout_sidebar_link")
    public WebElement logOut;
*/
    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    public WebDriverWait getWait(){
        return wait;
    }


    protected WebDriver getDriver(){
        return driver;
    }
    /*
    public ShoppingCartPage goToShoppingCart(){
        getWait().until(ExpectedConditions.elementToBeClickable(shoppingCart));
        shoppingCart.click();
        return new ShoppingCartPage(getDriver());
    }
*/
    public void dispose(){
        if(driver!= null){
            driver.quit();
        }
    }
}
