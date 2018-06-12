package com.qmkj.wlc.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CustomerOrderRes;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * 创建日期：2018/6/12
 * @author Yi Shan Xiang
 * 文件名称：客人点单界面适配器
 * email: 380948730@qq.com
 */
public class CustomerOrderAdapter extends XBaseAdapter<CustomerOrderRes>{

    public CustomerOrderAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.customer_order_adapter;
    }


    @Override
    protected void convert(XBaseViewHolder helper, CustomerOrderRes item) {

    }
}
