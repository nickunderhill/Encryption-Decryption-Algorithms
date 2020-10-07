package com.underhill.hyperskill;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<String, String> parseConsoleArgs(String[] args) {
        Map<String, String> consoleArgs = new HashMap<>();
        for (int i = 0; i < args.length - 1; i++) {
            consoleArgs.put(args[i], args[i + 1]);
        }
        return consoleArgs;
    }
}
