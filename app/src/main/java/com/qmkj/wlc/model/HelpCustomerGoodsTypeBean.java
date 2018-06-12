package com.qmkj.wlc.model;

/**
 * 创建日期：2018/6/12
 * @author Yi Shan Xiang
 * 文件名称： 助客点单界面商品信息类别
 * email: 380948730@qq.com
 */

public class HelpCustomerGoodsTypeBean{
    private boolean isSelect; //是否被选择
    private String typeName;  //类别名称

    public HelpCustomerGoodsTypeBean( String typeName,boolean isSelect) {
        this.isSelect = isSelect;
        this.typeName = typeName;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
