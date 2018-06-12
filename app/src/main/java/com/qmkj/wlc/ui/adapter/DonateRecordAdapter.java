package com.qmkj.wlc.ui.adapter;

import android.content.Context;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CustomerOrderRes;
import com.qmkj.wlc.model.DonateRecordRes;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * 创建日期：2018/6/12
 * @author Yi Shan Xiang
 * 文件名称：捐赠信息记录适配器
 * email: 380948730@qq.com
 */
public class DonateRecordAdapter extends XBaseAdapter<DonateRecordRes>{

    public DonateRecordAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.donate_record_adapter;
    }


    @Override
    protected void convert(XBaseViewHolder helper, DonateRecordRes item) {

    }
}
