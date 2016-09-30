package test;

import dataProvider.DataProviders;
import dataProvider.DataSource;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.att.ContactInformation;
import pages.att.Pricing;
import util.DataGenerator;
import util.TestNGTestBase;

/**
 * Created by user on 30.09.2016.
 */
public class ATTSignUp extends TestNGTestBase {
    Pricing pricing;
    ContactInformation contactInformation;
    @BeforeMethod
    public void initPage() {
        baseUrl = "http://service-amsup-att.lab.nordigy.ru/web/signup/plansandpricing.html";
        pricing = PageFactory.initElements(driver, Pricing.class);
        driver.get(baseUrl);
    }
    @Test(dataProvider = "contactInformationForLogin", dataProviderClass = DataProviders.class, enabled = true)
    @DataSource(xlsx = "src/test/resources/contactInformationForATTLogin.xlsx")
    public void signUpPaid(String type, String tier,String name, String surname, String emailLogin,String company,
                           String numberOfEmployees, String address1, String address2,String cityName, String postCode) {

        String phoneNumber = DataGenerator.getUSPhoneNumber();
        String email = DataGenerator.getEMailAddress(emailLogin, phoneNumber);
        contactInformation = selectTier(tier,type);
        contactInformation.fillContactForm(phoneNumber,name,surname,email,company)
                .clickCheckBox()
                .clickContinueButton()
                .fillVerificationCodeField("11111")
                .clickReviewButton()
                .clickReviewButton()
                .fillShippingInfo(name,surname,company,address1,address2,cityName,postCode)
                .clickBuyNowButton()
                .clickBuyNowButton()
                .getMainNumber();
    }
    public ContactInformation selectTier(String tier, String type) {
        if(tier.equals("Standard")) {
            if (type.equals("Trial")) {
                return pricing.clickStandardTrialButton();
            } else {
                return pricing.clickStandardBuyButton();
            }

        } else if (tier.equals("Entry")) {
            return pricing.clickPremiumBuyButton();
        } else return pricing.clickEnterpriseBuyButton();
    }
}
