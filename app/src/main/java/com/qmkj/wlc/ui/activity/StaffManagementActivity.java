package com.qmkj.wlc.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class StaffManagementActivity extends BaseActivity {
    //店员管理
    @BindView(R.id.staff_manage_tv)
    TextView staffTv;
    //职务管理
    @BindView(R.id.staff_duty_manage_tv)
    TextView dutyTv;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_staff_management;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.staff_manage_tv,R.id.staff_duty_manage_tv})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.staff_manage_tv:
                ActivityUtils.startActivity(mContext,StaffManagementSettingActivity.class);
                break;
            case R.id.staff_duty_manage_tv:
                ActivityUtils.startActivity(mContext,DutyManagementActivity.class);
                break;
        }
    }
}
