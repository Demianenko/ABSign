package pages.att;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pages.Page;
import util.WriteToFile;

/**
 * Created by user on 22.09.2016.
 */
public class ThankYou extends Page {
    public ThankYou(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class=\"thankYou\"]/div/h2")
    @CacheLookup
    private WebElement mainPhoneNumber;

    public void getMainNumber(){
        waitElementForClick(mainPhoneNumber);
        String phoneNumber = mainPhoneNumber.getText();
        System.out.println(phoneNumber);
        WriteToFile.writeToTXT(phoneNumber);
    }
}
