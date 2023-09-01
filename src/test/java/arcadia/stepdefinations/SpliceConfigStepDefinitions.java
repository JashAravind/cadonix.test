package arcadia.stepdefinations;

import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.datasources.ComponentDataJDBC;
import arcadia.domainobjects.AddComponentForm;
import arcadia.domainobjects.AdditionalReferences;
import arcadia.domainobjects.BomDetails;
import arcadia.domainobjects.ComponentDetails;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.HeaderPanel;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.SpliceConfigPage;
import arcadia.utils.StringHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpliceConfigStepDefinitions {
    private final TestContext context;
    private final SpliceConfigPage spliceConfigPage;
    String splicePartNumber = "spliceConfigAutomationTestUltra";
    public SpliceConfigStepDefinitions(TestContext context){
        this.context = context;
        spliceConfigPage = PageFactoryManager.getSpliceConfig(context.driver);
    }

    @And("add new splice configuration in profile")
    public void addNewSpliceConfigurationInProfile() throws InterruptedException, AWTException {
        spliceConfigPage.addNewSpliceConfigurationInProfile();
    }
    @Then("{string} component with billtype {string} is created")
    public void component_with_billtype_is_created_successfully(String componentName, String componentBomBillType) throws InterruptedException, SQLException, ClassNotFoundException {
        AddComponentForm addComponentForm = null;
        ComponentDetails componentDetails = null;
        List<AdditionalReferences> additionalReferencesList = null;
        AdditionalReferences additionalReferences1 = null;
        BomDetails bomDetails = null;
        String csvQuery = "";
        String csvDirectoryPath = "src/test/resources/componentDB/TestData";
        new HeaderPanel(context.driver).openAddNewComponentPage();


        //Adding component details
        csvQuery = "Select * from ComponentDetails where componentName='" + componentName.toLowerCase() + "'";
        addComponentForm = new AddComponentForm();
        componentDetails = new ComponentDataJDBC().getComponentDetails(csvDirectoryPath, csvQuery);
        componentDetails.setDescription(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()));
        addComponentForm.setComponentDetails(componentDetails);

        //Adding additional references details
        csvQuery = "Select * from AdditionalReferencesDetails where componentName='" + componentName.toLowerCase() + "'";
        additionalReferences1 = new ComponentDataJDBC().getAdditionalReferenceDetails(csvDirectoryPath, csvQuery);
        additionalReferencesList = new ArrayList<>();
        additionalReferences1.setReferencesPartNumber(splicePartNumber);
        additionalReferencesList.add(additionalReferences1);
        addComponentForm.setAdditionalReferences(additionalReferencesList);

        //Adding bom details
        csvQuery = "Select * from BomDetails where componentName='" + componentName.toLowerCase() + "'";
        bomDetails = new ComponentDataJDBC().getBomDetails(csvDirectoryPath, csvQuery);
        bomDetails.setBomBillType(componentBomBillType);
        addComponentForm.setBomDetails(bomDetails);
        new AddNewComponentPage(context.driver).createComponent(addComponentForm, componentName);
        new AddNewComponentPage(context.driver).submitComponentDetails();
        Thread.sleep(1000);
    }


    @And("add splice details to created splice")
    public void addSpliceDetailsToCreatedSplice() throws InterruptedException, AWTException {
        spliceConfigPage.addSpliceDetailsToCreatedSplice();
    }

    @Then("verify able to modify material and gauge")
    public void verifyAbleToModifyMaterialAndGauge() throws AWTException, InterruptedException {
        spliceConfigPage.modifyGaugeEditor();
    }

    @Then("verify splice configuration of Aside and Bside is calculated as per the gauge editor csa")
    public void verifySpliceConfigurationOfAsideAndBsideIsCalculatedAsPerTheGaugeEditorCsa() {
        spliceConfigPage.verifySpliceConfigurationOfAsideAndBsideIsCalculatedAsPerTheGaugeEditorCsa();
    }

    @And("splice,heatshrink from context menu options")
    public void spliceHeatshrinkFromContextMenuOptions() throws InterruptedException {
        spliceConfigPage.spliceHeatShrinkFromContextMenuOptions();
    }

    @Then("verify able to view update splice,heatshrink configuration popup")
    public void verifyAbleToViewUpdateSpliceHeatshrinkConfigurationPopup() {
        spliceConfigPage.verifyAbleToViewUpdateSpliceHeatshrinkConfigurationPopup();
    }

    @Then("verify able to throw error {string}")
    public void verifyErrorMessage(String errorMessage) throws InterruptedException {
        spliceConfigPage.verifyErrorMessage(errorMessage);
    }
}
