package com.qmkj.wlc.ui.adapter;

import android.content.Context;

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

public class CharitableRecyAdapter extends XBaseAdapter<CharitableListModel> {


    public CharitableRecyAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.charitable_donation_list_item;
    }

    @Override
    protected void convert(XBaseViewHolder helper, CharitableListModel item) {
        helper.getView(R.id.charitable_donation_ll).setBackgroundColor(ResourcesUtil.getColor(item.isSelect() ? R
                .color.textGray : R.color.color_white_1));
    }
}
