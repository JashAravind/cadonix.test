package arcadia.pages.ComponentDB;

import arcadia.pages.BasePage;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class CommonElements extends BasePage {
    public CommonElements(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "idaddrow") WebElement buttonAddRow;
    @FindBy(id = "loadDataDb") WebElement buttonLoadDataDB;
    @FindBy(css = "button[value=\"Update Component\"]") WebElement updateComponent;
    String buttonMoveUp = "button[title=\"Move Up\"]";
    String buttonMoveDown = "button[title=\"Move Down\"]";
    String buttonDelete = "button[title=\"Delete\"]";
    @FindBy(id = "btnReset") WebElement resetButton;

    @FindBy(css = "table input[name=\"btSelectItem\"]") private WebElement checkboxfirstComponent;

    @FindBy(css = "table button[title=\"Edit\"]>i.fa-edit") private WebElement buttonEditFirstComponent;
    @FindBy(css = "input[name=\"addsimilar.NewPN\"]") private WebElement referencesNewPartNumber;

    @FindBy(css = "button[value^=\"Add Similar\"][name=\"confirmadd\"]") private WebElement buttonConfirmAddSimilar;

    @FindBy(css = "div.fixed-table-header input[placeholder=\"Part Number\"]") private WebElement searchFieldPartNumber;

    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >button >.caret") private WebElement paginationDropdown;
    @FindBy(css = "#grid >.bootstrap-table >.fixed-table-container >.fixed-table-pagination >.pull-left.pagination-detail >.page-list >.btn-group.dropup >.dropdown-menu>li:last-child >a") private WebElement paginationAll;

    @FindBy(css = "div.fixed-table-header input[placeholder=\"Description\"]") private WebElement searchFieldDescription;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Family\"]") private WebElement searchFieldFamily;
    @FindBy(css = "div.fixed-table-header select[class$=\"groupname\"]") private WebElement selectGroupName;
    @FindBy(css = "div.fixed-table-header select[class$=\"status\"]") private WebElement selectStatus;
    @FindBy(css = "div.fixed-table-header select[class$=\"usage\"]") private WebElement selectUsage;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Supplier\"]") private WebElement searchFieldSupplier;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Supplier PN\"]") private WebElement searchFieldSupplierPN;
    @FindBy(css = "div.fixed-table-header select[class$=\"colour\"]") private WebElement selectColour;

    @FindBy(css = "div.fixed-table-header select[class$=\"gender\"]") private WebElement selectGender;

    @FindBy(css = "div.fixed-table-header select[class$=\"sealingtype\"]") private WebElement selectSealingType;

    @FindBy(css = "div.fixed-table-header select[class$=\"control-type\"]") private WebElement selectControlType;

    @FindBy(css = "div.fixed-table-header select[class$=\"cabletype\"]") private WebElement selectCableType;

    @FindBy(css = "div.fixed-table-header select[class$=\"applicatorusage\"]") private WebElement selectApplicatorUsage;

    @FindBy(css = "div.fixed-table-header select[class$=\"forsealorterminal\"]") private WebElement selectSealOrTerminal;

    @FindBy(css = "div.fixed-table-header select[class$=\"inservice\"]") private WebElement selectInService;

    @FindBy(css = "div.fixed-table-header select[class$=\"housingGender\"]") private WebElement selectHousingGender;

    @FindBy(css = "div.fixed-table-header select[class$=\"ttype\"]") private WebElement selectConnectorType;

    @FindBy(css = "div.fixed-table-header input[placeholder$=\"Type\"]") private WebElement searchFieldType;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"AWG Size\"]") private WebElement searchFieldAwgSize;
    @FindBy(css = "div.fixed-table-header input[placeholder='Insulation OD']") private WebElement searchFieldInsulationOD;
    @FindBy(css = "div.fixed-table-header input[placeholder='Cavity Plug']") private WebElement searchFieldCavity;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Gauge\"]") private WebElement searchFieldGauge;
    @FindBy(css = "div.fixed-table-header input[placeholder$=\"CSA\"]") private WebElement searchFieldCSA;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Outside Dia\"]") private WebElement searchFieldOutsideDia;
    @FindBy(css = "div.fixed-table-header input[placeholder$=\"Material\"]") private WebElement searchFieldMaterial;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Minimum Bend Radius\"]") private WebElement searchFieldMinimumBendRadius;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Max Current\"]") private WebElement searchFieldMaxCurrent;
    @FindBy(css = "div.fixed-table-header input[placeholder=\"Resistance\"]") private WebElement searchFieldResistance;

    @FindBy(css = "div.fixed-table-header input[placeholder$=\"No. of Wires\"]") private WebElement searchFieldNumberOfWires;

    @FindBy(css = "div.fixed-table-header input[placeholder$=\"Applicator Site\"]") private WebElement searchFieldApplicatorSite;

    @FindBy(css = "div.fixed-table-header input[placeholder$=\"No. of Cavities\"]") private WebElement searchFieldNumberOfCavities;

    @FindBy(css = "div.fixed-table-header input[placeholder$=\"Keyway\"]") private WebElement searchFieldKeyway;

    @FindBy(css = "input[rel=\"partnumber\"]+div input") private WebElement linkPartNumber;

    @FindBy(css = "#idMsg.alert-success") private WebElement alertSuccessMessage;
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    public void selectFirstComponent(){
        checkboxfirstComponent.click();
    }

    public void editFirstComponent(){
        buttonEditFirstComponent.click();
    }

    public void enterNewPartNumber(String newPartNumber){
        customCommand.waitForElementVisibility(driver,referencesNewPartNumber);
        customCommand.enterText(referencesNewPartNumber,newPartNumber);
    }

    public void enterLinkPartNumber(String partNumber) throws AWTException, InterruptedException {
        customCommand.waitForElementVisibility(driver,linkPartNumber);
        customCommand.simulateKeyEnterWithValue(linkPartNumber,partNumber);
        Thread.sleep(2000);
        customCommand.simulateKeyEnter();
    }

    public void clickAddSimilarOnPopup(){
        buttonConfirmAddSimilar.click();
    }

    public void getFullPagination() throws InterruptedException {
        Thread.sleep(3000);
        customCommand.scrollIntoView(driver,paginationDropdown);
        paginationDropdown.click();
        customCommand.waitForElementVisibility(driver,paginationAll);
        Thread.sleep(3000);
        paginationAll.click();
        Thread.sleep(3000);
    }

    public void viewAllFields() throws InterruptedException {
        driver.findElement(By.cssSelector("div[title=\"Columns\"]>button.dropdown-toggle")).click();
        Thread.sleep(2000);
        List<WebElement> allFieldsElements = driver.findElements(By.cssSelector("div.columns ul.dropdown-menu input"));
        Thread.sleep(5000);
        for(WebElement element : allFieldsElements){
            if(element.getAttribute("checked")==null){
                element.click();
            }
        }
    }

    public void filterComponentBasedOnPartNumber(String partNumber) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.waitForElementToBeClickable(driver,searchFieldPartNumber);
        customCommand.simulateKeyEnterWithValue(searchFieldPartNumber,partNumber);
        Thread.sleep(3000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnStatus(String status) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectStatus,status);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnDescription(String description) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldDescription,description);
        Thread.sleep(3000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnFamily(String family) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldFamily,family);
        Thread.sleep(3000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnUsage(String usage) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectUsage,usage);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnSupplier(String supplier) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldSupplier,supplier);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnSupplierPN(String supplierPN) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldSupplierPN,supplierPN);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnColour(String colour) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectColour,colour);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnCavity(String cavity) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldCavity,cavity);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnInsulationOD(String insulationOD) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldInsulationOD,insulationOD);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnAwgSize(String awgSize) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldAwgSize,awgSize);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnGauge(String gauge) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldGauge,gauge);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnCSARange(String csaRange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.scrollIntoView(driver,searchFieldCSA);
        customCommand.simulateKeyEnterWithValue(searchFieldCSA,csaRange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnOutsideDiaRange(String outsideDiaRange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldOutsideDia,outsideDiaRange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnMaterial(String material) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldMaterial,material);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnMinimumBendRadiusRange(String minimumBendRadiusRange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldMinimumBendRadius,minimumBendRadiusRange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnMaxCurrentRange(String maxCurrentRange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldMaxCurrent,maxCurrentRange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnResistanceRange(String resistanceRange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldResistance,resistanceRange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnGender(String gender) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectGender,gender.toLowerCase());
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnType(String type) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.simulateKeyEnterWithValue(searchFieldType,type);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnSealingType(String sealingType) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectSealingType,sealingType.toLowerCase());
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnControlType(String controlType) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectControlType,controlType.replace(" ","_"));
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnCableType(String cableType) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectCableType,cableType.toLowerCase());
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnNumberOfWiresRange(String wiresRange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.scrollIntoView(driver,searchFieldNumberOfWires);
        customCommand.simulateKeyEnterWithValue(searchFieldNumberOfWires,wiresRange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnApplicatorUsage(String applicatorusage) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectApplicatorUsage,applicatorusage);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnSealOrTerminal(String forsealorterminal) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectSealOrTerminal,forsealorterminal);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnInService(String inservice) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectInService,inservice.toLowerCase());
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnApplicatorSite(String applicatorSite) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.scrollIntoView(driver,searchFieldApplicatorSite);
        customCommand.simulateKeyEnterWithValue(searchFieldApplicatorSite,applicatorSite);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnNumberOfCavitiesRange(String cavitiesRange) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.scrollIntoView(driver,searchFieldNumberOfCavities);
        customCommand.simulateKeyEnterWithValue(searchFieldNumberOfCavities,cavitiesRange);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnHousingGender(String housingGender) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectHousingGender,housingGender.toLowerCase());
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }
    public void filterComponentBasedOnConnectorType(String connectorType) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.selectDropDownByValue(selectConnectorType,connectorType.toLowerCase());
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void filterComponentBasedOnKeyway(String keyway) throws InterruptedException {
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,paginationDropdown);
        customCommand.scrollIntoView(driver,searchFieldKeyway);
        customCommand.simulateKeyEnterWithValue(searchFieldKeyway,keyway);
        Thread.sleep(2000 );
        customCommand.waitForElementVisibility(driver,checkboxfirstComponent);
    }

    public void clickUpdateComponent(){
        updateComponent.click();
    }

    public void verifyAlertSuccessMessage(String message){
        customCommand.waitForElementVisibility(driver,alertSuccessMessage);
        alertSuccessMessage.getText().equals(message);
    }

}
