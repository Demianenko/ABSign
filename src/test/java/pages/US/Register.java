package pages.US;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;

/**
 * Created by user on 22.09.2016.
 */
public class Register extends Page {
    public Register(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"ContactForm_firstName\"]")
     @CacheLookup
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"ContactForm_lastName\"]")
     @CacheLookup
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"ContactForm_email\"]")
     @CacheLookup
    private WebElement contactEmail;

    @FindBy(xpath = "//*[@id=\"ContactForm_contactPhone\"]")
     @CacheLookup
    private WebElement contactPhone;

    @FindBy(xpath = "//*[@id=\"ContactForm_company\"]")
     @CacheLookup
    private WebElement contactCompany;

    @FindBy(xpath = "//*[@id=\"ContactForm_numberOfEmployees\"]")
     @CacheLookup
    private WebElement contactNumberOfEmployees;

   @FindBy(xpath = "//*[@id=\"ContactForm_mainOfficeLocation\"]")
   @CacheLookup
   private WebElement mainOfficeLocation;

    @FindBy(xpath = "//*[@name=\"yt1\"]")
    @CacheLookup
    private WebElement contactFormContinueButton;

    public Register selectLocation(String name) {
        waitElementForClick(mainOfficeLocation);
        selectDropdownByVisibleText(mainOfficeLocation,name);
        return this;
    }
    public Register fillContactForm(String name, String surname, String email, String phone, String company, String numberOfEmployees) {
        waitElementForClick(firstName).sendKeys(name);
        lastName.sendKeys(surname);
        contactEmail.sendKeys(email);
        contactPhone.sendKeys(phone);
        contactCompany.sendKeys(company);
        contactNumberOfEmployees.sendKeys(numberOfEmployees);
        return this;
    }

    public SystemSetup clickContinueButton(){
        waitElementForClick(contactFormContinueButton).click();
        return PageFactory.initElements(driver,SystemSetup.class);
    }

}
