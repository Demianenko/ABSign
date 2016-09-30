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
public class Verification extends Page {
    public Verification(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"PhoneVerificationForm_verificationCode\"]")
    @CacheLookup
    public WebElement verificationCodeField;

    @FindBy(xpath = "//*[@name=\"yt2\"]")
    @CacheLookup
    public WebElement continueButon;

    public Verification fillVerificationCodeField(String verificationCode){
        waitElementForClick(verificationCodeField).sendKeys(verificationCode);
        return this;
    }

    public ContactPhoneNumber clickReviewButton(){
        continueButon.click();
        return PageFactory.initElements(driver,ContactPhoneNumber.class);
    }
}
