package lession12.common;

import com.aventstack.extentreports.Status;
import lession12.report.ExtentReportManager;
import org.openqa.selenium.WebElement;

public class BaseLoginBTTH {
    /**
     * Input text to  ...
     */

    
    public void inputText(WebElement element, String value, String title) {
        element.clear();
        element.sendKeys(value);
        ExtentReportManager.logMessage(Status.INFO, String.format("Input text: [%s] to [%s]", value, title));
    }

    public void clickTo(WebElement element, String title){
        element.click();
        ExtentReportManager.logMessage(Status.INFO, String.format("Click to [%s]", title));
    }

    public void assertTrue(boolean isResult, String msg){
        Status status = Status.FAIL;
        if (isResult){
            status = Status.PASS;
        }
        ExtentReportManager.logMessage(status, String.format("Verify %s", msg));
    }
}
