package com.swagLabs.pages;

import com.swagLabs.utilts.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    //locators

    private final WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton  = By.id("login-button");

    //constructor
    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    //Actions

    public void enterUserName(String username){
        ElementActions.sendData(driver,this.username,username);
    }
    public void enterPassword(String password){
        ElementActions.sendData(driver,this.password,password);
    }
    public void clickLoginButton(){
        ElementActions.clickElement(driver,loginButton);
    }

    //validations


}
