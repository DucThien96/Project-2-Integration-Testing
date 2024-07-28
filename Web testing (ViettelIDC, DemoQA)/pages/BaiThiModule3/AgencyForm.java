package lession12.pages.BaiThiModule3;

import lession12.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

public class AgencyForm extends BasePage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    protected AgencyForm(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
    }


    public WebElement findAgencyContent(){
        String AgencyBtnXpath = "//h2[contains(text(),'Đăng kí trở thành đại lý')]";
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AgencyBtnXpath)));
    }
    public void verifyAgencyForm() {
        WebElement agencyContentEle = findAgencyContent();
        assertTrue(Objects.nonNull(agencyContentEle), "Verify acess to Agency form");
    }

    String FORM_INPUT_PLACEHOLDER = "//input[@placeholder='%s']";

    /* Find Full Name */
    public WebElement findFullNameEle() {
        String txtFullNameXPath = String.format(FORM_INPUT_PLACEHOLDER, "Họ và tên");
        return findElement(By.xpath(txtFullNameXPath));
    }

    /* Find Position */
    public WebElement findPositionEle() {
        String txtPositionXPath = String.format(FORM_INPUT_PLACEHOLDER, "Chức vụ");
        return findElement(By.xpath(txtPositionXPath));
    }

    /* Find Company */
    public WebElement findCompanyEle() {
        String txtCompanyXPath = String.format(FORM_INPUT_PLACEHOLDER, "Tên công ty");
        return findElement(By.xpath(txtCompanyXPath));
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

    public WebElement findCloudServer() {
        String cloudServerXpath = "//label[contains(text(),'DỊCH VỤ CLOUD SERVER')]";
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(cloudServerXpath)));
    }

    public WebElement findStarCloud() {
        String starCloudXpath = "//label[contains(text(),'DỊCH VỤ VIETTEL START CLOUD')]";
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(starCloudXpath)));
    }

//    public WebElement findCloseBtn() {
//        String closeBtnXpath = "//a[contains(text(),'Gửi yêu cầu')]";
//        return webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(starCloudXpath)));
//    }

    public void inputTextToFullName(String value) {
        inputTextTo(findFullNameEle(), value, "Họ và tên");
    }

    public void inputTextToPosition(String value) {
        inputTextTo(findPositionEle(), value, "Chức vụ");
    }

    public void inputTextToCompany(String value) {
        inputTextTo(findCompanyEle(), value, "Tên công ty");
    }

    public void inputTextToPhone(String value) {
        inputTextTo(findPhoneEle(), value, "Số điện thoại");
    }

    public void inputTextToEmail(String value) {
        inputTextTo(findEmailEle(), value, "Email");
    }

    public void chooseServiceType() {
        clickElement(findCloudServer(), "Dịch vụ Cloud Server");
        clickElement(findStarCloud(),"Dịch vụ Viettel Star Cloud");
    }

    public void inputRegistrationForm(String fullName, String position, String company, String email, String phoneNum, String serviceType) {
        inputTextToFullName(fullName);
        inputTextToPosition(position);
        inputTextToCompany(company);
        inputTextToEmail(email);
        inputTextToPhone(phoneNum);
        chooseServiceType();


    }

    public void inputRegistrationForm(HashMap<String, String> data) {
        inputRegistrationForm(data.get("fullName"), data.get("position"), data.get("company"), data.get("email"), data.get("phone"), data.get("serviceType"));
    }

}
