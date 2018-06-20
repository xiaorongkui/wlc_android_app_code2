package com.qmkj.wlc.ui.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CharitableListModel;
import com.qmkj.wlc.model.CustomerResProductListModel;
import com.qmkj.wlc.ui.activity.base.BaseFragment;
import com.qmkj.wlc.ui.adapter.CustomerReservationProductRecyAdapter;
import com.qmkj.wlc.ui.adapter.CustomerReservationRecyAdapter;
import com.qmkj.wlc.ui.adapter.CustomerReservationSearchRecyAdapter;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;
import com.qmkj.wlc.utils.ResourcesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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

    @BindView(R.id.customer_reservation_ll)
    LinearLayout customerReservationLl;
    Unbinder unbinder;
    @BindView(R.id.search_iv)
    ImageView searchIv;
    @BindView(R.id.search_et)
    EditText searchEt;
    @BindView(R.id.search_ll)
    LinearLayout searchLl;
    @BindView(R.id.search_cancel_input_iv)
    ImageView searchCancelInputIv;
    @BindView(R.id.search_rl)
    RelativeLayout searchRl;
    @BindView(R.id.search_cancel_tv)
    TextView searchCancelTv;
    @BindView(R.id.search_bottom_line)
    View searchBottomLine;
    @BindView(R.id.search_content_ll)
    LinearLayout searchContentLl;
    private CustomerReservationRecyAdapter reservationRecyAdapter;
    private boolean mIsLoadMore;
    private int preSelectPosition = -1;
    private SearchTextWatcher searchTextWatcher;
    private View contentView;
    private CustomerReservationSearchRecyAdapter customerReservationSearchRecyAdapter;

    @Override
    protected void initView() {
        initRecycleView();
        initSearch();
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
            customerReservationLl.setVisibility(View.VISIBLE);
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
            productListData.add(new CustomerResProductListModel("商品名称商品名称", "X" + i));
        }
        reservationProductRecyAdapter.update(productListData);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.reservation_details_cancel_iv, R.id.search_cancel_input_iv, R.id.search_rl, R.id.search_cancel_tv,
            R.id.search_iv, R.id.search_et})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reservation_details_cancel_iv://取消详情
                customerReservationLl.setVisibility(View.GONE);
                break;
            case R.id.search_cancel_input_iv://删掉输入的内容
                break;
            case R.id.search_iv:
            case R.id.search_et:
            case R.id.search_rl://搜索的输入框
                searchIv.setVisibility(View.GONE);
                ViewGroup.LayoutParams layoutParamsInput = searchLl.getLayoutParams();
                layoutParamsInput.width = ViewGroup.LayoutParams.MATCH_PARENT;
                searchLl.setLayoutParams(layoutParamsInput);
                searchCancelInputIv.setVisibility(View.VISIBLE);
                searchEt.setFocusable(true);
                searchEt.setFocusableInTouchMode(true);
                searchEt.requestFocus();
                searchEt.requestFocusFromTouch();
                searchEt.setCursorVisible(true);
                break;
            case R.id.search_cancel_tv://取消搜索
                searchIv.setVisibility(View.VISIBLE);
                ViewGroup.LayoutParams layoutParamsCancel = searchLl.getLayoutParams();
                layoutParamsCancel.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                searchLl.setLayoutParams(layoutParamsCancel);
                searchCancelInputIv.setVisibility(View.GONE);
                searchEt.setClickable(true);
                searchEt.setFocusableInTouchMode(false);
                searchEt.setText(null);
                searchEt.setCursorVisible(false);
                break;
        }
    }

    private void initSearch() {
        searchTextWatcher = new SearchTextWatcher();
        searchEt.addTextChangedListener(searchTextWatcher);
    }

    private class SearchTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (TextUtils.isEmpty(s.toString())) {
                return;
            }
            showSearchPopWindow();
        }
    }

    private void showSearchPopWindow() {
        if (contentView == null) {
            contentView = LayoutInflater.from(mContext).inflate(R.layout.pop_window_search, null, false);
            RecyclerView searchRecycleView = contentView.findViewById(R.id.customer_reservation_search_rv);
            customerReservationSearchRecyAdapter = new
                    CustomerReservationSearchRecyAdapter(mContext);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
            searchRecycleView.setLayoutManager(mLayoutManager);
            searchRecycleView.setAdapter(customerReservationSearchRecyAdapter);
        }

        // 创建PopupWindow对象，其中：
        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        searchContentLl.measure(w, h);
        PopupWindow window = new PopupWindow(contentView, searchContentLl.getWidth(), (int) ResourcesUtil.getDimen(R
                .dimen.x500), true);
        // 设置PopupWindow的背景
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置PopupWindow是否能响应外部点击事件
        window.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        window.setTouchable(true);
        // 显示PopupWindow，其中：
        // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
        if (window.isShowing()) {
            customerReservationSearchRecyAdapter.update(reservationlistData);
        } else {
            window.showAsDropDown(searchBottomLine, 0, 0);
        }
        // 或者也可以调用此方法显示PopupWindow，其中：
        // 第一个参数是PopupWindow的父View，第二个参数是PopupWindow相对父View的位置，
        // 第三和第四个参数分别是PopupWindow相对父View的x、y偏移
        // window.showAtLocation(parent, gravity, x, y);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (searchEt != null) {
            searchEt.removeTextChangedListener(searchTextWatcher);
        }
    }
}
