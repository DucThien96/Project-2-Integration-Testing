package lession12.pages.pim;

import lession12.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class AddEmployeePage extends BasePage {
    WebDriver webDriver;

    protected AddEmployeePage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
    }

    String FORM_INPUT_PLACEHOLDER = "//input[@placeholder='%s']";
    String FORM_BUTTON_TEXT = "//button[normalize-space()='%s']";
    //a[@title='PAY AS YOU WISH']
    /* Find First Name */
    private WebElement findFirstName() {
        String txtFirstNameXPath = String.format(FORM_INPUT_PLACEHOLDER, "First Name");
        return findElement(By.xpath(txtFirstNameXPath));
    }

    /* Find Middle Name */
    private WebElement findMiddleName() {
        String txtMiddleNameXPath = String.format(FORM_INPUT_PLACEHOLDER, "Middle Name");
        return findElement(By.xpath(txtMiddleNameXPath));
    }

    /* Find Last Name */
    private WebElement findLastName() {
        String txtLastNameXPath = String.format(FORM_INPUT_PLACEHOLDER, "Last Name");
        return findElement(By.xpath(txtLastNameXPath));
    }

    /*Detail*/
    private WebElement findDetail(){
        String btnDetailXpath = "//input[@type='checkbox']";
        return findElement(By.xpath(btnDetailXpath));
    }

    /*Input username*/
    private WebElement findUserName(){
        String userNameXpath = "//div[normalize-space()='Username']//input[@class='oxd-input oxd-input--active']";
        return findElement(By.xpath(userNameXpath));
    }

    /* Find Cancel */
    private WebElement findCancelButton() {
        String txtCancelXPath = String.format(FORM_BUTTON_TEXT, "Cancel");
        return findElement(By.xpath(txtCancelXPath));
    }

    /* Find Cancel */
    private WebElement findSaveButton() {
        String txtSaveXPath = String.format(FORM_BUTTON_TEXT, "Save");
        return findElement(By.xpath(txtSaveXPath));
    }


    /* Input First Name */
    public void inputFirstName(String value) {
        inputTextTo(findFirstName(), value, "First Name");
    }

    /* Input Last Name */
    public void inputLastName(String value) {
        inputTextTo(findLastName(), value, "Last Name");
    }

    /* Input Middle Name */
    public void inputMiddleName(String value) {
        inputTextTo(findMiddleName(), value, "Middle Name");
    }

    /* Click Detail */
    public EmployeeListPage clickDetailButton() {
        clickElement(findDetail(), "Open Detail");
        return new EmployeeListPage(webDriver);
    }

    /* Input user Name */
    public void inputUserName(String value) {
        inputTextTo(findUserName(), value, "Username");
    }

    /* Click Save */
    public EmployeeListPage clickSaveButton() {
        clickElement(findSaveButton(), "Save");
        return new EmployeeListPage(webDriver);
    }

    /* Click Cancel */
    public void clickCancelButton() {
        clickElement(findCancelButton(), "Cancel");
    }


    public void inputEmployeeInfo(String firtName, String middleName, String lastName) {
        inputFirstName(firtName);
        inputMiddleName(middleName);
        inputLastName(lastName);
    }

    public void inputEmployeeInfo(HashMap<String, String> data) {
        inputFirstName(data.get("firstName"));
        inputMiddleName(data.get("middleName"));
        inputLastName(data.get("lastName"));
    }
}
