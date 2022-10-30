package testPet;

import com.chilun.petStore.dao.SelectInfo;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.service.PetService;
import com.chilun.petStore.view.Page;
import org.junit.Test;

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
}
