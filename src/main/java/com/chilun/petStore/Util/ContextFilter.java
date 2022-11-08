package com.chilun.petStore.Util;

import com.chilun.petStore.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.DataLine;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @Title:
 * @Description:
 * @author: anthor
 * @date:2022/11/621:05
 */
public class ContextFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
