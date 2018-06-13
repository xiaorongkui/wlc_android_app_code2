package com.qmkj.wlc.ui.adapter;

import android.content.Context;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.HeadquartersOrderListModel;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * author：rongkui.xiao --2018/3/20
 * email：dovexiaoen@163.com
 * description:总部订单商品列表
 */

public class HeadquartersOrderRecyAdapter extends XBaseAdapter<HeadquartersOrderListModel> {


    public HeadquartersOrderRecyAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.headquarters_order_middle_item;
    }

    @Override
    protected void convert(XBaseViewHolder helper, HeadquartersOrderListModel item) {
        helper.addOnClickListener(R.id.minus_sign_tv).addOnClickListener(R.id.plus_tv);
        ((TextView) helper.getView(R.id.product_list_item_name_tv)).setText(item.getName());
    }
}
