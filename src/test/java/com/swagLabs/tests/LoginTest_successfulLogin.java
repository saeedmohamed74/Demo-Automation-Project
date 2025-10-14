package com.swagLabs.tests;

import com.swagLabs.drivers.DriverManager;
import com.swagLabs.pages.LoginPage;
import com.swagLabs.utilts.AllureUtils;
import com.swagLabs.utilts.BrowserActions;
import com.swagLabs.utilts.FilesUtiles;
import com.swagLabs.utilts.ScreenshotsUtils;
import org.testng.annotations.*;

import java.io.File;
import java.sql.DriverAction;

public class LoginTest_successfulLogin {
    //variables
File allure_results = new File("test-outputs/allure-results");

    //Tests

    @Test

    public void successfulLogin(){
        new LoginPage(DriverManager.getDriver()).enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .assertSuccessLogin();
        ScreenshotsUtils.takeScreenshot("successful-login");

    }
    //configurations
    @BeforeSuite
    public void beforeSuite(){
        FilesUtiles.deleteFiles(allure_results);
    }
    @BeforeMethod
    public void setUp(){
         DriverManager.createInstance("chrome");
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown(){
        BrowserActions.closeBrowser(DriverManager.getDriver());

    }
    @AfterClass
    public void afterClass(){
        AllureUtils.attachLogsToAllureReports();
    }


}
