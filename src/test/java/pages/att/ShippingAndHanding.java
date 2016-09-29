package pages.att;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;

/**
 * Created by user on 29.09.2016.
 */
public class ShippingAndHanding extends Page {
    public ShippingAndHanding(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"ShippingInfoForm_firstName\"]")
    @CacheLookup
    public WebElement firstName;
    @FindBy(xpath = "//*[@id=\"ShippingInfoForm_lastName\"]")
    @CacheLookup
    public WebElement lastName;
    @FindBy(xpath = "//*[@id=\"ShippingInfoForm_company\"]")
    @CacheLookup
    public WebElement companyName;

    @FindBy(xpath = "//*[@id=\"ShippingInfoForm_addressLine1\"]")
    @CacheLookup
    public WebElement addressLine1;

    @FindBy(xpath = "//*[@id=\"ShippingInfoForm_addressLine2\"]")
    @CacheLookup
    public WebElement addressLine2;

    @FindBy(xpath = "//*[@id=\"ShippingInfoForm_city\"]")
    @CacheLookup
    public WebElement city;

    @FindBy(xpath = "//*[@id=\"ShippingInfoForm_zipCode\"]")
    @CacheLookup
    public WebElement zipCode;

    @FindBy(xpath = "//*[@id=\"ShippingInfoForm_stateId\"]")
    @CacheLookup
    public WebElement stateDropdown;

    @FindBy(xpath = "//*[@name=\"yt4\"]")
    @CacheLookup
    public WebElement buyNowButton;

    public ShippingAndHanding fillShippingInfo(String name, String surname, String company, String address1,
                                               String address2, String cityName, String zip){
        waitElementForClick(firstName);
        firstName.sendKeys(name);
        lastName.sendKeys(surname);
        companyName.sendKeys(company);
        addressLine1.sendKeys(address1);
        addressLine2.sendKeys(address2);
        city.sendKeys(cityName);
        zipCode.sendKeys(zip);
        return this;
    }
    public ShippingAndHanding selectCounty (String county){
        waitElementForClick(stateDropdown);
        selectDropdownByValue(stateDropdown,county);
        return this;
    }
    public Summary clickBuyNowButton (){
        waitElementForClick(buyNowButton).click();
        return PageFactory.initElements(driver,Summary.class);
    }
}
