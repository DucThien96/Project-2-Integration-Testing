package lession12.testscript.pim;

import lession12.common.TestBase;
import lession12.pages.pim.*;

import lession12.provider.PIMProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class AddEmployeeTest extends TestBase {
    private LoginPage loginPage;
    private HomePage homePage;
    private PIMPage pimPage;
    private AddEmployeePage addEmployeePage;
    private EmployeeListPage employeeListPage;

    @BeforeMethod
    public void beforeMethod() {
//        loginPage = new LoginPage(DriverManager.getWebDriver());
//        loginPage.gotoWeb("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void AddEmployee_001_AddNew() {
        homePage = loginPage.login("Admin", "admin123");
        homePage.verifyLoginSuccessfully();
        pimPage = homePage.clickToPIMNav();
        pimPage.verifyPIMPageSuccessfully();
        addEmployeePage = pimPage.clickToAddEmployeeTab();

        String firstName = "Vincent";
        String lastName = "Test";
        String middleName = "Test";
        addEmployeePage.inputEmployeeInfo(firstName, middleName, lastName);


        employeeListPage = addEmployeePage.clickSaveButton();

        // Verify employeeList

        System.out.println();
    }

    @Test(description = "Execute with data", dataProvider = "AddEmployee_002_AddNew", dataProviderClass = PIMProvider.class)
    public void AddEmployee_002_AddNew(HashMap<String, String> data) {
        homePage = loginPage.login(data.get("username"), data.get("password"));
        homePage.verifyLoginSuccessfully();
        pimPage = homePage.clickToPIMNav();
        pimPage.verifyPIMPageSuccessfully();
        addEmployeePage = pimPage.clickToAddEmployeeTab();

        addEmployeePage.inputEmployeeInfo(data);
        addEmployeePage.clickDetailButton();

        employeeListPage = addEmployeePage.clickSaveButton();
        // Verify employeeList

        System.out.println();
    }

}
