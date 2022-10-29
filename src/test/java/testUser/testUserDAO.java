package testUser;

import com.chilun.petStore.dao.specialDAO.UserDAO;
import com.chilun.petStore.pojo.User;
import org.junit.Test;

/**
 * @auther 齿轮
 * @create 2022-10-27-21:51
 */
public class testUserDAO {
    UserDAO dao = new UserDAO();
    @Test
    public void testGet(){
        User user= dao.getUserByAcc("chilun");
        System.out.println(user);
    }

    @Test
    public void testAdd(){
        User user = new User(0,"chilun2","北京","123123","chilun4",null);
        dao.addUser(user);
    }

    @Test
    public void testUpdate(){
        long chilun2 = dao.getUserByAcc("chilun2").getUserID();
        User user = new User(chilun2,"chilun2","浙江","123123","chilun2",null);
        dao.updateUserById(user);
    }
}
