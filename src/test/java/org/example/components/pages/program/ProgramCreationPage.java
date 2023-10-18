package org.example.components.pages.program;

import org.example.components.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProgramCreationPage extends BasePage {
    public ProgramCreationPage() {}

    @FindBy(css = "div.detail-title")
    private WebElement pageTitle;

    @FindBy(css = "#mat-select-4")
    private WebElement selectProgramType;

     @FindAll({
            @FindBy(css = "span.mat-option-text")
    })
    private List<WebElement> selectType;

    @FindBy(css = "mat-checkbox[formcontrolname=\"renewProgramInd\"]")
    private WebElement renewProgramCheckBox;

    @FindBy(css = "div.mat-form-field-infix input[formcontrolname=\"commonRate\"]")
    private WebElement commonRateInput;

    @FindBy(css = "mat-checkbox[formcontrolname=\"interStateInd\"]")
    private WebElement interStateCheckBox;

    @FindBy(css = "mat-checkbox[formcontrolname=\"intraStateInd\"]")
    private WebElement intraStateCheckBox;

    @FindBy(css = "mat-checkbox[formcontrolname=\"canadianInd\"]")
    private WebElement internationalCheckBox;

    @FindBy(css = "#mat-select-2")
    private WebElement selectPayOn;

    @FindBy(css = "#mat-select-10")
    private WebElement selectRateType;


    @FindBy(css = "div.mat-select-panel mat-option.mat-option:first-child .mat-option-text")
    private WebElement rateTypeOption;


    @FindBy(css = "mat-form-field.no-margin input[formcontrolname=\"interStateAmcAmount\"]")
    private WebElement interStateInput;
    @FindBy(css = "mat-form-field.no-margin input[formcontrolname=\"intraStateAmcAmount\"]")
    private WebElement intraStateInput;
    @FindBy(css = "mat-form-field.no-margin input[formcontrolname=\"canadianAmcAmount\"]")
    private WebElement internationalInput;

    @FindBy(css = "mat-checkbox[formcontrolname=\"outboundPrepaidCd\"]")
    private WebElement otbdCheckBox;

    @FindBy(css = "mat-checkbox[formcontrolname=\"inboundCollectCd\"]")
    private WebElement inbdCheckBox;

    @FindBy(css = "#mat-input-25")
    private WebElement maxDiscInput;

    @FindBy(css = "#mat-input-27")
    private WebElement maxDaysInput;

    @FindBy(css = "button.create-button")
    private WebElement createButton;


    public String checkTitle(){
        loadingGifWait(loadingIndicator);
        logInfo("Waiting for load...");
        getWait().until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }


    public boolean firstFilling(String type,Double rate) {
        logInfo("Step-Select Program Type");
        selectProgramType.click();
        for (WebElement element : selectType) {
            if (element.getText().contains(type)) {
                element.click();
                break; // Termina el bucle una vez que se encuentra el elemento deseado
            }
        }
        logInfo("Step-Click Renew ChaeckBox");
        getWait().until(ExpectedConditions.elementToBeClickable(renewProgramCheckBox));
        renewProgramCheckBox.click();

        logInfo("Step-Fill common Rate");
        commonRateInput.click();
        commonRateInput.clear();
        commonRateInput.sendKeys(rate.toString());

        return true;
    }

     public boolean secondFilling(
                           String payOn,
                           String rateType,
                           Integer interState,
                           Integer intraState,
                           Integer international) {
        logInfo("Step-2/////");

        logInfo("Step-Selecting States");
        interStateCheckBox.click();
        intraStateCheckBox.click();
        internationalCheckBox.click();
        
        logInfo("Step-Select PayOn");        
        selectPayOn.click();
        for (WebElement element : selectType) {
            getWait().until(ExpectedConditions.visibilityOf(element));
            if (element.getText().contains(payOn)) {
                getWait().until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break; // Termina el bucle una vez que se encuentra el elemento deseado
            }
        }
        
        logInfo("Step-Filling States");

        interStateInput.click();
        interStateInput.clear();
        interStateInput.sendKeys(interState.toString());

        intraStateInput.click();
        intraStateInput.clear();
        intraStateInput.sendKeys(intraState.toString());

        internationalInput.click();
        internationalInput.clear();
        internationalInput.sendKeys(international.toString());

        logInfo("Step-Select Rate Type");
        selectRateType.click();
        getWait().until(ExpectedConditions.elementToBeClickable(rateTypeOption));
        rateTypeOption.click();


        logInfo("Steps-2-Done");

        return true;
    }
     public boolean thirdFilling() {
        logInfo("Steps-3....");
        getWait().until(ExpectedConditions.elementToBeClickable(otbdCheckBox));
        otbdCheckBox.click();
        inbdCheckBox.click();

        return true;
    }
    public boolean fourthFilling(Double maxDisc, Integer maxDays) {
        //falta un checkBox
        logInfo("Steps-3....");
        maxDiscInput.sendKeys(maxDisc.toString());
        maxDaysInput.sendKeys(maxDays.toString());

        getWait().until(ExpectedConditions.elementToBeClickable(createButton));
        createButton.click();
        return true;
    }
}
/**
 * Note: Just a program per Type.
 */
