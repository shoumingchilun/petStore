package com.chilun.petStore.dao.specialDAO;

import com.chilun.petStore.dao.BaseDAO;
import com.chilun.petStore.pojo.CartItem;


/**
 * @author cqy
 * @time 2022.10.30 10:26
 * 购物车项目类
 */

public class CartItemDAO extends BaseDAO<CartItem> {
    //根据petID获得对应具体购物车项目类
    public CartItem getCartItemById(long id) {
        return super.load("select *from cartitems where petID = ?", id);
    }

    //根据CartItem添加购物车项目
    public void addCartItem(CartItem cartItem) {
        String sql = "insert into cartitems values(?,0,?,?)";
        super.executeUpdate(sql,cartItem.getPetID(),cartItem.getUserID(),cartItem.getNum());
    }
    //删除购物车项目
    public void deleteCartItem(long id) {
        String sql = "delete *from cartitems where petID = ?";
        super.executeUpdate(sql,id);
    }
    //根据id更新购物车信息
    public void updateCartItemById(CartItem newCartItem) {
        String sql = "update cariitems set petID = ? , num = ? where UserID = ? ";
        super.executeUpdate(sql,newCartItem.getPetID(),newCartItem.getUserID(),newCartItem.getNum());
    }
    public void Numminusone(CartItem cartItem){
        int newnum = cartItem.getNum();
        newnum--;
        cartItem.setNum(newnum);
    }
}

