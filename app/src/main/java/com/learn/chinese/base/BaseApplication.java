package com.learn.chinese.base;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.learn.chinese.util.SharedPre;
import com.learn.chinese.util.UuidUtil;
import com.lib.com.sdk.DeoSdk;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/12  10:15
 */
public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        DeoSdk.init(this);
        initNicknameAndAccount();
    }

    private void initNicknameAndAccount() {
        String nickname = SharedPre.getInstance().getString("nick_name");
        if (TextUtils.isEmpty(nickname)) {
            SharedPre.getInstance().putString("nick_name", "CN" + UuidUtil.getUUID());
        }
        String account = SharedPre.getInstance().getString("account");
        if (TextUtils.isEmpty(account)) {
            SharedPre.getInstance().putString("account", UuidUtil.getUUID(10));
        }
    }

    public static Context getContext() {
        return mContext;
    }

    public static Context getAppContext() {
        return mContext.getApplicationContext();
    }
}
