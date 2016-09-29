package pages.US.mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;
import pages.UK.Register;

/**
 * Created by user on 29.09.2016.
 */
public class UpgradeToOffice extends Page {
    public UpgradeToOffice(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class=\"btn btn-large\"]")
    @CacheLookup
    public WebElement noThanksButton;

    public SignMeUp clickButtonPaidEntry(){
        waitElementForClick(noThanksButton).click();
        return PageFactory.initElements(driver,SignMeUp.class);
    }
}
