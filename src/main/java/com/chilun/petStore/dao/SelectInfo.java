package com.chilun.petStore.dao;

import java.math.BigDecimal;

/**
 * @auther 齿轮
 * @create 2022-10-26-15:40
 *
 * 封装查询条件
 */
public class SelectInfo {
    private int pageNo;

    //价格
    private float minPrice = 0;
    private float maxPrice = Integer.MAX_VALUE;

    //宠物种类
    private int species = 0;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getSpecies() {
        return species;
    }

    public void setSpecies(int species) {
        this.species = species;
    }
}
