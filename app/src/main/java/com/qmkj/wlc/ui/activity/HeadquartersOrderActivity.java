package com.qmkj.wlc.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qmkj.wlc.R;
import com.qmkj.wlc.model.CommodityManagerLeftModel;
import com.qmkj.wlc.model.HeadquartersOrderListModel;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.CommodityManagerLeftRecyAdapter;
import com.qmkj.wlc.ui.adapter.HeadquartersOrderRecyAdapter;
import com.qmkj.wlc.ui.adapter.HeadquartersOrderSelectRecyAdapter;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;
import com.qmkj.wlc.utils.RxUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;

/**
 * author：rongkui.xiao --2018/6/13
 * email：dovexiaoen@163.com
 * description:总部订单
 */

public class HeadquartersOrderActivity extends BaseActivity {
    @BindView(R.id.product_service_list_rv)
    RecyclerView productServiceListRv;
    @BindView(R.id.product_list_rv)
    RecyclerView productListRv;
    @BindView(R.id.product_list_xrl)
    XRefreshLayout productListXrl;
    @BindView(R.id.select_product_list_rv)
    RecyclerView selectProductListRv;
    @BindView(R.id.headquarters_order_submit_bt)
    Button headquartersOrderSubmitBt;
    private boolean isCanRefresh;
    private HeadquartersOrderRecyAdapter headquartersOrderRecyAdapter;
    private boolean mIsLoadMore;
    private HeadquartersOrderSelectRecyAdapter headquartersOrderSelectRecyAdapter;
    private boolean isSelectProductExist;
    private boolean isAdd;
    private int productAmount = 0;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_headquarters_order;
    }

    @Override
    protected void initView() {
        initRecyclerView();
        initRefresh();
    }

    @Override
    protected void initData() {

    }


    List<CommodityManagerLeftModel> leftDataList = new ArrayList<>();
    List<HeadquartersOrderListModel> rightDataList = new ArrayList<>();
    List<HeadquartersOrderListModel> rightSelectDataList = new ArrayList<>();

    private void initRecyclerView() {
        //左边提供的服务列表
        CommodityManagerLeftRecyAdapter commodityManagerLeftRecyAdapter = new CommodityManagerLeftRecyAdapter(mContext);
        LinearLayoutManager mLayoutManagerLeft = new LinearLayoutManager(mContext);
        mLayoutManagerLeft.setOrientation(LinearLayoutManager.VERTICAL);
        productServiceListRv.setLayoutManager(mLayoutManagerLeft);
        productServiceListRv.setAdapter(commodityManagerLeftRecyAdapter);
        commodityManagerLeftRecyAdapter.setOnItemClickListener((adapter, view, position) -> {

        });
        leftDataList.add(new CommodityManagerLeftModel(getString(R.string.custom_product)));
        leftDataList.add(new CommodityManagerLeftModel(getString(R.string.high_grade_products)));
        leftDataList.add(new CommodityManagerLeftModel(getString(R.string.common_product)));
        leftDataList.add(new CommodityManagerLeftModel(getString(R.string.fast_food_area)));
        leftDataList.add(new CommodityManagerLeftModel(getString(R.string.wine)));
        leftDataList.add(new CommodityManagerLeftModel(getString(R.string.gift_area)));
        commodityManagerLeftRecyAdapter.update(leftDataList);

        //中间的产品列表
        headquartersOrderRecyAdapter = new HeadquartersOrderRecyAdapter(mContext);
        LinearLayoutManager mLayoutManagerRight = new LinearLayoutManager(mContext);
        mLayoutManagerRight.setOrientation(LinearLayoutManager.VERTICAL);
        productListRv.setLayoutManager(mLayoutManagerRight);
        productListRv.setAdapter(headquartersOrderRecyAdapter);
        headquartersOrderRecyAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()) {
                case R.id.minus_sign_tv://减产品
                    isAdd = false;
                    break;
                case R.id.plus_tv://加产品
                    isAdd = true;
                    break;
            }
            calculateSelectProduct(adapter, position);
        });
        for (int i = 0; i < 10; i++) {
            rightDataList.add(new HeadquartersOrderListModel("产品" + i, 0));
        }
        headquartersOrderRecyAdapter.update(rightDataList);

        //右边选择商品的列表
        headquartersOrderSelectRecyAdapter = new HeadquartersOrderSelectRecyAdapter(mContext);
        LinearLayoutManager mLayoutManagerSelectRight = new LinearLayoutManager(mContext);
        mLayoutManagerRight.setOrientation(LinearLayoutManager.VERTICAL);
        selectProductListRv.setLayoutManager(mLayoutManagerSelectRight);
        selectProductListRv.setAdapter(headquartersOrderSelectRecyAdapter);

        headquartersOrderSelectRecyAdapter.update(rightSelectDataList);
    }

    //计算右边选中的产品列表，数量
    private void calculateSelectProduct(BaseQuickAdapter adapter, int position) {
        String listProductName = rightDataList.get(position).getName();
        if (rightSelectDataList.size() > 0) {
            for (int i = 0; i < rightSelectDataList.size(); i++) {
                String listSelectProductName = rightSelectDataList.get(i).getName();
                if (!TextUtils.isEmpty(listSelectProductName) && listSelectProductName.equals(listProductName)) {
                    isSelectProductExist = true;
                    productAmount = rightSelectDataList.get(i).getAmount();
                    productAmount = isAdd ? ++productAmount : --productAmount;
                    if (productAmount > 0) {
                        rightSelectDataList.set(i, new HeadquartersOrderListModel(listProductName, productAmount));
                    } else {
                        rightSelectDataList.remove(i);
                    }
                }
            }
            if (!isSelectProductExist) {//商品不存在
                if (isAdd) {
                    rightSelectDataList.add(new HeadquartersOrderListModel(listProductName, 1));
                    productAmount = 1;
                } else {
                    productAmount = 0;
                }
            }
        } else {
            if (isAdd) {
                rightSelectDataList.add(new HeadquartersOrderListModel(listProductName, 1));
                productAmount = 1;
            } else {
                productAmount = 0;
            }
        }

        TextView productAmountTv = (TextView) adapter.getViewByPosition(position, R.id.product_amount_tv);
        if (productAmountTv != null) {
            productAmountTv.setText(String.format("%s", productAmount));
        }
        isSelectProductExist = false;
        headquartersOrderSelectRecyAdapter.update(rightSelectDataList);
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

        headquartersOrderRecyAdapter.setOnLoadMoreListener(() -> {
            mIsLoadMore = true;
        }, productListRv);
    }
}
