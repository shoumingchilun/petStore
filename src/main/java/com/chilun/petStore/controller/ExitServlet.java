package com.chilun.petStore.controller;

import com.chilun.petStore.pojo.User;
import com.chilun.petStore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 皮皮皮
 * @date 2022/11/5 19:44
 */
@WebServlet("/exit")
public class ExitServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user=null;
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        req.getRequestDispatcher("main").forward(req,resp);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
