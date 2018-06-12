package com.qmkj.wlc.ui.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CustomerOrderDetailsRes;
import com.qmkj.wlc.model.CustomerOrderRes;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.CustomerOrderAdapter;
import com.qmkj.wlc.ui.adapter.CustomerOrderDetailsAdapter;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;

import butterknife.BindView;

/**
 * 创建日期：2018/6/12
 * @author Yi Shan Xiang
 * 文件名称： 客人订单
 * email: 380948730@qq.com
 */
public class CustomerOrderActivity extends BaseActivity {
    @BindView(R.id.customer_order_refreshLayout)
    XRefreshLayout refreshLayout;
    @BindView(R.id.customer_order_recyclerView)
    RecyclerView orderRecyclerView;
    @BindView(R.id.customer_order_details_recyclerView)
    RecyclerView detailsRecyclerView;
    private CustomerOrderAdapter adapterOrder;
    private CustomerOrderDetailsAdapter adaptedDetails;

    boolean mIsCanRefresh = true;
    boolean mIsLoadMore;
    int mPage;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_customer_order;
    }

    @Override
    protected void initView() {
        adapterOrder = new CustomerOrderAdapter(mContext);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        orderRecyclerView.setLayoutManager(layoutManager);
        orderRecyclerView.setAdapter(adapterOrder);
        //添加分割线
        orderRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        adapterOrder.addData(new CustomerOrderRes());
        adapterOrder.addData(new CustomerOrderRes());
        adapterOrder.addData(new CustomerOrderRes());
        adapterOrder.addData(new CustomerOrderRes());
        adapterOrder.addData(new CustomerOrderRes());
        adapterOrder.addData(new CustomerOrderRes());

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
                return mIsCanRefresh;
            }
        });

        //设置滑动监听
        orderRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
        adapterOrder.setOnLoadMoreListener(() -> {
            mIsLoadMore = true;
            getDataFromNet();
        }, orderRecyclerView);



        adaptedDetails = new CustomerOrderDetailsAdapter(mContext);
        adaptedDetails.addData(new CustomerOrderDetailsRes());
        adaptedDetails.addData(new CustomerOrderDetailsRes());
        adaptedDetails.addData(new CustomerOrderDetailsRes());
        LinearLayoutManager layoutManager_details = new LinearLayoutManager(mContext);
        layoutManager_details.setOrientation(LinearLayoutManager.VERTICAL);
        detailsRecyclerView.setLayoutManager(layoutManager_details);
        detailsRecyclerView.setAdapter(adaptedDetails);
        //添加分割线
        detailsRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));



    }

    @Override
    protected void initData() {

    }

    /**
     * 获取网络数据
     */
    public void getDataFromNet() {

    }

}
