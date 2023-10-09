package org.example.tests;

import org.example.pages.AgreementListPage;
import org.example.pages.MicrosoftSSOPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    private AgreementListPage agreementListPage;
    @Test
    public void loginWithSSO(){
        agreementListPage =  getAgreementListPage();
        agreementListPage.createNewAgreement();
    }


    /*
    private InventoryPage inventoryPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;

    @Test
    public void selectProductTest() {
        inventoryPage = getInventoryPage();
        productPage = inventoryPage.details();
        Assert.assertEquals(productPage.getProductImage(), inventoryPage.getProductImageSRC());
    }

    @Test(dependsOnMethods = "selectProductTest")
    public void addToCartTest() {
        shoppingCartPage = productPage.goToShoppingCart();
    }

    @Test(dependsOnMethods = "addToCartTest")
    public void checkoutTest() {
        CheckoutPrincipalPage checkout_01 = shoppingCartPage.checkout();
        CheckoutOverviewPage checkout_02 = checkout_01.provideData("Samuel", "Traslaviña", "123456");
        CheckoutCompletePage checkout_03 = checkout_02.finishProcess();
        Assert.assertEquals("Thank you for your order!", checkout_03.getConfirmationMessage());
    }

     */
}
