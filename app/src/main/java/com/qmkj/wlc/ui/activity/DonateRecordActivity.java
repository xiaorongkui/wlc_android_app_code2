package com.qmkj.wlc.ui.activity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.DonateRecordRes;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.DonateRecordAdapter;
import com.qmkj.wlc.ui.view.XRecyclerView;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;

import butterknife.BindView;

/**
 * 创建日期：2018/6/14
 * @author Yi Shan Xiang
 * 文件名称： 捐赠记录
 * email: 380948730@qq.com
 */
public class DonateRecordActivity extends BaseActivity {

    @BindView(R.id.donate_record_refreshLayout)
    XRefreshLayout donateRefreshLayout;
    @BindView(R.id.donate_record_recyclerView)
    XRecyclerView donateRecyclerView;

    private DonateRecordAdapter donateDetailsAdapter;

    boolean mIsLoadMore;
    int mPage;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_donate_record;
    }

    @Override
    protected void initView() {
        donateDetailsAdapter = new DonateRecordAdapter(mContext);
        donateRecyclerView.setAdapter(donateDetailsAdapter);
        donateDetailsAdapter.addData(new DonateRecordRes());
        donateDetailsAdapter.addData(new DonateRecordRes());
        donateDetailsAdapter.addData(new DonateRecordRes());
        donateDetailsAdapter.addData(new DonateRecordRes());
        donateDetailsAdapter.addData(new DonateRecordRes());

        //设置下拉刷新监听
        donateRefreshLayout.setOnRefreshListener(new XRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIsLoadMore = false;
                mPage = 0;
                getDataFromNet();
            }

            @Override
            public boolean checkCanDoRefresh(View content, View header) {
                if(donateRecyclerView!=null){
                    return donateRecyclerView.isCanRefresh();
                }
                return true;
            }
        });

        //设置上拉加载更多监听
        donateDetailsAdapter.setOnLoadMoreListener(() -> {
            mIsLoadMore = true;
            getDataFromNet();
        }, donateRecyclerView);

    }

    @Override
    protected void initData() {

    }

    /**
     * 获取捐赠记录
     */
    public void getDataFromNet() {

    }
}
