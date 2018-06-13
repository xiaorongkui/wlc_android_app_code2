package com.qmkj.wlc.ui.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.AreaLocationManageRes;
import com.qmkj.wlc.model.AreaManageRes;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.AreaLocationManageAdapter;
import com.qmkj.wlc.ui.adapter.AreaManageAdapter;
import com.qmkj.wlc.ui.dialog.AddAreaDialog;
import com.qmkj.wlc.ui.dialog.AddAreaLocationDialog;
import com.qmkj.wlc.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称： 区域管理
 * email: 380948730@qq.com
 */
public class AreaManagementActivity extends BaseActivity {
    //位置管理
    @BindView(R.id.area_location_manage_recyclerView)
    RecyclerView locationRecycleView;
    //区域管理
    @BindView(R.id.area_manage_recyclerView)
    RecyclerView areaRecycleView;

    //添加区域
    @BindView(R.id.area_add_btn)
    Button areaButton;
    //添加位置
    @BindView(R.id.area_location_add_btn)
    Button locationButton;

    //区域管理适配器
    private AreaManageAdapter areaAdapter;
    //位置管理适配器
    private AreaLocationManageAdapter locationAdapter;


    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_area_manage;
    }

    @Override
    protected void initView() {
        //初始化区域管理
        areaAdapter = new AreaManageAdapter(mContext);
        areaAdapter.addData(new AreaManageRes());
        areaAdapter.addData(new AreaManageRes());
        areaAdapter.addData(new AreaManageRes());
        areaAdapter.addData(new AreaManageRes());
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        areaRecycleView.setLayoutManager(layoutManager);
        areaRecycleView.setAdapter(areaAdapter);
        //添加分割线
        areaRecycleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //初始化位置管理
        locationAdapter = new AreaLocationManageAdapter(mContext);
        locationAdapter.addData(new AreaLocationManageRes());
        locationAdapter.addData(new AreaLocationManageRes());
        locationAdapter.addData(new AreaLocationManageRes());
        locationAdapter.addData(new AreaLocationManageRes());
        locationAdapter.addData(new AreaLocationManageRes());
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(mContext);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        locationRecycleView.setLayoutManager(layoutManager2);
        locationRecycleView.setAdapter(locationAdapter);
        //添加分割线
        locationRecycleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    @OnClick({R.id.area_add_btn,R.id.area_location_add_btn})
    public void onClickView(View view){
        switch (view.getId()){
            case R.id.area_add_btn: //添加区域

                AddAreaDialog areaDialog = new AddAreaDialog(mContext);
                areaDialog.setOnAddAreaListener((areaName) ->{
                    ToastUtil.showShort("新增区域！");
                });
                areaDialog.show();

                break;

            case R.id.area_location_add_btn://添加位置

                AddAreaLocationDialog locationDialog = new AddAreaLocationDialog(mContext);
                locationDialog.setOnAddAreaLocationListener((locationName,personAmount) ->{
                    ToastUtil.showShort("新增位置！");
                });
                locationDialog.show();

                break;
        }

    }

    @Override
    protected void initData() {}
}
