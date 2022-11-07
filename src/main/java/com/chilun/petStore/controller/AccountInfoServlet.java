package com.chilun.petStore.controller;

import com.chilun.petStore.pojo.User;
import com.chilun.petStore.service.UserService;
import org.junit.Test;
import org.junit.runner.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Objects;

/**
 * @author 皮皮皮
 * @date 2022/11/5 0:39
 */
public class AccountInfoServlet extends HttpServlet {
    private String name;
    private String address;
    private String email;
    private String password;
    private String account;
    private String phone;
    private String pets_love;

    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getSession().getAttribute("user")!=null){
            name=req.getParameter("name");
            password=req.getParameter("password");
//            account=req.getParameter("account");  //info里不能修改account
            address=req.getParameter("province")+req.getParameter("city")+req.getParameter("region");
            email=req.getParameter("email");
            phone=req.getParameter("phone");
            pets_love=req.getParameter("pets_love");
            userService=new UserService();

            User user0=(User)req.getSession().getAttribute("user");
            User user=new User();
            user.setAccount(user0.getAccount());
            user.setPassword(password);
            user.setName(name);
            user.setAddress(address);

            userService.updatePsw(user);
            req.getSession().setAttribute("user",user);

            resp.sendRedirect("main");
        }else{
            req.getRequestDispatcher("login").forward(req,resp);
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
