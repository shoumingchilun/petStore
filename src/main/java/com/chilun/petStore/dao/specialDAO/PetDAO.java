package com.chilun.petStore.dao.specialDAO;

import com.chilun.petStore.dao.BaseDAO;
import com.chilun.petStore.dao.SearchAndSelectInfo;
import com.chilun.petStore.dao.SelectInfo;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.pojo.User;
import org.junit.Test;

import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-10-29-19:49
 */
public class PetDAO extends BaseDAO<Pet> {
    //根据petID获得对应具体宠物类
    public Pet getPetById(long id) {
        return super.load("select *from pets where petID = ?", id);
    }

    //根据Pet添加新宠物
    public void addPet(Pet pet) {
        String sql = "insert into pets values(0,?,?,?,?,?,?)";
        super.executeUpdate(sql, pet.getSpecies(), pet.getName(), pet.getDescription(), pet.getPicture(), pet.getPrices(), pet.getAmount());
    }

    //根据id修改宠物信息
    public void updatePetById(Pet newPet) {
        String sql = "update pets set species = ? , Name = ? , description = ? , picture = ? , prices = ? , amount = ? where petID = ? ";
        super.executeUpdate(sql, newPet.getSpecies(), newPet.getName(), newPet.getDescription(), newPet.getPicture(), newPet.getPrices(), newPet.getAmount(), newPet.getPetID());
    }

    //根据SelectInfo获得符合条件的petList
    public List<Pet> getSelectPet(SelectInfo info) {
        String sql = "select * from pets where ";
        if (info.getSpecies() != null) {
            sql += "species = ? && prices <= ? && prices >= ? LIMIT ? , 5";
            return super.executeQuery(sql, info.getSpecies(), info.getMaxPrice(), info.getMinPrice(), info.getPageNo() * 5);
        } else {
            sql += "prices <= ? && prices >= ? LIMIT ? , 5";
            return super.executeQuery(sql, info.getMaxPrice(), info.getMinPrice(), info.getPageNo() * 5);
        }
    }

    //根据selecctInfo获得宠物，无page信息
    public List<Pet> getSelectPetWithoutPage(SelectInfo info) {
        String sql = "select * from pets where ";
        if (info.getSpecies() != null) {
            sql += "species = ? && prices <= ? && prices >= ?";
            return super.executeQuery(sql, info.getSpecies(), info.getMaxPrice(), info.getMinPrice());
        } else {
            sql += "prices <= ? && prices >= ?";
            return super.executeQuery(sql, info.getMaxPrice(), info.getMinPrice());
        }
    }

    @Test
    public void test() {
        List petList = getOrderOfSelectPet();
        System.out.println(petList);
    }

    //根据SelectInfo获得符合条件的宠物数量
    public long getNumOfSelectPet(SelectInfo info) {
        String sql = "select count(*) from pets where ";
        if (info.getSpecies() != null) {
            sql += "species = ? && prices <= ? && prices >= ? ";
            return (long) super.executeComplexQuery(sql, info.getSpecies(), info.getMaxPrice(), info.getMinPrice())[0];
        } else {
            sql += "prices <= ? && prices >= ? ";
            return (long) super.executeComplexQuery(sql, info.getMaxPrice(), info.getMinPrice())[0];
        }
    }

    //根据search的字符串获得名称相似的Pet的List
    public List<Pet> getSearchPet(SearchAndSelectInfo info) {
        String sql = "select * from pets where name like CONCAT('%',?,'%') and ";
        if (info.getSpecies() != null) {
            sql += "species = ? && prices <= ? && prices >= ? LIMIT ? , 5";
            return super.executeQuery(sql, info.getSearchStr(), info.getSpecies(), info.getMaxPrice(), info.getMinPrice(), info.getPageNo() * 5);
        } else {
            sql += "prices <= ? && prices >= ? LIMIT ? , 5";
            return super.executeQuery(sql, info.getSearchStr(), info.getMaxPrice(), info.getMinPrice(), info.getPageNo() * 5);
        }
    }

    //根据searchInfo获得符合条件的宠物数量
    public long getNumOfSelectPet(SearchAndSelectInfo info) {
        String sql = "select count(*) from pets where name like CONCAT('%',?,'%') and ";
        if (info.getSpecies() != null) {
            sql += "species = ? && prices <= ? && prices >= ? ";
            return (long) super.executeComplexQuery(sql, info.getSearchStr(), info.getSpecies(), info.getMaxPrice(), info.getMinPrice())[0];
        } else {
            sql += "prices <= ? && prices >= ? ";
            return (long) super.executeComplexQuery(sql, info.getSearchStr(), info.getMaxPrice(), info.getMinPrice())[0];
        }
    }

    //获得宠物列表并将数量为零宠物后置
    public List<Pet> getOrderOfSelectPet() {
        String sql = "select * from pets where amount > 0 union select * from pets where amount = 0";
        return super.executeQuery(sql);
    }

    //根据name进行模糊查询
    public List<Pet> getLikedName(String name){
        String sql = "select * from pets where name like CONCAT('%',?,'%') limit 0,8;";
        return super.executeQuery(sql,name);
    }
}
