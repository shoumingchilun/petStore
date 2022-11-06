package com.chilun.petStore.controller;

import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.service.PetService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class ChangeNumServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int petID = Integer.parseInt(request.getParameter("petID"));
        int NumOfBuy = Integer.parseInt(request.getParameter("NumOfBuy"));

        HttpSession session = request.getSession();
        Map<Pet, Integer> cart = (Map<Pet, Integer>) session.getAttribute("cart");
        PetService ps=new PetService();
        Pet b=ps.getPetByID(petID);
        //如果商品数据为0，就删除对象
        if(NumOfBuy==0) {
            cart.clear();
        }else {
            cart.clear();
            cart.put(b,NumOfBuy);
        }

        request.getRequestDispatcher("/CartServlet").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
