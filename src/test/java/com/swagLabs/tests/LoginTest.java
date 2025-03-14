package com.swagLabs.tests;

import com.swagLabs.pages.LoginPage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    //variables
    private WebDriver driver;

    //Tests

    @Test

    public void successfulLogin(){
        new LoginPage(driver).enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .assertSuccessLogin();

    }
    //configurations
    @BeforeMethod
    public void setUp(){

        driver = new EdgeDriver();
        new LoginPage(driver).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown(){
    driver.quit();
    }


}
