package com.swagLabs.utilts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementActions {
    private ElementActions(){

    }

    public static void sendData(WebDriver driver, By locator , String data){

        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrolltoElement(driver, locator);
        driver.findElement(locator).sendKeys(data);
    }

    public static void clickElement(WebDriver driver, By locator){

        Waits.waitForElementClickable(driver, locator);
        Scrolling.scrolltoElement(driver, locator);
        driver.findElement(locator).click();
    }
}
