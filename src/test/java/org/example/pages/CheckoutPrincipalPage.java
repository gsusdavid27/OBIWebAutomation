package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPrincipalPage extends BasePage{
    private List<WebElement> forms = new ArrayList<>();
    @FindBy(css="input[data-test=firstName]")
    private WebElement inputFirstName;
    @FindBy(css="input[data-test=lastName]")
    private WebElement inputLastName;
    @FindBy(css="input[data-test=postalCode]")
    private WebElement inputPostalCode;
    @FindBy(css="input[data-test=continue]")
    private WebElement buttonContinue;
    public CheckoutPrincipalPage(WebDriver driver) {
        super(driver);
        forms.add(inputFirstName);
        forms.add(inputLastName);
        forms.add(inputPostalCode);
        forms.add(buttonContinue);
    }

    public CheckoutOverviewPage provideData(String firstName, String lastName, String postalCode){
        getWait().until(ExpectedConditions.visibilityOfAllElements(this.forms));
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputPostalCode.sendKeys(postalCode);
        buttonContinue.click();
        return new CheckoutOverviewPage(getDriver());
    }


}
