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
 * description:总部订单商品列表,右边已选择的商品
 */

public class HeadquartersOrderSelectRecyAdapter extends XBaseAdapter<HeadquartersOrderListModel> {


    public HeadquartersOrderSelectRecyAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.headquarters_order_select_item;
    }

    @Override
    protected void convert(XBaseViewHolder helper, HeadquartersOrderListModel item) {
        ((TextView) helper.getView(R.id.name_tv)).setText(item.getName());
        ((TextView) helper.getView(R.id.amount_tv)).setText(String.format("X%d", item.getAmount()));
    }
}
