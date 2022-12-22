package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.domainobjects.*;
import arcadia.pages.ComponentDB.AddNewComponentPage;
import arcadia.pages.ComponentDB.HeaderPanel;
import arcadia.pages.ComponentDB.Wires.WiresComponentDBPage;
import arcadia.utils.StringHelper;
import io.cucumber.java.en.Then;
import org.apache.commons.collections.ListUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComponentDBStepDefinitions {
    private final TestContext context;
    public ComponentDBStepDefinitions(TestContext context) {
        this.context = context;
    }

    @Then("{string} component with status {string} is created successfully")
    public void component_with_status_is_created_successfully(String componentName, String componentStatus) throws InterruptedException {
        switch(componentName.toLowerCase()) {
            case "wire":
                new HeaderPanel(context.driver).openAddNewComponentPage();
                AddComponentForm addComponentForm = new AddComponentForm();
                ComponentDetails componentDetails = new ComponentDetails(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()),"testfamily",componentStatus,"","testproprietary","","BLACK","BLUE","BROWN","PVC","NOT SET","");
                addComponentForm.setComponentDetails(componentDetails);
                List<AdditionalReferences> additionalReferencesList = new ArrayList<>();
                AdditionalReferences additionalReferences1 = new AdditionalReferences(String.valueOf(new StringHelper().generateRandomDigit()),"Manufacturer","testcompany");
                additionalReferencesList.add(additionalReferences1);
                addComponentForm.setAdditionalReferences(additionalReferencesList);
                BomDetails bomDetails = new BomDetails(0.0022,"","EACH","GBP","gm","INCLUDED");
                addComponentForm.setBomDetails(bomDetails);
                new AddNewComponentPage(context.driver).createComponent(addComponentForm);
                new AddNewComponentPage(context.driver).submitComponentDetails();
                Thread.sleep(1000);
                break;
        }
    }

    @Then("{string} component with billtype {string} is created successfully")
    public void component_with_billtype_is_created_successfully(String componentName, String componentBomBillType) throws InterruptedException {
        switch(componentName.toLowerCase()) {
            case "wire":
                new HeaderPanel(context.driver).openAddNewComponentPage();
                AddComponentForm addComponentForm = new AddComponentForm();
                ComponentDetails componentDetails = new ComponentDetails(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()),"testfamily","IN REVIEW","","testproprietary","","BLACK","BLUE","BROWN","PVC","NOT SET","");
                addComponentForm.setComponentDetails(componentDetails);
                List<AdditionalReferences> additionalReferencesList = new ArrayList<>();
                AdditionalReferences additionalReferences1 = new AdditionalReferences(String.valueOf(new StringHelper().generateRandomDigit()),"Manufacturer","testcompany");
                additionalReferencesList.add(additionalReferences1);
                addComponentForm.setAdditionalReferences(additionalReferencesList);
                BomDetails bomDetails = new BomDetails(0.0022,"","EACH","GBP","gm",componentBomBillType);
                addComponentForm.setBomDetails(bomDetails);
                new AddNewComponentPage(context.driver).createComponent(addComponentForm);
                new AddNewComponentPage(context.driver).submitComponentDetails();
                Thread.sleep(1000);
                break;
        }
    }

    @Then("{string} component with referencepartnumber {string} and referencecompany {string} only is created")
    public void component_with_reference_details_is_created(String componentName, String partNumber, String referencecompany) throws InterruptedException {
        switch(componentName.toLowerCase()) {
            case "wire":
                new HeaderPanel(context.driver).openAddNewComponentPage();
                AddComponentForm addComponentForm = new AddComponentForm();
                if(!String.valueOf(partNumber).isEmpty()){
                    partNumber = String.valueOf(new StringHelper().generateRandomDigit());
                }
                List<AdditionalReferences> additionalReferencesList = new ArrayList<>();
                AdditionalReferences additionalReferences1 = new AdditionalReferences(partNumber,"",referencecompany);
                additionalReferencesList.add(additionalReferences1);
                addComponentForm.setAdditionalReferences(additionalReferencesList);
                new AddNewComponentPage(context.driver).createComponentWithMandatoryDetailsOnly(addComponentForm);
                new AddNewComponentPage(context.driver).submitComponentDetails();
                Thread.sleep(1000);
                break;
        }
    }

    @Then("Verify error message is displayed for mandatory field {string} for component {string}")
    public void error_message_is_displayed_for_mandatory_field(String fieldName, String componentName) throws InterruptedException {
        //ToDo the error messages needs to be moved to a separate file
        String errorMessage="";
        switch(fieldName.toLowerCase()) {
            case "referencepartnumber":
                errorMessage = "Enter Part Number";
                break;
            case "referencecompany":
                errorMessage = "Enter Company";
                break;
        }
        new AddNewComponentPage(context.driver).verifyErrorMessage(errorMessage);
        new AddNewComponentPage(context.driver).closeErrorPopUp();
    }

    @Then("{string} component with additionalreferencetype {string} is created successfully")
    public void component_with_additionalreferencetype_is_created_successfully(String componentName, String additionalRefernceType) throws InterruptedException {
        switch(componentName.toLowerCase()) {
            case "wire":
                new HeaderPanel(context.driver).openAddNewComponentPage();
                AddComponentForm addComponentForm = new AddComponentForm();
                ComponentDetails componentDetails = new ComponentDetails(String.format("testdescription-%04d", new StringHelper().generateRandomDigit()),"testfamily","IN REVIEW","","testproprietary","","BLACK","BLUE","BROWN","PVC","NOT SET","");
                addComponentForm.setComponentDetails(componentDetails);
                BomDetails bomDetails = new BomDetails(0.0022,"","EACH","GBP","gm","INCLUDED");
                addComponentForm.setBomDetails(bomDetails);
                List<AdditionalReferences> additionalReferencesList = new ArrayList<>();
                String[] arrayOfRefrenceType = additionalRefernceType.split(",");
                for(String refType: arrayOfRefrenceType){
                    AdditionalReferences additionalReferences = new AdditionalReferences(String.valueOf(new StringHelper().generateRandomDigit()),refType,"testcompany");
                    additionalReferencesList.add(additionalReferences);
                }
                addComponentForm.setAdditionalReferences(additionalReferencesList);
                new AddNewComponentPage(context.driver).createComponent(addComponentForm);
                new AddNewComponentPage(context.driver).submitComponentDetails();
                Thread.sleep(1000);
                break;
        }
    }

    @Then("Verify component data on the basis of filter {string} with value {string}")
    public void verify_component_data_on_the_basis_of_filter(String filterName, String filterValue) throws InterruptedException {
        new WiresComponentDBPage(context.driver).getFullPagination();
        List<WiresComponentDB> dbData = new WiresComponentDBPage(context.driver).getWiresData();
        switch(filterName.toLowerCase()) {
            case "status":
                new WiresComponentDBPage(context.driver).filterWiresBasedOnStatus(filterValue);
                break;
            case "partnumber":
                new WiresComponentDBPage(context.driver).filterWiresBasedOnPartNumber(filterValue);
                break;
            case "description":
                new WiresComponentDBPage(context.driver).filterWiresBasedOnDescription(filterValue);
                break;
            case "family":
                new WiresComponentDBPage(context.driver).filterWiresBasedOnFamily(filterValue);
                break;
            case "usage":
                new WiresComponentDBPage(context.driver).filterWiresBasedOnUsage(filterValue);
                break;
            case "supplier":
                new WiresComponentDBPage(context.driver).filterWiresBasedOnSupplier(filterValue);
                break;
            case "supplierpn":
                new WiresComponentDBPage(context.driver).filterWiresBasedOnSupplierPN(filterValue);
                break;
            case "colour":
                new WiresComponentDBPage(context.driver).filterWiresBasedOnColour(filterValue);
                break;
        }
        List<WiresComponentDB> wiresData = new WiresComponentDBPage(context.driver).getWiresData();
        Assert.assertTrue(ListUtils.subtract(dbData.stream().filter(x->x.getStatus().equals(filterValue)).collect(Collectors.toList()),wiresData.stream().toList()).size()==0);
    }

}
