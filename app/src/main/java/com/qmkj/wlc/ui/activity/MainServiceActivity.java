package com.qmkj.wlc.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.common.Constants;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.utils.ResourcesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author：rongkui.xiao --2018/6/12
 * email：dovexiaoen@163.com
 * description:维链场提供的项目服务页面
 */

public class MainServiceActivity extends BaseActivity {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.charitable_donation_left_iv)
    ImageView charitableDonationLeftIv;
    @BindView(R.id.charitable_donation_left_tv)
    TextView charitableDonationLeftTv;
    @BindView(R.id.customer_reservation_left_iv)
    ImageView customerReservationLeftIv;
    @BindView(R.id.customer_reservation_left_tv)
    TextView customerReservationLeftTv;
    @BindView(R.id.guest_order_left_iv)
    ImageView guestOrderLeftIv;
    @BindView(R.id.guest_order_left_tv)
    TextView guestOrderLeftTv;
    @BindView(R.id.guest_list_left_iv)
    ImageView guestListLeftIv;
    @BindView(R.id.guest_list_left_tv)
    TextView guestListLeftTv;
    private FragmentTransaction ft;
    private CharitableDonFragment charitableDonFragment;//慈善捐赠页面
    private CustomerReservationFragment customerReservationFragment;//客户预约
    private GuestOrdeFragment guestOrdeFragment;//客人订单
    private OrderTheGuestFragment orderTheGuestFragment;//助客点单

    @Override
    protected void initTitle() {
        title.setText("xxxxxxxxmengdain门店");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_service;
    }

    @Override
    protected void initView() {
        int index = getIntent().getIntExtra(Constants.INTENT_PARAMETER_1, 1);
        setSelect(index);
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.charitable_donation_left_ll, R.id.customer_reservation_left_ll, R.id.guest_order_left_ll, R.id
            .guest_list_left_ll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.charitable_donation_left_ll:
                setSelect(0);
                break;
            case R.id.customer_reservation_left_ll:
                setSelect(1);
                break;
            case R.id.guest_order_left_ll:
                setSelect(2);
                break;
            case R.id.guest_list_left_ll:
                setSelect(3);
                break;
        }
    }

    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        hideFragments();
        resetImages();
        switch (i) {
            case 0:
                if (charitableDonFragment == null) {
                    charitableDonFragment = new CharitableDonFragment();
                    ft.add(R.id.mian_service_fl, charitableDonFragment);
                }
                ft.show(charitableDonFragment);

                charitableDonationLeftTv.setTextColor(ResourcesUtil.getColor(R.color.color_bule_1));
                charitableDonationLeftIv.setImageResource(R.mipmap.charitable_donation_select);
                break;
            case 1:
                if (customerReservationFragment == null) {
                    customerReservationFragment = new CustomerReservationFragment();
                    ft.add(R.id.mian_service_fl, customerReservationFragment);
                }
                ft.show(customerReservationFragment);
                customerReservationLeftTv.setTextColor(ResourcesUtil.getColor(R.color.color_bule_1));
                customerReservationLeftIv.setImageResource(R.mipmap.customer_reservation_select);
                break;
            case 2:
                if (guestOrdeFragment == null) {
                    guestOrdeFragment = new GuestOrdeFragment();
                    ft.add(R.id.mian_service_fl, guestOrdeFragment);
                }
                ft.show(guestOrdeFragment);

                guestOrderLeftTv.setTextColor(ResourcesUtil.getColor(R.color.color_bule_1));
                guestOrderLeftIv.setImageResource(R.mipmap.guest_order_select);
                break;
            case 3:
                if (orderTheGuestFragment == null) {
                    orderTheGuestFragment = new OrderTheGuestFragment();
                    ft.add(R.id.mian_service_fl, orderTheGuestFragment);
                }
                ft.show(orderTheGuestFragment);
                guestListLeftTv.setTextColor(ResourcesUtil.getColor(R.color.color_bule_1));
                guestListLeftIv.setImageResource(R.mipmap.guest_list_select);
                break;
        }
        ft.commit();
    }

    private void resetImages() {
        charitableDonationLeftIv.setImageResource(R.mipmap.charitable_donation_unselect);
        customerReservationLeftIv.setImageResource(R.mipmap.customer_reservation_unselect);
        guestOrderLeftIv.setImageResource(R.mipmap.guest_order_unselect);
        guestListLeftIv.setImageResource(R.mipmap.guest_list_unselect);

        charitableDonationLeftTv.setTextColor(ResourcesUtil.getColor(R.color.color_white_1));
        customerReservationLeftTv.setTextColor(ResourcesUtil.getColor(R.color.color_white_1));
        guestOrderLeftTv.setTextColor(ResourcesUtil.getColor(R.color.color_white_1));
        guestListLeftTv.setTextColor(ResourcesUtil.getColor(R.color.color_white_1));
    }

    private void hideFragments() {
        if (charitableDonFragment != null) {
            ft.hide(charitableDonFragment);
        }
        if (customerReservationFragment != null) {
            ft.hide(customerReservationFragment);
        }
        if (guestOrdeFragment != null) {
            ft.hide(guestOrdeFragment);
        }
        if (orderTheGuestFragment != null) {
            ft.hide(orderTheGuestFragment);
        }
    }
}
