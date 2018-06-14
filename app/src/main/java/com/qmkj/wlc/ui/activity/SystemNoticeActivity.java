package com.qmkj.wlc.ui.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CustomerOrderRes;
import com.qmkj.wlc.model.SystemNoticeRes;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.SystemNoticeAdapter;
import com.qmkj.wlc.ui.view.XRecyclerView;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;

import butterknife.BindView;

/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称： 系统公告
 * email: 380948730@qq.com
 */
public class SystemNoticeActivity extends BaseActivity {
    @BindView(R.id.system_notice_refreshLayout)
    XRefreshLayout refreshLayout;
    @BindView(R.id.system_notice_recyclerView)
    XRecyclerView noticeRecyclerView;
    private SystemNoticeAdapter noticeAdapter;
    boolean mIsLoadMore;
    int mPage;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_system_notice;
    }

    @Override
    protected void initView() {
        noticeAdapter = new SystemNoticeAdapter(mContext);
        noticeRecyclerView.setAdapter(noticeAdapter);

        noticeAdapter.addData(new SystemNoticeRes());
        noticeAdapter.addData(new SystemNoticeRes());
        noticeAdapter.addData(new SystemNoticeRes());
        noticeAdapter.addData(new SystemNoticeRes());
        noticeAdapter.addData(new SystemNoticeRes());

        //设置下拉刷新监听
        refreshLayout.setOnRefreshListener(new XRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIsLoadMore = false;
                mPage = 0;
                getDataFromNet();
            }
            @Override
            public boolean checkCanDoRefresh(View content, View header) {
                if(noticeRecyclerView!=null){
                    return noticeRecyclerView.isCanRefresh();
                }
                return true;
            }
        });
        //设置上拉加载更多监听
        noticeAdapter.setOnLoadMoreListener(() -> {
            mIsLoadMore = true;
            getDataFromNet();
        }, noticeRecyclerView);
    }

    @Override
    protected void initData() {

    }

    /**
     * 获取系统公告网络数据
     */
    public void getDataFromNet() {

    }
}
