package org.example.components.pages.program;

import org.example.components.pages.BasePage;
import org.openqa.selenium.By;
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


    @FindBy(css = "#mat-input-26")
    private WebElement interStateInput;
    @FindBy(css = "#mat-input-27")
    private WebElement intraStateInput;
    @FindBy(css = "#mat-input-28")
    private WebElement internationalInput;

    @FindBy(css = "input#mat-checkbox-8-input")
    private WebElement otbdCheckBox;

    @FindBy(css = "input#mat-checkbox-11-input")
    private WebElement inbdCheckBox;

    @FindBy(css = "#mat-input-20")
    private WebElement maxDiscInput;

    @FindBy(css = "#mat-input-23")
    private WebElement maxDaysInput;


    public String checkTitle(){
        getWait().until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }


    public boolean fillAll(String type,
                           Double rate,
                           String payOn,
                           String rateType,
                           Double interState,
                           Double intraState,
                           Double international,
                           Double maxDisc,
                           Double maxDays) {
        loadingGifWait(loadingIndicator);

        selectProgramType.click();
        for(int i=0; i<selectType.size(); i++){
            if(selectType.get(i).getText().contains(type)){
                selectType.get(i).click();
            }
        }
        getWait().until(ExpectedConditions.elementToBeClickable(renewProgramCheckBox));
        renewProgramCheckBox.click();
        commonRateInput.sendKeys(rate.toString());
        interStateCheckBox.click();
        intraStateCheckBox.click();
        internationalCheckBox.click();

        selectPayOn.click();
        for (WebElement element : selectType) {
            getWait().until(ExpectedConditions.visibilityOf(element));
            if (element.getText().contains(payOn)) {
                element.click();
                break; // Termina el bucle una vez que se encuentra el elemento deseado
            }
        }
        selectRateType.click();
        getWait().until(ExpectedConditions.elementToBeClickable(rateTypeOption));
        rateTypeOption.click();

        interStateInput.sendKeys(interState.toString());
        intraStateInput.sendKeys(intraState.toString());
        internationalInput.sendKeys(international.toString());
        otbdCheckBox.click();
        inbdCheckBox.click();
        maxDiscInput.sendKeys(maxDisc.toString());
        maxDaysInput.sendKeys(maxDays.toString());

        return true;
    }
}
