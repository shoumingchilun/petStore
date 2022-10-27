package com.chilun.petStore.pojo;

/**
 * @auther 齿轮
 * @create 2022-10-26-15:54
 * 购物车内具体条目数据
 */
public class CartItem {
    private int petID;
    private int userID;
    private int num;

    public CartItem() {
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public CartItem(int petID, int userID, int num) {
        this.petID = petID;
        this.userID = userID;
        this.num = num;
    }
}
