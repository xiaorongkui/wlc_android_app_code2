package com.qmkj.wlc.common;


import com.qmkj.wlc.App;
import com.qmkj.wlc.utils.preferences.PreferencesUtils;

/**
 * Created by Yun on 2018/1/5.
 * 项目参数配置
 */
public interface Constants {
    /**
     * 项目名
     */
    String PROJECT = "wlc";
    String BUGLY_APP_ID = "";

    /**
     * 数据库名称
     */
    String DB_NAME = PROJECT + ".db";

    String KEY_BASE_URL = "key_base_url";
    /**
     * 服务器地址
     */
    String BASE_URL = PreferencesUtils.getString(App.getInstance(), KEY_BASE_URL,
            "xxx");

    //INTENT KEY
    public static final String INTENT_PARAMETER_1 = "intent_parameter_1";
    public static final String INTENT_PARAMETER_2 = "intent_parameter_2";
}
