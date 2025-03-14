package com.swagLabs.utilts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class ElementActions {
    private ElementActions(){

    }

    public static void sendData(WebDriver driver, By locator , String data){

        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrolltoElement(driver, locator);
        findElement(driver,locator).sendKeys(data);
    }

    public static void clickElement(WebDriver driver, By locator){

        Waits.waitForElementClickable(driver, locator);
        Scrolling.scrolltoElement(driver, locator);
        findElement(driver,locator).click();
    }

    public static String getText(WebDriver driver, By locator){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrolltoElement(driver, locator);
        return findElement(driver,locator).getText();
    }
    public static WebElement findElement(WebDriver driver, By locator){
        return driver.findElement(locator);
    }
}
