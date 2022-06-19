package com.web.news.pojo;

import java.util.List;

public class PageResult {
    private List rows;//分页区间数
    private Long total;//总记录数

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}