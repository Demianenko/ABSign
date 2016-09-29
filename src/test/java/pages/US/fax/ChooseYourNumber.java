package pages.US.fax;

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
public class ChooseYourNumber extends Page {
    public ChooseYourNumber(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@name=\"yt0\"]")
    @CacheLookup
    public WebElement contactInformationButton;

    public Register clickButtonPaidEntry(){
        waitElementForClick(contactInformationButton).click();
        return PageFactory.initElements(driver,Register.class);
    }
}
