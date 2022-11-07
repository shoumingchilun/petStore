package com.chilun.petStore.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-10-26-15:51
 * 购物车类
 */
public class Cart {
    private int userID;
    private HashMap<Pet,Integer> Pets;
    private BigDecimal totalPrice;

    public Cart() {
    }
}
