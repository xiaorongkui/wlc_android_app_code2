package com.qmkj.wlc.ui.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.DutyDetailsAdapter;
import com.qmkj.wlc.ui.adapter.DutyRecycleAdapter;
import com.qmkj.wlc.ui.view.SpaceItemDecoration;

import butterknife.BindView;

/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称： 职务管理
 * email: 380948730@qq.com
 */
public class DutyManagementActivity extends BaseActivity {
    @BindView(R.id.duty_manage_rv)
    RecyclerView dutyManageRecycle;
    @BindView(R.id.duty_manage_details_rv)
    RecyclerView detailsRecycle;
    private DutyRecycleAdapter dutyAdapter;
    private DutyDetailsAdapter detailsAdapter;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_duty_management;
    }

    @Override
    protected void initView() {
        dutyAdapter = new DutyRecycleAdapter(mContext);
        dutyAdapter.addData("店员");
        dutyAdapter.addData("店员");
        dutyAdapter.addData("店员");
        dutyAdapter.addData("店员");
        dutyAdapter.addData("店员");
        dutyAdapter.addData("店员");
        dutyAdapter.addData("店员");
        dutyAdapter.addData("店员");
        GridLayoutManager layoutManager = new GridLayoutManager(mContext,3);
        dutyManageRecycle.setLayoutManager(layoutManager);
        dutyManageRecycle.addItemDecoration(new SpaceItemDecoration(20,3));
        dutyManageRecycle.setAdapter(dutyAdapter);



        detailsAdapter = new DutyDetailsAdapter(mContext);
        detailsAdapter.addData("11");
        detailsAdapter.addData("11");
        detailsAdapter.addData("11");
        detailsAdapter.addData("11");
        detailsAdapter.addData("11");
        detailsAdapter.addData("11");
        detailsAdapter.addData("11");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        detailsRecycle.setLayoutManager(linearLayoutManager);
        detailsRecycle.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        detailsRecycle.setAdapter(detailsAdapter);

    }

    @Override
    protected void initData() {

    }
}
