package com.chilun.petStore.controller;

import com.chilun.petStore.dao.specialDAO.TransactionDAO;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.pojo.Transaction;
import com.chilun.petStore.pojo.User;
import com.chilun.petStore.service.PetService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BuyServlet extends HttpServlet {
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
        Set<Pet> keys=new HashSet<>(cart.keySet());
            for(Pet key1:keys) {
                if (key1.getPetID() == petID)
                    cart.remove(key1);
            }

        b.setAmount(newamount-NumOfBuy);
        ps.getDao().updatePetById(b);

        User user = (User) request.getSession().getAttribute("user");
//        System.out.println(user.getUserID());
        TransactionDAO transactionDAO = new TransactionDAO();

        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        String string = "您在"+df.format(day)+"购买了"+b.getName()+NumOfBuy+"只";
        Transaction transaction = new Transaction(user.getUserID(), string);
        transactionDAO.addTransaction(transaction);
        request.getRequestDispatcher("/CartServlet").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
