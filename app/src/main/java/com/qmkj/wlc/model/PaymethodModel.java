package com.qmkj.wlc.model;

/**
 * author：rongkui.xiao --2018/6/20
 * email：dovexiaoen@163.com
 * description:
 */

public class PaymethodModel {
    public String name;
    public boolean isSelect;

    public PaymethodModel(String name, boolean isSelect) {
        this.name = name;
        this.isSelect = isSelect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
