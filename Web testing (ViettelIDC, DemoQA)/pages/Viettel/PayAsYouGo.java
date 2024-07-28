package lession12.pages.Viettel;

import lession12.common.BasePage;
import lession12.pages.pim.EmployeeListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

public class PayAsYouGo extends BasePage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    protected PayAsYouGo(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
    }



    public WebElement findLogoPAYW(){
        String logoPAYWXpath = "//a[@title='Pay as You Wish có gì ?' and @role='tab']";
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoPAYWXpath)));
    }
    public void verifyPAYWSuccessfully() {
        WebElement logoPAYWEle = findLogoPAYW();
        assertTrue(Objects.nonNull(logoPAYWEle), "Verify acess to PAYW page");
    }

    /*Contact Button*/
    public WebElement findContactButton(){
        String btnContactXpath = "//div[@id='table-colocation']//div[@data-slick-index='1']//button[normalize-space()='Nhận tư vấn' and @tabindex='0']";
//    "//div[contains(text(),'Colo 2')]//following::span[contains(text(),'2.100.000')]//following::label[contains(text(),'Bình Dương')]//following::button[normalize-space()='Nhận tư vấn']";
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnContactXpath)));
    }

    public PAYWContact clicktoContactBtn(){
        clickElement(findContactButton(),"Dang ky tu van");
        return new PAYWContact(webDriver);
    }

}


