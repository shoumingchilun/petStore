package com.chilun.petStore.Util;



import org.testng.annotations.Test;

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
                    Logger log = Logger.getLogger("com.chilun.petStore.Util.Logback");
                    log.setLevel(Level.ALL);
                    ConsoleHandler consoleHandler = new ConsoleHandler();
                    consoleHandler.setLevel(Level.ALL);
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
    @Test
    public void  a() throws IOException {
        Logger logger=Logback.getlog();
        getlog().log(Level.FINEST,"A");
        logger.finest("finest");
        logger.finer("finer");
        logger.fine("fine");
        logger.config("config");
        logger.info("info");
        logger.warning("warning");
        logger.severe("severe");
    }
}
