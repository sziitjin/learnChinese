package com.lib.deo;

import android.app.Application;
import android.content.Context;

import com.lib.com.interfaces.IBaseApp;
import com.lib.com.util.LogUtil;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/8/2  18:34
 */
public class DeoApp extends Application implements IBaseApp {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    @Override
    public void initialize(Application app) {
        LogUtil.i("DeoApp", "initialize");
        mContext = app.getApplicationContext();
    }

    public static Context getContext() {
        return mContext.getApplicationContext();
    }
}
