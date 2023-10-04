package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.util.List;

public class TableOperationPage extends BasePage {
    BundleOpsPage bundleOpsPage = new BundleOpsPage(driver);
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();

    @FindBy(css="#btnFotter > button:nth-child(1)")private WebElement buttonSubmitDetails;
    @FindBy(css="input[placeholder='Search']")private WebElement searchInputBox;
    public TableOperationPage(WebDriver driver) {
        super(driver);
    }

    public void placeBomTableInDrawing() throws InterruptedException {
        bundleOpsPage.inputCommand("bomtable 43.59,125.13");
        verifyBOMTableHeaderData();
    }

    public void verifyBOMTableHeaderData() {
        WebElement eleBOMDataRow = driver.findElement(By.cssSelector("#layer_52 > g > g > foreignObject > table > thead > tr"));
        List<WebElement> tdElements = eleBOMDataRow.findElements(By.cssSelector("th"));
        System.out.println(tdElements.get(0).getText());
        System.out.println(tdElements.get(1).getText());
        System.out.println(tdElements.get(2).getText());
        System.out.println(tdElements.get(3).getText());
        System.out.println(tdElements.get(4).getText());
        System.out.println(tdElements.get(5).getText());
        System.out.println(tdElements.get(6).getText());
        System.out.println(tdElements.get(7).getText());
//        Assert.assertEquals(tdElements.get(0).getText(),colour);
//        Assert.assertEquals(tdElements.get(1).getText(),gauge);
//        Assert.assertEquals(tdElements.get(2).getText(),material);
//        Assert.assertEquals(tdElements.get(3).getText(),dest);
//        Assert.assertEquals(tdElements.get(4).getText(),outerDia);
//        Assert.assertEquals(tdElements.get(5).getText(),csa);
//        Assert.assertEquals(tdElements.get(6).getText(),fromTag);
//        Assert.assertEquals(tdElements.get(7).getText(),toTag);
//        Assert.assertEquals(tdElements.get(8).getText(),entryPort);
    }

    public String getTaskID() {
        String url1 = driver.getCurrentUrl();
        String taskID = url1;
        taskID = taskID.substring(taskID.indexOf("R") + 1);
        taskID = taskID.substring(0, taskID.indexOf("&"));
        System.out.println("Task id :" + taskID);
        return taskID;
    }

    public void makeAllHeadersVisibleINBOMTableSettings() throws InterruptedException, AWTException {
        WebElement eleBOMDataRow = driver.findElement(By.cssSelector("#GRIDbomtable > tbody"));
        List<WebElement> tdElements = eleBOMDataRow.findElements(By.cssSelector("tr"));
        for(int i=1;i<=17;i++){
            Select makeVisible = new Select(driver.findElement(By.cssSelector(tdElements.get(i)+"> td:nth-child(4) > select")));
            makeVisible.selectByValue("true");
        }
        customCommand.scrollToElement(driver,buttonSubmitDetails);
        customCommand.waitClick(buttonSubmitDetails);
        customCommand.clearAndEnterText(searchInputBox,getTaskID());
        customCommand.simulateKeyEnter();
        WebElement profileCheckBox =driver.findElement(By.cssSelector("#"+getTaskID()));
        customCommand.waitClick(profileCheckBox);
        customCommand.scrollIntoView(driver,buttonSubmitDetails);
        customCommand.waitClick(buttonSubmitDetails);
    }
}
