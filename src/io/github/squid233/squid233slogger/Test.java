package io.github.squid233.squid233slogger;

import io.github.squid233.squid233slogger.consolestyle.BackgroundColor;
import io.github.squid233.squid233slogger.consolestyle.Color;
import io.github.squid233.squid233slogger.consolestyle.Style;
import io.github.squid233.squid233slogger.logger.LogManager;
import io.github.squid233.squid233slogger.logger.Logger;

/**
 * Used by tester<br>
 * Clean the codes after test complete
 * @author squid233
 */
public class Test {
    private static final Logger LOGGER = LogManager.getLogger("Test");

    public static void main(String[] args) {
        Main.load();
        LOGGER.message("TEST SUCCESS", Color.LIGHT_BLUE);
        LOGGER.message("BOLD & PURPLE", Style.BOLD, Color.PURPLE);
        LOGGER.send(LOGGER.getSenderName(), Color.RED);
        LOGGER.send("Plain Text");
        LOGGER.message("Hey!", BackgroundColor.BLUE);
        LOGGER.message("msg", Color.GRAY, Style.UNDERLINE);
    }
}
