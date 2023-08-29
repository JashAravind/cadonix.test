package arcadia.stepdefinations;

import arcadia.context.TestContext;
import arcadia.domainobjects.NodeIdentifier;
import arcadia.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.awt.*;
import java.util.List;

public class BundleOpsStepDefinitions {
    private final TestContext context;
    private final BundleOpsPage bundleOpsPage;
    private final BundlePage bundlePage;

    public BundleOpsStepDefinitions(TestContext context) {
        this.context = context;
        bundleOpsPage = PageFactoryManager.getBundleOpsPage(context.driver);
        bundlePage = PageFactoryManager.getBundlePage(context.driver);;
    }

    @And("user tries to draw bundle using command {string} through command line in harness")
    public void userTriesToDrawBundleUsingCommandThroughCommandLineInHarness(String command) throws InterruptedException {
        bundleOpsPage.inputCommand(command);
    }

    @And("user add bend using command {string} through command line in harness")
    public void userAddBendUsingCommandThroughCommandLineInHarness(String command) throws InterruptedException {
        bundleOpsPage.userAddBendUsingCommandThroughCommandLineInHarness(command);
    }
    @Then("check able to move one end of bundle to bend or not")
    public void checkAbleToMoveOneEndOfBundleToBendOrNot() throws InterruptedException {
        bundleOpsPage.checkAbleToMoveOneEndOfBundleToBendOrNot();
    }

    @And("user tries to place node on bundle")
    public void userTriesToPlaceNodeOnBundle() throws InterruptedException {
        bundleOpsPage.userTriesToPlaceNodeOnBundle();
    }

    @Then("check able to rejoin the bundle or not")
    public void checkAbleToRejoinTheBundleOrNot() throws InterruptedException {
        bundleOpsPage.checkAbleToRejoinTheBundleOrNot();
    }

    @Then("check able to remove bend or not")
    public void checkAbleToRemoveBendOrNot() throws InterruptedException {
        bundleOpsPage.checkAbleToRemoveBendOrNot();
    }
    @And("user set all radius")
    public void setAllRadius() throws InterruptedException, AWTException {
        Thread.sleep(5000);
        bundlePage.getBundlePage("","");
        bundleOpsPage.setAllRadius();
    }
    public void inspectBundle() throws InterruptedException {
        List<NodeIdentifier> nodeIdentifierList = bundlePage.getNodeElementFromDrawingPage();
        new HarnessPage(context.driver).getBundleContextMenu(nodeIdentifierList.get(0).getNodeElementId());
    }


    @Then("Check bend radius in bundle")
    public void checkBendRadiusInBundle() {
        bundleOpsPage.checkBendRadiusInBundle();
    }

    @And("user try to remove all bends in the drawing")
    public void userTryToRemoveAllBendsInTheDrawing() throws InterruptedException {
        bundleOpsPage.userTryToRemoveAllBendsInTheDrawing();
    }

    @Then("check able to remove all bends or not")
    public void checkAbleToRemoveAllBendsOrNot() {
        bundleOpsPage.checkAbleToRemoveAllBendsOrNot();
    }

    @And("bundle break is placed on bundle")
    public void bundleBreakIsPlacedOnBundle() throws InterruptedException {
        bundleOpsPage.bundleBreakIsPlacedOnBundle();
    }

    @Then("check bundle is broken or not")
    public void checkBundleIsBrokenOrNot() {
        bundleOpsPage.checkBundleIsBrokenOrNot();
    }

    @And("user try to rejoin the bundle break")
    public void userTryToRejoinTheBundleBreak() throws InterruptedException {
        bundleOpsPage.userTryToRejoinTheBundleBreak();
    }

    @Then("check bundle break is deleted or not")
    public void checkBundleBreakIsDeletedOrNot() throws InterruptedException {
        bundleOpsPage.checkBundleBreakIsDeletedOrNot();
    }

    @And("user tries to join two bundles with bundlebreak")
    public void userTriesToJoinTwoBundlesWithBundleBreak() throws InterruptedException {
        bundleOpsPage.userTriesToJoinTwoBundlesWithBundleBreak();
    }

    @Then("check bundle can be joined two bundles with bundlebreak")
    public void checkBundleCanBeJoinedTwoBundlesWithBundleBreak() throws InterruptedException {
        bundleOpsPage.checkBundleCanBeJoinedTwoBundlesWithBundleBreak();
    }

    @And("user tries to calculate the dimension through chain dimension")
    public void userTriesToCalculateTheDimensionThroughChainDimension() throws InterruptedException {
          bundleOpsPage.userTriesToCalculateTheDimensionThroughChainDimension();
    }

    @Then("verify chain dimension is calculated as expected to the bundle or not")
    public void verifyChainDimensionIsCalculatedAsExpectedToTheBundleOrNot() {
        bundleOpsPage.verifyChainDimensionIsCalculatedAsExpectedToTheBundleOrNot();
    }

    @And("user tries to calculate dimension between two bundles")
    public void userTriesToCalculateDimensionBetweenTwoBundles() throws InterruptedException {
        bundleOpsPage.userTriesToCalculateDimensionBetweenTwoBundles();
    }

    @Then("verify chain dimension is calculated between two bundle or not")
    public void verifyChainDimensionIsCalculatedBetweenTwoBundleOrNot() {
        bundleOpsPage.verifyChainDimensionIsCalculatedBetweenTwoBundleOrNot();
    }

    @And("user tries to set length not to scale")
    public void userTriesToSetLengthNotToScale() throws InterruptedException, AWTException {
        bundlePage.getBundlePage("","");
        bundleOpsPage.userTriesToSetLengthNotToScale();
    }

    @Then("check able to scale or not")
    public void checkAbleToScaleOrNot() throws InterruptedException {
        bundleOpsPage.checkToScale();
    }

    @Then("check whether set length value is updated or not as NTS")
    public void checkWhetherSetLengthValueIsUpdatedOrNotAsNTS() {
        bundleOpsPage.checkWhetherSetLengthValueIsUpdatedOrNotAsNTS();
    }

    @Then("verify bundle is in as expected or not")
    public void verifyBundleIsInAsExpectedOrNot() throws InterruptedException, AWTException {
        bundleOpsPage.verifyBundleIsInAsExpectedOrNot();
    }

    @Then("verify bundle covering partnumber is in as expected or not in bundle content or not")
    public void verifyBundleCoveringPartNumberIsInAsExpectedOrNotInBundleContentOrNot() throws InterruptedException, AWTException {
        bundleOpsPage.verifyBundleCoveringPartNumberIsInAsExpectedOrNotInBundleContentOrNot();
    }


    @And("user gets the covering list from bundle properties;")
    public void userGetsTheCoveringListFromBundleProperties() throws InterruptedException, AWTException {
        bundleOpsPage.userGetsTheCoveringListFromBundleProperties();
    }

    @Then("verify by clicking wire that wires is highlighted in cavity table or not")
    public void verifyByClickingWireThatWiresIsHighlightedInCavityTableOrNot() throws InterruptedException, AWTException {
        bundleOpsPage.verifyByClickingWireThatWiresIsHighlightedInCavityTableOrNot();
    }

    @Then("check match properties working or not as expected with basic bundle properties")
    public void checkMatchPropertiesWorkingOrNotAsExpectedWithBasicBundleProperties() throws InterruptedException {
        bundleOpsPage.checkMatchPropertiesWorkingOrNotAsExpectedWithBasicBundleProperties();
    }

    @Then("check match properties working or not as expected with basic bundle properties in covering")
    public void checkMatchPropertiesWorkingOrNotAsExpectedWithBasicBundlePropertiesInCovering() throws InterruptedException, AWTException {
        bundleOpsPage.checkMatchPropertiesWorkingOrNotAsExpectedWithBasicBundlePropertiesInCovering();
    }

    @Then("Reset to defaults")
    public void resetToDefaults() throws InterruptedException {
        bundleOpsPage.resetToDefaults();
    }
}
