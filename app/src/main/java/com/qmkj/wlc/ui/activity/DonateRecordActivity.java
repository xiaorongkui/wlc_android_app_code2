package com.qmkj.wlc.ui.activity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.DonateRecordRes;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.DonateRecordAdapter;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;

import butterknife.BindView;

public class DonateRecordActivity extends BaseActivity {

    @BindView(R.id.donate_record_refreshLayout)
    XRefreshLayout donateRefreshLayout;
    @BindView(R.id.donate_record_recyclerView)
    RecyclerView donateRecyclerView;

    private DonateRecordAdapter donateDetailsAdapter;

    boolean mIsCanRefresh = true;
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        donateRecyclerView.setLayoutManager(layoutManager);
        donateRecyclerView.setAdapter(donateDetailsAdapter);
        //添加分割线
        donateRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

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
                return mIsCanRefresh;
            }
        });

        //设置滑动监听
        donateRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
