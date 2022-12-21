package arcadia.stepdefinations;

import arcadia.constants.EndPoint;
import arcadia.context.FlowContext;
import arcadia.context.TestContext;
import arcadia.mapperObjects.DrawingInstructor;
import arcadia.pages.*;
import arcadia.pages.ComponentDB.HeaderPanel;
import arcadia.utils.DrawingHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinitions {
    private final LoginPage loginPage;
    private final TestContext context;
    public LoginStepDefinitions(TestContext context){
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }
    @Given("I'm on Arcadia test environment")
    public void i_m_on_arcadia_test_environment() throws IOException, InterruptedException {
        loginPage.load(EndPoint.TRAINING.url);
        loginPage.Login();
        Thread.sleep(1000);
    }
    @Given("test data config loaded for test identifier {word}")
    public void test_data_config_loaded_for_test_identifier(String string) throws IOException, InterruptedException {
        Thread.sleep(1000);
        context.testIdentifier = string;
    }

    @Given("Navigated to selected componentDB")
    public void navigated_to_selected_component_db() {
        String selectedComponentDB = System.getProperty("componentDB");
        System.out.println("selectedComponentDB "+ selectedComponentDB);
        String endpoint = EndPoint.COMPONENTDB.url.replace("componentDB",selectedComponentDB);
        loginPage.load(endpoint);

    }

    @And("Navigated to quickstart project")
    public void navigateToProjectQuickStart(){
        loginPage.load(EndPoint.PROJECT.url);
    }
    @And( "Navigated to Test Project")
    public void navigateToTestProject() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.load(EndPoint.TEST.url);
        Thread.sleep(1000);
        new DefineBundleTolerance(context.driver).CaptureBundleTollerance();

    }

    @And("Navigating to Company profile page")
    public void navigateToSettings() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.load(EndPoint.SETTINGS.url);
        Thread.sleep(1000);
        loginPage.load(EndPoint.AutomationCompanyProfile.url);
        Thread.sleep(1000);
        loginPage.load(EndPoint.BUNDLEDEFAULTDISPLAY.url);
        Thread.sleep(1000);
       new DefineBundleTolerance(context.driver).CaptureModifyBundleTollerance();
        Thread.sleep(1000);

    }

    @Given("User selected {string} from componentDB")
    public void user_selected_from_component_db(String menuName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new HeaderPanel(context.driver).invokeMainMenu(menuName);
    }

    @And("Harness bundle default values are captured")
    public void captureHarnessBundleDefaults(){
        loginPage.load(EndPoint.HARNESSBUNDLEDISPLAY.url);
        new HarnessBundleDisplayPage(context.driver).captureDefaultHarnessBundleValues();
        System.out.println(FlowContext.defaultBundleDisplay.get(0).getCoveringTypes());
        System.out.println(FlowContext.defaultBundleDisplay.get(0).getDiameterAddon());
        System.out.println(FlowContext.defaultBundleDisplay.get(0).getDiameterScales());
    }

    @Given("based on drawing orchestrator components are created")
    public void based_on_drawing_orchestrator_components_are_created() throws IOException, InterruptedException, AWTException {
        List<DrawingInstructor> drawingInstructorList =  new DrawingHelper().getDrawingInstruction(context.testIdentifier);
        new DrawingHelper().drawOrchestrator(drawingInstructorList,context.driver);

    }


}
