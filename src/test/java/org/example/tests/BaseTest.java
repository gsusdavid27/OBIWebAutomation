package org.example.tests;

import org.example.MyDriver;
import org.example.pages.HomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
    MyDriver myDriver;
    private HomePage home;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver= new MyDriver(browser);
        home= new HomePage(myDriver.getDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        home.dispose();
    }

    public HomePage getHomePage() {
        return home;
    }
}
