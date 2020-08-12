package io.github.squid233.squid233slogger.logger;

import io.github.squid233.squid233slogger.consolestyle.Color;
import io.github.squid233.squid233slogger.consolestyle.Style;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import static java.time.LocalTime.now;

/**
 * @author squid233
 */
public class Logger {

    /**
     * Sender name.
     */
    private final String sender;

    @Contract(pure = true)
    public Logger(String name) {
        sender = name;
    }

    /**
     * Send an styled message to console.
     *
     * @param msg           Message to be sent.
     * @param consoleStyles Custom console styles. Can be field of {@link Color}, {@link Style}, etc.
     * @see Logger#send(String)
     * @since 1.0.0
     */
    public void send(String msg, @Nullable String... consoleStyles) {
        if (consoleStyles == null) {
            send(msg);
        } else {
            int consoleStylesLength;
            StringBuilder consoleStylesString = new StringBuilder();
            consoleStylesLength = consoleStyles.length;
            for (int i = 0; i < consoleStylesLength; i++) {
                consoleStylesString.append(consoleStyles[i]);
            }
            System.out.println(consoleStylesString + msg + Style.EMPTY);
        }
    }

    /**
     * Send an un-styled message to console. The call <code>Logger#send(msg)</code> is effectively equivalent to the call <code>System.out.println(msg)</code>
     *
     * @param msg Message to be sent.
     * @see Logger#send(String, String...)
     * @since 1.0.0
     */
    public void send(String msg) {
        System.out.println(msg);
    }

    /**
     * Send a message with more info. Include time, center text.
     *
     * @param msg           Message to be sent.
     * @param center        Center text. Position is before {@linkplain Logger#sender sender name}, after sent time.
     * @param consoleStyles Custom console styles.
     * @since 1.0.0
     */
    public void sendWithMoreInfo(String msg, String center, @Nullable String... consoleStyles) {
        System.out.print(Color.LIGHT_BLUE + "[" + now().getHour() + ":" + now().getMinute() + ":" + now().getSecond() + "]" + Style.EMPTY + center +
                "(" + sender + ")");
        send(msg, consoleStyles);
    }

    public void send(String msg, LogLevel logLevel, @Nullable String... consoleStyles) {
        sendWithMoreInfo(msg, logLevel.getLevelColor() + "[" + Thread.currentThread().getName() + "/" + logLevel + "]" + Style.EMPTY, consoleStyles);
    }

    /**
     * Send message with custom styles.
     *
     * @param msg           Message to be sent.
     * @param consoleStyles Custom console styles. Can be field of {@link Color}, {@link Style}, etc.
     * @see Logger#message(String)
     * @since 1.0.0
     */
    public void message(String msg, @Nullable String... consoleStyles) {
        send(msg, LogLevel.MESSAGE, consoleStyles);
    }

    /**
     * Send message to console. The message format just like this below:<br>
     * [${hours}:${minutes}:${seconds}][${threadName}/Thread[${threadName},${threadPriority},${threadGroupName}]][${sender}]${msg}<br>
     * Among them, ${} is variable.<br>
     * For example:<br>
     * <code><span style="color:#87DBFF;">[16:35:34]</span>[main/MESSAGE](Squid233's Logger) TEST SUCCESS</code><br>
     * To use it:<br>
     * <code>{@link LogManager}.{@linkplain LogManager#getLogger(String) getLogger(String)}.message(String);</code>
     *
     * @param msg Message to be sent
     * @see Logger#message(String, String...)
     * @since 1.0.0
     */
    @SuppressWarnings("SpellCheckingInspection")
    public void message(String msg) {
        message(msg, (String[]) null);
    }

    public void info(String info, @Nullable String... consoleStyles) {

    }

    /**
     * @return {@link Logger#sender}
     */
    public String getSenderName() {
        return sender;
    }
}
