package test;

import dataProvider.DataProviders;
import dataProvider.DataSource;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US.PlansAndPricing;
import pages.US.Register;
import util.DataGenerator;
import util.TestNGTestBase;

/**
 * Created by user on 30.09.2016.
 */
public class USSignUp extends TestNGTestBase {
    PlansAndPricing plansAndPricing;
    Register register;
    @BeforeMethod
    public void initPage() {
        baseUrl = "http://service-amsup-us.lab.nordigy.ru/office/plansandpricing.html";
        plansAndPricing = PageFactory.initElements(driver, PlansAndPricing.class);
        driver.get(baseUrl);
        Cookie ck1 = new Cookie("disable_Captcha", "success");
        driver.manage().addCookie(ck1);
    }
    @Test(dataProvider = "contactInformationForLogin", dataProviderClass = DataProviders.class, enabled = true)
    @DataSource(xlsx = "src/test/resources/contactInformationForUSLogin.xlsx")
    public void signUpPaid(String n, String tier,String billingCountryID, String name, String surname,
                           String emailLogin,String company, String numberOfEmployees, String address1,String address2,
                           String cityName, String postCode, String countyID,String cardType, String cardMonth,
                           String cardYear, String cvv, String captcha) {
        String creditCard = DataGenerator.getCreditCardNumber();
        String phoneNumber = DataGenerator.getUSPhoneNumber();
        String email = DataGenerator.getEMailAddress(emailLogin, phoneNumber);
        register = selectTier(tier);
        register.fillContactForm(name,surname,email,phoneNumber,company,numberOfEmployees).clickContinueButton().clickButtonCheckOut()
                .fillBillingAddress(address1,address2,cityName,postCode).selectBillingCountry(billingCountryID)
                .selectCounty(countyID)
                .setCreditInformation(cardType,cardMonth,cardYear,creditCard,cvv)
                .clickCheckBoxBuy()
                .fillCaptcha(captcha)
                .clickReviewButton()
                .clickButtonBuyNow()
                .getMainNumber();

    }
    public pages.US.Register selectTier(String tier) {
        if(tier.equals("Standard")) {
            return plansAndPricing.clickButtonPaidStandard();
        } else if (tier.equals("Entry")) {
            return plansAndPricing.clickButtonPaidEntry();
        } else if (tier.equals("Premium")){
            return plansAndPricing.clickButtonPaidPremium();
        } else return plansAndPricing.clickButtonPaidEnterprise();
    }
}
