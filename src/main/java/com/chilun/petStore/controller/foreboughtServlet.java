package com.chilun.petStore.controller;

import com.chilun.petStore.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class foreboughtServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if(user == null)
        {
            resp.sendRedirect("/login");
        }
        else
            req.getRequestDispatcher("WEB-INF/foreboughtJsp/forebought.jsp").forward(req,resp);
    }
}
