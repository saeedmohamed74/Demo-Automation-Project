package com.swagLabs.utilts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling {

    private Scrolling(){

    }

    public static void scrolltoElement(WebDriver driver , By locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ElementActions.findElement(driver,locator));
    }

}
