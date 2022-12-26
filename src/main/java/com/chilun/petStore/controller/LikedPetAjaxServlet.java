package com.chilun.petStore.controller;

import com.chilun.petStore.service.PetService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-12-26-9:14
 */
public class LikedPetAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //获取搜索框输入的内容
        String name=request.getParameter("name");
//        name=new String(name.getBytes("iso-8859-1"), "utf-8");
        //向server层调用相应的业务
        PetService petService = new PetService();
        String res=petService.getLikedName(name);
        System.out.println(name+res);
        //返回结果
        response.getWriter().write(res);
    }
}
