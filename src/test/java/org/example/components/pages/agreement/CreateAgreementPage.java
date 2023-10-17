package org.example.components.pages.agreement;

import org.example.components.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * CreateAgreementPage represents the page for creating agreements.
 */
public class CreateAgreementPage extends BasePage {
    @FindBy(css = "input[formcontrolname=\"madCode\"]")
    private WebElement madCodeField;

    @FindBy(css = "strong")
    private WebElement customerName;

    @FindBy(css = "input[formcontrolname=\"remittanceName\"]")
    private WebElement remittanceInput;

    @FindBy(css = "input[formcontrolname=\"effectiveDate\"]")
    private WebElement effectiveDateField;

    @FindBy(css = "input[formcontrolname=\"expiryDate\"]")
    private WebElement expiryDateField;

    @FindBy(css = "input[formcontrolname=\"vendorCode\"]")
    private WebElement vendorCode;

    @FindBy(css = "input[formcontrolname=\"siteCode\"]")
    private WebElement siteCode;
    @FindBy(css = "textarea[formcontrolname=\"agreementComment\"]")
    private WebElement commentInput;

    @FindBy(css="button.mat-flat-button")
    private WebElement createButton;

    @FindBy(css="div.xpo-Notification-message-mainMessage")
    private WebElement successCard;


    public CreateAgreementPage() {}

    /**
     * Get the current URL of the page.
     *
     * @return The current URL of the page.
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Fill the MAD Code for the customer.
     *
     * @param input The MAD Code input.
     */
    public void fillCustomerMADCode(String input) {
        madCodeField.sendKeys(input);
    }

    /**
     * Check the customer name update and return it.
     *
     * @return The updated customer name.
     */
    public String checkCustomerNameUpdate() {
        remittanceInput.click();
        loadingGifWait(loadingIndicator);
        return customerName.getText();
    }

    /**
     * Fill all the required fields for creating an agreement.
     *
     * @param sdate  The effective date.
     * @param vendor The vendor code.
     * @param site   The site code.
     * @param days   The number of days to add to the effective date for the expiry date.
     * @return True if all fields are successfully filled, false otherwise.
     */
    public boolean fillAllFields(String sdate, String vendor, String site, int days) {
        effectiveDateField.sendKeys(sdate);
        remittanceInput.click();
        if (!generateExpiryDate(sdate, days).contains(expiryDateField.getText())) {
            return false;
        }
        vendorCode.sendKeys(vendor);
        siteCode.sendKeys(site);
        commentInput.sendKeys("This is a GSUS-TEST");
        return true;
    }

    /**
     * Generate the expiry date based on the effective date and the number of days.
     *
     * @param sdate The effective date in "MM/dd/yyyy" format.
     * @param days  The number of days to add.
     * @return The generated expiry date in "MM/dd/yyyy" format.
     */
    public String generateExpiryDate(String sdate, int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(sdate);
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, days);
        } catch (ParseException e) {
            // Handle the exception if needed.
        }
        return sdf.format(calendar.getTime());
    }

    public boolean createAgreement(){
        try{
            getWait().until(ExpectedConditions.visibilityOf(createButton));
            createButton.click();
            getWait().until(ExpectedConditions.visibilityOf(successCard));
        }catch (Exception e){
            return false;
        }
        return true;
    }


}
