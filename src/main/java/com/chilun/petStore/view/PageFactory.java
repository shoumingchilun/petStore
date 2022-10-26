package com.chilun.petStore.view;

/**
 * @auther 齿轮
 * @create 2022-10-26-15:24
 */
public class PageFactory<T> {
    public Page<T> createPage(int pageNo){
        Page<T> page = new Page<T>(pageNo);
        return page;
    }
}
