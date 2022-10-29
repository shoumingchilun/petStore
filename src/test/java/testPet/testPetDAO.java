package testPet;

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
    public void testGetById(){
        Pet pet = petDAO.getPetById(1);
        System.out.println(pet);
    }
    @Test
    public void testAdd(){
        Pet pet = new Pet(0,1,"小狗2号","无","无",new BigDecimal("12.23"),23);
        petDAO.addPet(pet);
    }
    @Test
    public void testUpdate(){
        Pet pet = new Pet(4,2,"小鸟3号","无","无",new BigDecimal("192.23"),23);
        petDAO.updatePetById(pet);
    }
    @Test
    public void testSelectByInfo(){
        SelectInfo info = new SelectInfo(0,10,50);
        petDAO.getSelectPet(info).forEach(System.out::println);

        info = new SelectInfo(0,50,200);
        petDAO.getSelectPet(info).forEach(System.out::println);

        info = new SelectInfo(0,50,200,0);
        petDAO.getSelectPet(info).forEach(System.out::println);
    }
}
