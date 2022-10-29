package com.chilun.petStore.pojo;

/**
 * @auther 齿轮
 * @create 2022-10-26-16:01
 * 已完成交易类
 */
public class Transaction {
    private long UserId;
    private String specificInfo;

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
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

    public Transaction(long userId, String specificInfo) {
        UserId = userId;
        this.specificInfo = specificInfo;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "UserId=" + UserId +
                ", specificInfo='" + specificInfo + '\'' +
                '}';
    }
}
