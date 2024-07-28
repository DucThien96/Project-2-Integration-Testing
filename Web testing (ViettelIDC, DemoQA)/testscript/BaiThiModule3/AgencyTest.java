package lession12.testscript.BaiThiModule3;

import lession12.common.DriverManager;
import lession12.common.TestBase;
import lession12.pages.BaiThiModule3.AgencyForm;
import lession12.pages.BaiThiModule3.AgencyPage;
import lession12.pages.BaiThiModule3.HomePage;


import lession12.provider.AgencyProvider;
import org.testng.annotations.*;

import java.util.HashMap;

public class AgencyTest extends TestBase {
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
    public void Agency_002_Valid() {
        HomePage.goToWebsite(true);
        HomePage.verifyHomePageSuccessfully();
        AgencyPage agencyPage = HomePage.gotoAgencyPage();
        agencyPage.verifyAgencyPage();

        AgencyForm agencyForm = agencyPage.clicktoAgencyBtn();
        agencyForm.verifyAgencyForm();
        agencyForm.inputRegistrationForm("Duc Thien", "Nvvp", "Cty TNHH ABC", "johnt1211@gmail.com", "0868298402","Cloud Server va Viettel Star Cloud");

    }

    @Test(description = "Verify with data provider", dataProviderClass = AgencyProvider.class, dataProvider = "Agency_002_Valid")
    public void Agency_002_Valid(HashMap<String, String> data) {
        HomePage.goToWebsite(true);
        AgencyPage agencyPage = HomePage.gotoAgencyPage();
        agencyPage.verifyAgencyPage();

        AgencyForm agencyForm = agencyPage.clicktoAgencyBtn();
        agencyForm.verifyAgencyForm();
        agencyForm.inputRegistrationForm(data);
    }
}
