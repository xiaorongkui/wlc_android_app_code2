package com.qmkj.wlc.model;

/**
 * author：rongkui.xiao --2018/6/20
 * email：dovexiaoen@163.com
 * description:
 */

public class StoreManagerModel {
    public int resId;
    public String name;

    public StoreManagerModel(int resId, String name) {
        this.resId = resId;
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
