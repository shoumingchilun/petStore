package com.chilun.petStore.controller;

import com.chilun.petStore.dao.specialDAO.UserDAO;
import com.chilun.petStore.pojo.User;
import com.chilun.petStore.service.UserService;
import org.testng.annotations.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 皮皮皮
 * @date 2022/10/31 11:24
 */
@WebServlet(name="RegisterServlet" ,urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService=new UserService();
    private User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String password_confirm=request.getParameter("password_Confirm");
        String checkCode=request.getParameter("checkCode");

        //先判断验证码是否正确
        if(request.getSession().getAttribute("code").equals(checkCode)){
            //判断账户是否已经存在
            if(userService.isExist(account)){

                request.setAttribute("msg","该账户名已存在!");
                request.getRequestDispatcher("Register.jsp").forward(request,response);
            }else if(password.equals(password_confirm)){
                //判断两次密码是否一致，如果一致，数据库增加用户
                user=new User();
                user.setAccount(account);
                user.setPassword(password);
                user.setName("p");
                //name栏不能为空    构造方法   注销账号(UserDao)删除
                userService.add(user);

                String msg="~欢迎"+account+"小主加入宠物商店~";
                request.getSession().setAttribute("msg",msg);
                response.sendRedirect("login.jsp");
            }else{
                request.setAttribute("msg","密码不一致，请重新输入");
                request.getRequestDispatcher("Register.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("msg","验证码错误");
            request.getRequestDispatcher("Register.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
