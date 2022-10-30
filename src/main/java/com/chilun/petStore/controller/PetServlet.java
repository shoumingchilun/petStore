package com.chilun.petStore.controller;

import com.chilun.petStore.dao.specialDAO.PetDAO;
import com.chilun.petStore.pojo.Pet;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String petIDStr = req.getParameter("petID");
        long petID = 0;
        try {
            if (petIDStr!=null)
                petID = Integer.parseInt(petIDStr);
        } catch (NumberFormatException e) {
        }
        Page<Pet> page = (Page<Pet>) req.getSession().getAttribute("page");
        Pet pet = null;
        for (Pet pet1: page.getList()){
            if (pet1.getPetID()==petID){
                pet = pet1;
                break;
            }
        }
        req.setAttribute("pet",pet);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/WEB-INF/Pet/Pet.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
