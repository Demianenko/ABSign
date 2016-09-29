package pages.US.mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;
import pages.UK.SystemSetup;

/**
 * Created by user on 29.09.2016.
 */
public class SignMeUp extends Page {
    public SignMeUp(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"ContactForm_firstName\"]")
    @CacheLookup
    public WebElement firstName;

    @FindBy(xpath = "//*[@id=\"ContactForm_lastName\"]")
    @CacheLookup
    public WebElement lastName;

    @FindBy(xpath = "//*[@id=\"ContactForm_email\"]")
    @CacheLookup
    public WebElement contactEmail;

    @FindBy(xpath = "//*[@id=\"ContactForm_contactPhone\"]")
    @CacheLookup
    public WebElement contactPhone;

    @FindBy(xpath = "//*[@id=\"ContactForm_company\"]")
    @CacheLookup
    public WebElement contactCompany;

    @FindBy(xpath = "//*[@id=\"ContactForm_numberOfEmployees\"]")
    @CacheLookup
    public WebElement contactNumberOfEmployees;

    @FindBy(xpath = "//*[@class=\"chkBox\"]")
    @CacheLookup
    public WebElement checkBox;

    @FindBy(xpath = "//*[@id=\"ContactForm_captchaCode\"]")
    @CacheLookup
    public WebElement captcha;

    @FindBy(xpath = "//*[@name=\"yt5\"]")
    @CacheLookup
    public WebElement checkoutButton;

    public SignMeUp selectNumberOfEmployees(String numberOfEmployees) {
        waitElementForClick(contactNumberOfEmployees);
        selectDropdownByVisibleText(contactNumberOfEmployees,numberOfEmployees);
        return this;
    }
    public SignMeUp fillContactForm(String name, String surname, String email, String phone, String company, String captchaValue) {
        waitElementForClick(firstName).sendKeys(name);
        lastName.sendKeys(surname);
        contactEmail.sendKeys(email);
        contactPhone.sendKeys(phone);
        contactCompany.sendKeys(company);
        captcha.sendKeys(captchaValue);
        return this;
    }
    public SignMeUp clickCheckBox(){
        waitElementForClick(checkBox).click();
        return this;
    }

    public SystemSetup clickCheckoutButton(){
        waitElementForClick(checkoutButton).click();
        return PageFactory.initElements(driver,SystemSetup.class);
    }
}
