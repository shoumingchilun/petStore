package com.chilun.petStore.service;

import com.chilun.petStore.dao.SearchAndSelectInfo;
import com.chilun.petStore.dao.SelectInfo;
import com.chilun.petStore.dao.specialDAO.PetDAO;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.view.Page;
import com.chilun.petStore.view.PetPageFactory;

import java.util.ArrayList;
import java.util.List;

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
    public Pet getPetByID(long Pet) {
        return dao.getPetById(Pet);
    }

    //获得全部宠物
    public List<Pet> getAllPet(Integer species) {
        if (species == null) {
            return dao.getSelectPetWithoutPage(new SelectInfo(0, 0, Integer.MAX_VALUE));
        } else
            return dao.getSelectPetWithoutPage(new SelectInfo(0, 0, Integer.MAX_VALUE, species));
    }

    //获得与名称相似的Pets中存在的名称
    public List<String> getLikedName(String name) {
        List<String> list = new ArrayList<>();
        dao.getLikedName(name).forEach((pet) -> {
            list.add(pet.getName());
        });
        return list;
    }
}
