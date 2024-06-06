package com.lib.com

import android.app.Application
import android.content.Context
import com.lib.com.interfaces.IBaseApp
import com.lib.com.util.LogUtil

/**
 * @Author:  Jin
 * @Description:
 * @CreateDate: 2023/8/2  18:22
 */
class CommonApp : Application(), IBaseApp {

    companion object {
        @JvmStatic
        private var mContext: Context? = null

        @JvmStatic
        fun getAppContext(): Context? {
            return mContext?.applicationContext
        }

        @JvmStatic
        fun getContext(): Context {
            return mContext!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        initialize(this)
    }

    override fun initialize(app: Application) {
        LogUtil.i("CommonApp", "initialize")
        mContext = app.baseContext
    }
}