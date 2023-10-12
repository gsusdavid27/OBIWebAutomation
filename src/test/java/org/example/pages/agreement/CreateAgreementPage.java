package org.example.pages.agreement;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

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

    public boolean fillAllFields(String sdate, String vendor, String site, int days){
        effectiveDateField.sendKeys(sdate);
        if(!generateExpiryDate(sdate,days).equals(expiryDateField.getText())){
            return false;
        }
        vendorCode.sendKeys(vendor);
        siteCode.sendKeys(site);
        if(!costumerName.equals(madCodeField.getText())){
            return false;
        }
        return true;
    }

    public String generateExpiryDate(String sdate, int days){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(sdate);
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, days);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(calendar.getTime());
    }
}
