package com.chilun.petStore.controller;

import com.chilun.petStore.dao.specialDAO.PetDAO;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.service.PetService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class addCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int petID = Integer.parseInt(req.getParameter("petID"));
        int NumOfBuy = Integer.parseInt(req.getParameter("NumOfBuy"));
        PetService pet = new PetService();
        Pet i = pet.getPetByID(petID);
        HttpSession session = req.getSession();


        Map<Pet,Integer> cart=(ConcurrentHashMap<Pet, Integer>)session.getAttribute("cart");
        if(cart==null){
            cart = new ConcurrentHashMap<Pet,Integer>();
        }
        if(cart!=null){
            cart.put(i,NumOfBuy);
        }
        session.setAttribute("cart",cart);

        String from = req.getParameter("from");
        if(from.equals("select")) resp.sendRedirect("/select?back=true");
        else resp.sendRedirect("/main");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
