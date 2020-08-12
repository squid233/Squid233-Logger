package io.github.squid233.squid233slogger.logger;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author squid233
 */
public class LogManager {

    private static boolean isLoaded = false;
    public static final String VERSION = "1.0.0+build.1";

    /**
     * @return The unnamed logger.
     * @since 1.0.0
     */
    @Contract(value = " -> new", pure = true)
    public static @NotNull UnnamedLogger getUnnamedLogger() {
        return new UnnamedLogger();
    }

    /**
     * @param name Logger's name. Will be use for logger's sender name.
     * @return The named logger.
     * @since 1.0.0
     */
    @Contract(value = "_ -> new")
    public static @NotNull Logger getLogger(String name) {
        if (!isLoaded) {
            isLoaded = true;
            getLogger("Squid233's Logger").message("Squid233's Logger [" + VERSION + "] initialize success");
        }
        return new Logger(name);
    }
}
