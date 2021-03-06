package pages.US;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;

/**
 * Created by user on 22.09.2016.
 */
public class Checkout extends Page {
    public Checkout(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_addressLine1\"]")
    private WebElement addressLine1;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_addressLine2\"]")
    private WebElement addressLine2;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_city\"]")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_zipCode\"]")
    private WebElement zipCode;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_type\"]")
    private WebElement type;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_expirationMonth\"]")
    private WebElement expirationMonth;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_expirationYear\"]")
    private WebElement expirationYear;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_number\"]")
    private WebElement number;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_cvv\"]")
    private WebElement cvv;

    @FindBy(xpath =  "//*[@id=\"yw2\"]/div[6]/div[1]")
    private WebElement switchToAnnual;

    @FindBy(xpath = "//*[@id=\"yw2\"]/div[6]/div[2]")
    private WebElement switchToMonth;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_captchaCode\"]")
    private WebElement captchaCode;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_countryId\"]")
    private WebElement countryDropdown;

    @FindBy(xpath = "//*[@id=\"BillingInfoForm_stateId\"]")
    private WebElement stateDropdown;


    @FindBy(xpath =  "//*[@id=\"BillingInfoForm_vatNumber\"]")
    private WebElement vatNumberField;

    @FindBy(xpath =  "//*[@id=\"yw4\"]/div[4]/div[2]/div[2]")
    private WebElement checkBox1;

    @FindBy(xpath =  "//*[@id=\"yw4\"]/div[3]/div[3]/div[2]")
    private WebElement checkBox2;

    @FindBy(xpath =  "//*[@id=\"yw4\"]/div[1]/div[2]/div")
    private WebElement checkBoxShipping;

    @FindBy(xpath =  "//*[@class=\"rowCheck topCheck\"]//*[@class=\"chkBox\"]")
    private WebElement checkBoxBuy;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_firstName\"]")
    private WebElement shippingName;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_lastName\"]")
    private WebElement shippingSurname;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_company\"]")
    private WebElement shippingCompany;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_addressLine1\"]")
    private WebElement shippingAddress1;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_addressLine2\"]")
    private WebElement shippingAddress2;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_city\"]")
    private WebElement shippingCity;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_zipCode\"]")
    private WebElement shippingZipCode;

    @FindBy(xpath =  "//*[@id=\"ShippingInfoForm_stateId\"]")
    private WebElement shippingStateId;

    @FindBy(xpath =  "//*[@name=\"yt0\"]")
    private WebElement reviewButton;

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
        driver.manage().addCookie(new Cookie("disable_Captcha", "success"));//////////////////////////////////////////////////////////
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
        waitElementForClick(number);
        selectDropdownByValue(expirationMonth,month);
        selectDropdownByValue(expirationYear,year);
        number.sendKeys(creditCardNumber);
        cvv.sendKeys(cvvNumber);
        return this;
    }

    public Checkout fillCaptcha(String captchaValue){
        waitElementForClick(captchaCode).sendKeys(captchaValue);
        return this;
    }

    public Checkout clickShippingCheckBox(){
        waitElementForClick(checkBoxShipping).click();
        return this;
    }

    public Checkout clickCheckBoxBuy(){
        waitElementForClick(checkBoxBuy).click();
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
