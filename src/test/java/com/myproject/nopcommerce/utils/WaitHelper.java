package com.myproject.nopcommerce.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Miroslav Kološnjaji
 */
public class WaitHelper {

    public final WebDriver driver;
    private final WebDriverWait webDriverWait;

    public WaitHelper(WebDriver driver, Duration seconds) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, seconds);
    }

    public void waitForElement(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisibility(WebElement webElement){
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForClickabillity(By locator) {
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void waitForClickabillity(WebElement webElement){
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void waitForInvisibility(By locator) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
