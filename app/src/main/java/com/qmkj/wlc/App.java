package com.qmkj.wlc;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class App extends Application {
    private static App context;

    public static App getInstance() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
