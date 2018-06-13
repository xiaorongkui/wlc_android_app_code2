package com.qmkj.wlc.ui.adapter;

import android.content.Context;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.AreaLocationManageRes;
import com.qmkj.wlc.model.AreaManageRes;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称：区域位置管理适配器
 * email: 380948730@qq.com
 */
public class AreaLocationManageAdapter extends XBaseAdapter<AreaLocationManageRes>{

    public AreaLocationManageAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.area_location_manage_adapter;
    }


    @Override
    protected void convert(XBaseViewHolder helper, AreaLocationManageRes item) {

    }
}
