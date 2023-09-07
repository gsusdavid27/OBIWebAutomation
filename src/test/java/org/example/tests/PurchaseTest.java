package org.example.tests;

import junit.framework.Assert;
import org.example.pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurchaseTest extends BaseTest {

    @Test
    public void purchaseTest(){
        SoftAssert softAssert = new SoftAssert();

        HomePage home = getHomePage();
        InventoryPage inventoryPage = home.login("standard_user", "secret_sauce");
        softAssert.assertEquals(inventoryPage.getPageTitle(), "Products");

        ProductPage productPage = inventoryPage.details();
        softAssert.assertEquals(productPage.getProductImage(), inventoryPage.getProductImageSRC());

        ShoppingCartPage shoppingCartPage = productPage.goToShoppingCart();
        CheckoutPrincipalPage checkout_01 = shoppingCartPage.checkout();
        CheckoutOverviewPage checkout_02 = checkout_01.provideData("Samuel", "Traslaviña", "123456");
        CheckoutCompletePage checkout_03 = checkout_02.finishProcess();

        softAssert.assertEquals("Thank you for your order!", checkout_03.getConfirmationMessage());

// Realiza una verificación suave, esto verifica todas las aserciones pero no lanza una excepción inmediatamente si alguna falla.
        softAssert.assertAll();
    }

}
