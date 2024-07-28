package lession12.pages.pim;

import lession12.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

    private WebDriver webDriver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
    }

    String FORM_INPUT_PLACEHOLDER = "//input[@placeholder='%s']";


    /* Find User Name Element*/
    private WebElement findUserNameEle() {
        String txtUserNameXPath = String.format(FORM_INPUT_PLACEHOLDER, "Username");
        return findElement(By.xpath(txtUserNameXPath));
    }


    /* Find Password Element*/
    private WebElement findPasswordEle() {
        String txtPasswordXPath = String.format(FORM_INPUT_PLACEHOLDER, "Password");
        return findElement(By.xpath(txtPasswordXPath));
    }

    /* Find LoginButton Element*/
    private WebElement findLoginButton() {
        String btnLoginXPath = "//button[@type='submit']";
        return findElement(By.xpath(btnLoginXPath));
    }

    /* 1. Truy cập website */
    public void gotoWeb(String url) {
        webDriver.get(url);
        verifyAccessLoginPage();
    }

    /* 2. Login */
    public HomePage login(String userName, String password) {
        inputUserName(userName);
        inputPassword(password);
        return clickLogin();
    }

    /* 2.1 Input user name */
    public void inputUserName(String value) {
        inputTextTo(findUserNameEle(), value, "UserName");
    }

    /* 2.2 Input password */
    public void inputPassword(String value) {
        inputTextTo(findPasswordEle(), value, "Password");
    }

    /* 2.3 Click Login (Move to HomePage) */
    public HomePage clickLogin() {
        clickElement(findLoginButton(), "Login Button");
        return new HomePage(webDriver);
    }

    /* 1. Kiểm tra truy cập đúng k */
    public void verifyAccessLoginPage() {
        WebElement txtUserNameEle = findUserNameEle();
        assertTrue(Objects.nonNull(txtUserNameEle), "Verify username display");
    }

}
