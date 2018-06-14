package com.qmkj.wlc.ui.activity;

import android.view.View;
import com.qmkj.wlc.R;
import com.qmkj.wlc.model.MessageCenterRes;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.MessageCenterAdapter;
import com.qmkj.wlc.ui.view.XRecyclerView;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;

import butterknife.BindView;

/**
 * 创建日期：2018/6/14
 * @author Yi Shan Xiang
 * 文件名称： 消息中心
 * email: 380948730@qq.com
 */
public class MessageCenterActivity extends BaseActivity {
    @BindView(R.id.message_center_refreshLayout)
    XRefreshLayout messageRefreshLayout;
    @BindView(R.id.message_center_recyclerView)
    XRecyclerView messageRecyclerView;

    private MessageCenterAdapter messageCenterAdapter;
    boolean mIsLoadMore;
    int mPage;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message_center;
    }

    @Override
    protected void initView() {
        messageCenterAdapter = new MessageCenterAdapter(mContext);
        messageRecyclerView.setAdapter(messageCenterAdapter);
        messageCenterAdapter.addData(new MessageCenterRes());
        messageCenterAdapter.addData(new MessageCenterRes());
        messageCenterAdapter.addData(new MessageCenterRes());
        messageCenterAdapter.addData(new MessageCenterRes());
        messageCenterAdapter.addData(new MessageCenterRes());
        messageCenterAdapter.addData(new MessageCenterRes());

        //设置下拉刷新监听
        messageRefreshLayout.setOnRefreshListener(new XRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIsLoadMore = false;
                mPage = 0;
                getDataFromNet();
            }
            @Override
            public boolean checkCanDoRefresh(View content, View header) {
                if(messageRecyclerView!=null){
                    return messageRecyclerView.isCanRefresh();
                }
                return true;
            }
        });
        //设置上拉加载更多监听
        messageCenterAdapter.setOnLoadMoreListener(() -> {
            mIsLoadMore = true;
            getDataFromNet();
        }, messageRecyclerView);
    }

    @Override
    protected void initData() {

    }


    /**
     * 获取系统消息
     */
    public void getDataFromNet() {

    }
}
