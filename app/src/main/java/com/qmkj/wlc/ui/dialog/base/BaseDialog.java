package com.qmkj.wlc.ui.dialog.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Rongkui.xiao on 2017/5/9.
 *
 * @description 统一的对话框生成工具类
 */

public class BaseDialog extends Dialog {
    Activity activity;
    private final View mView;

    public BaseDialog(Activity context, int theme, int layoutResId) {
        super(context, theme);
        this.activity = context;
        mView = LayoutInflater.from(getContext()).inflate(layoutResId, null);
        setContentView(mView);
        super.setContentView(mView);
    }

    public <T extends View> T getView(int viewId, Class<T> clazz) {
        return (T) mView.findViewById(viewId);
    }

    public void setAlertDialogSize(int width, int height) {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        if (getWindow() != null) {
            lp.copyFrom(getWindow().getAttributes());
            lp.width = width;
            lp.height = height;
            getWindow().setAttributes(lp);
        }
    }

    /**
     * @param width 对话框的宽度
     */
    public void setAlertDialogWidth(int width) {
//        final WindowManager.LayoutParams attrs = getWindow().getAttributes();
//        getWindow().setLayout(width, attrs.height);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        if (getWindow() != null) {
            lp.copyFrom(getWindow().getAttributes());
            lp.width = width;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            getWindow().setAttributes(lp);
        }
    }

    /**
     * @param height 对话框的高度
     */
    public void setAlertDialogHight(int height) {
        if (height <= 0) {
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            if (getWindow() != null) {
                lp.copyFrom(getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                getWindow().setAttributes(lp);
            }
        } else {
            if (getWindow() != null) {
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = height;
                getWindow().setAttributes(lp);
            }
        }
    }

    /**
     * @param gravity 对话框的位置 Gravity.BOTTOM
     */
    public void setAlertDialogGravity(int gravity) {
        //定义宽度
        if (getWindow() != null) {
            final WindowManager.LayoutParams attrs = getWindow().getAttributes();
            attrs.gravity = gravity;
            getWindow().setAttributes(attrs);
        }
    }

    /**
     * 关闭对话框
     */
    public void dismiss() {
        super.dismiss();
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = 1.0f;
        lp.dimAmount = 1.0f;
        activity.getWindow().setAttributes(lp);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    public void show() {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = 0.5f;
        lp.dimAmount = 0.5f;
        activity.getWindow().setAttributes(lp);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        super.show();
    }

    public void setAnimation(int style) {
        Window w = getWindow();
        if (w != null) {
            w.setWindowAnimations(style);
        }
    }
}
