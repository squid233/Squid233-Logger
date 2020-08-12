package io.github.squid233.squid233slogger.logger;

import io.github.squid233.squid233slogger.config.Config;
import io.github.squid233.squid233slogger.config.ReadProgramArguments;
import org.jetbrains.annotations.Contract;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author squid233
 */
public class LoggerLevelResolver {
    private static boolean isDisplayMessage;
    private static boolean isDisplayInfo;
    private static boolean isDisplayWarn;
    private static boolean isDisplayError;
    private static boolean isDisplayFatal;
    private static boolean isDisplayDebug;
    private static int STAGE = 6;

    public static void init() {
        try {
            Config.CONFIG.load(new FileReader("squidlog.cfg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int loggerValue = Integer.parseInt(Config.CONFIG.getProperty("logger-level", String.valueOf(15)));
        if (loggerValue < 0) {
            setIsDisplayMessage(false);
            setIsDisplayInfo(false);
            setIsDisplayWarn(false);
            setIsDisplayError(false);
            setIsDisplayFatal(false);
            setIsDisplayDebug(false);
        } else {
            while (STAGE > 0) {
                if (loggerValue >= LogLevel.MESSAGE.getLevel()) {
                    setIsDisplayMessage(true);
                    loggerValue -= LogLevel.MESSAGE.getLevel();
                    STAGE--;
                }
                if (loggerValue >= LogLevel.INFO.getLevel()) {
                    setIsDisplayInfo(true);
                    loggerValue -= LogLevel.INFO.getLevel();
                    STAGE--;
                }
                if (loggerValue >= LogLevel.WARN.getLevel()) {
                    setIsDisplayWarn(true);
                    loggerValue -= LogLevel.WARN.getLevel();
                    STAGE--;
                }
                if (loggerValue >= LogLevel.ERROR.getLevel()) {
                    setIsDisplayError(true);
                    loggerValue -= LogLevel.ERROR.getLevel();
                    STAGE--;
                }
                if (loggerValue >= LogLevel.FATAL.getLevel()) {
                    setIsDisplayFatal(true);
                    loggerValue -= LogLevel.FATAL.getLevel();
                    STAGE--;
                }
                if (loggerValue >= LogLevel.DEBUG.getLevel()) {
                    setIsDisplayDebug(true);
                    loggerValue -= LogLevel.DEBUG.getLevel();
                    STAGE--;
                }
            }
        }
        System.out.println(
                "[DEBUG]Message: " + isDisplayMessage() + "|" +
                        "Info: " + isDisplayInfo() + "|" +
                        "Warn: " + isDisplayWarn() + "|" +
                        "Error: " + isDisplayError() + "|" +
                        "Fatal: " + isDisplayFatal() + "|" +
                        "Debug: " + isDisplayDebug());
    }

    @Contract(pure = true)
    public static boolean isDisplayMessage() {
        return isDisplayMessage;
    }

    @Contract(pure = true)
    public static boolean isDisplayInfo() {
        return isDisplayInfo;
    }

    @Contract(pure = true)
    public static boolean isDisplayWarn() {
        return isDisplayWarn;
    }

    @Contract(pure = true)
    public static boolean isDisplayError() {
        return isDisplayError;
    }

    @Contract(pure = true)
    public static boolean isDisplayFatal() {
        return isDisplayFatal;
    }

    @Contract(pure = true)
    public static boolean isDisplayDebug() {
        return isDisplayDebug;
    }

    public static void setIsDisplayMessage(boolean isDisplayMessage) {
        LoggerLevelResolver.isDisplayMessage = isDisplayMessage;
    }

    public static void setIsDisplayInfo(boolean isDisplayInfo) {
        LoggerLevelResolver.isDisplayInfo = isDisplayInfo;
    }

    public static void setIsDisplayWarn(boolean isDisplayWarn) {
        LoggerLevelResolver.isDisplayWarn = isDisplayWarn;
    }

    public static void setIsDisplayError(boolean isDisplayError) {
        LoggerLevelResolver.isDisplayError = isDisplayError;
    }

    public static void setIsDisplayFatal(boolean isDisplayFatal) {
        LoggerLevelResolver.isDisplayFatal = isDisplayFatal;
    }

    public static void setIsDisplayDebug(boolean isDisplayDebug) {
        LoggerLevelResolver.isDisplayDebug = isDisplayDebug;
    }
}
