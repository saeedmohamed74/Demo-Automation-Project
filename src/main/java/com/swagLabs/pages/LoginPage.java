package com.swagLabs.pages;

import com.swagLabs.utilts.BrowserActions;
import com.swagLabs.utilts.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;

public class LoginPage {
    //locators

    private final WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton  = By.id("login-button");
    private final By errorMessage = By.cssSelector("data-test=\"error\"");
    //constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //navigate to the login page
    public void navigateToLoginPage(){
       BrowserActions.navigateToUrl(driver,"https://www.saucedemo.com/v1/");
    }
    //Actions

    public LoginPage enterUserName(String username){
        ElementActions.sendData(driver,this.username,username);
        return this;
    }
    public LoginPage enterPassword(String password){
        ElementActions.sendData(driver,this.password,password);
        return this;
    }
    public LoginPage clickLoginButton(){
        ElementActions.clickElement(driver,loginButton);
        return this;
    }

    public String getErrorMessage(){
        return ElementActions.getText(driver,errorMessage);
    }
    //validations
    public LoginPage assertSuccessLogin(){
        Assert.assertEquals(BrowserActions.getCurrentUrl(driver),"https://www.saucedemo.com/v1/inventory.html");
        return this;
    }

    public LoginPage assertUnsuccessfulLogin(){
        Assert.assertEquals(getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
        return this;
    }

}
