package arcadia.pages;

import arcadia.constants.EndPoint;
import arcadia.utils.SeleniumCustomCommand;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class PostMigrationPage extends BasePage  {

    SeleniumCustomCommand customCommand = new SeleniumCustomCommand();
    HarnessPage harnessPage =new HarnessPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    public PostMigrationPage(WebDriver driver) throws IOException {
        super(driver);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(css="#ExpProj")private WebElement expandAll;
    @FindBy(css ="#example-tables > div.tabulator-tableholder > div")private WebElement actualProjectCount;
    int availableProjectCount,count =0;
    String path = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles" +File.separator +"taskDetails.txt";
    FileWriter file = new FileWriter(path,true);
    BufferedWriter wr = new BufferedWriter(file);
    public void openAllAvailableProjectsAndTasksInGivenInstance() throws InterruptedException, IOException {
        wr.write("*******************************************************");
        wr.newLine();
        wr.write("               Automation Test Report                  ");
        wr.newLine();
        wr.write("********************************************************");
        wr.newLine();
        wr.newLine();
        wr.write("Date   :"+new Date());
        wr.newLine();
        wr.newLine();
        wr.newLine();
        expandAll.click();
        Thread.sleep(2000);
        Object countOfProject = js.executeScript("return document.querySelector('#example-tables > div.tabulator-tableholder > div').childElementCount");
        availableProjectCount = Integer.parseInt(countOfProject.toString());
        Actions actions = new Actions(driver);
        for (int i = 1; i <= availableProjectCount; i++) {
            if(i %8 == 0) {
                loginPage.load(EndPoint.LOGOUT.url);
                loginPage.load();
                loginPage.Login();
                Thread.sleep(2000);
                loginPage.load(EndPoint.PROJECTHOMEPAGE.url);
            }
            WebElement customLevelProject = driver.findElement(By.cssSelector("#example-tables > div.tabulator-tableholder > div > div:nth-child("+i+")"));
            WebElement project = driver.findElement(By.cssSelector("#example-tables > div.tabulator-tableholder > div > div:nth-child(" + i + ") > div:nth-child(2)"));
            actions.moveToElement(project);
            if (!Objects.equals(customLevelProject.getAttribute("style"), "padding-left: 0px; background-color: rgb(244, 244, 244); border-bottom: 1px solid white;")) {
                count++;
                try {
                    WebElement projectName = driver.findElement(By.cssSelector("#example-tables > div.tabulator-tableholder > div > div:nth-child(" + i + ") > div:nth-child(1)"));
                    wr.newLine();
                    wr.write("Project Name :" + projectName.getText());
                    wr.newLine();
                } catch (NoSuchElementException e) {
                    Thread.sleep(100);
                }
                project.click();
                Thread.sleep(5000);
                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));

                try {
                    WebElement drawingCount = driver.findElement(By.cssSelector("#tableDRA > tbody"));
                    List<WebElement> c = drawingCount.findElements(By.xpath("./child::*"));
                    System.out.println("Drawing task count :" + c.size());
                    for (int j = 1; j <= c.size(); j++) {
                        WebElement drawingTask = driver.findElement(By.cssSelector("#tableDRA > tbody > tr:nth-child(" + j + ") > td:nth-child(2)"));
                        drawingTask.click();
                        Thread.sleep(4000);
                        try {
                            harnessPage.exitDrawingPage();
                            Thread.sleep(1000);
                        } catch (ElementClickInterceptedException e) {
                            System.out.println(driver.getCurrentUrl());
                            wr.newLine();
                            wr.write("Blocker crash/Some issue task details:  " + driver.getCurrentUrl());
                            driver.navigate().back();
                        }
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Drawing task count : 0");
                    wr.newLine();
                    wr.write("Drawing task count : 0");
                    Thread.sleep(1000);
                }

                try {
                    WebElement schematicsCount = driver.findElement(By.cssSelector("#tableSCH > tbody"));
                    List<WebElement> c = schematicsCount.findElements(By.xpath("./child::*"));
                    wr.newLine();
                    System.out.println("Schematic task count :" + c.size());
                    wr.write("Schematic task count :" + c.size());
                    for (int j = 1; j <= c.size(); j++) {
                        WebElement schDel = driver.findElement(By.cssSelector("#tableSCH > tbody > tr:nth-child(" + j + ") > td:nth-child(2)"));
                        schDel.click();
                        Thread.sleep(4000);
                        try {
                            harnessPage.exitDrawingPage();
                            Thread.sleep(1000);
                        } catch (ElementClickInterceptedException e) {
                            wr.newLine();
                            wr.write("Blocker crash/Some issue task details:  " + driver.getCurrentUrl());
                            driver.navigate().back();
                        }
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Schematic task count : 0");
                    wr.newLine();
                    wr.write("Schematic task count : 0");
                    Thread.sleep(1000);
                }


                try {
                    WebElement harnessCount = driver.findElement(By.cssSelector("#tableHAR > tbody"));
                    List<WebElement> c = harnessCount.findElements(By.xpath("./child::*"));
                    System.out.println("Harness task count :" + c.size());
                    wr.newLine();
                    wr.write("Harness task count :" + c.size());
                    wr.newLine();
                    for (int k = 1; k <= c.size(); k++) {
                        WebElement harDel = driver.findElement(By.cssSelector("#tableHAR > tbody > tr:nth-child(" + k + ") > td:nth-child(2)"));
//                        harDel.click();
                        customCommand.javaScriptClick(driver, harDel);
                        Thread.sleep(5000);
                        try {
                            harnessPage.exitDrawingPage();
                        } catch (ElementClickInterceptedException e) {
                            wr.write("Blocker crash/Some issue task details:  " + driver.getCurrentUrl());
                            wr.newLine();
                            Thread.sleep(2000);
                            driver.navigate().back();
                        }
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Harness task count : 0");
                    wr.newLine();
                    wr.write("Harness task count : 0");
                    wr.newLine();
                }

                driver.close();
                driver.switchTo().window(tabs.get(0));
            }
        }
        wr.newLine();
        wr.write("Available Projects :"+count);
        wr.close();
    }
}
