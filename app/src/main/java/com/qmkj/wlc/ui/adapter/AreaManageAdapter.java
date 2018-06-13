package com.qmkj.wlc.ui.adapter;

import android.content.Context;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.AreaManageRes;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称：区域管理适配器
 * email: 380948730@qq.com
 */
public class AreaManageAdapter extends XBaseAdapter<AreaManageRes>{

    public AreaManageAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.area_manage_adapter;
    }


    @Override
    protected void convert(XBaseViewHolder helper, AreaManageRes item) {

    }
}
