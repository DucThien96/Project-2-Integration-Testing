package lession12.testscript.viettel;

import lession12.common.TestBase;
import lession12.pages.Viettel.HomePage;

import lession12.pages.Viettel.PAYWContact;
import lession12.pages.Viettel.PayAsYouGo;
import lession12.provider.ConsultantProvider;
import lession16.common.DriverManager;
import org.testng.annotations.*;

import java.util.HashMap;

public class ClientTest extends TestBase {
    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        homePage = new HomePage(DriverManager.getWebDriver());
    }

    @BeforeMethod
    public void beforeMethod() {}

    @AfterClass
    public void afterClass() {
        DriverManager.getWebDriver().quit();
    }

    @AfterMethod
    public void afterMethod() {
    }

    @Test
    public void Consultant_001_Valid() {
        HomePage.goToWebsite(true);
        HomePage.verifyHomePageSuccessfully();
        PayAsYouGo payAsYouGo = HomePage.gotoPayAsYouGoPage();
        payAsYouGo.verifyPAYWSuccessfully();

        PAYWContact paywContact = payAsYouGo.clicktoContactBtn();
        paywContact.verifyClickContactSuccessfully();
        paywContact.inputRegistrationForm("Tran Thi Ly", "0364758678", "lytt@gmail.com", "Cloud", "abcd");
        paywContact.verifyResultNotice();
    }

    @Test(description = "Verify with data provider", dataProviderClass = ConsultantProvider.class, dataProvider = "Consultant_002_Valid")
    public void Consultant_002_Valid(HashMap<String, String> data) {
        HomePage.goToWebsite(true);
        PayAsYouGo payAsYouGo = HomePage.gotoPayAsYouGoPage();
        payAsYouGo.verifyPAYWSuccessfully();

        PAYWContact paywContact = payAsYouGo.clicktoContactBtn();
        paywContact.verifyClickContactSuccessfully();
        paywContact.inputRegistrationForm(data);
    }
}
