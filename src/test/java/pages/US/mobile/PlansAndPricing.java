package pages.US.mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
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

    @FindBy(xpath = "//*[@id=\"pblock_1_paidbtn\"]")
   // @CacheLookup
    public WebElement buttonPaidStandard;

    @FindBy(xpath = "//*[@id=\"pblock_1_trialbtn\"]")
  //  @CacheLookup
    public WebElement buttonTrialStandard;

    @FindBy(xpath = "//*[@id=\"pblock_2_paidbtn\"]")
  //  @CacheLookup
    public WebElement buttonPaidPremium;

    @FindBy(xpath = "//*[@id=\"pblock_2_trialbtn\"]")
  //  @CacheLookup
    public WebElement buttonTrialPremium;

    @FindBy(xpath = "//*[@id=\"pblock_3_paidbtn\"]")
    //  @CacheLookup
    public WebElement buttonPaidEnterprise;

    @FindBy(xpath = "//*[@id=\"plan3_contactsales\"]")
    //  @CacheLookup
    public WebElement buttonTrialEnterprise;

    @FindBy(xpath = "//*[@id=\"pblock_1\"]//*[@id=\"select_bl\"]")
    @CacheLookup
    public WebElement selectThisPlanPro;

    @FindBy(xpath = "//*[@id=\"pblock_3\"]//*[@id=\"select_bl\"]")
    @CacheLookup
    public WebElement selectThisPlanProPower;

    public ChooseYourNumber clickButtonPaidEntry(){
        waitElementForClick(buttonPaidEntry).click();
        return PageFactory.initElements(driver,ChooseYourNumber.class);
    }
    public ChooseYourNumber clickButtonPaidStandard(){
        waitElementForClick(buttonPaidStandard).click();
        return PageFactory.initElements(driver,ChooseYourNumber.class);
    }
    public ChooseYourNumber clickButtonPaidPremium(){
        waitElementForClick(buttonPaidPremium).click();
        return PageFactory.initElements(driver,ChooseYourNumber.class);
    }
    public ChooseYourNumber clickButtonPaidEnterprise(){
        waitElementForClick(buttonPaidEnterprise).click();
        return PageFactory.initElements(driver,ChooseYourNumber.class);
    }

    public ChooseYourNumber clickButtonSelectThisPlanPro(){
        waitElementForClick(selectThisPlanPro).click();
        return PageFactory.initElements(driver,ChooseYourNumber.class);
    }
    public ChooseYourNumber clickButtonSelectThisPlanProPower(){
        waitElementForClick(selectThisPlanProPower).click();
        return PageFactory.initElements(driver,ChooseYourNumber.class);
    }
}
