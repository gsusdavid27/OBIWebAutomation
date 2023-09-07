package org.example.tests;

import org.example.pages.HomePage;
import org.example.pages.InventoryPage;
import org.example.pages.ProductPage;
import org.example.pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteTest extends BaseTest{
    private InventoryPage inventoryPage;
    private ShoppingCartPage shoppingCartPage;

    @Test
    public void selectProductTest() {
        inventoryPage = getInventoryPage();
        inventoryPage.selectProducts(3);
    };

    @Test(dependsOnMethods = "selectProductTest")
    public void removeFromCartTest() {
        shoppingCartPage = inventoryPage.goToCart();
        shoppingCartPage.removeProducts();
        Assert.assertEquals(true,shoppingCartPage.cartEmpty());
    }
}
