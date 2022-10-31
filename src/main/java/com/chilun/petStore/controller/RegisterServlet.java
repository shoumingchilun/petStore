package com.chilun.petStore.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 皮皮皮
 * @date 2022/10/31 11:24
 */
@WebServlet(name="RegisterServlet" ,urlPatterns = "/register")
public class RegisterServlet {
    private String account;
    private String password;

    protected void doPost(HttpServletRequest request, HttpServletResponse response){

        account=request.getParameter("account");
        password=request.getParameter("password");
        String password_confirm=request.getParameter("password_Confirm");

        if(password.equals(password_confirm)){
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        doPost(request,response);
    }
}
