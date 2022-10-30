package com.chilun.petStore.controller;

import com.chilun.petStore.dao.SelectInfo;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.view.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @auther 齿轮
 * @create 2022-10-30-16:45
 */
public class selectPetsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNoStr = req.getParameter("pageNo");
        String minPriceStr = req.getParameter("minPrice");
        String maxPriceStr = req.getParameter("maxPrice");
        String speciesStr = req.getParameter("species");

        int pageNo = 1;
        BigDecimal minPrice = new BigDecimal("0");
        BigDecimal maxPrice = new BigDecimal(Integer.MAX_VALUE);
        Integer species = null;


        try {
            pageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {
        }
        try {
            minPrice = new BigDecimal(minPriceStr);
        } catch (NumberFormatException e) {
        }
        try {
            maxPrice = new BigDecimal(maxPriceStr);
        } catch (NumberFormatException e) {
        }
        SelectInfo info = new SelectInfo(pageNo,minPrice.floatValue(),maxPrice.floatValue());
        if (species != null) {
            species = Integer.parseInt(speciesStr);
            info = new SelectInfo(pageNo,minPrice.floatValue(),maxPrice.floatValue(),species);
        }

//        Page<Pet> page = bookService.getPage(criteriaBook);
//
//        request.setAttribute("bookpage", page);
//
//        request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
