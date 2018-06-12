package com.qmkj.wlc.ui.activity;

import android.os.Handler;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.utils.ActivityUtils;


/**
 * 启动页面
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        new Handler().postDelayed(() -> ActivityUtils.startActivityAndFinish(mContext, MainActivity.class)
                , 2000);
    }

    @Override
    protected void initData() {

    }
}
