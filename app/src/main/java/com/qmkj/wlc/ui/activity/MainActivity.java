package com.qmkj.wlc.ui.activity;

import android.view.KeyEvent;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.activity.base.BaseActivity;
import com.qmkj.wlc.utils.ToastUtil;

public class MainActivity extends BaseActivity {
    private static final long INTERVAL = 2000;  //2s间隔
    /**
     * 再按一次退出程序
     */
    private long exitTime = 0;  //退出时间

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > INTERVAL) {
                exitTime = System.currentTimeMillis();
                ToastUtil.showShort(getString(R.string.exit_application_click_once_again));
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
