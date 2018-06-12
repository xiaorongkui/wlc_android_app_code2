package com.qmkj.wlc.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;

/**
 * author：rongkui.xiao --2018/6/12
 * email：dovexiaoen@163.com
 * description:获取设备属性
 */

public class SystemUtil {
    /**
     * 返回当前程序版本名
     *
     * @param context the context
     * @return the app version name
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        int versioncode = 0;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            versioncode = pi.versionCode;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            LogUtil.i(e.getMessage());
        }
        return versionName;
    }


    /**
     * 获取分辨率
     *
     * @param context the context
     * @return the android pix
     */
    public static int getAndroidPixWidth(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取分辨率
     *
     * @param context the context
     * @return the android pix
     */
    public static int getAndroidPixHeigth(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
}
