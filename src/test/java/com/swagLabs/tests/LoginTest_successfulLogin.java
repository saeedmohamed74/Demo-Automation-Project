package com.swagLabs.tests;

import com.swagLabs.drivers.DriverManager;
import com.swagLabs.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest_successfulLogin {
    //variables


    //Tests

    @Test

    public void successfulLogin(){
        new LoginPage(DriverManager.getDriver()).enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .assertSuccessLogin();

    }
    //configurations
    @BeforeMethod
    public void setUp(){
         DriverManager.createInstance("chrome");
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown(){
    DriverManager.getDriver().quit();

    }


}
