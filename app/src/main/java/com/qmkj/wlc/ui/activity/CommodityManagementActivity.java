package com.qmkj.wlc.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CommodityManagerLeftModel;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.CommodityManagerLeftRecyAdapter;
import com.qmkj.wlc.ui.adapter.CommodityManagerRightRecyAdapter;
import com.qmkj.wlc.ui.view.FullGridView;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;
import com.qmkj.wlc.utils.ResourcesUtil;
import com.qmkj.wlc.utils.RxUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;

/**
 * author：rongkui.xiao --2018/6/13
 * email：dovexiaoen@163.com
 * description:商品管理
 */

public class CommodityManagementActivity extends BaseActivity {
    @BindView(R.id.product_list_rv)
    RecyclerView productListRv;
    @BindView(R.id.product_list_xrl)
    XRefreshLayout productListXrl;
    @BindView(R.id.product_detail_ll)
    LinearLayout productDetailLl;
    @BindView(R.id.detail_picture_gv)
    FullGridView detailPictureGv;
    @BindView(R.id.product_add_ll)
    LinearLayout productAddLl;
    @BindView(R.id.add_new_product_bt)
    Button addNewProductBt;
    @BindView(R.id.title)
    TextView title;
    private boolean isCanRefresh;
    private CommodityManagerRightRecyAdapter commodityManagerRightRecyAdapter;
    private boolean mIsLoadMore;

    @Override
    protected void initTitle() {
        title.setText(ResourcesUtil.getString(R.string.commodity_management));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commodity_management;
    }

    @Override
    protected void initView() {
        initRecyclerView();
        initRefresh();
        initGrideView();
    }

    private void initGrideView() {

    }

    List<CommodityManagerLeftModel> leftDataList = new ArrayList<>();
    List<Object> rightDataList = new ArrayList<>();

    private void initRecyclerView() {
        //todo
        CommodityManagerLeftRecyAdapter commodityManagerLeftRecyAdapter = new CommodityManagerLeftRecyAdapter(mContext);
        leftDataList.add(new CommodityManagerLeftModel("定制产品"));
        leftDataList.add(new CommodityManagerLeftModel("高档产品"));
        leftDataList.add(new CommodityManagerLeftModel("普通产品"));
        leftDataList.add(new CommodityManagerLeftModel("快餐区"));
        leftDataList.add(new CommodityManagerLeftModel("酒水"));
        leftDataList.add(new CommodityManagerLeftModel("赠送区"));
        commodityManagerLeftRecyAdapter.update(leftDataList);

        commodityManagerRightRecyAdapter = new CommodityManagerRightRecyAdapter(mContext);
        LinearLayoutManager mLayoutManagerRight = new LinearLayoutManager(mContext);
        mLayoutManagerRight.setOrientation(LinearLayoutManager.VERTICAL);
        productListRv.setLayoutManager(mLayoutManagerRight);
        productListRv.setAdapter(commodityManagerRightRecyAdapter);
        commodityManagerLeftRecyAdapter.setOnItemClickListener((adapter, view, position) -> {

        });
        rightDataList.add(new CommodityManagerLeftModel("定制产品"));
        rightDataList.add(new CommodityManagerLeftModel("高档产品"));
        rightDataList.add(new CommodityManagerLeftModel("普通产品"));
        rightDataList.add(new CommodityManagerLeftModel("快餐区"));
        rightDataList.add(new CommodityManagerLeftModel("酒水"));
        rightDataList.add(new CommodityManagerLeftModel("赠送区"));
        commodityManagerRightRecyAdapter.update(rightDataList);
        commodityManagerRightRecyAdapter.setOnItemClickListener((adapter, view, position) -> {
            productAddLl.setVisibility(View.INVISIBLE);
            productDetailLl.setVisibility(View.VISIBLE);
        });
    }

    private void initRefresh() {

        productListXrl.setOnRefreshListener(new XRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Observable.timer(10000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(aLong -> {
                    productListXrl.refreshComplete();
                });
            }

            @Override
            public boolean checkCanDoRefresh(View content, View header) {
                return isCanRefresh;
            }
        });
        productListRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

        commodityManagerRightRecyAdapter.setOnLoadMoreListener(() -> {
            mIsLoadMore = true;
        }, productListRv);

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

    @OnClick({R.id.add_new_product_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_new_product_bt:
                productDetailLl.setVisibility(View.INVISIBLE);
                productAddLl.setVisibility(View.VISIBLE);
                break;
        }
    }
}
