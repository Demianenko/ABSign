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
public class ContactPhoneNumber extends Page {
    public ContactPhoneNumber(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@name=\"yt38\"]")
    @CacheLookup
    public WebElement continueButon;

    public ShippingAndHanding clickReviewButton(){
        continueButon.click();
        return PageFactory.initElements(driver,ShippingAndHanding.class);
    }
}
