package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.*;
import arcadia.utils.FormulaCalculator;
import arcadia.utils.RestAssuredUtility;
import arcadia.utils.SeleniumCustomCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

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
    @FindBy(css = "#ui-accordion-accordion-panel-0 > table > tbody > tr > td:nth-child(2)")private WebElement  summaryReportSplicePartNumber;
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
    @FindBy(css="#body > div:nth-child(21)")private WebElement updateSpliceDialogBox;
    @FindBy(css="#spliceconfigbox")private WebElement updateSpliceCheckBox;
    @FindBy(css="#btnFotter > button")private WebElement dialogBoxSubmitButton;
    @FindBy(css="#rightPaneContent")private WebElement summaryReportDynamicForm;
    @FindBy(css="#ui-accordion-accordion-panel-1 > table > tbody > tr > td:nth-child(2)")private WebElement errorMessageSummaryReport;
    @FindBy(css="#rightPaneContent > table > tbody > tr:nth-child(1) > td:nth-child(3)")private WebElement suggestedSplicePartNumber;
    @FindBy(css="#btnFotter > button")private WebElement closeButton;
    @FindBy(css=".hyperlink")private WebElement partNumber;
    @FindBy(css ="#ui-accordion-accordion-header-0")private WebElement updateSummaryHeader;
    @FindBy(css = "button[title=\"Submit\"]")
    private WebElement buttonSubmitDetails;
    @FindBy(css ="#bundlesize")private WebElement sideBundleDiameter;
    @FindBy(css ="#rightPaneContent > table > tbody > tr:nth-child(1) > td:nth-child(8)")private WebElement heatShrinkPartNumber;
    @FindBy(css="#rightPaneContent > table > tbody > tr:nth-child(1) > td:nth-child(9)")private WebElement expectedASide;
    @FindBy(css="#rightPaneContent > table > tbody > tr:nth-child(1) > td:nth-child(10)")private WebElement expectedBSide;
    String spliceTechnology = "Ultrasonic";
    String stringWireMaterial ="PVC";
    String actualAside ,actualBside,recoveredDia;
    HarnessPage harnessPage = new HarnessPage(driver);
    String aSideBundleDiameter,bSideBundleDiameter;
    RestAssuredUtility rs;
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

    public void addSpliceDetailsToCreatedPhysicalSplice() throws InterruptedException, AWTException {
        customCommand.javaScriptClick(driver,componentDBSplice);
        customCommand.clearAndEnterText(componentDBSpliceTechnology,spliceTechnology);
        customCommand.pressKey(driver,"enter");
        customCommand.clearAndEnterText(wireMaterial,stringWireMaterial);
        customCommand.pressKey(driver,"enter");
        Thread.sleep(2000);
        customCommand.clearAndEnterText(compDBASideCsa,"4");
        Thread.sleep(1000);
        customCommand.clearAndEnterText(compDBBSideCsa,"7");
        customCommand.javaScriptClick(driver,updateComponent);
        Thread.sleep(5000);
    }

    public void verifyAbleToViewUpdatePhysicalSpliceConfigurationPopup() throws InterruptedException {
        Thread.sleep(2000);
      //  Assert.assertTrue(updateSpliceDialogBox.isDisplayed(),"Update Splice/Heat-shrink dialog box is not able to view");
        Select library = new Select(driver.findElement(By.cssSelector("#updateSpliceHeatShrink > div.formDiv > div:nth-child(1) > select")));
        library.selectByValue(System.getProperty("componentDB"));
        Select technology = new Select(driver.findElement(By.cssSelector("#updateSpliceHeatShrink > div.formDiv > div:nth-child(3) > select")));
        technology.selectByValue(spliceTechnology);
        Thread.sleep(2000);
        buttonSubmitDetails.click();
    }

    public void verifyAbleToSuggestCreatedSplicePartNumber() throws InterruptedException {
        String splicePartNumber = "AUTOMATIONTESTPHYSICAL";
        Assert.assertEquals(suggestedSplicePartNumber.getText(),splicePartNumber,"Physical splice is not suggesting part number as expected");
        buttonSubmitDetails.click();
        Thread.sleep(3000);
        updateSummaryHeader.click();
        Thread.sleep(2000);
        Assert.assertTrue(summaryReportDynamicForm.isDisplayed(),"Summary Report is not visible");
        Assert.assertEquals(summaryReportSplicePartNumber.getText(),splicePartNumber,"Physical splice is not updated in summary report");
    }

    public void verifySuggestedSplicePartNumberHasBeenUpdatedInHarnessDrawing() {
        Assert.assertEquals(partNumber.getText(),"AUTOMATIONTESTPHYSICAL", "Splice Cavity part number is not visible as expected");
    }

    public void verifyAbleToSuggestCreatedSplicePartNumberAndHeatShrink() throws JsonProcessingException {

        rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("sleevetube", driver);
        sleeveTubeData =new SleeveTubeComponentDB(driver).getSleeveTubeAPIData(response);
        System.out.println(sleeveTubeData);
        List<ComponentDB> expectedPartNumberList = sleeveTubeData.stream().filter(x -> x.getPartnumber().equals(heatShrinkPartNumber.getText())).toList();
        recoveredDia = String.valueOf(expectedPartNumberList.get(0).getInternaldia());
    }
    List<ComponentDB> sleeveTubeData = null;

    public Double sleeveTubeAPIData() throws JsonProcessingException, InterruptedException {
        rs= new RestAssuredUtility();
        String response=rs.getComponentDbResponse("sleevetube", driver);
        sleeveTubeData =new SleeveTubeComponentDB(driver).getSleeveTubeAPIData(response);
        System.out.println(sleeveTubeData);
        List<ComponentDB> expectedPartNumberList = sleeveTubeData.stream().filter(x -> x.getPartnumber().equals("ES2000-NO.3-B9-0-40MM")).collect(Collectors.toList());
        System.out.println("expectedPartNumberList");
        System.out.println(expectedPartNumberList.get(0).getInternaldia());
        System.out.println(expectedPartNumberList.get(0).getExternaldia());
        return  expectedPartNumberList.get(0).getInternaldia();
    }

    public void calculate() throws JsonProcessingException, InterruptedException {
        String aSideFitPercentage = String.valueOf(new FormulaCalculator().getSpliceFitPercentageASide(Double.valueOf(aSideBundleDiameter.replace("mm","")), Double.valueOf(recoveredDia)));
        System.out.println(aSideFitPercentage);
        Assert.assertEquals(expectedASide.getText().substring(0,3),aSideFitPercentage.substring(0,3),"Suggested A side fit percentage is not as expected value");
        String bSideFitPercentage = String.valueOf(new FormulaCalculator().getSpliceFitPercentageBSide(Double.valueOf(bSideBundleDiameter.replace("mm","")), Double.valueOf(recoveredDia)));
        Assert.assertEquals(expectedBSide.getText().substring(0,3),bSideFitPercentage.substring(0,3),"Suggested B side fit percentage is not as expected value");
        System.out.println(bSideFitPercentage);
    }

    public void getBundleDiameter() throws InterruptedException {
        String identifier = FlowContext.bundleIdentifierList.get(0).getBundleId();
        harnessPage.getNodeContextMenu(identifier);
        new HarnessPage(driver).performOperation("inspect",identifier);
        aSideBundleDiameter = sideBundleDiameter.getText();
        String identifier2 = FlowContext.bundleIdentifierList.get(1).getBundleId();
        harnessPage.getNodeContextMenu(identifier2);
        new HarnessPage(driver).performOperation("inspect",identifier2);
        bSideBundleDiameter = sideBundleDiameter.getText();
    }
}

