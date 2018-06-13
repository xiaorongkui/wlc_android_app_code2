package com.qmkj.wlc.model;

/**
 * author：rongkui.xiao --2018/6/13
 * email：dovexiaoen@163.com
 * description:
 */

public class CommodityManagerLeftModel {
    boolean isSelect;
    public String productName;

    public CommodityManagerLeftModel(String productName) {
        this.productName = productName;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
