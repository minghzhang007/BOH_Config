package com.lewis.bohconfig.common.util;

import java.util.List;

/**
 * Created by zhangminghua on 2017/1/14.
 */
public class Pager<T> {

    private int total;

    private List<T> rows;

    public Pager() {
    }

    public Pager(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
