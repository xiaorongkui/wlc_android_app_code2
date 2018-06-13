package com.qmkj.wlc.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CharitableListModel;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.CharitableGrideAdapter;
import com.qmkj.wlc.ui.adapter.CharitableRecyAdapter;
import com.qmkj.wlc.ui.view.FullGridView;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;
import com.qmkj.wlc.utils.ResourcesUtil;
import com.qmkj.wlc.utils.RxUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

/**
 * author：rongkui.xiao --2018/6/12
 * email：dovexiaoen@163.com
 * description:慈善捐赠页面
 */

public class CharitableDonActivity extends BaseActivity {
    @BindView(R.id.charitable_donation_rv)
    RecyclerView charitableDonationRv;
    @BindView(R.id.pay_method_gv)
    FullGridView payMethodGv;
    @BindView(R.id.submit_bt)
    Button submitBt;
    @BindView(R.id.charitable_donation_sl)
    ScrollView charitableDonationSl;
    @BindView(R.id.charitable_donation_xrl)
    XRefreshLayout charitableDonationXrl;
    @BindView(R.id.title)
    TextView title;
    private CharitableRecyAdapter charitableRecyAdapter;
    private boolean mIsLoadMore;
    private int preSelectPosition = -1;
    private boolean isCanRefresh;

    @Override
    protected void initTitle() {
        title.setText("xxxxxxxxmengdain");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_charitable_donation;
    }

    @Override
    protected void initView() {
        initRecycleView();
        initGridView();
        initRefresh();
    }

    private void initRefresh() {

        charitableDonationXrl.setOnRefreshListener(new XRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Observable.timer(10000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(aLong -> {
                    charitableDonationXrl.refreshComplete();
                });
            }

            @Override
            public boolean checkCanDoRefresh(View content, View header) {
                return isCanRefresh;
            }
        });
        charitableDonationRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int firstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                isCanRefresh = firstCompletelyVisibleItemPosition <= 0;
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }


    private void initRecycleView() {
        charitableRecyAdapter = new CharitableRecyAdapter(mContext);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        charitableDonationRv.setLayoutManager(mLayoutManager);
        charitableDonationRv.setAdapter(charitableRecyAdapter);
        charitableRecyAdapter.setOnItemClickListener((adapter, view, position) -> {
            charitableDonationSl.setVisibility(View.VISIBLE);
            if (preSelectPosition >= 0 && preSelectPosition != position) {
                CharitableListModel pre = listData.get(preSelectPosition);
                if (pre != null) {
                    pre.setSelect(false);
                }
            }
            CharitableListModel currently = listData.get(position);
            currently.setSelect(true);
            charitableRecyAdapter.update(listData);
            preSelectPosition = position;
        });
        charitableRecyAdapter.setOnLoadMoreListener(() -> {
            mIsLoadMore = true;
        }, charitableDonationRv);

        for (int i = 0; i < 10; i++) {
            listData.add(new CharitableListModel());
        }
        charitableRecyAdapter.update(listData);
    }

    List<String> payMethodData = new ArrayList<>();
    List<CharitableListModel> listData = new ArrayList<>();

    /**
     * 初始化支付方式
     */
    private void initGridView() {
        payMethodData.add("余额支付");
        payMethodData.add("XT支付");
        payMethodData.add("支付宝支付");
        payMethodData.add("微信支付");
        payMethodData.add("XX支付");
        payMethodData.add("线下支付");
        CharitableGrideAdapter charitableGrideAdapter = new CharitableGrideAdapter(mContext, R.layout
                .chartiable_pay_method_gv_item_, payMethodData);
        payMethodGv.setAdapter(charitableGrideAdapter);
        payMethodGv.setOnItemClickListener((parent, view, position, id) -> {

        });
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
}
