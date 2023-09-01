package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;

public class SpliceConfigPage extends BasePage {
    public SpliceConfigPage(WebDriver driver){
        super(driver);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    @FindBy(css = "input[name='splicetechnology']")private WebElement spliceConfigTechnologyInProfile;
    @FindBy(css = "input[name='Splice.fromcsa']")private WebElement compDBASideCsa;
    @FindBy(css = "input[name='Splice.tocsa']")private WebElement compDBBSideCsa;
    @FindBy(css = "#GRIDspliceconfiguration > tbody > tr > td:nth-child(6) > div > div.selectize-input.items.not-full.has-options > input")private WebElement spliceMaterialTypeInProfile;
    @FindBy(css = "input[name='maxcsa']")private WebElement spliceWireCsaInProfile;
    @FindBy(css ="#idspliceform > div.box-body.no-padding > div.nav-tabs-custom.no-margin > ul > li:nth-child(2) >a")private WebElement componentDBSplice;
    @FindBy(css="#idDetails > div.box-body > div:nth-child(1) > div:nth-child(2) > div > div.selectize-input.items.not-full.has-options > input")private WebElement componentDBSpliceTechnology;
    @FindBy(css="#iddefview > div.box-body > div:nth-child(1) > div:nth-child(2) > div > div.selectize-input.items.not-full> input")private WebElement wireMaterial;
    @FindBy(css="#spliceconfig")private WebElement spliceConfigurationInputBox;
    @FindBy(css="#btnSave")private WebElement updateComponent;
    @FindBy(css = "button[class='btn btn-primary']")
    private WebElement okayButton;
    @FindBy(css="#idselectform > div.box-footer > button")private WebElement saveButton;
    @FindBy(css="#addRow")private WebElement addRow;
    @FindBy(css="#getConfig")private WebElement getConfigASideBSide;
    @FindBy(css="#gaugeDefault")private WebElement loadDefaultButton;
    @FindBy(xpath="//button[@id='gaugeRow']")private WebElement addRowButton;
    @FindBy(css="#gaugeTable > tbody > tr:nth-child(22) > td:nth-child(1) > div > div.selectize-input.items.not-full.has-options > input")private WebElement gaugeName;
    @FindBy(css = "#gaugeTable > tbody > tr:nth-child(22) > td:nth-child(2) > input")private WebElement gaugeEditorMaxCurrent;
    @FindBy(css = "#gaugeTable > tbody > tr:nth-child(22) > td:nth-child(3) > input")private WebElement gaugeEditorCSA;
    @FindBy(css="#gaugeTable > tbody > tr:nth-child(22) > td:nth-child(4) > input")private WebElement gaugeEditorResistivity;
    @FindBy(css="#idselectform > div.box-footer > div > button")private WebElement gaugeEditorSaveButton;
    @FindBy(css="#body > div:nth-child(42)")private WebElement updateSpliceDialogBox;
    @FindBy(css="#spliceconfigbox")private WebElement updateSpliceCheckBox;
    @FindBy(css="#btnFotter > button")private WebElement dialogBoxSubmitButton;
    @FindBy(css="#rightPaneContent")private WebElement summaryReportDynamicForm;
    @FindBy(css="#ui-accordion-accordion-panel-1 > table > tbody > tr > td:nth-child(2)")private WebElement errorMessageSummaryReport;
    @FindBy(css = "button[title=\"Submit\"]")
    private WebElement buttonSubmitDetails;
    String spliceTechnology = "Ultrasonic";
    String stringWireMaterial ="PVC";
    String actualAside ,actualBside;
    public void addNewSpliceConfigurationInProfile() throws InterruptedException, AWTException {
        Object rowCount = js.executeScript("return document.querySelector('#GRIDspliceconfiguration > tbody').childElementCount");
        int rowCountToInt = Integer.parseInt(rowCount.toString());
        for (int i =1;i<rowCountToInt;i++)
        {
            driver.findElement(By.cssSelector("#GRIDspliceconfiguration > tbody > tr:nth-child(1) > td:nth-child(8) > div > button.removeRow.btn.btn-sm.btn-danger")).click();
            customCommand.javaScriptClick(driver,okayButton);
        }
        customCommand.clearAndEnterText(spliceConfigTechnologyInProfile,spliceTechnology);
        //customCommand.javaScriptClick(driver,spliceMaterialTypeInProfile);
        customCommand.enterText(spliceMaterialTypeInProfile,stringWireMaterial);
        customCommand.pressKey(driver,"enter");
        customCommand.clearAndEnterText(spliceWireCsaInProfile,"10mm");
        customCommand.javaScriptClick(driver,saveButton);
    }


    public void addSpliceDetailsToCreatedSplice() throws InterruptedException, AWTException {
        customCommand.javaScriptClick(driver,componentDBSplice);
        customCommand.clearAndEnterText(componentDBSpliceTechnology,spliceTechnology);
        customCommand.pressKey(driver,"enter");
        customCommand.clearAndEnterText(wireMaterial,stringWireMaterial);
        customCommand.pressKey(driver,"enter");
        customCommand.clearAndEnterText(spliceConfigurationInputBox,"18-2,16-1/18-2");
        customCommand.javaScriptClick(driver,getConfigASideBSide);
        customCommand.javaScriptClick(driver,updateComponent);
        actualAside =  compDBASideCsa.getAttribute("value");
        actualBside = compDBBSideCsa.getAttribute("value");
        Thread.sleep(5000);
    }

    public void modifyGaugeEditor() throws AWTException, InterruptedException {
        loadDefaultButton.click();
        Thread.sleep(2000);
        addRowButton.click();
        Thread.sleep(3000);
        customCommand.scrollIntoView(driver,gaugeEditorSaveButton);
        customCommand.enterText(gaugeName,"18.0");
        customCommand.pressKey(driver,"enter");
        customCommand.enterText(gaugeEditorMaxCurrent,"110.0");
        customCommand.enterText(gaugeEditorCSA,"18.5");
        customCommand.enterText(gaugeEditorResistivity,"1.10");
        customCommand.javaScriptClick(driver,gaugeEditorSaveButton);
    }

    public void verifySpliceConfigurationOfAsideAndBsideIsCalculatedAsPerTheGaugeEditorCsa() {
        Assert.assertEquals(actualAside,"4.10","A side CSA calculation value is not expected");
        Assert.assertEquals(actualBside,"2.00","B side CSA calculation value is not expected");
    }
    public void spliceHeatShrinkFromContextMenuOptions() throws InterruptedException {
        String spliceId = new ConnectorPage(driver).getSpliceElementIdsFromDrawingPage().get(Integer.parseInt(String.valueOf(0))).getSpliceId();
        WebElement ele=driver.findElement(By.xpath("//*[name()='g' and @id='"+spliceId+"']/*[name()='rect']"));
        new HarnessPage(driver).getContextMenu(spliceId,ele);
        Thread.sleep(2000);
        new HarnessPage(driver).performOperation("Splice/Heat Shrink",spliceId);
    }

    public void verifyErrorMessage(String errorMessage) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(summaryReportDynamicForm.isDisplayed(),"Summary Report is not visible for splice");
        Assert.assertEquals(errorMessageSummaryReport.getText(),errorMessage,"Error message is not visible as expected");
    }

    public void verifyAbleToViewUpdateSpliceHeatshrinkConfigurationPopup() {
        Assert.assertTrue(updateSpliceDialogBox.isDisplayed(),"Update Splice/Heat-shrink dialog box is not able to view");
        Select library = new Select(driver.findElement(By.cssSelector("#updateSpliceHeatShrink > div.formDiv > div:nth-child(1) > select")));
        library.selectByValue(System.getProperty("componentDB"));
        updateSpliceCheckBox.click();
        buttonSubmitDetails.click();
    }
}

