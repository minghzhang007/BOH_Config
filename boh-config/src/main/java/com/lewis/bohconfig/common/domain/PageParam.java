package com.lewis.bohconfig.common.domain;

/**
 * Created by Administrator on 2017/1/14.
 */
public class PageParam {

    private Integer startIndex;

    private Integer numberPerPage;

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getNumberPerPage() {
        return numberPerPage;
    }

    public void setNumberPerPage(Integer numberPerPage) {
        this.numberPerPage = numberPerPage;
    }

    public PageParam(Integer startIndex, Integer numberPerPage) {
        this.startIndex = startIndex;
        this.numberPerPage = numberPerPage;
    }

    public PageParam() {
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "startIndex=" + startIndex +
                ", numberPerPage=" + numberPerPage +
                '}';
    }
}
