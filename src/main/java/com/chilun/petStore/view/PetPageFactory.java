package com.chilun.petStore.view;

import com.chilun.petStore.dao.SearchAndSelectInfo;
import com.chilun.petStore.dao.SelectInfo;
import com.chilun.petStore.dao.specialDAO.PetDAO;
import com.chilun.petStore.pojo.Pet;

import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-10-26-15:24
 */
public class PetPageFactory {
    public Page<Pet> createPage(int pageNo) {
        Page<Pet> page = new Page<Pet>(pageNo);
        return page;
    }

    public Page<Pet> createPageByInfo(SelectInfo info, PetDAO dao) {
        Page<Pet> page = new Page<Pet>();
        List<Pet> list = dao.getSelectPet(info);
        page.setPageNo(info.getPageNo());
        page.setList(list);
        page.setNumOfAllItem((int) dao.getNumOfSelectPet(info));
        return page;
    }

    public Page<Pet> createPageBySearchInfo(SearchAndSelectInfo info,PetDAO dao){
        Page<Pet> page = new Page<Pet>();
        List<Pet> list = dao.getSearchPet(info);
        page.setPageNo(info.getPageNo());
        page.setList(list);
        page.setNumOfAllItem((int) dao.getNumOfSelectPet(info));
        return page;
    }
}
