package com.swagLabs.utilts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

public class Scrolling {

    private Scrolling(){

    }

    public static void scrolltoElement(WebDriver driver , By locator){
       LogsUtil.info("Scrolling to the element: ", locator.toString());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                ElementActions.findElement(driver,locator));
    }

}
