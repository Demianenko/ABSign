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
public class Summary extends Page {
    public Summary(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@name=\"yt13\"]")
    @CacheLookup
    private WebElement buyNowButton;

    public ThankYou clickBuyNowButton (){
        waitElementForClick(buyNowButton).click();
        return PageFactory.initElements(driver,ThankYou.class);
    }
}
