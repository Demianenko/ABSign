package test;

import dataProvider.DataProviders;
import dataProvider.DataSource;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UK.Checkout;
import pages.UK.PlansAndPricing;
import pages.UK.Register;
import util.DataGenerator;
import util.TestNGTestBase;

/**
 * Created by user on 22.09.2016.
 */
public class SignUpUK extends TestNGTestBase {
    private PlansAndPricing plansAndPricing;
    private Checkout checkout;


    @BeforeMethod
    public void initPage() {
        baseUrl = "http://service-amsup-uk.lab.nordigy.ru/office/plansandpricing.html";
        plansAndPricing = PageFactory.initElements(driver, PlansAndPricing.class);
        driver.get(baseUrl);
    }

    @Test(dataProvider = "contactInformationForUKLogin", dataProviderClass = DataProviders.class, enabled = true)
    @DataSource(xlsx = "src/test/resources/contactInformationForUKLogin.xlsx")
    public void signUpPaid(String tier,String billingCountryID, String vatNumber, String name, String surname,
                                   String emailLogin,String company, String numberOfEmployees, String address1,
                                   String address2,String cityName, String postCode, String location, String countyID,
                                   String cardType, String cardMonth, String cardYear, String cvv, String captcha) {

        String creditCard = DataGenerator.getCreditCardNumber();
        String phoneNumber = DataGenerator.getUKPhoneNumber();
        String email = DataGenerator.getEMailAddress(emailLogin, phoneNumber);
        checkout = selectTier(tier).selecLocation(location)
                .fillContactForm(name, surname, email, phoneNumber, company, numberOfEmployees)
                .clckContinueButton()
                .clickButtonCheckOut()
                .fillBillingAddress(address1, address2, cityName, postCode)
                .selectCounty(countyID);
        if (!billingCountryID.equals("224")) {
            if (vatNumber.equals("0")) {
                vatNumber = "";
            }
            checkout.selectBillingCountry(billingCountryID)
                    .fillVATNumber(vatNumber)
                    .setShippingAddress(name, surname, address1, address2, cityName, postCode, company, countyID);
        }
        checkout.setCreditInformation(cardType,cardMonth, cardYear, creditCard, cvv)
                .captcha(captcha)
                .clickReviewButton()
                .clickButtonBuyNow()
                .getMainNumber();
    }
    public Register selectTier(String tier) {
        if(tier.equals("Standard")) {
            return plansAndPricing.clickButtonPaidStandard();
        } else if (tier.equals("Entry")) {
            return plansAndPricing.clickButtonPaidEntry();
        } else return plansAndPricing.clickButtonPaidPremium();
    }
}
