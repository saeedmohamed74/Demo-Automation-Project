package com.swagLabs.pages;

import com.swagLabs.utilts.BrowserActions;
import com.swagLabs.utilts.CustomSoftAssertion;
import com.swagLabs.utilts.ElementActions;
import com.swagLabs.utilts.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //locators

    private final WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("data-test=\"error\"");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigating to login Page")
    //navigate to the login page
    public void navigateToLoginPage() {
        BrowserActions.navigateToUrl(driver, "https://www.saucedemo.com/v1/");
    }

    //Actions
    @Step("Entering username: {0}")
    public LoginPage enterUserName(String username) {
        ElementActions.sendData(driver, this.username, username);
        return this;
    }

    @Step("Ebtering password: {0}")
    public LoginPage enterPassword(String password) {
        ElementActions.sendData(driver, this.password, password);
        return this;
    }

    @Step("Clicking Login button")
    public LoginPage clickLoginButton() {
        ElementActions.clickElement(driver, loginButton);
        return this;
    }

    @Step("Get error message")
    public String getErrorMessage() {
        return ElementActions.getText(driver, errorMessage);
    }
    //validations
    @Step("Asserting login page url")
    public LoginPage assertLoginPageUrl() {
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentUrl(driver),
                "https://www.saucedemo.com/v1/inventory.html");
        return this;
    }
    @Step("Asserting login page title")
    public LoginPage assertLoginPageTitle() {
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getPageTitle(driver),
                "Swag Labs");
        return this;

    }
    @Step("Asserting successful login")
    public LoginPage assertSuccessLoginSoft() {
        assertLoginPageUrl().assertLoginPageTitle();
        return this;
    }

    public LoginPage assertSuccessLogin() {
        Validations.validatePageUrl(driver, "https://www.saucedemo.com/v1/inventory.html");

        return this;
    }
    @Step("Asserting unsuccessful login")
    public LoginPage assertUnsuccessfulLogin() {
        Validations.validateEquals(getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message is not as expected");
        return this;
    }

}
