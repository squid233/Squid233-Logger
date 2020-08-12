package io.github.squid233.squid233slogger.logger;

import io.github.squid233.squid233slogger.consolestyle.Color;
import io.github.squid233.squid233slogger.consolestyle.ColorfulColor;
import org.jetbrains.annotations.Contract;

/**
 * @author squid233
 */
public enum LogLevel {
    /**
     * Level: Message
     */
    MESSAGE(0, ""),
    /**
     * Level: Info
     */
    INFO(1, ColorfulColor.GREEN),
    /**
     * Level: Warn
     */
    WARN(2, Color.YELLOW),
    /**
     * Level: Error
     */
    ERROR(4, ColorfulColor.RED),
    /**
     * Level: Fatal
     */
    FATAL(8, Color.RED),
    /**
     * Level: Debug
     */
    DEBUG(16, Color.GREEN);

    private final int level;
    private final String levelColor;

    @Contract(pure = true)
    LogLevel(int level, String levelColor) {
        this.level = level;
        this.levelColor = levelColor;
    }

    @Contract(pure = true)
    public int getLevel() {
        return level;
    }

    @Contract(pure = true)
    public String getLevelColor() {
        return levelColor;
    }
}
