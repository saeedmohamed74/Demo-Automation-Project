package com.swagLabs.drivers;

import com.swagLabs.utilts.LogsUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.fail;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
        super();
    }

    @Step("create driver instance on {browserName}")
    public static WebDriver createInstance(String browserName){
        WebDriver driver = BrowserFactory.getBrowser(browserName);
        LogsUtil.info("Driver created on: ", browserName);
        setDriver(driver);
        return getDriver();
    }
    public static WebDriver getDriver() {
        if(driverThreadLocal.get() == null){
            fail("Driver is null");
        }

        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }
}
