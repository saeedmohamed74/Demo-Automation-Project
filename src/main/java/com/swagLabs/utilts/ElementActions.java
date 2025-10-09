package com.swagLabs.utilts;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.Wait;

public class ElementActions {
    private ElementActions(){

    }
    @Step("Sending data: {data} to the element: {locator}")
    public static void sendData(WebDriver driver, By locator , String data){

        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrolltoElement(driver, locator);
        findElement(driver,locator).sendKeys(data);
        LogsUtil.info("Data entered: ", data , "in the field", locator.toString());
    }
    @Step("Clicking on element: {locator}")
    public static void clickElement(WebDriver driver, By locator){

        Waits.waitForElementClickable(driver, locator);
        Scrolling.scrolltoElement(driver, locator);
        findElement(driver,locator).click();
        LogsUtil.info("Clicked on element: ", locator.toString());
    }
    @Step("Getting Text of element: {locator}")
    public static String getText(WebDriver driver, By locator){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrolltoElement(driver, locator);
        return findElement(driver,locator).getText();
    }

    public static WebElement findElement(WebDriver driver, By locator){

        return driver.findElement(locator);
    }
}
