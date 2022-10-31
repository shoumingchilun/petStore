package com.chilun.petStore.dao.specialDAO;

import com.chilun.petStore.dao.BaseDAO;
import com.chilun.petStore.pojo.Cart;

import java.math.BigDecimal;

public class CartDAO extends BaseDAO<Cart> {
    public BigDecimal getTotalPrice(Cart cart){
        return cart.getTotalPrice();
    }
}
