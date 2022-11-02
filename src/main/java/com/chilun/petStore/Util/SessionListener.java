package com.chilun.petStore.Util;

import com.mysql.cj.Session;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;

/**
 * @Title:
 * @Description:
 * @author: anthor
 * @date:2022/11/120:12
 */
public class SessionListener implements HttpSessionListener, ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();
        servletContext.setAttribute("userCouter",new AtomicInteger());
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSessionListener.super.sessionCreated(se);
        HttpSession httpSession=se.getSession();
        ServletContext servletContext=httpSession.getServletContext();
        AtomicInteger userCouter=(AtomicInteger)servletContext.getAttribute("userCouter");
        try {
            Logback.getlog().log(Level.INFO,"userCouter incremented to"+userCouter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSessionListener.super.sessionDestroyed(se);
        HttpSession httpSession=se.getSession();
        ServletContext servletContext=httpSession.getServletContext();
        AtomicInteger userCouter=(AtomicInteger)servletContext.getAttribute("userCouter");
        try {
            Logback.getlog().log(Level.INFO,"userCouter decremented to"+userCouter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
