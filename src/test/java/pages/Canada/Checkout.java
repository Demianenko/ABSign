package pages.Canada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;
import pages.UK.Review;

/**
 * Created by user on 22.09.2016.
 */
public class Checkout extends Page {
    public Checkout(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_addressLine1\"]")
    @CacheLookup
    public WebElement addressLine1;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_addressLine2\"]")
    @CacheLookup
    public WebElement addressLine2;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_city\"]")
    @CacheLookup
    public WebElement city;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_zipCode\"]")
    @CacheLookup
    public WebElement zipCode;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_type\"]")
    @CacheLookup
    public WebElement type;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_expirationMonth\"]")
    @CacheLookup
    public WebElement expirationMonth;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_expirationYear\"]")
    @CacheLookup
    public WebElement expirationYear;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_number\"]")
    @CacheLookup
    public WebElement number;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_cvv\"]")
    @CacheLookup
    public WebElement cvv;

    @FindBy(xpath =  "//*[@id=\"yw2\"]/div[6]/div[1]")
    @CacheLookup
    public WebElement switchToAnnual;

    @FindBy(xpath = "//*[@id=\"yw2\"]/div[6]/div[2]")
    @CacheLookup
    public WebElement switchToMonth;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_captchaCode\"]")
    @CacheLookup
    public WebElement captchaCode;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_countryId\"]")
    @CacheLookup
    public WebElement countryDropdown;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_stateId\"]")
    @CacheLookup
    public WebElement stateDropdown;


    @FindBy(xpath =  "//*[@id=\"BillingInfoForm_vatNumber\"]")
    @CacheLookup
    public WebElement vatNumberField;

    @FindBy(xpath =  "//*[@id=\"yw4\"]/div[4]/div[2]/div[2]")
    @CacheLookup
    public WebElement checkBox1;

    @FindBy(xpath =  "//*[@id=\"yw4\"]/div[3]/div[3]/div[2]")
    @CacheLookup
    public WebElement checkBox2;

    @FindBy(xpath =  "//*[@id=\"yw4\"]/div[1]/div[2]/div")
    @CacheLookup
    public WebElement checkBoxShipping;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_firstName\"]")
    @CacheLookup
    public WebElement shippingName;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_lastName\"]")
    @CacheLookup
    public WebElement shippingSurname;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_company\"]")
    @CacheLookup
    public WebElement shippingCompany;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_addressLine1\"]")
    @CacheLookup
    public WebElement shippingAddress1;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_addressLine2\"]")
    @CacheLookup
    public WebElement shippingAddress2;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_city\"]")
    @CacheLookup
    public WebElement shippingCity;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_zipCode\"]")
    @CacheLookup
    public WebElement shippingZipCode;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_stateId\"]")
    @CacheLookup
    public WebElement shippingStateId;

    @FindBy(xpath =  "//*[@name=\"yt0\"]")
    @CacheLookup
    public WebElement reviewButton;

    public Checkout selectBillingCountry(String billingCountryID){
        waitElementForClick(countryDropdown);
        selectDropdownByValue(countryDropdown,billingCountryID);
        return this;
    }

    public Checkout fillVATNumber(String vatNumber){
        waitElementForClick(vatNumberField).sendKeys(vatNumber);
        return this;
    }

    public Checkout fillBillingAddress(String address1, String address2, String cityName, String postCode){
        waitElementForClick(addressLine1).sendKeys(address1);
        addressLine2.sendKeys(address2);
        city.sendKeys(cityName);
        zipCode.sendKeys(postCode);
        return this;
    }

    public Checkout selectCounty (String county){
        waitElementForClick(stateDropdown);
        selectDropdownByValue(stateDropdown,county);
        return this;
    }

    public Checkout switchMonth(){
        waitElementForClick(switchToMonth).click();
        waitForAjax();
        return this;
    }

    public Checkout switchAnnual(){
        waitElementForClick(switchToAnnual).click();
        waitForAjax();
        return this;
    }

    public Checkout setCreditInformation(String creditCardType, String month, String year, String creditCardNumber, String cvvNumber){
        waitElementForClick(type);
        selectDropdownByValue(type,creditCardType);
        selectDropdownByValue(expirationMonth,month);
        selectDropdownByValue(expirationYear,year);
        number.sendKeys(creditCardNumber);
        cvv.sendKeys(cvvNumber);
        return this;
    }

    public Checkout captcha(String captchaValue){
        waitElementForClick(captchaCode).sendKeys(captchaValue);
        checkBox1.click();
        checkBox2.click();
        return this;
    }

    public Checkout clickShippingCheckBox(){
        waitElementForClick(checkBoxShipping).click(); //*[@id="yw4"]/div[1]/div[2]/div
        return this;
    }

    public Checkout setShippingAddress(String name, String surname, String address1, String address2,
                                       String cityName, String postCode, String shippingCompanyName, String county){
        waitElementForClick(shippingAddress1).sendKeys(address1);
        shippingAddress2.sendKeys(address2);
        shippingCity.sendKeys(cityName);
        shippingCompany.sendKeys(shippingCompanyName);
        shippingAddress1.sendKeys(name);
        shippingSurname.sendKeys(surname);
        shippingZipCode.sendKeys(postCode);
        selectDropdownByValue(shippingStateId,county);
        return this;
    }

    public Review clickReviewButton(){
        reviewButton.click();
        return PageFactory.initElements(driver,Review.class);
    }

}
