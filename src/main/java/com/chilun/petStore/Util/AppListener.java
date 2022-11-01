package com.chilun.petStore.Util;

import org.testng.annotations.Test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.util.logging.*;


/**
 * @Title:
 * @Description:
 * @author: anthor
 * @date:2022/11/120:10
 */
public class AppListener implements ServletContextListener {
//
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("start");
        Logger log = Logger.getLogger("com.chilun.petStore");
        log.setLevel(Level.INFO);

        ConsoleHandler consoleHandler =new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        log.addHandler(consoleHandler);
        log.info("Aaa");
//        FileHandler fileHandler = null;
//        try {
//            fileHandler = new FileHandler("testlog.log");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        fileHandler.setLevel(Level.INFO);
//        //fileHandler.setFormatter(new SimpleFormatter());
//        log.addHandler(fileHandler);
//        log.info("111");
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
    @Test
    public void methods(){
        System.out.println("start");
        Logger log = Logger.getLogger("com.chilun.petStore.logback");
        log.setLevel(Level.INFO);
        ConsoleHandler consoleHandler =new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        log.addHandler(consoleHandler);
        log.info("Aaa");
    }
}
