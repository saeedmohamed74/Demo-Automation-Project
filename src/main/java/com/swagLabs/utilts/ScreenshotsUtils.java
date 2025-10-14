package com.swagLabs.utilts;

import com.swagLabs.drivers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotsUtils {
    public static final String SCREENSHOTS_PATH = "test-outputs/screenshots/";
    public ScreenshotsUtils() {
        super();
    }
public static void takeScreenshot(String screenshotName){

        try{
            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(SCREENSHOTS_PATH +screenshotName + ".png");
            FileUtils.copyFile(screenshot,screenshotFile);
            AllureUtils.attachScreenshotToAllureReport(screenshotName,screenshotFile.getPath() );
        } catch (IOException e) {
           LogsUtil.error("Failed to take screenshot: " + e.getMessage());
        }
}

}
