package com.qmkj.wlc.ui.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.MessageCenterRes;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.MessageCenterAdapter;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;

import butterknife.BindView;

public class MessageCenterActivity extends BaseActivity {
    @BindView(R.id.message_center_refreshLayout)
    XRefreshLayout messageRefreshLayout;
    @BindView(R.id.message_center_recyclerView)
    RecyclerView messageRecyclerView;

    private MessageCenterAdapter messageCenterAdapter;
    boolean mIsCanRefresh = true;
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        messageRecyclerView.setLayoutManager(layoutManager);
        messageRecyclerView.setAdapter(messageCenterAdapter);
        //添加分割线
        messageRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

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
                return mIsCanRefresh;
            }
        });

        //设置滑动监听
        messageRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int topRowVerticalPosition =
                        (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0)
                                .getTop();
                mIsCanRefresh = topRowVerticalPosition >= 0;
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
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
