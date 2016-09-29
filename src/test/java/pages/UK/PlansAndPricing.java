package pages.UK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;

/**
 * Created by user on 22.09.2016.
 */
public class PlansAndPricing extends Page {
    public PlansAndPricing(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"plan0_paidbtn\"]")
   // @CacheLookup
    public WebElement buttonPaidEntry;

    @FindBy(xpath = "//*[@id=\"plan0_contactsales\"]")
   // @CacheLookup
    public WebElement buttonTrialEntry;

    @FindBy(xpath = "//*[@id=\"plan1_paidbtn\"]")
   // @CacheLookup
    public WebElement buttonPaidStandard;

    @FindBy(xpath = "//*[@id=\"plan1_contactsales\"]")
  //  @CacheLookup
    public WebElement buttonTrialStandard;

    @FindBy(xpath = "//*[@id=\"plan2_paidbtn\"]")
  //  @CacheLookup
    public WebElement buttonPaidPremium;

    @FindBy(xpath = "//*[@id=\"plan2_contactsales\"]")
  //  @CacheLookup
    public WebElement buttonTrialPremium;

    public Register clickButtonPaidEntry(){
        waitElementForClick(buttonPaidEntry).click();
        return PageFactory.initElements(driver,Register.class);
    }
    public Register clickButtonPaidStandard(){
        waitElementForClick(buttonPaidStandard).click();
        return PageFactory.initElements(driver,Register.class);
    }
    public Register clickButtonPaidPremium(){
        waitElementForClick(buttonPaidPremium).click();
        return PageFactory.initElements(driver,Register.class);
    }
}
