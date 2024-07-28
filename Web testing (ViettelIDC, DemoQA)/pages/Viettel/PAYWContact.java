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

public class PAYWContact extends BasePage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    protected PAYWContact(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
    }

    String FORM_INPUT_PLACEHOLDER = "//input[@placeholder='%s']";


    /* Find Full Name */
    public WebElement findFullNameEle() {
        String txtFullNameXPath = String.format(FORM_INPUT_PLACEHOLDER, "Họ và tên");
        return findElement(By.xpath(txtFullNameXPath));
    }

    /* Find Email */
    public WebElement findEmailEle() {
        String txtEmailXPath = String.format(FORM_INPUT_PLACEHOLDER, "Email");
        return findElement(By.xpath(txtEmailXPath));
    }

    /* Find phone */
    public WebElement findPhoneEle() {
        String txtPhoneXPath = String.format(FORM_INPUT_PLACEHOLDER, "Số điện thoại");
        return findElement(By.xpath(txtPhoneXPath));
    }

    /* Find Content */
    public WebElement findContentEle() {
        String txtPhoneXPath = "//textarea[@placeholder='Nội dung']";
        return findElement(By.xpath(txtPhoneXPath));
    }

    public WebElement findServiceTicket(String type) {
        String radServiceXPath = String.format("//label[@for='serviceTicket_Title_%s']", type);
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(radServiceXPath)));
    }

    public WebElement findBtnGuiYCEle() {
        String btnGuiYCXpath = "//a[contains(text(),'Gửi yêu cầu')]";
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnGuiYCXpath)));
    }

    public WebElement findResultNotice() {
        String notiResultXPath = "//div[@id='toast-container']";
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notiResultXPath)));
    }

    // Region Element's Action

    private WebElement findLogoPAYWContact(){
        String logoPAYWContactXpath = "//h2[contains(text(),'Đăng ký nhận tư vấn')]";
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logoPAYWContactXpath)));
    }

    public void verifyClickContactSuccessfully() {
        WebElement logoPAYWContactEle = findLogoPAYWContact();
        assertTrue(Objects.nonNull(logoPAYWContactEle), "Verify Acess to Contact");
    }


    public void inputTextToFullName(String value) {
        inputTextTo(findFullNameEle(), value, "Họ và tên");
    }


    public void inputTextToPhone(String value) {
        inputTextTo(findPhoneEle(), value, "Số điện thoại");
    }

    public void inputTextToEmail(String value) {
        inputTextTo(findEmailEle(), value, "Email");
    }

    public void chooseServiceType(String value) {
        clickElement(findServiceTicket(value), "Loại dịch vụ - " + value);
    }

    public void inputTextToContent(String value) {
        inputTextTo(findContentEle(), value, "Nội dung");
    }

    public void clickToBtnGuiYC() {
        clickElement(findBtnGuiYCEle(), "Gửi yêu cầu");
    }

    public void inputRegistrationForm(String fullName, String phoneNum, String email, String serviceType, String content) {
        inputTextToFullName(fullName);
        inputTextToPhone(phoneNum);
        inputTextToEmail(email);
        chooseServiceType(serviceType);
        inputTextToContent(content);

        clickToBtnGuiYC();
    }

    public void inputRegistrationForm(HashMap<String, String> data) {
        inputRegistrationForm(data.get("fullName"), data.get("phone"), data.get("email"), data.get("serviceType"), data.get("content"));
    }

    public void verifyResultNotice() {
        WebElement noticeEle = findResultNotice();
        String expText = "Captcha không hợp lệ!";
        assertEqual(noticeEle.getText(), expText,"Verify result: ");
    }
}
