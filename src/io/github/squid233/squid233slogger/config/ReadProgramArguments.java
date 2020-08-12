package io.github.squid233.squid233slogger.config;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

/**
 * @author squid233
 */
public class ReadProgramArguments {

    private final Map<String, String> ARGS_MAP;

    public void read(String[] args) {
        for (String arg : args) {
            ARGS_MAP.put(arg.split("=")[0], arg.split("=")[1]);
        }
    }

    @Contract(pure = true)
    public ReadProgramArguments(String[] args) {
        // args.length * 2
        ARGS_MAP = new HashMap<>(args.length << 1);
    }

    public String get(String key) {
        return ARGS_MAP.get(key);
    }
}
