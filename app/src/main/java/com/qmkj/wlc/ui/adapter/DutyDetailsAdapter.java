package com.qmkj.wlc.ui.adapter;

import android.content.Context;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称：职务管理功能适配器
 * email: 380948730@qq.com
 */
public class DutyDetailsAdapter extends XBaseAdapter<String>{

    public DutyDetailsAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.duty_details_itm_adapter;
    }


    @Override
    protected void convert(XBaseViewHolder helper, String item) {

    }
}
