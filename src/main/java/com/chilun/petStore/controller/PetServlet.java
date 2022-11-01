package com.chilun.petStore.controller;

import com.chilun.petStore.dao.specialDAO.PetDAO;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.service.PetService;
import com.chilun.petStore.view.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther 齿轮
 * @create 2022-10-30-21:45
 */
public class PetServlet extends HttpServlet {
    PetService service = new PetService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获得对应PetID
        String petIDStr = req.getParameter("petID");
        long petID = 0;
        try {
            if (petIDStr!=null)
                petID = Integer.parseInt(petIDStr);
        } catch (NumberFormatException e) {
        }
        //2.获得对应Pet实例并加载到req中
        Pet pet = service.getPetByID(petID);
        req.setAttribute("pet",pet);
        //3.判断来源是select还是首页main
        String from = req.getParameter("from");
        if ("select".equals(from)){
            req.setAttribute("from","select");
        }else if("main".equals(from)){
            req.setAttribute("from","main");
        }
        req.getRequestDispatcher("/WEB-INF/Pet/Pet.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
