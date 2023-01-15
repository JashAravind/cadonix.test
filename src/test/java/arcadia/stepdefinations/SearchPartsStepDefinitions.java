package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.domainobjects.ConnectorDB;
import arcadia.domainobjects.WiresComponentDB;
import arcadia.mapperObjects.SearchParts;
import arcadia.mapperObjects.TestMapper;
import arcadia.pages.BundlePage;
import arcadia.pages.ComponentDB.Connectors.ConnectorsDBPage;
import arcadia.pages.ComponentDB.Wires.WiresComponentDBPage;
import arcadia.pages.HarnessPage;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.SearchPartsDatabasePage;
import arcadia.utils.ConversionUtil;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPartsStepDefinitions {
    private final BundlePage bundlePage;
    private  HarnessPage harnessPage;
    private final SearchPartsDatabasePage searchPartsDatabasePage;
    private final TestContext context;
    ConversionUtil conversionUtil = new ConversionUtil();
    public SearchPartsStepDefinitions(TestContext context){
        this.context = context;
        bundlePage = PageFactoryManager.getBundlePage(context.driver);
        harnessPage = PageFactoryManager.getDrawingPage(context.driver);
        searchPartsDatabasePage = PageFactoryManager.getPartsDatabasePage(context.driver);
    }

    @Given("Search parts populated")
    public void search_parts_populated() throws IOException, InterruptedException {
        Thread.sleep(2000);
        TestMapper mapper = conversionUtil.getTestMapperConfig(context.testIdentifier);
        SearchParts searchParts = mapper.getSearchParts();
        ExtentCucumberAdapter.addTestStepLog(String.format("Search keyword %s %s", searchParts.getDescription(),searchParts.getCavityNumber()));
        searchPartsDatabasePage.findInSearchPartDatabase(searchParts.getDescription(),searchParts.getCavityNumber());
        Thread.sleep(2000);
        searchPartsDatabasePage.populateParts();
    }

    @Then("Verify user can filter {string} using {string}")
    public void userFiltersConnectorOnCreateBundle(String component, String filtertype) throws InterruptedException, AWTException, IOException {
        File file = new File("src/test/resources/componentDB/Connector/ConnectorData.json");
        List<ConnectorDB> dbData = null;
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), new TypeReference<List<ConnectorDB>>() {
            });
        }
        if (!file.exists()) {
            dbData = new ConnectorsDBPage(context.driver).getConnectorsData();
            ObjectMapper mapper = new ObjectMapper();
            Files.createDirectories(Paths.get("src/test/resources/componentDB/Connector"));
            mapper.writeValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), dbData);
        }
        ConnectorDB randomConnectorData = new ConnectorsDBPage(context.driver).getRandomConnectorComponent(dbData);
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectSearchDB(System.getProperty("componentDB"));
        searchPartsDatabasePage.selectComponentType(component);
        switch (filtertype.toLowerCase()){
            case "partnumber":
                filteredDbData = dbData.stream().filter(x -> x.getPartNumber().equals(randomConnectorData.getPartNumber())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingPartNumber(randomConnectorData.getPartNumber());
                break;
            case "cavity":
                filteredDbData = dbData.stream().filter(x -> x.getNumberOfCavities().equals(randomConnectorData.getNumberOfCavities())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingCavity(randomConnectorData.getNumberOfCavities());
                break;
            case "family":
                filteredDbData = dbData.stream().filter(x -> x.getFamily().equals(randomConnectorData.getFamily())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingFamily(randomConnectorData.getFamily());
                break;
            case "supplier":
                filteredDbData = dbData.stream().filter(x -> x.getSupplier().equals(randomConnectorData.getSupplier())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingSupplier(randomConnectorData.getSupplier());
                break;
            case "housinggender":
                filteredDbData = dbData.stream().filter(x -> x.getHousingGender().equals(randomConnectorData.getHousingGender())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingHousingGender(randomConnectorData.getHousingGender());
                break;
            case "terminalgender":
                filteredDbData = dbData.stream().filter(x -> x.getTerminalGender().equals(randomConnectorData.getTerminalGender())).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingTerminalGender(randomConnectorData.getTerminalGender());
                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchPartsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
        List<String> differenceFromExpectedPartNumberList = expectedPartNumberList.stream()
                .filter(element -> !actualUniquePartList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPartNumberList.toString()));
        }
        List<String> differenceFromActualPartNumberList = actualUniquePartList.stream()
                .filter(element -> !expectedPartNumberList.contains(element))
                .collect(Collectors.toList());
        Assert.assertEquals(actualUniquePartList.size(),expectedPartNumberList.size());
    }

    @Then("Verify user can filter {string} using {string} with value {string}")
    public void verifyUserCanFilterConnectorUsingFilterAndValue(String component, String filtertype, String filterValue) throws IOException, InterruptedException, AWTException {
        File f = new File("src/test/resources/componentDB/Connector/ConnectorData.json");
        List<ConnectorDB> dbData = null;
        System.out.println("Resuse JSON");
        ObjectMapper mapper = new ObjectMapper();
        dbData = mapper.readValue(new File("src/test/resources/componentDB/Connector/ConnectorData.json"), new TypeReference<List<ConnectorDB>>() {
        });
        List<ConnectorDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectSearchDB(System.getProperty("componentDB"));
        searchPartsDatabasePage.selectComponentType(component);
        switch (filtertype.toLowerCase()){
            case "housinggender":
                filteredDbData = dbData.stream().filter(x -> x.getHousingGender().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingHousingGender(filterValue);
                break;
            case "terminalgender":
                filteredDbData = dbData.stream().filter(x -> x.getTerminalGender().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingTerminalGender(filterValue);
                break;
            case "type":
                filteredDbData = dbData.stream().filter(x -> x.getConnectorType().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingType(filterValue);
                break;
            case "colour":
                filteredDbData = dbData.stream().filter(x -> x.getColour().equals(filterValue)).collect(Collectors.toList());
                searchPartsDatabasePage.searchPartUsingColour(filterValue);
                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchPartsData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
        List<String> differenceFromExpectedPartNumberList = expectedPartNumberList.stream()
                .filter(element -> !actualUniquePartList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPartNumberList.toString()));
        }
        List<String> differenceFromActualPartNumberList = actualUniquePartList.stream()
                .filter(element -> !expectedPartNumberList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromActualPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with actual %s", differenceFromActualPartNumberList.toString()));
        }
        Assert.assertEquals(actualUniquePartList.size(),expectedPartNumberList.size());
    }

    @And("User closes the searchparts window")
    public void userClosesTheSearchpartsWindow() throws InterruptedException {
        searchPartsDatabasePage.closeSearchPartsWindow();
    }

    @Then("Verify user filters {string} using {string} successfully")
    public void verifyUserFiltersWire(String wireType, String filterName) throws IOException, InterruptedException, AWTException {
        File file = new File("src/test/resources/componentDB/Wire/WireData.json");
        List<WiresComponentDB> dbData = null;
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            dbData = mapper.readValue(new File("src/test/resources/componentDB/Wire/WireData.json"), new TypeReference<List<WiresComponentDB>>() {
            });
        }
        WiresComponentDB randomWiresData = new WiresComponentDBPage(context.driver).getRandomWireComponent(dbData);
        List<WiresComponentDB> filteredDbData = new ArrayList<>();
        searchPartsDatabasePage.selectWireType(wireType);
        switch (filterName.toLowerCase()) {
            case "partnumber":
                filteredDbData = dbData.stream().filter(x -> x.getPartNumber().equals(randomWiresData.getPartNumber())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireUsingPartNumber(randomWiresData.getPartNumber());
                break;
            case "material":
                filteredDbData = dbData.stream().filter(x -> x.getMaterial().equals(randomWiresData.getMaterial())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireUsingMaterial(randomWiresData.getMaterial());
                break;
            case "gauge":
                filteredDbData = dbData.stream().filter(x -> x.getGauge().equals(randomWiresData.getGauge())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireUsingGauge(randomWiresData.getGauge());
                break;
            case "csa":
                filteredDbData = dbData.stream().filter(x -> x.getWireCSA().equals(randomWiresData.getWireCSA())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireUsingCSA(String.valueOf(randomWiresData.getWireCSA()));
                break;
            case "outerdia":
                filteredDbData = dbData.stream().filter(x -> x.getOutsideDia().equals(randomWiresData.getOutsideDia())).collect(Collectors.toList());
                searchPartsDatabasePage.searchWireUsingOuterDia(String.valueOf(randomWiresData.getOutsideDia()));
                break;
        }
        List<String> actualUniquePartList = searchPartsDatabasePage.getSearchWiresData();
        List<String> expectedPartNumberList = filteredDbData.stream().map(x -> x.getPartNumber()).collect(Collectors.toList());
        List<String> differenceFromExpectedPartNumberList = expectedPartNumberList.stream()
                .filter(element -> !actualUniquePartList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromExpectedPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with expected %s", differenceFromExpectedPartNumberList.toString()));
        }
        List<String> differenceFromActualPartNumberList = actualUniquePartList.stream()
                .filter(element -> !expectedPartNumberList.contains(element))
                .collect(Collectors.toList());
        if(differenceFromActualPartNumberList.size()>0){
            ExtentCucumberAdapter.addTestStepLog(String.format("Differences with actual %s", differenceFromActualPartNumberList.toString()));
        }
        Assert.assertEquals(actualUniquePartList.size(),expectedPartNumberList.size());
    }
}
