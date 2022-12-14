package arcadia.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumCustomCommand {
    public void enterText(WebElement element , String value){
        if (value != null || !value.isEmpty() || !value.trim().isEmpty()){
            element.sendKeys(value);
        }

    }
    public void selectDropDownByValue(WebElement element ,String value) throws InterruptedException {
        if (value != null || !value.isEmpty() || !value.trim().isEmpty()){
            Select dropDownElement = new Select(element);
            dropDownElement.selectByValue(value);
            Thread.sleep(2000);
        }
    }
    public void selectDropDownByVisibleText(WebElement element ,String value) throws InterruptedException {
        if (value != null || !value.isEmpty() || !value.trim().isEmpty()){
            Select dropDownElement = new Select(element);
            dropDownElement.selectByVisibleText(value);
            Thread.sleep(2000);
        }
    }
    public void waitForElementVisibility(WebDriver driver , WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToBeClickable(WebDriver driver , WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public void simulateKeyEnterWithValue(WebElement element , String value){
        if (value != null || !value.isEmpty() || !value.trim().isEmpty()){
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
        }
    }
    public void scrollIntoView(WebDriver driver , WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
    }

    public void javaScriptClick(WebDriver driver , WebElement element) throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        Thread.sleep(1000);
    }

    public void movePointerAndDoubleClick(int xCoordinates , int yCoordinates) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.mouseMove(xCoordinates, yCoordinates);
        Thread.sleep(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(1000);
    }

    public String getValueByJavascriptExecutor(WebDriver driver , WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String elementValue = (String) jse.executeScript("return arguments[0].value", element);
        return  elementValue;
    }

    public void mouseHover(WebDriver driver , WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void waitClick(WebElement element) throws InterruptedException {
        long endTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(1L, TimeUnit.MINUTES);
        boolean elementVisible = false;
        while (!elementVisible && System.nanoTime() < endTime) {
            try {
                element.click();
                elementVisible = true;
            }
            catch(Exception e) {
                elementVisible = false;
                Thread.sleep(1000);
            }

        }

    }
    public void simulateKeyEnter() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(200);
    }

    public void rightClick(WebDriver driver,WebElement ele)
    {
        Actions a = new Actions(driver);
        a.moveToElement(ele).contextClick().build().perform();
    }

    public void doubleClick(WebDriver driver , WebElement element){
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

}
