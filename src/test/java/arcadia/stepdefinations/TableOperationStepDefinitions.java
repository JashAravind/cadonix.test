package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.TableOperationPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.FindBy;

@FindBy(css="#layer_52 > g > g > foreignObject > table > thead > tr > th:nth-child(1)")
public class TableOperationStepDefinitions {
    private final TestContext context;
    private final TableOperationPage tableOperationsPage;

    public TableOperationStepDefinitions(TestContext context){
        this.context = context;
        tableOperationsPage = PageFactoryManager.getTableOperationPage(context.driver);
    }

    @And("place bom table in drawing")
    public void placeBomTableInDrawing() throws InterruptedException {
        tableOperationsPage.placeBomTableInDrawing();
    }
}
