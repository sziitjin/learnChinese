package com.lib.com.sdk

import android.app.Application
import com.lib.com.constant.AppConfig
import com.lib.com.interfaces.IBaseApp
import com.lib.com.util.LogUtil


class AppModule {
    companion object {
        @JvmStatic
        val TAG = "AppModule"

        @JvmStatic
        fun init(application: Application) {
            for (component in AppConfig.APP_COMPONENTS) {
                try {
                    val clazz = Class.forName(component)
                    val obj = clazz.newInstance()
                    if (obj is IBaseApp) {
                        obj.initialize(application)
                    }
                } catch (e: Exception) {
                    LogUtil.e(TAG, "init err ${e.message}")
                }
            }
        }
    }
}