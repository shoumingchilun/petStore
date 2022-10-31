package com.chilun.petStore.service;

import com.chilun.petStore.dao.SearchAndSelectInfo;
import com.chilun.petStore.dao.SelectInfo;
import com.chilun.petStore.dao.specialDAO.PetDAO;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.view.Page;
import com.chilun.petStore.view.PetPageFactory;

/**
 * @auther 齿轮
 * @create 2022-10-30-17:54
 */
public class PetService {
    private PetDAO dao = new PetDAO();

    public PetDAO getDao() {
        return dao;
    }

    //根据选择条件获得对应的宠物页
    public Page<Pet> getPage(SelectInfo info) {
        PetPageFactory factory = new PetPageFactory();
        Page<Pet> page = factory.createPageByInfo(info, dao);
        return page;
    }

    //根据搜索条件获得对应的宠物页
    public Page<Pet> getPageBySearch(SearchAndSelectInfo info) {
        PetPageFactory factory = new PetPageFactory();
        Page<Pet> page = factory.createPageBySearchInfo(info, dao);
        return page;
    }

    //根据PetID获得对应的宠物类
    public Pet getPetByID(long Pet){
        return dao.getPetById(Pet);
    }
}
