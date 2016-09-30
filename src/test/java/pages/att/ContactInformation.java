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
public class ContactInformation extends Page {
    public ContactInformation(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"ContactForm_contactPhone\"]")
    @CacheLookup
    public WebElement contactPhone;

    @FindBy(xpath = "//*[@id=\"ContactForm_firstName\"]")
    @CacheLookup
    public WebElement firstName;

    @FindBy(xpath = "//*[@id=\"ContactForm_lastName\"]")
    @CacheLookup
    public WebElement lastName;

    @FindBy(xpath = "//*[@id=\"ContactForm_email\"]")
    @CacheLookup
    public WebElement contactEmail;


    @FindBy(xpath = "//*[@id=\"ContactForm_company\"]")
    @CacheLookup
    public WebElement contactCompany;

    @FindBy(xpath =  "//*[@id=\"ContactForm_isAgreement\"]")
    @CacheLookup
    public WebElement checkBox;

    @FindBy(xpath = "//*[@name=\"yt1\"]")
    @CacheLookup
    public WebElement continueButton;


    public ContactInformation fillContactForm(String phoneNumber, String name, String surname, String email, String company) {
        waitElementForClick(firstName).sendKeys(name);
        contactPhone.sendKeys(phoneNumber);
        lastName.sendKeys(surname);
        contactEmail.sendKeys(email);
        contactCompany.sendKeys(company);
        return this;
    }

    public Verification clickContinueButton(){
        waitElementForClick(continueButton).click();
        return PageFactory.initElements(driver,Verification.class);
    }
}
