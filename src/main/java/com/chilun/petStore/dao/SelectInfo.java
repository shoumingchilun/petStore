package com.chilun.petStore.dao;

import java.math.BigDecimal;

/**
 * @auther 齿轮
 * @create 2022-10-26-15:40
 *
 * 封装查询条件：价格、物种、页面
 */
public class SelectInfo {
    private int pageNo;

    //价格
    private float minPrice = 0;
    private float maxPrice = Integer.MAX_VALUE;

    //宠物种类
    private Integer species;

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

    public Integer getSpecies() {
        return species;
    }

    public SelectInfo(int pageNo, float minPrice, float maxPrice) {
        this.pageNo = pageNo;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        species=null;
    }

    public SelectInfo(int pageNo, float minPrice, float maxPrice, Integer species) {
        this.pageNo = pageNo;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.species = species;
    }

    public void setSpecies(int species) {
        this.species = species;
    }
}
