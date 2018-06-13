package com.qmkj.wlc.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CharitableListModel;
import com.qmkj.wlc.model.CommodityManagerLeftModel;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;
import com.qmkj.wlc.utils.ResourcesUtil;

/**
 * author：rongkui.xiao --2018/3/20
 * email：dovexiaoen@163.com
 * description:
 */

public class CommodityManagerLeftRecyAdapter extends XBaseAdapter<CommodityManagerLeftModel> {


    public CommodityManagerLeftRecyAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.commodity_manager_left_item;
    }

    @Override
    protected void convert(XBaseViewHolder helper, CommodityManagerLeftModel item) {
        helper.getView(R.id.commodity_manager_left_item_ll).setBackgroundColor(ResourcesUtil.getColor(item.isSelect()
                ? R
                .color.textGray : R.color.color_white_1));
        ((TextView) helper.getView(R.id.commodity_manager_left_item_tv)).setText(item.getProductName());
    }
}
