package lession12.pages.Viettel;

import lession12.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class HomePage extends BasePage {
    static WebDriver webDriver;
    static WebDriverWait webDriverWait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
        this.webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
    }

    private static WebElement findWebLogo() {
        String imgLogoXPath = "//a[@title='Viettel IDC']//img[@alt='Viettel IDC']";
        return findElement(By.xpath(imgLogoXPath));
    }

    public static WebElement findBtnPayGoEle() {
        String btnPayGoXpath = "//a[contains(@href,'/pay-as-you-wish') and @tabindex='0']";
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnPayGoXpath)));
    }

    /* Verify login thanh cong hay khong */
    public static void verifyHomePageSuccessfully() {
        WebElement imgLogoEle = findWebLogo();
        assertTrue(Objects.nonNull(imgLogoEle), "Verify Web's Logo");
    }

    public static void goToWebsite(boolean isVerify) {
        String baseURl = "https://viettelidc.com.vn/";
        webDriver.get(baseURl);
        if (isVerify)
            verifyHomePageSuccessfully();
    }

    public static PayAsYouGo gotoPayAsYouGoPage() {
        clickElement(findBtnPayGoEle(), "Pay as you wish");
        return new PayAsYouGo(webDriver);
    }
}
