package lession12.pages.pim;

import lession14.common.BasePage;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage extends BasePage {
    private WebDriver webDriver;

    public EmployeeListPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }
}
