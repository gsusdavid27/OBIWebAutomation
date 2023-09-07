package org.example.tests;

import org.example.pages.HomePage;
import org.example.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    private InventoryPage inventoryPage;
    @Test
    public void selectProductTest() {
        inventoryPage = getInventoryPage();
        Assert.assertEquals(inventoryPage.logOut().getTitle(),"Swag Labs");
    };
}
