package com.qmkj.wlc.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CharitableListModel;
import com.qmkj.wlc.model.CustomerResProductListModel;
import com.qmkj.wlc.ui.activity.base.BaseFragment;
import com.qmkj.wlc.ui.adapter.CharitableGrideAdapter;
import com.qmkj.wlc.ui.adapter.CharitableRecyAdapter;
import com.qmkj.wlc.ui.adapter.CustomerReservationProductRecyAdapter;
import com.qmkj.wlc.ui.adapter.CustomerReservationRecyAdapter;
import com.qmkj.wlc.ui.view.FullGridView;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;
import com.qmkj.wlc.utils.RxUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;

/**
 * author：rongkui.xiao --2018/6/19
 * email：dovexiaoen@163.com
 * description:客户预约
 */

public class CustomerReservationFragment extends BaseFragment {

    @BindView(R.id.customer_reservation_rv)
    RecyclerView customerReservationRv;
    @BindView(R.id.customer_reservation_xrl)
    XRefreshLayout customerReservationXrl;
    @BindView(R.id.customer_reservation_sv)
    ScrollView customerReservationSv;
    @BindView(R.id.reservation_product_rv)
    RecyclerView reservationProductRv;
    private CustomerReservationRecyAdapter reservationRecyAdapter;
    private boolean mIsLoadMore;
    private int preSelectPosition = -1;

    @Override
    protected void initView() {
        initRecycleView();
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_customer_reservation;
    }

    @Override
    protected String getSimpleNme() {
        return getClass().getSimpleName();
    }

    List<CharitableListModel> reservationlistData = new ArrayList<>();
    List<CustomerResProductListModel> productListData = new ArrayList<>();

    private void initRecycleView() {
        reservationRecyAdapter = new CustomerReservationRecyAdapter(mContext);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        customerReservationRv.setLayoutManager(mLayoutManager);
        customerReservationRv.setAdapter(reservationRecyAdapter);
        reservationRecyAdapter.setOnItemClickListener((adapter, view, position) -> {
            customerReservationSv.setVisibility(View.VISIBLE);
            if (preSelectPosition >= 0 && preSelectPosition != position) {
                CharitableListModel pre = reservationlistData.get(preSelectPosition);
                if (pre != null) {
                    pre.setSelect(false);
                }
            }
            CharitableListModel currently = reservationlistData.get(position);
            currently.setSelect(true);
            reservationRecyAdapter.update(reservationlistData);
            preSelectPosition = position;
        });
        reservationRecyAdapter.setOnLoadMoreListener(() -> {
            mIsLoadMore = true;
        }, customerReservationRv);

        for (int i = 0; i < 10; i++) {
            reservationlistData.add(new CharitableListModel());
        }
        reservationRecyAdapter.update(reservationlistData);

        CustomerReservationProductRecyAdapter reservationProductRecyAdapter = new
                CustomerReservationProductRecyAdapter(mContext);
        LinearLayoutManager reservationProductManager = new LinearLayoutManager(mContext);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        reservationProductRv.setLayoutManager(reservationProductManager);
        reservationProductRv.setAdapter(reservationProductRecyAdapter);
        for (int i = 0; i < 5; i++) {
            productListData.add(new CustomerResProductListModel("商品名称商品名称", "X3"));
        }
        reservationProductRecyAdapter.update(productListData);
    }
}
