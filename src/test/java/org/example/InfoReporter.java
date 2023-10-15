package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfoReporter {
    private static Logger getLogger() { return LogManager.getLogger(InfoReporter.class); }
    public static void logInfo(String text) { getLogger().info(text); }
    public static void logError(String text) { getLogger().error(text); }
    public static void logWarning(String text) { getLogger().warn(text); }
}