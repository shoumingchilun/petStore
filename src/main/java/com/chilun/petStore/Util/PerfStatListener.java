package com.chilun.petStore.Util;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

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
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequestListener.super.requestInitialized(sre);
    }
}
