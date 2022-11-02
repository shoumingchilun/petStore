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

    private Logger log = null;

    public Logger getlog() throws IOException {
        if (log == null) {
            Logger log = Logger.getLogger("com.chilun.petStore.logback");
            log.setLevel(Level.INFO);
            ConsoleHandler consoleHandler = new ConsoleHandler();
            log.addHandler(consoleHandler);
            FileHandler fileHandler = new FileHandler("testlog.log",true);
            fileHandler.setFormatter(new LoggerFormatter());
            log.addHandler(fileHandler);
            return log;
        } else return log;
    }
}
