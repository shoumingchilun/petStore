package com.chilun.petStore.pojo;

/**
 * @auther 齿轮
 * @create 2022-10-26-16:01
 * 已完成交易类
 */
public class Transaction {
    private int UserId;
    private String specificInfo;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public Transaction() {
    }

    public String getSpecificInfo() {
        return specificInfo;
    }

    public void setSpecificInfo(String specificInfo) {
        this.specificInfo = specificInfo;
    }

    public Transaction(int userId, String specificInfo) {
        UserId = userId;
        this.specificInfo = specificInfo;
    }
}
