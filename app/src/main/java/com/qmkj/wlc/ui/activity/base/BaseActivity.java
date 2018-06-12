package com.qmkj.wlc.ui.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.activity.StoreManagementActivity;
import com.qmkj.wlc.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

/**
 * Base Activity
 */
public abstract class BaseActivity extends AppCompatActivity {
    public List<Disposable> disposableList = new ArrayList<>();
    protected Activity mContext;
    private Unbinder unbinder;

    /**
     * 初始化Actionbar(title)
     */
    protected abstract void initTitle();

    /**
     * 初始化Activity异常销毁保存的数据
     */
    public void initSavedInstanceState(Bundle bundle) {

    }

    /**
     * 初始化intent传递的数据
     */
    public void initIntentData(Intent intent) {

    }

    /**
     * 获取布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        unbinder = ButterKnife.bind(this);
        if (savedInstanceState != null) {
            initSavedInstanceState(savedInstanceState);
        }
        if (getIntent() != null) {
            initIntentData(getIntent());
        }
        initHeader();
        initTitle();
        initView();
        initData();
    }

    protected void initHeader() {
        View backIv = findViewById(R.id.back_iv);
        View backTv = findViewById(R.id.back_tv);
        if (backIv != null) {
            backIv.setOnClickListener(v -> finish());
        }
        if (backTv != null) {
            backTv.setOnClickListener(v -> finish());
        }
        View storeManagerTv = findViewById(R.id.store_manager_tv);
        if (storeManagerTv != null) {
            storeManagerTv.setOnClickListener(v -> ActivityUtils.startActivity(mContext, StoreManagementActivity
                    .class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
    }
}
