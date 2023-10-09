package org.example.tests;

import org.example.MyDriver;
import org.example.pages.AgreementListPage;
import org.example.pages.MicrosoftSSOPage;
import org.testng.annotations.*;

public abstract class BaseTest {
    public MyDriver myDriver;
    private MicrosoftSSOPage microsoftSSOPage;
    private AgreementListPage agreementListPage;

    //private InventoryPage inventoryPage;


    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser){
        myDriver= new MyDriver(browser);
        microsoftSSOPage= new MicrosoftSSOPage(myDriver.getDriver());
    }

    @BeforeTest(alwaysRun = true)
    @Parameters({ "user", "password" })
    public void login(String user, String pass){
        microsoftSSOPage = getSSOPage();
        microsoftSSOPage.doSSO(user,pass);
    }
    
    @AfterTest(alwaysRun = true)
    public void afterSuite(){
        microsoftSSOPage.dispose();
    }

    public MicrosoftSSOPage getSSOPage() {
        return microsoftSSOPage;
    }


    public AgreementListPage getAgreementListPage() {
        return new AgreementListPage(myDriver.getDriver());
    }


}
