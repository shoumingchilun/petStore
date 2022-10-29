package com.chilun.petStore.dao.specialDAO;

import com.chilun.petStore.dao.BaseDAO;
import com.chilun.petStore.pojo.User;

/**
 * @auther 齿轮
 * @create 2022-10-27-21:31
 */
public class UserDAO extends BaseDAO<User> {
    //根据用户账户account获得具体类
    public User getUserByAcc(String acc){
        return super.load("select * from users where account = ?",acc);
    }
    //根据User添加新用户
    public void addUser(User user){
        if (getUserByAcc(user.getAccount())!=null){
            System.out.println("重复添加");
            return;
        }
        String sql = "insert into users values(0,?,?,?,?)";
        super.executeUpdate(sql,user.getName(),user.getAddress(),user.getPassword(),user.getAccount());
    }

    //根据id修改账户信息
    public void updateUserById(User newUser){
        String sql = "update users set name = ? , address = ? , password = ? , account = ? where userID = ? " ;
        super.executeUpdate(sql,newUser.getName(),newUser.getAddress(),newUser.getPassword(),newUser.getAccount(),newUser.getUserID());
    }
}
