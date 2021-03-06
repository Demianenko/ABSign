package pages.UK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;

/**
 * Created by user on 22.09.2016.
 */
public class SystemSetup extends Page {
    public SystemSetup(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@name=\"yt5\"]")
    @CacheLookup
    private WebElement buttonCheckOut;

    public Checkout clickButtonCheckOut(){
        waitElementForClick(buttonCheckOut).click();
        return PageFactory.initElements(driver,Checkout.class);
    }
}
