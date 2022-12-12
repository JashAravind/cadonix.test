package arcadia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPanel extends BasePage{
    public HeaderPanel(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button[value=\"Add New Component\"]") private WebElement addNewComponent;
    @FindBy(id = "btnImport") private WebElement importCsv;
    @FindBy(id = "idexport") private WebElement exportCsv;
    @FindBy(id = "dataexport") private WebElement exportData;
    @FindBy(id = "customExport") private WebElement exportCustomFields;
    @FindBy(id = "btnaddsimilar") private WebElement addSimilar;
    @FindBy(id = "btnmove") private WebElement btnCopy;
    @FindBy(id = "btnDelete") private WebElement btnDelete;
    @FindBy(css = "select[name=\"company\"]") private WebElement selectBoxCompany;
}
