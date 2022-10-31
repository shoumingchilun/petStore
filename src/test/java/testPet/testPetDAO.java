package testPet;

import com.chilun.petStore.dao.SearchAndSelectInfo;
import com.chilun.petStore.dao.SelectInfo;
import com.chilun.petStore.dao.specialDAO.PetDAO;
import com.chilun.petStore.pojo.Pet;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @auther 齿轮
 * @create 2022-10-29-20:18
 */
public class testPetDAO {
    PetDAO petDAO = new PetDAO();

    @Test
    public void testGetById() {
        Pet pet = petDAO.getPetById(1);
        System.out.println(pet);
    }

    @Test
    public void testAdd() {
        Pet pet = new Pet(0, 1, "小狗2号", "无", "无", new BigDecimal("12.23"), 23);
        petDAO.addPet(pet);
    }

    @Test
    public void testUpdate() {
        Pet pet = new Pet(5, 2, "小猪4号", "无", "无", new BigDecimal("192.23"), 23);
        petDAO.updatePetById(pet);
    }

    @Test
    public void testSelectByInfo() {
        //测试基本功能
//        SelectInfo info = new SelectInfo(0,10,50);
//        petDAO.getSelectPet(info).forEach(System.out::println);
//
//        info = new SelectInfo(1,50,200);
//        petDAO.getSelectPet(info).forEach(System.out::println);
//
//        info = new SelectInfo(0,50,200,0);
//        petDAO.getSelectPet(info).forEach(System.out::println);
        //测试分页功能
        SelectInfo info = new SelectInfo(0, 0, 10000);
        petDAO.getSelectPet(info).forEach(System.out::println);
        System.out.println();
        SelectInfo info2 = new SelectInfo(1, 0, 10000);
        petDAO.getSelectPet(info2).forEach(System.out::println);
    }

    @Test
    public void testNum(){
        SelectInfo info2 = new SelectInfo(1, 1000, 10000);
        System.out.println(petDAO.getNumOfSelectPet(info2));
    }

    @Test
    public void testSearch(){
        SearchAndSelectInfo info2 = new SearchAndSelectInfo(0, 0, 10000,1,"小");
        petDAO.getSearchPet(info2).forEach(System.out::println);
    }
}