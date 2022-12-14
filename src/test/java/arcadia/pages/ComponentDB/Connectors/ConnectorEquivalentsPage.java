package arcadia.pages.ComponentDB.Connectors;

import arcadia.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConnectorEquivalentsPage extends BasePage {
    public ConnectorEquivalentsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "table#Equivalents_termsused") private WebElement tableEquivalentHalves;
    String equivalentHalvesPartNumber = "input[rel=\"partnumber\"]+div input";
    String equivalentDescription = "input[rel=\"Desc\"]";
    String equivalentColour = "input[rel=\"Colour\"]";
    String equivalentHousingGender = "input[rel=\"housingGender\"]";
    String equivalentTerminalGender = "input[rel=\"TermGender\"]";
    String equivalentCavities = "input[rel=\"Cavities\"]";
}
