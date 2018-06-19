package com.qmkj.wlc.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 创建日期：2018/6/19
 * @author Yi Shan Xiang
 * 文件名称： 登陆页面\找回密码页面
 * email: 380948730@qq.com
 */
public class LoginActivity extends BaseActivity {
    //登录布局
    @BindView(R.id.login_layout)
    LinearLayout loginLayout;
    //找回密码布局
    @BindView(R.id.login_forgot_layout)
    LinearLayout forgotLayout;
    //登录按钮
    @BindView(R.id.login_btn)
    Button loginBtn;
    //找回密码按钮
    @BindView(R.id.login_forgot_btn)
    TextView forgotBtn;
    //找回密码提交按钮
    @BindView(R.id.login_forgot_submit_btn)
    Button submitForgotBtn;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.login_btn,R.id.login_forgot_btn,R.id.login_forgot_submit_btn})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_btn:
                //进入首页
                ActivityUtils.startActivityAndFinish(mContext, MainActivity.class);
                break;
            case R.id.login_forgot_btn:
                loginLayout.setVisibility(View.GONE);
                forgotLayout.setVisibility(View.VISIBLE);
                break;
             case R.id.login_forgot_submit_btn:
                loginLayout.setVisibility(View.VISIBLE);
                forgotLayout.setVisibility(View.GONE);
                break;
        }

    }
}
