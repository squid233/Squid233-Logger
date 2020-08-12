package io.github.squid233.squid233slogger;

import io.github.squid233.squid233slogger.logger.LoggerLevelResolver;
import org.jetbrains.annotations.Contract;

/**
 * Please add <code>Main.load(args);</code>!
 * @author squid233
 */
public class Main {
    @Contract(pure = true)
    public static void main(String[] args) {

    }

    public static void load() {
        LoggerLevelResolver.init();
    }
}
