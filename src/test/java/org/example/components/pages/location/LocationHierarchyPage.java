package org.example.components.pages.location;

import java.util.List;

import org.example.components.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LocationHierarchyPage extends BasePage {
    public LocationHierarchyPage(){}

    @FindBy(css = "xpo-board-header-title.xpo-BoardHeader-title")
    private WebElement pageTitle;

    @FindAll({
            @FindBy(css = "input.mat-checkbox-input")
    })
    private List<WebElement> checkBoxes;


     public String checkTitle(){
        loadingGifWait(loadingIndicator);
        logInfo("Waiting for load...");
        getWait().until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    public Boolean selectAll(){
        logInfo("Select All->>");
        checkBoxes.get(1).click();
        return true;
    }

    

}
