package com.qmkj.wlc.ui.adapter;

import android.content.Context;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.MessageCenterRes;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称：消息中心适配器
 * email: 380948730@qq.com
 */
public class MessageCenterAdapter extends XBaseAdapter<MessageCenterRes>{

    public MessageCenterAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.message_center_adapter;
    }


    @Override
    protected void convert(XBaseViewHolder helper, MessageCenterRes item) {

    }
}
