package com.swagLabs.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    public static WebDriver getBrowser(String browserName) {

        switch (browserName.toLowerCase()) {
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--disable-infobars");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new EdgeDriver(edgeOptions);
            case "firefox":
                FirefoxOptions fireOptions = new FirefoxOptions();
                fireOptions.addArguments("--start-maximized");
                fireOptions.addArguments("--disable-extensions");
                fireOptions.addArguments("--disable-infobars");
                fireOptions.addArguments("--disable-notifications");
                fireOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                fireOptions.setAcceptInsecureCerts(true);
                return new FirefoxDriver(fireOptions);
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-notifications");
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new ChromeDriver(options);


        }
    }
}
