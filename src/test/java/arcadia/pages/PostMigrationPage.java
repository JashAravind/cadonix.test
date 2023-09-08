package arcadia.pages;

import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.*;
import org.python.modules._bytecodetools;

import java.util.ArrayList;
import java.util.List;


public class PostMigrationPage extends BasePage  {
    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    HarnessPage harnessPage =new HarnessPage(driver);
    public PostMigrationPage(WebDriver driver) {
        super(driver);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    int availableProjectCount;

    public void openAllAvailableProjectsAndTasksInGivenInstance() throws InterruptedException {
        Object countOfProject = js.executeScript("return document.querySelector('#example-tables > div.tabulator-tableholder > div').childElementCount");
        availableProjectCount = Integer.parseInt(countOfProject.toString());
        System.out.println("Available Projects: "+availableProjectCount);
        for(int i=1;i<=availableProjectCount;i++)
        {
            WebElement project = driver.findElement(By.cssSelector("#example-tables > div.tabulator-tableholder > div > div:nth-child("+i+") > div:nth-child(2)"));
            project.click();
            Thread.sleep(5000);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            try {
                WebElement schematicsCount = driver.findElement(By.cssSelector("#tableSCH > tbody"));
                List<WebElement> c = schematicsCount.findElements(By.xpath("./child::*"));
                System.out.println("Schematic task count :" + c.size());
                for(int j=1;j<=c.size();j++) {
                    WebElement schDel = driver.findElement(By.cssSelector("#tableSCH > tbody > tr:nth-child(" + j + ") > td:nth-child(2)"));
                    schDel.click();
                    Thread.sleep(4000);
                    try{
                        harnessPage.exitDrawingPage();
                        Thread.sleep(1000);
                    }
                    catch (ElementClickInterceptedException e) {
                        System.out.println(driver.getCurrentUrl());
                        driver.navigate().back();
                    }
                }
            }
            catch (NoSuchElementException e) {
                System.out.println("Schematic task count : 0");
                Thread.sleep(1000);
            }


            try {
                WebElement harnessCount = driver.findElement(By.cssSelector("#tableHAR > tbody"));
                List<WebElement> c = harnessCount.findElements(By.xpath("./child::*"));
                System.out.println("Harness task count :" + c.size());
                for(int k=1;k<c.size();k++) {
                    WebElement harDel = driver.findElement(By.cssSelector("#tableHAR > tbody > tr:nth-child(" + k + ") > td:nth-child(2)"));
                    harDel.click();
                    Thread.sleep(5000);
                    try {
                        harnessPage.exitDrawingPage();
                    }
                    catch (ElementClickInterceptedException e) {
                       System.out.println(driver.getCurrentUrl());
                        driver.navigate().back();
                    }
                }
            }
            catch (NoSuchElementException e) {
                System.out.println("Harness task count : 0");
                Thread.sleep(2000);
            }

            driver.close();
            driver.switchTo().window(tabs.get(0));
        }
    }
}
