package org.example.pages.agreement;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//https://obi-g.dev-ltl-xpo.com/obi-agreement/agreement-create
public class CreateAgreementPage extends BasePage {
    @FindBy(css = "input[formcontrolname=\"madCode\"]")
    private WebElement madCodeField;

    @FindBy(css="strong")
    private WebElement costumerName;

    @FindBy(css="input[formcontrolname=\"remittanceName\"]")
    private WebElement remittanceInput;
    public CreateAgreementPage(WebDriver driver) {
        super(driver);
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public void fillCusomerMadCode(String input){
        madCodeField.sendKeys(input);
    }

    public String checkCostumerNameUpdate(){
        remittanceInput.click();
        loadingIndicatorWait();
        return costumerName.getText();
    }
}
