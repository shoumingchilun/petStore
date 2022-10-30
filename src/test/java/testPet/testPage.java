package testPet;

import com.chilun.petStore.dao.SelectInfo;
import com.chilun.petStore.pojo.Pet;
import com.chilun.petStore.service.PetService;
import com.chilun.petStore.view.Page;
import org.junit.Test;

/**
 * @auther 齿轮
 * @create 2022-10-30-19:24
 */
public class testPage {
    PetService service = new PetService();
    @Test
    public void testPage(){
        Page<Pet> page = service.getPage(new SelectInfo(0, 0, 10000));
        System.out.println(page.isHasNext());
        System.out.println(page.isHasPrev());
    }
}
