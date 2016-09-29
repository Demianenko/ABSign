package pages.US;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;
import pages.UK.Checkout;

/**
 * Created by user on 22.09.2016.
 */
public class SystemSetup extends Page {
    public SystemSetup(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@name=\"yt4\"]")
    @CacheLookup
    public WebElement buttonCheckOut;

    public Checkout clickButtonCheckOut(){
        waitElementForClick(buttonCheckOut).click();
        return PageFactory.initElements(driver,Checkout.class);
    }
}
