package org.example.components.tests.suite.system.functional.e2e;

import org.example.components.pages.location.LocationHierarchyPage;
import org.example.components.tests.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class LocationHierarchyTest extends BaseTest{
    private LocationHierarchyPage locationHierarchyPage;

    @Test
    public void loadDialoguePopup(){
        Assert.assertTrue(locationHierarchyPage.checkTitle().contains("Location Hierarchy"));
    }

    @Test
    public void selectAllLocations(){
        locationHierarchyPage.selectAll();
        
    }

}
