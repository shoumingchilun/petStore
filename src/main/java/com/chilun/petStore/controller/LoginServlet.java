package com.chilun.petStore.controller;


import com.chilun.petStore.service.UserService;
import com.mysql.cj.xdevapi.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author 皮皮皮
 * @date 2022/10/29 22:23
 */
@WebServlet(name="LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserService();
    private String account;
    private String password;
    protected void doPost(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException {
        account=request.getParameter("account");
        password=request.getParameter("password");

        if(userService.login(account,password)){

            session.setAttribute("account",account);
            response.sendRedirect("MainInterface.jsp");
        }else{
            request.setAttribute("msg","账号或密码不正确");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


}
