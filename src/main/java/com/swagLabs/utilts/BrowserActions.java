package com.swagLabs.utilts;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private BrowserActions(){

    }
    @Step("Navigating to URL: {url}")
    public static  void navigateToUrl(@NotNull WebDriver driver, String url){
        driver.get(url);
        LogsUtil.info("Navigate to: ", url);
    }
    @Step("Getting current URL")
    //get current url
    public static String getCurrentUrl(@NotNull WebDriver driver){
        LogsUtil.info("Current URL:" , driver.getCurrentUrl());
        return driver.getCurrentUrl();

    }
    @Step("Getting page title")
    //Get page title
    public static String getPageTitle(@NotNull WebDriver driver){
        LogsUtil.info("Page title: ", driver.getTitle());
        return driver.getTitle();
    }
    @Step("Refreshing page")
    //refresh page
    public static void refreshPage(@NotNull WebDriver driver){
        driver.navigate().refresh();
    }
    @Step("Closing the browser")
    public static void closeBrowser(@NotNull WebDriver driver){
        LogsUtil.info("closing the browser");
        driver.quit();
    }
}

