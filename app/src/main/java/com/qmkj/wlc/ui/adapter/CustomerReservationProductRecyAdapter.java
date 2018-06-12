package com.qmkj.wlc.ui.adapter;

import android.content.Context;
import android.view.View;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CharitableListModel;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;
import com.qmkj.wlc.utils.ResourcesUtil;

/**
 * author：rongkui.xiao --2018/3/20
 * email：dovexiaoen@163.com
 * description:
 */

public class CustomerReservationProductRecyAdapter extends XBaseAdapter<CharitableListModel> {


    public CustomerReservationProductRecyAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.customer_reservation_product_list_item;
    }

    @Override
    protected void convert(XBaseViewHolder helper, CharitableListModel item) {
    }
}
