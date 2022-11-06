package com.chilun.petStore.Util;

import com.chilun.petStore.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private Logger logger;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            logger = Logback.getlog();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session=((HttpServletRequest)servletRequest).getSession();
        User user = (User) session.getAttribute("loginUser");
        if(user==null)
            servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest,servletResponse);
        logger.log(Level.FINEST, "ContextFilter doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
