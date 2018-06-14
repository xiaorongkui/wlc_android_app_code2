package com.qmkj.wlc.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.StoreManagementGrideAdapter;
import com.qmkj.wlc.ui.view.FullGridView;
import com.qmkj.wlc.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author：rongkui.xiao --2018/6/12
 * email：dovexiaoen@163.com
 * description:门店管理
 */

public class StoreManagementActivity extends BaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.store_management_gv)
    FullGridView storeManagementGv;

    @Override
    protected void initTitle() {
        title.setText(R.string.store_management);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_store_manager;
    }

    @Override
    protected void initView() {
        initGridView();
    }

    List<String> managementData = new ArrayList<>();

    private void initGridView() {
        managementData.add(getString(R.string.charitable_donation));
        managementData.add(getString(R.string.commodity_management));
        managementData.add(getString(R.string.headquarters_order));
        managementData.add(getString(R.string.system_notice));
        managementData.add(getString(R.string.regional_management));
        managementData.add(getString(R.string.shop_assistant_management));
        managementData.add(getString(R.string.person_info));
        StoreManagementGrideAdapter storeManagementGrideAdapter = new StoreManagementGrideAdapter(mContext, R.layout
                .store_management_gv_item_, managementData);
        storeManagementGv.setAdapter(storeManagementGrideAdapter);
        storeManagementGv.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0://慈善管理
                    ActivityUtils.startActivity(mContext, DonateRecordActivity.class);
                    break;
                case 1://商品管理
                    ActivityUtils.startActivity(mContext, CommodityManagementActivity.class);
                    break;
                case 2://总部订单
                    ActivityUtils.startActivity(mContext, HeadquartersOrderActivity.class);
                    break;
                case 3://系统公告
                    ActivityUtils.startActivity(mContext,SystemNoticeActivity.class);
                    break;
                case 4://区域管理
                    ActivityUtils.startActivity(mContext,AreaManagementActivity.class);
                    break;
                case 5://店员管理
                    ActivityUtils.startActivity(mContext,StaffManagementActivity.class);
                    break;
                case 6://个人信息
                    ActivityUtils.startActivity(mContext, PersonInfoActivity.class);
                    break;
            }
        });
    }

    @Override
    protected void initData() {

    }
}
