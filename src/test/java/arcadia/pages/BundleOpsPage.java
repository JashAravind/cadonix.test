package arcadia.pages;

import arcadia.context.FlowContext;
import arcadia.domainobjects.Wire;
import arcadia.domainobjects.WireProperties;
import arcadia.utils.FormulaCalculator;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;


public class BundleOpsPage extends BasePage {
    @FindBy(css = "#iaddnode")
    private WebElement node;
    @FindBy(css = "#layer_drawNodes > g:nth-child(3)")
    private WebElement nodeID;
    @FindBy(css = "#layer_drawNodes > g:nth-child(3)")
    private WebElement getBendNodeID;
    @FindBy(css = "#layer_80 > g.DG0.bundleGroup > g > g > use")
    private WebElement getXYOfNode;
    @FindBy(css = "#layer_80 > g.DG0.bundleGroup > g")
    private WebElement getBundleNode1Attributes;
    @FindBy(css = "#layer_80 > g.DG1.bundleGroup > g")
    private WebElement getBundleNode2Attributes;
    @FindBy(css = "#layer_80 > g.DG7.bundleGroup > g")
    private WebElement getBundleNode3Attributes;
    @FindBy(css = "#layer_80 > g:nth-child(2)")
    private WebElement rejoinNode;
    @FindBy(css = "#cmiremoverejoin")
    private WebElement rejoin;
    @FindBy(css = "#layer_55 > g > g")
    private WebElement bundle1;
    @FindBy(css = "#botbar-messages > span > span")
    private WebElement commandMessage;
    @FindBy(css = "#rightPaneContent")
    private WebElement rightBarContent;
    @FindBy(css = "#bundle2")
    private WebElement bundle2Rejoin;
    @FindBy(css = "form#DynamicForm button[title=\"Submit\"]")
    private WebElement buttonSubmitBundleDetailsForm;
    @FindBy(css = "#layer_drawNodes > g:nth-child(4)")
    private WebElement bendControlNode;
    @FindBy(css = "input[name=\"bundle.allBendsRadius\"]")
    private WebElement setAllRadius;
    @FindBy(css = "input[name=\"bundle.override\"]")
    private WebElement checkBoxOverRide;
    @FindBy(css = "input[name=\"bundle.length\"]")
    private WebElement setLengthValueTextBox;
    @FindBy(css = "button[title=\"Submit\"]")
    private WebElement buttonSubmitDetails;
    @FindBy(css = "#layer_55 > g > g > path:nth-child(7)")
    private WebElement pathSelector;
    @FindBy(css = "#iremoveallbends > span")
    private WebElement removeAllBends;
    @FindBy(css = "#layer_80 > g.DG7.bundleGroup > g")
    private WebElement bundleBreakControlNode;
    @FindBy(css = "#drawdestroyclone")
    private WebElement deleteBundleBreak;
    @FindBy(css = "#layer_drawNodes > g:nth-child(7)")
    private WebElement layerDrawNodes7;
    @FindBy(css = "#layer_100 > g > text")
    private WebElement layer100TextContent;
    @FindBy(css = "#appContextMenu > form > input[type=text]:nth-child(3)")
    private WebElement setLength;
    @FindBy(css = ".complabel")
    private WebElement complabel;
    @FindBy(css = "#rightPaneContent")
    private WebElement bundleSizeAndContentTab;
    @FindBy(css = "#ishowbundlecontent")
    private WebElement contentButton;
    @FindBy(css = "#layer_85 > g.DG5.bundleGroup > g > text")
    private WebElement bundleCoveringDetails;
    @FindBy(css="#opt1")private WebElement optionBundleProperties;
    @FindBy(css="#layer_85 > g.DG13.bundleGroup > g > text")private WebElement bundle2Text;
    @FindBy(css="#selectboth")private WebElement selectAllMatchProperties;
    String expectedPathD = "M 12.01 26.45 L 191.56 26.45 L 191.56 26.45 L 193.74 26.55 L 195.9 26.83 L 198.03 27.3 L 200.11 27.96 L 202.13 28.79 L 204.06 29.8 L 205.9 30.97 L 207.63 32.3 L 209.24 33.77 L 210.71 35.38 L 212.04 37.11 L 213.21 38.95 L 214.22 40.88 L 215.05 42.9 L 215.71 44.98 L 216.18 47.11 L 216.46 49.27 L 216.56 51.45 L 216.56 51.45 L 216.56 175.1 L 216.56 175.1 L 216.46 177.28 L 216.18 179.44 L 215.71 181.57 L 215.05 183.65 L 214.22 185.67 L 213.21 187.6 L 212.04 189.44 L 210.71 191.17 L 209.24 192.78 L 207.63 194.25 L 205.9 195.58 L 204.06 196.75 L 202.13 197.76 L 200.11 198.59 L 198.03 199.25 L 195.9 199.72 L 193.74 200 L 191.56 200.1 L 191.56 200.1 L 37.46 200.1 L 37.46 200.1 L 35.28 200 L 33.12 199.72 L 30.99 199.25 L 28.91 198.59 L 26.89 197.76 L 24.96 196.75 L 23.12 195.58 L 21.39 194.25 L 19.78 192.78 L 18.31 191.17 L 16.98 189.44 L 15.81 187.6 L 14.8 185.67 L 13.97 183.65 L 13.31 181.57 L 12.84 179.44 L 12.56 177.28 L 12.46 175.1 L 12.46 175.1 L 12.46 75.36 L 12.46 75.36 L 12.56 73.18 L 12.84 71.02 L 13.31 68.89 L 13.97 66.81 L 14.8 64.79 L 15.81 62.86 L 16.98 61.02 L 18.31 59.29 L 19.78 57.68 L 21.39 56.21 L 23.12 54.88 L 24.96 53.71 L 26.89 52.7 L 28.91 51.87 L 30.99 51.21 L 33.12 50.74 L 35.28 50.46 L 37.46 50.36 L 37.46 50.36 L 173.74 50.36 L 173.74 50.36 L 175.92 50.46 L 178.08 50.74 L 180.21 51.21 L 182.29 51.87 L 184.31 52.7 L 186.24 53.71 L 188.08 54.88 L 189.81 56.21 L 191.42 57.68 L 192.89 59.29 L 194.22 61.02 L 195.39 62.86 L 196.4 64.79 L 197.23 66.81 L 197.89 68.89 L 198.36 71.02 L 198.64 73.18 L 198.74 75.36 L 198.74 75.36 L 198.74 139.02 L 198.74 139.02 L 198.64 141.2 L 198.36 143.36 L 197.89 145.49 L 197.23 147.57 L 196.4 149.59 L 195.39 151.52 L 194.22 153.36 L 192.89 155.09 L 191.42 156.7 L 189.81 158.17 L 188.08 159.5 L 186.24 160.67 L 184.31 161.68 L 182.29 162.51 L 180.21 163.17 L 178.08 163.64 L 175.92 163.92 L 173.74 164.02 L 173.74 164.02 L 62.27 164.02 L 62.27 164.02 L 60.09 163.92 L 57.93 163.64 L 55.8 163.17 L 53.72 162.51 L 51.7 161.68 L 49.77 160.67 L 47.93 159.5 L 46.2 158.17 L 44.59 156.7 L 43.12 155.09 L 41.79 153.36 L 40.62 151.52 L 39.61 149.59 L 38.78 147.57 L 38.12 145.49 L 37.65 143.36 L 37.37 141.2 L 37.27 139.02 L 37.27 139.02 L 37.27 88.44 L 37.27 88.44 L 37.37 86.26 L 37.65 84.1 L 38.12 81.97 L 38.78 79.89 L 39.61 77.87 L 40.62 75.94 L 41.79 74.1 L 43.12 72.37 L 44.59 70.76 L 46.2 69.29 L 47.93 67.96 L 49.77 66.79 L 51.7 65.78 L 53.72 64.95 L 55.8 64.29 L 57.93 63.82 L 60.09 63.54 L 62.27 63.44 L 62.27 63.44 L 149.38 63.44 L 149.38 63.44 L 151.56 63.54 L 153.72 63.82 L 155.85 64.29 L 157.93 64.95 L 159.95 65.78 L 161.88 66.79 L 163.72 67.96 L 165.45 69.29 L 167.06 70.76 L 168.53 72.37 L 169.86 74.1 L 171.03 75.94 L 172.04 77.87 L 172.87 79.89 L 173.53 81.97 L 174 84.1 L 174.28 86.26 L 174.38 88.44 L 174.38 88.44 L 174.38 114.66 L 174.38 114.66 L 174.28 116.84 L 174 119 L 173.53 121.13 L 172.87 123.21 L 172.04 125.23 L 171.03 127.16 L 169.86 129 L 168.53 130.73 L 167.06 132.34 L 165.45 133.81 L 163.72 135.14 L 161.88 136.31 L 159.95 137.32 L 157.93 138.15 L 155.85 138.81 L 153.72 139.28 L 151.56 139.56 L 149.38 139.66 L 149.38 139.66 L 87.3 139.66 L 87.3 139.66 L 85.12 139.56 L 82.96 139.28 L 80.83 138.81 L 78.75 138.15 L 76.73 137.32 L 74.8 136.31 L 72.96 135.14 L 71.23 133.81 L 69.62 132.34 L 68.15 130.73 L 66.82 129 L 65.65 127.16 L 64.64 125.23 L 63.81 123.21 L 63.15 121.13 L 62.68 119 L 62.4 116.84 L 62.3 114.66 L 62.3 114.66 L 62.3 114.37 L 62.3 114.37 L 62.4 112.19 L 62.68 110.03 L 63.15 107.9 L 63.81 105.82 L 64.64 103.8 L 65.65 101.87 L 66.82 100.03 L 68.15 98.3 L 69.62 96.69 L 71.23 95.22 L 72.96 93.89 L 74.8 92.72 L 76.73 91.71 L 78.75 90.88 L 80.83 90.22 L 82.96 89.75 L 85.12 89.47 L 87.3 89.37 L 87.3 89.37 L 135.6 89.37";
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    String x = "75", y = "75";
    int coveringsSize = 0;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    HarnessPage harnessPage = new HarnessPage(driver);

    public BundleOpsPage(WebDriver driver) {
        super(driver);
    }

    public void inputCommand(String command) throws InterruptedException {
        Thread.sleep(8000);
        harnessPage.fillCommandLine(command);
        harnessPage.clickOnCommandLineOK();
        harnessPage.waitBetweenHarnessActions();
    }

    public void userAddBendUsingCommandThroughCommandLineInHarness(String command) throws InterruptedException {
        Thread.sleep(5000);
        String frameCommand = command + " " + bundle1.getAttribute("id") + " 88.48,46.13";
        inputCommand(frameCommand);
    }

    public String bundleId() throws InterruptedException {
        Thread.sleep(10000);
        String bundleId = FlowContext.bundleIdentifierList.get(0).getBundleId();
        ;
        System.out.println(bundleId);
        return bundleId;
    }

    public void moveCommand() throws InterruptedException {
        String frameCommand = "move " + nodeEId() + " " + x + "," + y;
        inputCommand(frameCommand);
    }

    public void checkAbleToMoveOneEndOfBundleToBendOrNot() throws InterruptedException {
        moveCommand();
        Assert.assertEquals(getXYOfNode.getAttribute("x"), "19.04", "Add bend x coordinate is not in expected position");
        Assert.assertEquals(getXYOfNode.getAttribute("y"), "46.05", "Add bend y coordinate is not in expected position");
    }

    public void checkAbleToRejoinTheBundleOrNot() throws InterruptedException {
        String identifier = FlowContext.nodeIdentifierList.get(1).getNodeElementId();
        harnessPage.getNodeContextMenu(identifier);
        new HarnessPage(driver).performOperation("rejoin", identifier);
        checkBundleIsRejoined();
        Assert.assertTrue(removeRejoinTableIsDisplayed(), "Remove and Rejoin tab is not visible after rejoin operation is performed");
        Object rightTabContent = js.executeScript("return document.querySelector('#rightPaneContent > table > tbody').childElementCount");
        String rightTabContentBundleSize = rightTabContent.toString();
        System.out.println(rightTabContentBundleSize);
        Assert.assertEquals(rightTabContentBundleSize, "2", "Bundle rejoin is not visible as per the bundle quantities");
        customCommand.javaScriptClick(driver, bundle2Rejoin);
        customCommand.javaScriptClick(driver, buttonSubmitBundleDetailsForm);
    }

    public void userTriesToPlaceNodeOnBundle() throws InterruptedException {
        String frameCommand = "insertnode " + bundleId() + " 78.04,45.78";
        inputCommand(frameCommand);
        Thread.sleep(5000);
    }

    public String nodeEId() throws InterruptedException {
        Thread.sleep(5000);
        String nodeId = nodeID.getAttribute("id");
        System.out.println(nodeId);
        System.out.println(nodeId.substring(2));
        return nodeId.substring(2);
    }

    public boolean removeRejoinTableIsDisplayed() {
        System.out.println(rightBarContent.isDisplayed());
        return rightBarContent.isDisplayed();
    }

    public void checkBundleIsRejoined() {
        int identifier = FlowContext.nodeIdentifierList.size();
        System.out.println("identifier :" + identifier);
    }

    public void checkAbleToRemoveBendOrNot() throws InterruptedException {
        String id = bendControlNode.getAttribute("id");
        String frameCommand = "rmbundlebend " + id.substring(2);
        inputCommand(frameCommand);
        Thread.sleep(3000);
        Assert.assertEquals(pathSelector.getAttribute("d"), "M 19.04 46.05 L 19.04 46.05 L 75 75", "Remove bend is not working as expected");
    }

    public void setAllRadius() throws InterruptedException {
        customCommand.clearAndEnterText(setAllRadius, "25mm");
        customCommand.javaScriptClick(driver, checkBoxOverRide);
        customCommand.scrollIntoView(driver, buttonSubmitDetails);
        customCommand.javaScriptClick(driver, buttonSubmitDetails);
    }

    public void checkBendRadiusInBundle() {
        String actualPathD = pathSelector.getAttribute("d");
        System.out.println(actualPathD);
        Assert.assertEquals(actualPathD, expectedPathD, "In Harness bundle radius is not expected");
    }

    public void userTryToRemoveAllBendsInTheDrawing() throws InterruptedException {
        customCommand.scrollIntoView(driver, removeAllBends);
        customCommand.javaScriptClick(driver, removeAllBends);
    }

    public void checkAbleToRemoveAllBendsOrNot() {
        String actualPathD = pathSelector.getAttribute("d");
        System.out.println(actualPathD);
        Assert.assertEquals(actualPathD, "M 12.01 26.45 L 135.6 89.37", "Remove all bends are not working as expected");
    }

    public void bundleBreakIsPlacedOnBundle() throws InterruptedException {
        String frameCommand = "bundlebreak " + bundle1.getAttribute("id") + " 47.43mm,73.69mm";
        inputCommand(frameCommand);
        Assert.assertEquals(commandMessage.getText(), "Command Successful", "Bundle break in command line is not working as expected");
    }

    public void checkBundleIsBrokenOrNot() {
        Object bundleCount = js.executeScript("return document.querySelector('#layer_55').childElementCount");
        String actualBundleCount = bundleCount.toString();
        System.out.println(actualBundleCount);
        Assert.assertEquals(actualBundleCount, "2", "After bundle break bundle quantity is not matching as expected");
    }

    public void checkBundleBreakIsDeletedOrNot() throws InterruptedException {
        Object bundleCount = js.executeScript("return document.querySelector('#layer_55').childElementCount");
        String actualBundleCount = bundleCount.toString();
        System.out.println(actualBundleCount);
        Assert.assertEquals(actualBundleCount, "1", "Bundle break delete is not working as expected");
    }

    public void userTryToRejoinTheBundleBreak() throws InterruptedException {
        customCommand.rightClick(driver, bundleBreakControlNode);
        Thread.sleep(2000);
        customCommand.javaScriptClick(driver, deleteBundleBreak);
    }

    public void userTriesToJoinTwoBundlesWithBundleBreak() throws InterruptedException {
        String frameCommand = "bundlebreakjoin " + nodeID.getAttribute("id").substring(2) + " " + layerDrawNodes7.getAttribute("id").substring(2);
        inputCommand(frameCommand);
        Thread.sleep(5000);
    }

    public void checkBundleCanBeJoinedTwoBundlesWithBundleBreak() throws InterruptedException {
        Assert.assertTrue(removeRejoinTableIsDisplayed(), "Remove and Rejoin tab is not visible after rejoin operation is performed");
        Object rightTabContent = js.executeScript("return document.querySelector('#rightPaneContent > table > tbody').childElementCount");
        String rightTabContentBundleSize = rightTabContent.toString();
        System.out.println(rightTabContentBundleSize);
        Assert.assertEquals(rightTabContentBundleSize, "2", "Bundle rejoin is not visible as per the bundle quantities");
        customCommand.javaScriptClick(driver, bundle2Rejoin);
        customCommand.javaScriptClick(driver, buttonSubmitBundleDetailsForm);
    }

    public void userTriesToCalculateTheDimensionThroughChainDimension() throws InterruptedException {
        String frameCommand = "chaindimension " + getBundleNode1Attributes.getAttribute("id") + " " + getBundleNode2Attributes.getAttribute("id") + " " + "73.79,112.47";
        inputCommand(frameCommand);
        Assert.assertEquals(commandMessage.getText(), "Command Successful", "Chain dimension through command line is not working as expected");
    }

    public void verifyChainDimensionIsCalculatedAsExpectedToTheBundleOrNot() {
        Assert.assertEquals(layer100TextContent.getText(), "136.25 +/- 10", "chain dimension length is not as expected");
    }

    public void userTriesToCalculateDimensionBetweenTwoBundles() throws InterruptedException {
        String frameCommand = "chaindimension " + getBundleNode1Attributes.getAttribute("id") + " " + getBundleNode3Attributes.getAttribute("id") + " " + "73.79,112.47";
        inputCommand(frameCommand);
    }

    public void verifyChainDimensionIsCalculatedBetweenTwoBundleOrNot() {
        Assert.assertEquals(commandMessage.getText(), "No path found between the selected nodes. Hence, chain dimensioning is not possible.", "Chain dimension is not possible between two different bundle");
    }

    public void inspectBundle() throws InterruptedException {
        String identifier = FlowContext.bundleIdentifierList.get(1).getBundleId();
        harnessPage.getNodeContextMenu(identifier);
        new HarnessPage(driver).performOperation("inspect", identifier);
    }

    public void userTriesToSetLengthNotToScale() throws InterruptedException, AWTException {
        customCommand.javaScriptClickAndEnterValue(driver, setLengthValueTextBox, "15");
        customCommand.javaScriptClickAndEnterValue(driver, setAllRadius, "3");
        customCommand.javaScriptClick(driver, checkBoxOverRide);
        customCommand.javaScriptClick(driver, buttonSubmitBundleDetailsForm);
    }

    private void rightClickBundle(String operation) throws InterruptedException, AWTException {

        String identifier = FlowContext.bundleIdentifierList.get(0).getBundleId();
        harnessPage.getNodeContextMenu(identifier);
        new HarnessPage(driver).performOperation(operation, identifier);
    }

    public void checkWhetherSetLengthValueIsUpdatedOrNotAsNTS() {
        Assert.assertEquals(complabel.getText(), "NTS15.00", "Not To scale length is not updated as expected");
        Assert.assertEquals(complabel.getAttribute("fill"), "#8214FF", "Not To scale length is not updating as default colour");
    }

    public void checkToScale() throws InterruptedException {
        String frameCommand = "bundlefix " + bundle1.getAttribute("id") + " " + getBundleNode1Attributes.getAttribute("id");
        inputCommand(frameCommand);
        Thread.sleep(3000);
        Assert.assertEquals(complabel.getText(), "15.00", "After To scale length is not updated as expected");
        Assert.assertEquals(complabel.getAttribute("fill"), "#ff0000", "After to scale font color is not changed");
    }

    public void verifyBundleIsInAsExpectedOrNot() throws InterruptedException, AWTException {
        System.out.println(bundle1.getAttribute("id"));
        rightClickBundle("content");
        Thread.sleep(5000);
        System.out.println(bundleSizeAndContentTab.isDisplayed());
        Assert.assertTrue(bundleSizeAndContentTab.isDisplayed());
        for (int i = 2; i <= 6; i += 2) {
            WebElement bundleNameSelector = driver.findElement(By.cssSelector("#rightPaneContent > font > table:nth-child(3) > thead > tr > th:nth-child(" + i + ") > strong"));
            if (i == 2) {
                Assert.assertEquals(bundleNameSelector.getText(), "3", "There is mismatch wire count which is mapped to the connector");
            } else if (i == 4) {
                List<WireProperties> wireProperties = Wire.getWirePropertiesList();
                String expectedDiameter = String.valueOf(new FormulaCalculator().getBundleDiameter(wireProperties.stream().map(WireProperties::getWireOuterDiameter).collect(toList())));
                Assert.assertEquals(bundleNameSelector.getText(), expectedDiameter + "mm", "Bundle diameter calculated is not expected");
            } else if (i == 6) {
                Assert.assertEquals(bundleNameSelector.getText(), complabel.getText() + "mm", "Bundle length displayed is not expected ");
            }
        }
    }

    public void verifyBundleCoveringPartNumberIsInAsExpectedOrNotInBundleContentOrNot() throws InterruptedException, AWTException {
        System.out.println(bundleCoveringDetails.getText());
        String expectedCoveringPartNumbers = bundleCoveringDetails.getText();
        rightClickBundle("content");
        Assert.assertTrue(bundleSizeAndContentTab.isDisplayed());
        String partNumbers;
        List<String> actualPartNumbers = new ArrayList<>();
        for (int i = 1; i <= coveringsSize; i++) {
            WebElement coveringPartNumberSelector = driver.findElement(By.cssSelector("#rightPaneContent > font > table:nth-child(6) > tbody:nth-child(3) > tr:nth-child(" + i + ") > td:nth-child(5)"));
            partNumbers = coveringPartNumberSelector.getText();
            actualPartNumbers.add(partNumbers);
        }
        System.out.println(actualPartNumbers);
        Assert.assertTrue(expectedCoveringPartNumbers.contains(actualPartNumbers.get(0)), "Covering part numbers are not expected in bundle content");
        Assert.assertTrue(expectedCoveringPartNumbers.contains(actualPartNumbers.get(1)), "Covering part numbers are not expected in bundle content");
    }

    public int userGetsTheCoveringListFromBundleProperties() throws InterruptedException, AWTException {
        rightClickBundle("inspect");
        Object coverings = js.executeScript("return document.querySelector('#coverings > tbody').childElementCount");
        coveringsSize = Integer.parseInt(coverings.toString());
        System.out.println(coveringsSize);
        return coveringsSize;
    }

    public void verifyByClickingWireThatWiresIsHighlightedInCavityTableOrNot() throws InterruptedException, AWTException {
        List<WireProperties> wireProperties = Wire.getWirePropertiesList();
        System.out.println(wireProperties.size());
        rightClickBundle("content");
        Object count = js.executeScript("return document.querySelector('#bundlecontentTbl > tbody').childElementCount");
        int actualWireInContent = Integer.parseInt(count.toString());
        Assert.assertEquals(actualWireInContent,wireProperties.size(),"Wire mapped with connector is not as expected in the bundle content wire properties");
        for(int i=1;i<=actualWireInContent;i++){
            WebElement contentWireSelector = driver.findElement(By.cssSelector("#bundlecontentTbl > tbody > tr:nth-child("+i+") > td:nth-child(2) > a"));
            customCommand.javaScriptClick(driver,contentWireSelector);
            WebElement cavityTableHighLightSelector = driver.findElement(By.cssSelector("#layer_80 > g.DG6.bundleGroup > g > g:nth-child(4) > g > foreignObject > table > tbody > tr:nth-Child("+i+")"));
            Assert.assertEquals(cavityTableHighLightSelector.getAttribute("class"),"forcehighlight","Wire "+i+" is not highlighting as expected");
        }
    }
    public void checkMatchPropertiesWorkingOrNotAsExpectedWithBasicBundleProperties() throws InterruptedException {
        passCommandMatchProperties();
        customCommand.javaScriptClick(driver,optionBundleProperties);
        customCommand.scrollIntoView(driver,buttonSubmitDetails);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
        Assert.assertEquals(complabel.getText(),"NTS90.00","After match properties Bundle 1 is not in expected length");
        Assert.assertEquals(complabel.getAttribute("fill"),"#8214FF","After match properties Bundle 1 is not in expected font colour");
        Assert.assertEquals(bundle2Text.getText(),"NTS90.00","After match properties Bundle 2 is not in expected length");
        Assert.assertEquals(bundle2Text.getAttribute("fill"),"#8214FF","After match properties Bundle 2 is not in expected font colour");
    }

    public void checkMatchPropertiesWorkingOrNotAsExpectedWithBasicBundlePropertiesInCovering() throws InterruptedException, AWTException {
       userGetsTheCoveringListFromBundleProperties();
        String bundle1ID = FlowContext.bundleIdentifierList.get(0).getBundleId();
        String bundle2ID = FlowContext.bundleIdentifierList.get(1).getBundleId();
        String frameCommand ="bundlematchprop "+bundle1ID+" "+bundle2ID;
        inputCommand(frameCommand);
        Assert.assertTrue(rightBarContent.isDisplayed(),"Bundle match properties is not visible as expected");
        customCommand.javaScriptClick(driver,selectAllMatchProperties);
        customCommand.scrollIntoView(driver,buttonSubmitDetails);
        customCommand.javaScriptClick(driver,buttonSubmitDetails);
        inspectBundle();
        Object coverings = js.executeScript("return document.querySelector('#coverings > tbody').childElementCount");
        coveringsSize = Integer.parseInt(coverings.toString());
        Assert.assertEquals(coveringsSize,userGetsTheCoveringListFromBundleProperties(),"Bundle match properties covering size do not match as expected");
    }
     public void passCommandMatchProperties() throws InterruptedException {
         String bundle1ID = FlowContext.bundleIdentifierList.get(0).getBundleId();
         String bundle2ID = FlowContext.bundleIdentifierList.get(1).getBundleId();
         String frameCommand ="bundlematchprop "+bundle2ID+" "+bundle1ID;
         inputCommand(frameCommand);
         Assert.assertTrue(rightBarContent.isDisplayed(),"Bundle match properties is not visible as expected");
     }
}
