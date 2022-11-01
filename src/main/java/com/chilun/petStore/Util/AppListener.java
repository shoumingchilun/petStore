package com.chilun.petStore.Util;

import org.testng.annotations.Test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
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
        try {
            Logback.getlog().info("444");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }

}
