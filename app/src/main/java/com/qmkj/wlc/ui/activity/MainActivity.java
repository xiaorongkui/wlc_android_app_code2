package com.qmkj.wlc.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.view.UPMarqueeView;
import com.qmkj.wlc.utils.ActivityUtils;
import com.qmkj.wlc.utils.LogUtil;
import com.qmkj.wlc.utils.ResourcesUtil;
import com.qmkj.wlc.utils.SystemUtil;
import com.qmkj.wlc.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    private static final long INTERVAL = 2000;  //2s间隔
    @BindView(R.id.charitable_donation_rl)
    RelativeLayout charitableDonationRl;
    @BindView(R.id.customer_reservation_rl)
    RelativeLayout customerReservationRl;
    @BindView(R.id.guest_order_rl)
    RelativeLayout guestOrderRl;
    @BindView(R.id.guest_list_rl)
    RelativeLayout guestListRl;
    @BindView(R.id.marquee_home_header_notice)
    UPMarqueeView upMarqueeView;
    @BindView(R.id.upMarqueeView_fl)
    FrameLayout upMarqueeViewFl;
    private List<String> systemNoticeList = new ArrayList<>();  //系统公告
    private List<View> noticeViews = new ArrayList<>();
    /**
     * 再按一次退出程序
     */
    private long exitTime = 0;  //退出时间

    @Override
    protected void initTitle() {
        LogUtil.i("MainActivity onCreate,状态栏高度=" + SystemUtil.getAndroidPixHeigth(mContext) + ";\t 分辨率=" +
                SystemUtil.getAndroidPixWidth(mContext) + ";\t设备信息");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initMarquee();
    }

    /**
     * 初始化系统公告的跑马灯
     */
    private void initMarquee() {
        systemNoticeList.add("456");
        systemNoticeList.add("456");
        systemNoticeList.add("456");
        systemNoticeList.add("456");
        noticeViews.clear();
        for (String homeNoticeInfo : systemNoticeList) {
            noticeViews.add(createNoticeView(homeNoticeInfo));
        }
        upMarqueeView.setViews(noticeViews);
        if (noticeViews.size() <= 1) {
            upMarqueeView.stopFlipping();
        }

        upMarqueeView.startFlipping();
        if (systemNoticeList.size() == 0) {
            upMarqueeViewFl.setVisibility(View.GONE);
        } else {
            upMarqueeViewFl.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 创建公告item View
     */
    private View createNoticeView(String noticeListBean) {
        View itemView = View.inflate(mContext, R.layout.home_notice_item, null);
        TextView mTvNotice = itemView.findViewById(R.id.tv_home_header_notice);
        TextView notice_title_type_tv = itemView.findViewById(R.id.notice_title_type_tv);
        TextView tv_home_header_notice_more = itemView.findViewById(R.id.tv_home_header_notice_more);

        mTvNotice.setText(noticeListBean);
        tv_home_header_notice_more.setText(ResourcesUtil.getString(R.string.more));
        notice_title_type_tv.setText(String.format("[%s]", noticeListBean));
        itemView.setTag(noticeListBean);
        return itemView;
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > INTERVAL) {
                exitTime = System.currentTimeMillis();
                ToastUtil.showShort(getString(R.string.exit_application_click_once_again));
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.charitable_donation_rl, R.id.customer_reservation_rl, R.id.guest_order_rl, R.id.guest_list_rl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.charitable_donation_rl://慈善捐赠
                ActivityUtils.startActivity(mContext, CharitableDonActivity.class);
                break;
            case R.id.customer_reservation_rl://客户预约
                ActivityUtils.startActivity(mContext, CustomerReservationActivity.class);
                break;
            case R.id.guest_order_rl://客人订单
                ActivityUtils.startActivity(mContext, CustomerOrderActivity.class);
                break;
            case R.id.guest_list_rl://助客点单
                ActivityUtils.startActivity(mContext, HelpCustomerOrderActivity.class);
                break;
        }
    }
}
