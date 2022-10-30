package com.chilun.petStore.view;

import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-10-26-15:19
 * <p>
 * 本类用于封装翻页信息
 * pageNo从0开始计数
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

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    //有无下页、上页判断
    public boolean isHasNext() {
        return getPageNo()+1 < getNumOfPage();
    }

    public boolean isHasPrev() {
        return getPageNo() > 0;
    }

    //获得上页、下页
    public int getPrevPageNo() {
        return isHasPrev() ? getPageNo() - 1 : getPageNo();
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", numOfAllItem=" + numOfAllItem +
                ",hasNext="+isHasNext()+
                ",hasPrev="+isHasPrev()+
                ",应该显示的页数="+(pageNo+1)+
                '}';
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

    public Page() {
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
        if (pageNo < 0) pageNo = 0;
        else if (pageNo > getNumOfPage()-1) pageNo = getNumOfPage()-1;
        return pageNo;
    }

    public int getSize() {
        return size;
    }

    public int getNumOfPage() {
        return numOfAllItem / size + (numOfAllItem % size != 0 ? 1 : 0);
    }
}
