package com.swagLabs.utilts;

import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private BrowserActions(){

    }
    public static  void navigateToUrl(WebDriver driver,String url){
        driver.get(url);
    }
    //get current url
    public static String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
}

