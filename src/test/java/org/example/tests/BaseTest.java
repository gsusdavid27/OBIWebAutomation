package org.example.tests;

import org.example.MyDriver;
import org.example.pages.HomePage;
import org.example.pages.InventoryPage;
import org.testng.annotations.*;

public abstract class BaseTest {
    public MyDriver myDriver;
    private HomePage home;
    private InventoryPage inventoryPage;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver= new MyDriver(browser);
        home= new HomePage(myDriver.getDriver());
    }

    @BeforeTest(alwaysRun = true)
    @Parameters({ "user", "password" })
    public void login(String user, String pass){
        inventoryPage=home.login(user, pass);
    }
    
    @AfterTest(alwaysRun = true)
    public void afterSuite(){
        home.dispose();
    }

    public HomePage getHomePage() {
        return home;
    }

    public InventoryPage getInventoryPage() {
        return inventoryPage;
    }
}
