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
import java.util.Map;

/**
 * @auther 齿轮
 * @create 2022-10-30-21:40
 */
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int petID = Integer.parseInt(req.getParameter("petID"));
        User user = (User) req.getSession().getAttribute("user");
        int NumOfBuy = Integer.parseInt(req.getParameter("NumOfBuy"));

        CartItem cartItem = new CartItem(petID, (int) user.getUserID(),NumOfBuy);
        CartItemDAO cartItemDAO = new CartItemDAO();
        cartItemDAO.addCartItem(cartItem);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String gotoMain = req.getParameter("gotoMain");
        String buyNow = req.getParameter("BuyNow");

        if (buyNow != null) {
            req.getRequestDispatcher("/WEB-INF/cartJsp/order.jsp").forward(req, resp);
        }
        else if (gotoMain != null) {
            resp.sendRedirect("/main");
        } else
            req.getRequestDispatcher("/WEB-INF/cartJsp/cart.jsp").forward(req, resp);
    }
}
