package com.chilun.petStore.view;

import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-10-26-15:19
 * <p>
 * 本类用于封装翻页信息
 */
public class Page<T> {
    //当前页
    private int pageNo;

    //当前页的list
    private List<T> list;

    //每页显示记录数
    private final int size = 5;

    //记录总数
    private int numOfAllItem;

    //有无下页、上页判断
    public boolean isHasNext() {
        return getPageNo() < getNumOfPage();
    }

    public boolean isHasPrev() {
        return getPageNo() > 1;
    }

    //获得上页、下页
    public int getPrevPageNo() {
        return isHasPrev() ? getPageNo() - 1 : getPageNo();
    }

    public int getNextPageNo() {
        return isHasNext() ? getPageNo() + 1 : getPageNo();
    }


    public Page(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getNumOfAllItem() {
        return numOfAllItem;
    }

    public void setNumOfAllItem(int numOfAllItem) {
        this.numOfAllItem = numOfAllItem;
    }

    public int getPageNo() {
        if (pageNo < 1) pageNo = 1;
        else if (pageNo > getNumOfPage()) pageNo = getNumOfPage();
        return pageNo;
    }

    public int getSize() {
        return size;
    }

    public int getNumOfPage() {
        return numOfAllItem / size + numOfAllItem % size != 0 ? 1 : 0;
    }
}
