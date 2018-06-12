package com.qmkj.wlc.model;

import com.qmkj.wlc.net.BaseResponse;

/**
 * 创建日期：2018/6/12
 * @author Yi Shan Xiang
 * 文件名称： 助客信息已选商品实体类
 * email: 380948730@qq.com
 */

public class HelpCustomerGoodsDetailsRes extends BaseResponse{
    private int buy_number = 0;

    public int getBuy_number() {
        return buy_number;
    }

    public void setBuy_number(int buy_number) {
        this.buy_number = buy_number;
    }
}
