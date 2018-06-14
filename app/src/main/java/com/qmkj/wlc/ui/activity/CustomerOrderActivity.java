package com.qmkj.wlc.ui.activity;

import android.view.View;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CustomerOrderDetailsRes;
import com.qmkj.wlc.model.CustomerOrderRes;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.CustomerOrderAdapter;
import com.qmkj.wlc.ui.adapter.CustomerOrderDetailsAdapter;
import com.qmkj.wlc.ui.view.XRecyclerView;
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
    XRecyclerView orderRecyclerView;
    @BindView(R.id.customer_order_details_recyclerView)
    XRecyclerView detailsRecyclerView;
    private CustomerOrderAdapter adapterOrder;
    private CustomerOrderDetailsAdapter adaptedDetails;

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
        orderRecyclerView.setAdapter(adapterOrder);
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
                if(orderRecyclerView!=null){
                    return orderRecyclerView.isCanRefresh();
                }
                return true;
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
        detailsRecyclerView.setAdapter(adaptedDetails);
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
