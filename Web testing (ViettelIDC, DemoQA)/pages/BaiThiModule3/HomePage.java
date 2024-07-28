package lession12.pages.BaiThiModule3;

import lession12.common.BasePage;
import lession12.pages.Viettel.PayAsYouGo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class HomePage extends BasePage {
    static WebDriver webDriver;
    static WebDriverWait webDriverWait;
    private static JavascriptExecutor javaScripts;

    public HomePage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
        this.webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
    }

    private static WebElement findWebLogo() {
        String imgLogoXPath = "//a[@title='Viettel IDC']//img[@alt='Viettel IDC']";
        return findElement(By.xpath(imgLogoXPath));
    }

    public static WebElement findContactEle() {
        String contactEleXpath = "//a[contains(text(),'Liên hệ') and @id='Contact']";
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(contactEleXpath)));
    }

    public static WebElement findPartnerEle() {
        String partnerEleXpath = "//a[contains(text(),'Đối tác') and @href='/Home/Partner']";
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(partnerEleXpath)));
    }

    /* Verify login thanh cong hay khong */
    public static void verifyHomePageSuccessfully() {
        WebElement imgLogoEle = findWebLogo();
        assertTrue(Objects.nonNull(imgLogoEle), "Verify Home Page");
    }

    public static void goToWebsite(boolean isVerify) {
        String baseURl = "https://viettelidc.com.vn/";
        webDriver.get(baseURl);
        if (isVerify)
            verifyHomePageSuccessfully();
    }

    public static AgencyPage gotoAgencyPage() {
        clickElement(findContactEle(), "Contact");
        javaScripts.executeScript("arguments[0].click();", findPartnerEle());
        return new AgencyPage(webDriver);
    }
}
