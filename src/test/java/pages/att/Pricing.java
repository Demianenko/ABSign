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
public class Pricing extends Page {
    public Pricing(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"main-content\"]/table/tbody/tr[3]/td[2]/a[2]")
    @CacheLookup
    public WebElement standardBuyButton;

    @FindBy(xpath = "//*[@id=\"main-content\"]/table/tbody/tr[3]/td[2]/a[3]")
    @CacheLookup
    public WebElement standardTrialButton;

    @FindBy(xpath = "//*[@id=\"main-content\"]/table/tbody/tr[3]/td[3]/a[2]")
    @CacheLookup
    public WebElement premiumBuyButton;

    @FindBy(xpath = "//*[@id=\"main-content\"]/table/tbody/tr[3]/td[4]/a[2]")
    @CacheLookup
    public WebElement enterpriseBuyButton;


    public ContactInformation clickStandardBuyButton(){
        waitElementForClick(standardBuyButton).click();
        return PageFactory.initElements(driver,ContactInformation.class);
    }

    public ContactInformation clickStandardTrialButton(){
        waitElementForClick(standardTrialButton).click();
        return PageFactory.initElements(driver,ContactInformation.class);
    }

    public ContactInformation clickPremiumBuyButton(){
        waitElementForClick(premiumBuyButton).click();
        return PageFactory.initElements(driver,ContactInformation.class);
    }

    public ContactInformation clickEnterpriseBuyButton(){
        waitElementForClick(enterpriseBuyButton).click();
        return PageFactory.initElements(driver,ContactInformation.class);
    }
}
