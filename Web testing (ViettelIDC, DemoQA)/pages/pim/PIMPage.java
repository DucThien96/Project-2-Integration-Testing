package lession12.pages.pim;

import lession12.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class PIMPage extends BasePage {
    private WebDriver webDriver;

    public PIMPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    /* Find Add Employee Tab */
    private WebElement findAddEmployeeTab() {
        String tabAddEmpPage = "//a[normalize-space()='Add Employee']";
        return findElement(By.xpath(tabAddEmpPage));
    }

    /* Move to AddEmployeePage */
    public AddEmployeePage clickToAddEmployeeTab() {
        clickElement(findAddEmployeeTab(), "Add Employee Tab");
        return new AddEmployeePage(webDriver);
    }

    /* Verify PIM Page */
    public void verifyPIMPageSuccessfully() {
        WebElement tabAddEmpEle = findAddEmployeeTab();
        assertTrue(Objects.nonNull(tabAddEmpEle), "Verify Add Employee display");
    }


}
