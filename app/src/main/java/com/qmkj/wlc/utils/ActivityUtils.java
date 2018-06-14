package com.qmkj.wlc.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Activity 工具类
 */
public class ActivityUtils {

    /**
     * 跳转Activity
     *
     * @param context
     * @param cls
     */
    public static void startActivity(Context context, Class<?> cls) {
        context.startActivity(new Intent(context, cls));
    }

    /**
     * 跳转Activity
     *
     * @param context
     * @param cls
     */
    public static void startActivityAndFinish(Context context, Class<?> cls) {
        context.startActivity(new Intent(context, cls));
        ((Activity) context).finish();
    }


}
