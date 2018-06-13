package com.qmkj.wlc.ui.adapter;

import android.content.Context;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.StaffManagementRes;
import com.qmkj.wlc.model.SystemNoticeRes;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称：员工管理适配器
 * email: 380948730@qq.com
 */
public class StaffManagementAdapter extends XBaseAdapter<StaffManagementRes>{

    public StaffManagementAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.staff_management_adapter;
    }


    @Override
    protected void convert(XBaseViewHolder helper, StaffManagementRes item) {

    }
}
