package com.chilun.petStore.dao;

/**
 * @auther 齿轮
 * @create 2022-10-31-10:33
 */
public class SearchAndSelectInfo extends SelectInfo {
    String searchStr = "";

    public SearchAndSelectInfo(int pageNo, float minPrice, float maxPrice) {
        super(pageNo, minPrice, maxPrice);
    }

    public SearchAndSelectInfo(int pageNo, float minPrice, float maxPrice, Integer species) {
        super(pageNo, minPrice, maxPrice, species);
    }

    public SearchAndSelectInfo(int pageNo, float minPrice, float maxPrice, String searchStr) {
        super(pageNo, minPrice, maxPrice);
        this.searchStr = searchStr;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public SearchAndSelectInfo(int pageNo, float minPrice, float maxPrice, Integer species, String searchStr) {
        super(pageNo, minPrice, maxPrice, species);
        this.searchStr = searchStr;
    }
}
