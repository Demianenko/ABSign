package pages.US.mobile;

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

    @FindBy(xpath = "//*[@id=\"yw4\"]/div[2]/div[3]/div[1]/div[1]/div/div")
    @CacheLookup
    public WebElement switchToAnnual;

    @FindBy(xpath =  "//*[@id=\"yw4\"]/div[2]/div[2]/div[1]/div[1]/div/div")
    @CacheLookup
    public WebElement switchToMonth;


    @FindBy(xpath = "//*[@id=\"BillingInfoForm_countryId\"]")
    @CacheLookup
    public WebElement countryDropdown;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_stateId\"]")
    @CacheLookup
    public WebElement stateDropdown;


    @FindBy(xpath =  "//*[@name=\"chkBox\"]")
    @CacheLookup
    public WebElement checkBox;


    @FindBy(xpath =  "//*[@name=\"yt0\"]")
    @CacheLookup
    public WebElement createAccount;

    public Checkout selectBillingCountry(String billingCountryID){
        waitElementForClick(countryDropdown);
        selectDropdownByValue(countryDropdown,billingCountryID);
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


    public Checkout clickCheckBox(){
        waitElementForClick(checkBox).click();
        return this;
    }

    public Review clickCreateAccount(){
        createAccount.click();
        return PageFactory.initElements(driver,Review.class);
    }

}
