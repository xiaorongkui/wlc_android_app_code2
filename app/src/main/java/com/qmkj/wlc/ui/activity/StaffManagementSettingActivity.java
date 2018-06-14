package com.qmkj.wlc.ui.activity;


import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.StaffManagementRes;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.ui.adapter.StaffManagementAdapter;
import com.qmkj.wlc.ui.view.XRecyclerView;
import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;
import com.qmkj.wlc.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称： 员工管理设置
 * email: 380948730@qq.com
 */
public class StaffManagementSettingActivity extends BaseActivity {
    @BindView(R.id.staff_manage_xrl)
    XRefreshLayout staffRefreshLayout;
    @BindView(R.id.staff_manage_rv)
    XRecyclerView staffRecycle;

    //添加员工
    @BindView(R.id.staff_manage_add_btn)
    Button addButton;
    //删除员工
    @BindView(R.id.staff_manage_delete_btn)
    Button deleteButton;
    //修改员工资料
    @BindView(R.id.staff_manage_change_btn)
    Button changeButton;
    //添加员工确认按钮
    @BindView(R.id.staff_manage_add_conform_btn)
    Button conformButton;
    //表单布局
    @BindView(R.id.staff_manage_form_layout)
    LinearLayout formLayout;
    //人员信息布局
    @BindView(R.id.staff_manage_person_layout)
    LinearLayout personLayout;


    private StaffManagementAdapter staffAdapter;

    boolean mIsLoadMore;
    int mPage;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_staff_management_setting;
    }

    @Override
    protected void initView() {
        staffAdapter = new StaffManagementAdapter(mContext);
        staffAdapter.addData(new StaffManagementRes());
        staffAdapter.addData(new StaffManagementRes());
        staffAdapter.addData(new StaffManagementRes());
        staffAdapter.addData(new StaffManagementRes());
        staffAdapter.addData(new StaffManagementRes());
        staffAdapter.addData(new StaffManagementRes());
        staffAdapter.addData(new StaffManagementRes());
        staffRecycle.setAdapter(staffAdapter);
        //设置下拉刷新监听
        staffRefreshLayout.setOnRefreshListener(new XRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIsLoadMore = false;
                mPage = 0;
                getDataFromNet();
            }

            @Override
            public boolean checkCanDoRefresh(View content, View header) {
                if(staffRecycle!=null){
                    return staffRecycle.isCanRefresh();
                }
                return true;
            }
        });
        //设置上拉加载更多监听
        staffAdapter.setOnLoadMoreListener(() -> {
            mIsLoadMore = true;
            getDataFromNet();
        }, staffRecycle);
    }

    @Override
    protected void initData() {

    }
    /**
     * 获取员工信息
     */
    public void getDataFromNet() {
    }

    @OnClick({R.id.staff_manage_add_btn,R.id.staff_manage_delete_btn,
            R.id.staff_manage_change_btn,R.id.staff_manage_add_conform_btn})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.staff_manage_add_btn:
                if(personLayout.getVisibility() == View.VISIBLE){
                    personLayout.setVisibility(View.GONE);
                    formLayout.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.staff_manage_delete_btn:

                break;
            case R.id.staff_manage_change_btn:
                ActivityUtils.startActivity(mContext,StaffManagementChangeActivity.class);
                break;
            case R.id.staff_manage_add_conform_btn:
                if(formLayout.getVisibility() == View.VISIBLE){
                    formLayout.setVisibility(View.GONE);
                    personLayout.setVisibility(View.VISIBLE);
                }
                break;
        }

    }
}
