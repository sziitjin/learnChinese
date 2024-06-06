package com.lib.com.sdk

import android.app.Application

/**
 * @Author:  Jin
 * @Description:
 * @CreateDate: 2023/8/2  18:31
 */
class DeoSdk {
    companion object {
        @JvmStatic
        private val TAG = "DeoSdk："

        @JvmStatic
        fun init(application: Application) {
            if (application == null) {
                throw NullPointerException(TAG + "Application can't be null.")
            }
            AppModule.init(application)
        }
    }
}