package com.atguigu.gmall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by clk on 2019/10/23.
 */
public class PmsSearchParam implements Serializable {
    public String getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        this.catalog3Id = catalog3Id;
    }


    private String catalog3Id;

    public String[] getValueId() {
        return valueId;
    }

    public void setValueId(String[] valueId) {
        this.valueId = valueId;
    }

    private String[] valueId;
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
