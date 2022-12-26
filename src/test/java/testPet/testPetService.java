package testPet;

import com.chilun.petStore.dao.SelectInfo;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.service.PetService;
import com.chilun.petStore.view.Page;
import org.junit.Test;

import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-10-30-18:19
 */
public class testPetService {
    PetService service = new PetService();
    @Test
    public void testGetPage(){
        Page<Pet> page = service.getPage(new SelectInfo(1, 0, 10000));
        System.out.println(page.getNumOfAllItem());
        page.getList().forEach(System.out::println);
    }
    @Test
    public void testGetAllPet(){
        service.getAllPet(null).forEach(System.out::println);
        System.out.println();
        service.getAllPet(1).forEach(System.out::println);
    }
    @Test
    public void test(){
        PetService petService=new PetService();
        //将各个物种保存在petList0、1、2、3...
        for(int i=0;i<5;i++){
            List<Pet> petList=petService.getAllPet(i);
            String str="petList"+i;
            System.out.println(petList);
        }

    }

    @Test
    public void testGetLike(){
        PetService petService = new PetService();
        System.out.println(petService.getLikedName("蟋"));
    }
}
