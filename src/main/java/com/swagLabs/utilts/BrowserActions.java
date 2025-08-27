package com.swagLabs.utilts;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private BrowserActions(){

    }
    public static  void navigateToUrl(@NotNull WebDriver driver, String url){
        driver.get(url);
    }
    //get current url
    public static String getCurrentUrl(@NotNull WebDriver driver){
        return driver.getCurrentUrl();
    }
    //Get page title
    public static String getPageTitle(@NotNull WebDriver driver){
        return driver.getTitle();
    }

    //refresh page
    public static void refreshPage(@NotNull WebDriver driver){
        driver.navigate().refresh();
    }
}

