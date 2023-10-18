package org.example.components.tests.suite.system.functional.e2e;

import org.example.components.pages.program.ProgramCreationPage;
import org.example.components.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProgramCreationTest extends BaseTest {

    private ProgramCreationPage programCreationPage;

    @Test
    public void accessToProgramCreation(){
        programCreationPage= new ProgramCreationPage();
        Assert.assertTrue(programCreationPage.checkTitle().contains("Program creation for"));
    }

    @Test(dependsOnMethods = "accessToProgramCreation")
    public void fillFirstLayerFields(){
        logInfo("Filling First Layer");
        Assert.assertTrue(programCreationPage.firstFilling("EOM",
                1.5));
    }

    @Test(dependsOnMethods = "fillFirstLayerFields")
    public void fillSecondLayerFields(){
        logInfo("Filling Second Layer");
        Assert.assertTrue(programCreationPage.secondFilling("Gross"," Percentage ",102,102,149));
    }

    @Test(dependsOnMethods = "fillSecondLayerFields")
    public void fillThirdLayerFields(){
        logInfo("Filling Third Layer");
        Assert.assertTrue(programCreationPage.thirdFilling());
    }

    @Test(dependsOnMethods = "fillThirdLayerFields")
    public void fillFourthLayerFields(){
        logInfo("Filling Fourth Layer");
        Assert.assertTrue(programCreationPage.fourthFilling(74.1,36));
    }


}
