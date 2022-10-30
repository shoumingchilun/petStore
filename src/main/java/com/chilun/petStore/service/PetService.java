package com.chilun.petStore.service;

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
    private PetDAO dao = new PetDAO();;

//根据选择条件获得对应的宠物页
    public Page<Pet> getPage(SelectInfo info){
        PetPageFactory factory = new PetPageFactory();
        Page<Pet> page = factory.createPageByInfo(info,dao);
        return page;
    }

}
