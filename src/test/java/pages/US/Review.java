package pages.US;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;
import pages.UK.ThankYou;

/**
 * Created by user on 22.09.2016.
 */
public class Review extends Page {
    public Review(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@name=\"yt4\"]")
    @CacheLookup
    public WebElement buttonBuyNow;

    public ThankYou clickButtonBuyNow(){
        waitElementForClick(buttonBuyNow).click();
        return PageFactory.initElements(driver,ThankYou.class);
    }
}
