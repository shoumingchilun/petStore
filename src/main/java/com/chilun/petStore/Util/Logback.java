package com.chilun.petStore.Util;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Title:
 * @Description:
 * @author: anthor
 * @date:2022/11/120:57
 */
public class Logback {
    public static Logger getlog() throws IOException {
        Logger log = Logger.getLogger("com.chilun.petStore.logback");
        FileHandler fileHandler = new FileHandler("testlog.log");
        log.setLevel(Level.INFO);
        ConsoleHandler consoleHandler =new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new LoggerFormatter());
        log.addHandler(consoleHandler);
        return log;
    }
}
