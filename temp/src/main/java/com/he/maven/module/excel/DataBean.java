package com.he.maven.module.excel;

import java.util.List;

/**
 * Created by heyanjing on 2017/12/1 16:18.
 */
public class DataBean {
    public List<?> dataList;
    public List<Title> titleList;

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }

    public List<Title> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<Title> titleList) {
        this.titleList = titleList;
    }

    public DataBean(List<?> dataList, List<Title> titleList) {

        this.dataList = dataList;
        this.titleList = titleList;
    }

    public DataBean() {

    }
}
