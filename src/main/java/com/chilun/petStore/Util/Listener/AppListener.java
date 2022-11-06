package com.chilun.petStore.Util.Listener;

import com.chilun.petStore.Util.Logback;
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


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        try {
            new Logback().getlog().log(Level.INFO, "context has Initialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
        try {
            Logback.getlog().log(Level.INFO, "context has Destroyed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void a() throws IOException {
        try {
            Logback.getlog().log(Level.INFO, "logtest1");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}