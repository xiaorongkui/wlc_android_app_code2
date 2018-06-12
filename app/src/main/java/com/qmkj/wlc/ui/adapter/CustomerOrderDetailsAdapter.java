package com.qmkj.wlc.ui.adapter;

import android.content.Context;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CustomerOrderDetailsRes;
import com.qmkj.wlc.model.CustomerOrderRes;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * 创建日期：2018/6/12
 * @author Yi Shan Xiang
 * 文件名称：客人点单详情适配器
 * email: 380948730@qq.com
 */
public class CustomerOrderDetailsAdapter extends XBaseAdapter<CustomerOrderDetailsRes>{

    public CustomerOrderDetailsAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.customer_order_details_adapter;
    }


    @Override
    protected void convert(XBaseViewHolder helper, CustomerOrderDetailsRes item) {

    }
}
