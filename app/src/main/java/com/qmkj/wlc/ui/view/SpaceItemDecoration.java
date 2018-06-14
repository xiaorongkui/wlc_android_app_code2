package com.qmkj.wlc.ui.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称： 分割线
 * RecyclerView 以Grid方式垂直排列
 * 用于在item之间产生间距
 * email: 380948730@qq.com
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private static final int DEFAULT_COLUMN = Integer.MAX_VALUE;
    private int space;
    private int column;

    public SpaceItemDecoration(int space) {
        this(space, DEFAULT_COLUMN);
    }

    public SpaceItemDecoration(int space, int column) {
        this.space = space;
        this.column = column;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = space;
        int pos = parent.getChildLayoutPosition(view);
        int total = parent.getChildCount();
        if (isFirstRow(pos)) {
            outRect.top = 0;
        }
        if (isLastRow(pos, total)) {
            outRect.bottom = 0;
        }
        if (column != DEFAULT_COLUMN) {
            float avg = (column - 1) * space * 1.0f / column;
            outRect.left = (int) (pos%column * (space - avg));
            outRect.right = (int) (avg - (pos%column * (space - avg)));
        }
    }

    boolean isFirstRow(int pos) {
        return pos < column;
    }

    boolean isLastRow(int pos, int total) {
        return total - pos <= column;
    }

    boolean isFirstColumn(int pos) {
        return pos % column == 0;
    }

    boolean isSecondColumn(int pos) {
        return isFirstColumn(pos - 1);
    }

    boolean isEndColumn(int pos) {
        return isFirstColumn(pos + 1);
    }

    boolean isNearEndColumn(int pos) {
        return isEndColumn(pos + 1);
    }

}
