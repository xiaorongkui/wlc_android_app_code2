package com.qmkj.wlc.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author：rongkui.xiao --2018/6/12
 * email：dovexiaoen@163.com
 * description:个人信息页面
 */

public class PersonInfoActivity extends BaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.modify_phone_num_left_tv)
    TextView modifyPhoneNumLeftTv;
    @BindView(R.id.modify_login_pwd_left_tv)
    TextView modifyLoginPwdLeftTv;
    @BindView(R.id.modify_phone_num_right_ll)
    LinearLayout modifyPhoneNumRightLl;
    @BindView(R.id.modify_login_pwd_right_ll)
    LinearLayout modifyLoginPwdRightLl;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_person_info;
    }

    @Override
    protected void initView() {

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

    @OnClick({R.id.modify_phone_num_left_tv, R.id.modify_login_pwd_left_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.modify_phone_num_left_tv://修改手机号
                setSelect(0);
                break;
            case R.id.modify_login_pwd_left_tv://修改登录密码
                setSelect(1);
                break;
        }
    }

    private void setSelect(int i) {
        switch (i) {
            case 0:
                modifyPhoneNumRightLl.setVisibility(View.VISIBLE);
                modifyLoginPwdRightLl.setVisibility(View.INVISIBLE);
                break;
            case 1:
                modifyPhoneNumRightLl.setVisibility(View.INVISIBLE);
                modifyLoginPwdRightLl.setVisibility(View.VISIBLE);
                break;
        }
    }
}
