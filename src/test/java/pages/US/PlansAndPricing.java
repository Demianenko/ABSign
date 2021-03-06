package pages.US;

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
    private WebElement buttonPaidEntry;

    @FindBy(xpath = "//*[@id=\"plan0_contactsales\"]")
    private WebElement buttonTrialEntry;

    @FindBy(xpath = "//*[@id=\"plan1_paidbtn\"]")
    private WebElement buttonPaidStandard;

    @FindBy(xpath = "//*[@id=\"plan1_contactsales\"]")
    private WebElement buttonTrialStandard;

    @FindBy(xpath = "//*[@id=\"plan2_paidbtn\"]")
    private WebElement buttonPaidPremium;

    @FindBy(xpath = "//*[@id=\"plan2_contactsales\"]")
    private WebElement buttonTrialPremium;

    @FindBy(xpath = "//*[@id=\"plan3_paidbtn\"]")
    private WebElement buttonPaidEnterprise;

    @FindBy(xpath = "//*[@id=\"plan3_contactsales\"]")
    private WebElement buttonTrialEnterprise;

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
    public Register clickButtonPaidEnterprise(){
        waitElementForClick(buttonPaidEnterprise).click();
        return PageFactory.initElements(driver,Register.class);
    }
}
