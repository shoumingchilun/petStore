package com.chilun.petStore.pojo;

/**
 * @auther 齿轮
 * @create 2022-10-26-15:50
 * 用户类
 */
public class User {
    private int userID;
    private String name;
    private String address;
    private Cart cart;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int userID, String name, String address, Cart cart) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.cart = cart;
    }
}
