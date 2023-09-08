package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.PostMigrationPage;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class PostMigrationStepDefinitions {
    private final PostMigrationPage postMigrationPage;
    private final TestContext context;

    public PostMigrationStepDefinitions(TestContext context) throws IOException {
        this.context = context;
        postMigrationPage =  PageFactoryManager.getPostMigrationPage(context.driver);
    }

    @Then("Open all available projects and tasks in given instance")
    public void openAllAvailableProjectsAndTasksInGivenInstance() throws InterruptedException, IOException {
        postMigrationPage.openAllAvailableProjectsAndTasksInGivenInstance();
    }
}
