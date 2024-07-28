package lession12.testscript;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lession12.common.DriverManager;
import lession12.common.TestBase;
import lession12.pages.LoginPage;
import lession12.provider.LoginProvider;
import lession12.provider.LoginProviderBTTH;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginTest extends TestBase {
    private WebDriver mWebDriver;
    private String baseURL = "https://www.saucedemo.com/";
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeTestMethod() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        mWebDriver = new ChromeDriver(configChromeOption());
        DriverManager.setWebDriver(mWebDriver);

        loginPage = new LoginPage(DriverManager.getWebDriver());
        loginPage.gotoWebsite(baseURL);
    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.quit();
    }

    @Test(description ="Verify the login function")
    public void RISE_Login_001_Correct() {
        loginPage.login("admin@demo.com", "riseDemo");

        // Neu phai login voi nhieu user thi ban se thuc hien nhu the nao
    }


    @Test(
            priority = 1,
            description = "Verify the login function",
            dataProvider = "RISE_Login",
            dataProviderClass = LoginProvider.class)
    public void RISE_Login_002_Correct(HashMap<String, String> data) {
        loginPage.login(data.get("username"), data.get("password"));
    }



    @Test(
            priority = 1,
            description = "Verify the login function",
            dataProvider = "BTTH_Login",
            dataProviderClass = LoginProviderBTTH.class)
    public void RISE_Login_003_Correct(HashMap<String, String> data) {
        loginPage.login(data.get("username"), data.get("password"));
    }

}
