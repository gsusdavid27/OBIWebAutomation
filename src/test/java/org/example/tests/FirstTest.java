package org.example.tests;

import org.example.pages.agreement.CreateAgreementPage;
import org.example.pages.agreement.AgreementListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    private AgreementListPage agreementListPage;
    private CreateAgreementPage createAgreementPage;
    @Test
    public void accessToAgreementListTest(){
        agreementListPage =  getAgreementListPage();
        logInfo("TEST-> Correct Access to OBI");
        Assert.assertTrue(agreementListPage.checkTitle().contains("Agreement List"));
    }

    @Test(dependsOnMethods = "accessToAgreementListTest")
    public void changeToCreateAgreementTest(){
        createAgreementPage =agreementListPage.createNewAgreement();
        logInfo("TEST-> Click on Create New Agreement");
        Assert.assertTrue(createAgreementPage.getCurrentUrl().contains("/obi-agreement/agreement-create"));
    }
    @Test(dependsOnMethods = "changeToCreateAgreementTest")
    public void fillCostumerMadCodeTes(){
        createAgreementPage.fillCusomerMadCode("COCVW001900");
        logInfo("TEST-> End To End - System Call - CostumerByMadCode");
        Assert.assertEquals(createAgreementPage.checkCostumerNameUpdate(),"CONKLIN COMPANY INC");
    }

    @Test(dependsOnMethods = "fillCostumerMadCodeTes")
    public void fillAllFields(){
        logInfo("TEST-> Complete Forms");
        Assert.assertTrue( createAgreementPage.fillAllFields("01/01/2024","6174","6174",364) );
    }
}
