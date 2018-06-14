package com.qmkj.wlc.ui.activity;

import android.view.View;
import android.widget.Button;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.AreaLocationManageRes;
import com.qmkj.wlc.model.AreaManageRes;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.AreaLocationManageAdapter;
import com.qmkj.wlc.ui.adapter.AreaManageAdapter;
import com.qmkj.wlc.ui.dialog.AddAreaButtonDialog;
import com.qmkj.wlc.ui.dialog.AddAreaLocationButtonDialog;
import com.qmkj.wlc.ui.view.XRecyclerView;
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
    XRecyclerView locationRecycleView;
    //区域管理
    @BindView(R.id.area_manage_recyclerView)
    XRecyclerView areaRecycleView;

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
        areaRecycleView.setAdapter(areaAdapter);

        //初始化位置管理
        locationAdapter = new AreaLocationManageAdapter(mContext);
        locationAdapter.addData(new AreaLocationManageRes());
        locationAdapter.addData(new AreaLocationManageRes());
        locationAdapter.addData(new AreaLocationManageRes());
        locationAdapter.addData(new AreaLocationManageRes());
        locationAdapter.addData(new AreaLocationManageRes());
        locationRecycleView.setAdapter(locationAdapter);

    }

    @OnClick({R.id.area_add_btn,R.id.area_location_add_btn})
    public void onClickView(View view){
        switch (view.getId()){
            case R.id.area_add_btn: //添加区域

                AddAreaButtonDialog areaDialog = new AddAreaButtonDialog(mContext);
                areaDialog.setOnAddAreaListener((areaName) ->{
                    ToastUtil.showShort("新增区域！");
                });
                areaDialog.show();

                break;

            case R.id.area_location_add_btn://添加位置

                AddAreaLocationButtonDialog locationDialog = new AddAreaLocationButtonDialog(mContext);
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
