package org.example.components.pages.agreement;

import org.example.components.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//https://obi-g.dev-ltl-xpo.com/obi-agreement/agreement-create
public class CreateAgreementPage extends BasePage {
    @FindBy(css = "input[formcontrolname=\"madCode\"]")
    private WebElement madCodeField;

    @FindBy(css="strong")
    private WebElement costumerName;

    @FindBy(css="input[formcontrolname=\"remittanceName\"]") //Debe ser igual a costumer Name.
    private WebElement remittanceInput;

    @FindBy(css = "input[formcontrolname=\"effectiveDate\"]")
    private WebElement effectiveDateField;

    @FindBy(css = "input[formcontrolname=\"expiryDate\"]")
    private WebElement expiryDateField;

    @FindBy(css = "input[formcontrolname=\"vendorCode\"]")
    private WebElement vendorCode;

    @FindBy(css = "input[formcontrolname=\"siteCode\"]")
    private WebElement siteCode;

    public CreateAgreementPage() {}
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public void fillCusomerMadCode(String input){
        madCodeField.sendKeys(input);
    }

    public String checkCostumerNameUpdate(){
        remittanceInput.click();
        elementLoad(loadingIndicator);
        return costumerName.getText();
    }

    public boolean fillAllFields(String sdate, String vendor, String site, int days){
        effectiveDateField.sendKeys(sdate);
        remittanceInput.click();
        if(!generateExpiryDate(sdate,days).contains(expiryDateField.getText())){
            return false;
        }
        vendorCode.sendKeys(vendor);
        siteCode.sendKeys(site);
        return true;
    }

    public String generateExpiryDate(String sdate, int days){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(sdate);
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, days);
        } catch (ParseException e) {}
        return sdf.format(calendar.getTime());
    }
}
