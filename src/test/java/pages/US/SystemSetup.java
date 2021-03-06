package pages.US;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    @FindBy(xpath = "//*[@name=\"yt4\"]")
    private WebElement buttonCheckOut;

    public Checkout clickButtonCheckOut(){
        waitElementForClick(buttonCheckOut).click();
        driver.manage().addCookie(new Cookie("disable_Captcha", "success"));//////////////////////////////////////////
        return PageFactory.initElements(driver,Checkout.class);
    }
}
