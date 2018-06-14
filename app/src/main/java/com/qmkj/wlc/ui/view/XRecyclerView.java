package com.qmkj.wlc.ui.view;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 创建日期：2018/6/14
 * @author Yi Shan Xiang
 * 文件名称： MyRecycleView
 * email: 380948730@qq.com
 */

public class XRecyclerView extends RecyclerView{
    boolean mIsCanRefresh = true;

    public XRecyclerView(Context context) {
        super(context,null);
    }

    public XRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XRecyclerView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        //设置布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(layoutManager);

        //添加分割线
        addItemDecoration(new DividerItemDecoration(context,DividerItemDecoration.VERTICAL));

        //设置滚动监听
        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int topRowVerticalPosition =
                        (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0)
                                .getTop();
                mIsCanRefresh = topRowVerticalPosition >= 0;
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    /**
     * 是否可以划动
     * @return
     */
    public boolean isCanRefresh(){
        return mIsCanRefresh;
    }
}
