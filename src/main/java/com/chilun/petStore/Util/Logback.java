package com.chilun.petStore.Util;

import org.slf4j.LoggerFactory;

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

    private volatile static Logger log = null;

    public static Logger getlog() throws IOException {
        if (log == null) {
            synchronized (Logback.class) {
                if (log == null) {
                    Logger log = Logger.getLogger("com.chilun.petStore.logback");
                    log.setLevel(Level.INFO);
                    ConsoleHandler consoleHandler = new ConsoleHandler();
                    log.addHandler(consoleHandler);
                    FileHandler fileHandler = new FileHandler("testlog.log", true);
                    fileHandler.setFormatter(new LoggerFormatter());
                    log.addHandler(fileHandler);
                    return log;
                }
            }
        }
        return log;
    }
}
