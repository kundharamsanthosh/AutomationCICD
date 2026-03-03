package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * GenericMethods contains commonly used Selenium helper methods for use
 * throughout the test framework. Keep methods small and focused so they are
 * easy to test and reuse.
 */
public class GenericMethods {

    private WebDriver driver;
    private WebDriverWait wait;
    private FluentWait<WebDriver> fluentWait;

    public GenericMethods(WebDriver driver, Duration explicitWait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, explicitWait);
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(explicitWait)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }

    // Waits
    public WebElement waitForElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitForTextToBePresent(WebElement element, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean waitForTitle(String title) {
        return wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitForPageLoad() {
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState").equals("complete"));
    }

    // Actions
    public void click(WebElement element) {
        waitForElementClickable(element).click();
    }

    public void typeText(WebElement element, String text) {
        WebElement el = waitForElementVisible(element);
        el.clear();
        el.sendKeys(text);
    }

    public String getText(WebElement element) {
        return waitForElementVisible(element).getText();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Throwable t) {
            return false;
        }
    }

    // Select helpers
    public void selectByVisibleText(WebElement selectElement, String text) {
        Select s = new Select(waitForElementVisible(selectElement));
        s.selectByVisibleText(text);
    }

    public void selectByValue(WebElement selectElement, String value) {
        Select s = new Select(waitForElementVisible(selectElement));
        s.selectByValue(value);
    }

    public void selectByIndex(WebElement selectElement, int index) {
        Select s = new Select(waitForElementVisible(selectElement));
        s.selectByIndex(index);
    }

    // JavaScript helpers
    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void jsScrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsScrollBy(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    // Actions chaining
    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(waitForElementVisible(element)).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(waitForElementVisible(source), waitForElementVisible(target)).perform();
    }

    // Alert handling
    public Alert waitForAlertAndSwitch() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public void acceptAlert() {
        Alert alert = waitForAlertAndSwitch();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = waitForAlertAndSwitch();
        alert.dismiss();
    }

    public String getAlertText() {
        return waitForAlertAndSwitch().getText();
    }

    // Window / frame handling
    public void switchToWindowByTitle(String title) {
        String current = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(title)) {
                return;
            }
        }
        driver.switchTo().window(current); // restore if not found
    }

    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(waitForElementVisible(frameElement));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Screenshots
    public File takeScreenshot(String fileNamePrefix) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + File.separator + "screenshots",
                fileNamePrefix + "_" + System.currentTimeMillis() + ".png");
        try {
            FileUtils.forceMkdirParent(dest);
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot: " + e.getMessage(), e);
        }
        return dest;
    }

    // Helpers for lists
    public WebElement findElementInListByText(List<WebElement> elements, String text) {
        for (WebElement e : elements) {
            if (e.getText().trim().equals(text))
                return e;
        }
        throw new NoSuchElementException("No element with text: " + text);
    }

    public boolean waitForAllElementsVisible(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements)) != null;
    }

    // Fluent wait example
    public WebElement fluentWaitForElement(WebElement element) {
        return fluentWait.until(driver -> {
            if (element.isDisplayed())
                return element;
            return null;
        });
    }
 

}
