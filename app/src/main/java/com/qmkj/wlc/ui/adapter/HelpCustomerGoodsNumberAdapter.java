package com.qmkj.wlc.ui.adapter;

import android.content.Context;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CustomerOrderRes;
import com.qmkj.wlc.model.HelpCustomerGoodsNumberRes;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * 创建日期：2018/6/12
 * @author Yi Shan Xiang
 * 文件名称：助客点单商品名称商品名称适配器
 * email: 380948730@qq.com
 */
public class HelpCustomerGoodsNumberAdapter extends XBaseAdapter<HelpCustomerGoodsNumberRes>{

    public HelpCustomerGoodsNumberAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.help_customer_goods_number_adapter;
    }


    @Override
    protected void convert(XBaseViewHolder helper, HelpCustomerGoodsNumberRes item) {

    }
}
