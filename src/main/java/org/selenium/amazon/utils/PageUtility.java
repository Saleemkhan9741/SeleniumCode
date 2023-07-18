package org.selenium.amazon.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.amazon.driverutils.Driver;
import org.selenium.amazon.enums.Locators;

import java.time.Duration;
import java.util.List;

public class PageUtility {

    private static final Logger LOGGER = LogManager.getLogger(PageUtility.class);
    public int WAIT = 60;
    public WebDriver driver;
    public WebDriverWait wait;

    public PageUtility() {
        driver = Driver.getInstance().getWebdriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(WAIT));
    }

    public void click(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void click(WebElement webElement, String msg){
        waitForVisibility(webElement);
        LOGGER.info(msg);
        click(webElement);
    }

    public void clickOnElementUsingJS(WebElement element){
        waitForVisibility(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public String getText(WebElement webElement){
        waitForVisibility(webElement);
        return webElement.getText();
    }

    public void waitForVisibility(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement getElementByLocator(Locators locators, String locatorValue){
        switch (locators){
            case ID -> {
                return driver.findElement(By.id(locatorValue));
            }
            case CSS -> {
                return driver.findElement(By.cssSelector(locatorValue));
            }
            case NAME -> {
                return driver.findElement(By.name(locatorValue));
            }
            case CLASS_NAME -> {
                return driver.findElement(By.className(locatorValue));
            }
            case TAG_NAME -> {
                return driver.findElement(By.tagName(locatorValue));
            }
            case LINK_TEXT -> {
                return driver.findElement(By.linkText(locatorValue));
            }
            case PARTIAL_LINK_TEXT -> {
                return driver.findElement(By.partialLinkText(locatorValue));
            }
            case XPATH -> {
                return driver.findElement(By.xpath(locatorValue));
            }
            default -> throw new RuntimeException("invalid locator and input");
        }
    }

    public List<WebElement> getElementsByLocator(Locators locators, String locatorValue){
        switch (locators){
            case ID -> {
                return driver.findElements(By.id(locatorValue));
            }
            case CSS -> {
                return driver.findElements(By.cssSelector(locatorValue));
            }
            case NAME -> {
                return driver.findElements(By.name(locatorValue));
            }
            case CLASS_NAME -> {
                return driver.findElements(By.className(locatorValue));
            }
            case TAG_NAME -> {
                return driver.findElements(By.tagName(locatorValue));
            }
            case LINK_TEXT -> {
                return driver.findElements(By.linkText(locatorValue));
            }
            case PARTIAL_LINK_TEXT -> {
                return driver.findElements(By.partialLinkText(locatorValue));
            }
            case XPATH -> {
                return driver.findElements(By.xpath(locatorValue));
            }
            default -> throw new RuntimeException("invalid locator and input");
        }
    }

    public void sendKeys(WebElement webElement, String text){
        waitForVisibility(webElement);
        webElement.sendKeys(text);
    }

    public void doubleClick(WebElement webElement, String msg){
        LOGGER.info(msg);
        waitForVisibility(webElement);
        click(webElement);
        try {
            clickOnElementUsingJS(webElement);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void clear(WebElement webElement){
        waitForVisibility(webElement);
        webElement.clear();
    }

    public void hoverOverAElement(WebElement element){
        waitForVisibility(element);
        Actions actions = new Actions(driver);
        LOGGER.info("Moving to element {}",element);
        actions.moveToElement(element).perform();
    }
}
