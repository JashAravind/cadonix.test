package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.pages.PageFactoryManager;
import arcadia.pages.PostMigrationPage;
import io.cucumber.java.en.Then;

public class PostMigrationStepDefinitions {
    private final PostMigrationPage postMigrationPage;
    private final TestContext context;

    public PostMigrationStepDefinitions(TestContext context) {
        this.context = context;
        postMigrationPage =  PageFactoryManager.getPostMigrationPage(context.driver);
    }

    @Then("Open all available projects and tasks in given instance")
    public void openAllAvailableProjectsAndTasksInGivenInstance() throws InterruptedException {
        postMigrationPage.openAllAvailableProjectsAndTasksInGivenInstance();
    }
}
