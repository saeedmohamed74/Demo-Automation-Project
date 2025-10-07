package com.swagLabs.utilts;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private BrowserActions(){

    }
    public static  void navigateToUrl(@NotNull WebDriver driver, String url){
        driver.get(url);
        LogsUtil.info("Navigate to: ", url);
    }
    //get current url
    public static String getCurrentUrl(@NotNull WebDriver driver){
        LogsUtil.info("Current URL:" , driver.getCurrentUrl());
        return driver.getCurrentUrl();

    }
    //Get page title
    public static String getPageTitle(@NotNull WebDriver driver){
        LogsUtil.info("Page title: ", driver.getTitle());
        return driver.getTitle();
    }

    //refresh page
    public static void refreshPage(@NotNull WebDriver driver){
        driver.navigate().refresh();
    }

    public static void closeBrowser(@NotNull WebDriver driver){
        LogsUtil.info("closing the browser");
        driver.quit();
    }
}

