package com.cloudplus.tool.core.constant;

import java.io.Serializable;

/**
 * 分页请求参数
 */
public class PageRequest implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
    private String orderBy;
    private Boolean asc;

    // 默认构造函数
    public PageRequest() {
        this.pageNum = 1;
        this.pageSize = 10;
        this.asc = true;
    }

    // 带参数构造函数
    public PageRequest(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum != null ? pageNum : 1;
        this.pageSize = pageSize != null ? pageSize : 10;
        this.asc = true;
    }

    // Getter和Setter方法
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Boolean getAsc() {
        return asc;
    }

    public void setAsc(Boolean asc) {
        this.asc = asc;
    }
}