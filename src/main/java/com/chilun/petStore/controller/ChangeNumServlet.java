package com.chilun.petStore.controller;

import com.chilun.petStore.dao.specialDAO.CartItemDAO;
import com.chilun.petStore.pojo.CartItem;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.pojo.User;
import com.chilun.petStore.service.PetService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class ChangeNumServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int petID = Integer.parseInt(request.getParameter("petID"));
        int NumOfBuy = Integer.parseInt(request.getParameter("NumOfBuy"));

        HttpSession session = request.getSession();
        Map<Pet, Integer> cart = (ConcurrentHashMap<Pet, Integer>) session.getAttribute("cart");
        PetService ps=new PetService();
        Pet b=ps.getPetByID(petID);
        long newamount = b.getAmount();
        //如果商品数据为0，就删除对象
        if(NumOfBuy==0)
        {
            Set<Pet> keys=new HashSet<>(cart.keySet());
            for(Pet key1:keys){
                if(key1.getPetID()==petID)
                cart.remove(key1);
            }
        }
        else if(NumOfBuy >0){
            Set<Pet> keys=new HashSet<>(cart.keySet());
            for(Pet key1:keys){
                if(key1.getPetID()==petID)
                    cart.remove(key1);
            }
            cart.put(b,NumOfBuy);
        }
        b.setAmount(newamount-NumOfBuy);
        ps.getDao().updatePetById(b);
        request.getRequestDispatcher("/CartServlet").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
