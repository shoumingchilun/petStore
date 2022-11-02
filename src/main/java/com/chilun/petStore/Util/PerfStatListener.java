package com.chilun.petStore.Util;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Level;

/**
 * @Title:
 * @Description:
 * @author: anthor
 * @date:2022/11/120:11
 */
public class PerfStatListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequestListener.super.requestDestroyed(sre);
        ServletRequest servletRequest = sre.getServletRequest();
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        try {
            Logback.getlog().log(Level.INFO, "time taken to excute " + httpServletRequest.getRequestURI() + ":" + (System.nanoTime() - (Long) servletRequest.getAttribute("start")) + "microseconds");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequestListener.super.requestInitialized(sre);
        ServletRequest servletRequest = sre.getServletRequest();
        servletRequest.setAttribute("start", System.nanoTime());

    }
}
