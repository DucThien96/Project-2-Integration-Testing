package lession12.pages.pim;

import lession12.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class HomePage extends BasePage {
    private WebDriver webDriver;

    protected HomePage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
    }


//    img homepage:
////img[@alt='client brand banner']
//    PIM:
//    //a[@href='/web/index.php/pim/viewPimModule']
//    Verify PIMPAGE:
////span//h6

    private WebElement findWebLogo() {
        String imgLogoXPath = "//img[@alt='client brand banner']";
        return findElement(By.xpath(imgLogoXPath));
    }

    private WebElement findPIMNav() {
        String navPIMXPath = "//a[contains(@href,'/pim/viewPimModule')]";
        return findElement(By.xpath(navPIMXPath));
    }


    public PIMPage clickToPIMNav() {
        WebElement navPIMEle = findPIMNav();
        //clickElement(navPIMEle, "PIM Nav");
        getJavascriptExecutor().executeScript("arguments[0].click();", navPIMEle);
        return new PIMPage(webDriver);
    }

    /* Verify login thanh cong hay khong */
    public void verifyLoginSuccessfully() {
        WebElement imgLogoEle = findWebLogo();
        assertTrue(Objects.nonNull(imgLogoEle), "Verify Web's Logo");
    }
}
