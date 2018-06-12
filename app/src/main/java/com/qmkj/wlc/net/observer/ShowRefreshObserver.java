package com.qmkj.wlc.net.observer;

import android.content.Context;

import com.qmkj.wlc.ui.view.refreshlayout.XRefreshLayout;

/**
 * Created by Yun on 2018/2/19 0019.
 * 网络请求观察者（请求结束时会关闭下拉刷新）
 */
public abstract class ShowRefreshObserver<T> extends BaseShowLoadingObserver<T> {
    private XRefreshLayout xRefreshLayout;

    protected ShowRefreshObserver(Context context, XRefreshLayout xRefreshLayout) {
        super(context);
        this.xRefreshLayout = xRefreshLayout;
    }

    @Override
    protected void showLoading() {
        //do nothing
    }

    @Override
    protected void hideLoading() {
        if (xRefreshLayout != null && xRefreshLayout.isRefreshing()) {
            xRefreshLayout.refreshComplete();
        }
    }
}
