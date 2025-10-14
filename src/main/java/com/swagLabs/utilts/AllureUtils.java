package com.swagLabs.utilts;

import io.qameta.allure.Allure;
import org.openqa.selenium.logging.Logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {

    public static final String ALLURE_RESULTS_PATH = "test_outputs/allure-results";
    private static final Logger log = LoggerFactory.getLogger(AllureUtils.class);

    public AllureUtils() {
        super();
    }

    public static void attachLogsToAllureReports() {
        try {
            File logFile = FilesUtiles.getLatestFile(LogsUtil.LOGS_PATH);
            if (!logFile.exists()) {
                LogsUtil.warn("log file does not exist: " + LogsUtil.LOGS_PATH);
                return;
            }
            Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));
            LogsUtil.info("Logs attached to allure report");
        } catch (Exception e) {
            LogsUtil.error("failed to attach logs to allure report: " + e.getMessage());
        }


    }
    public static void attachScreenshotToAllureReport(String screenshotName, String screenshotPath){
        try {
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotPath)));
        } catch (IOException e) {
            LogsUtil.error("Failed to attach screenshot to Allure report: " + e.getMessage());
        }
    }

}
