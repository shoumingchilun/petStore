package com.chilun.petStore.controller;

import com.chilun.petStore.dao.SelectInfo;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.service.PetService;
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
    PetService service = new PetService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNoStr = req.getParameter("pageNo");
        String minPriceStr = req.getParameter("minPrice");
        String maxPriceStr = req.getParameter("maxPrice");
        String speciesStr = req.getParameter("species");
        Page<Pet> page = (Page<Pet>) req.getAttribute("page");

        int showPageNo = 1;
        BigDecimal minPrice = new BigDecimal("0");
        BigDecimal maxPrice = new BigDecimal(Integer.MAX_VALUE);
        Integer species = null;

        try {
            if (pageNoStr != null)
                showPageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {
        }
        try {
            if (minPriceStr != null)
                minPrice = new BigDecimal(minPriceStr);
        } catch (NumberFormatException e) {
        }
        try {
            if (maxPriceStr != null)
                maxPrice = new BigDecimal(maxPriceStr);
        } catch (NumberFormatException e) {
        }

        if (showPageNo < 1) showPageNo = 1;
        if (page != null)
            if (showPageNo > page.getNumOfPage() + 1) showPageNo = page.getNumOfPage() + 1;

        SelectInfo info = new SelectInfo(showPageNo - 1, minPrice.floatValue(), maxPrice.floatValue());
        if (speciesStr != null) {
            System.out.println("进入物种筛选");
            try {
                species = Integer.parseInt(speciesStr);
            } catch (NumberFormatException e) {
            }
            info = new SelectInfo(showPageNo - 1, minPrice.floatValue(), maxPrice.floatValue(), species);
        }

        page = service.getPage(info);

        System.out.println(page);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/WEB-INF/selectPet/selectPet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
