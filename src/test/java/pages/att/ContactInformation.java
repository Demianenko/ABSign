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
    private WebElement contactPhone;

    @FindBy(xpath = "//*[@id=\"ContactForm_firstName\"]")
    @CacheLookup
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"ContactForm_lastName\"]")
    @CacheLookup
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"ContactForm_email\"]")
    @CacheLookup
    private WebElement contactEmail;


    @FindBy(xpath = "//*[@id=\"ContactForm_company\"]")
    @CacheLookup
    private WebElement contactCompany;

    @FindBy(xpath =  "//*[@id=\"ContactForm_isAgreement\"]")
    @CacheLookup
    private WebElement checkBox;

    @FindBy(xpath = "//*[@name=\"yt0\"]")
    @CacheLookup
    private WebElement continueButton;


    public ContactInformation fillContactForm(String phoneNumber, String name, String surname, String email, String company) {
        waitElementForClick(firstName).sendKeys(name);
        contactPhone.sendKeys(phoneNumber);
        lastName.sendKeys(surname);
        contactEmail.sendKeys(email);
        contactCompany.sendKeys(company);
        return this;
    }

    public ContactInformation clickCheckBox(){
        checkBox.click();
        return this;
    }
    public Verification clickContinueButton(){
        waitElementForClick(continueButton).click();
        return PageFactory.initElements(driver,Verification.class);
    }
}
