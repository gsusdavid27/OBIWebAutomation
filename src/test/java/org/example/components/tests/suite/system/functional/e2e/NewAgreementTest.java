package org.example.components.tests.suite.system.functional.e2e;

import org.example.components.pages.agreement.CreateAgreementPage;
import org.example.components.pages.agreement.AgreementListPage;
import org.example.components.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * FirstTest class containing a series of test cases.
 */
public class NewAgreementTest extends BaseTest {

    private AgreementListPage agreementListPage;
    private CreateAgreementPage createAgreementPage;

    @Test
    public void accessToAgreementListTest() {
        agreementListPage = new AgreementListPage();
        logInfo("TEST-> Correct Access to OBI");
        // Verify if the title contains "Agreement List"
        Assert.assertTrue(agreementListPage.checkTitle().contains("Agreement List"));
    }

    @Test(dependsOnMethods = "accessToAgreementListTest")
    public void changeToCreateAgreementTest() {
        createAgreementPage = agreementListPage.createNewAgreement();
        logInfo("TEST-> Click on Create New Agreement");
        // Verify if the URL contains "/obi-agreement/agreement-create"
        Assert.assertTrue(createAgreementPage.getCurrentUrl().contains("/obi-agreement/agreement-create"));
    }

    @Test(dependsOnMethods = "changeToCreateAgreementTest")
    public void fillCustomerMadCodeTest() {
        createAgreementPage.fillCustomerMADCode("COCVW001900");
        logInfo("TEST-> End To End - System Call - CustomerByMADCode");
        // Assert that the customer name is as expected
        Assert.assertEquals(createAgreementPage.checkCustomerNameUpdate(), "CONKLIN COMPANY INC");
    }

    @Test(dependsOnMethods = "fillCustomerMadCodeTest")
    public void fillAllFields() {
        logInfo("TEST-> Complete Forms");
        // Verify if all fields are successfully filled
        Assert.assertTrue(createAgreementPage.fillAllFields("01/01/2024", "6174", "6174", 364));
    }

    @Test(dependsOnMethods = "fillAllFields")
    public void pressCreateButton() {
        logInfo("TEST-> Creating Agreement");
        // Verify if all fields are successfully filled
        Assert.assertTrue(createAgreementPage.createAgreement());
    }
}
