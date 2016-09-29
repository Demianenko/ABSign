package pages.US;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Page;

/**
 * Created by user on 29.09.2016.
 */
public class AdressValidation extends Page {
    public AdressValidation(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class=\"info-popup-content\"]")
    @CacheLookup
    public WebElement validationPage;

    @FindBy(xpath = "//*[@class=\"icon\"]")
    @CacheLookup
    public WebElement validationIcon;

    @FindBy(xpath = "//*[@name=\"yt1\"]")
    @CacheLookup
    public WebElement validationButton;

    public Review checkPopUp(){
        waitElementForClick(validationIcon).click();
        validationButton.click();
        return PageFactory.initElements(driver, pages.US.Review.class);
    }
}
