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
    public void fillProgramFields(){
        Assert.assertTrue(programCreationPage.fillAll("EOM",
                1.5,"Gross"," Percentage ",102d,102d,149d,74.1,36d));
    }


}
