package lession12.pages.BaiThiModule3;

import lession12.common.BasePage;
import lession12.pages.Viettel.PAYWContact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class AgencyPage extends BasePage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    protected AgencyPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
    }

    public WebElement findAgencyBtn(){
        String agencyBtnXpath = "//div[@class='preview-cloud-service-action ']//following-sibling::a[@href='javascript:;' and @title='Trở thành đại lý']";
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(agencyBtnXpath)));
    }
    public void verifyAgencyPage() {
        WebElement agencyBTnEle = findAgencyBtn();
        assertTrue(Objects.nonNull(agencyBTnEle), "Verify acess to Agency page");
    }

    public AgencyForm clicktoAgencyBtn(){
        clickElement(findAgencyBtn(),"Dang ky dai ly");
        return new AgencyForm(webDriver);
    }
}
