package com.swagLabs.utilts;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsUtil {
    private LogsUtil() {
        super();
    }

    public static Logger logger() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    public static void trace(String... message) {

        logger().trace(String.join(" ", message));
    }

    public static void debug(String... message) {

        logger().debug(String.join(" ", message));
    }

    public static void info(String... message) {

        logger().info(String.join(" ", message));
    }

    public static void warn(String... message) {

        logger().warn(String.join(" ", message));
    }

    public static void error(String... message) {

        logger().error(String.join(" "));
    }

    public static void fatal(String... message) {

        logger().fatal(String.join(" ", message));
    }
}
