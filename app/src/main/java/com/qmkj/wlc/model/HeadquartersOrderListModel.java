package com.qmkj.wlc.model;

/**
 * author：rongkui.xiao --2018/6/13
 * email：dovexiaoen@163.com
 * description:
 */

public class HeadquartersOrderListModel {
    public String name;
    public int amount;

    public HeadquartersOrderListModel(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
