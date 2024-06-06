package com.lib.com.util

import android.util.Log

/**
 * @Author:  Jin
 * @Description: log管理
 * @CreateDate: 2022/10/27  16:11
 */
class LogUtil {
    companion object {
        /**
         * 打印日志，默认不保存到本地
         */
        @JvmStatic
        fun i(tag: String, msg: String) {
            Log.i(tag, msg)
        }

        /**
         * 打印日志，true 保存到本地
         */
        @JvmStatic
        fun i(tag: String, msg: String, isSaveLog: Boolean) {
            Log.i(tag, msg)
        }

        @JvmStatic
        fun v(tag: String, msg: String) {
            Log.v(tag, msg)
        }

        @JvmStatic
        fun d(tag: String, msg: String) {
            Log.d(tag, msg)
        }

        /**
         * 打印错误日志，保存到本地
         */
        @JvmStatic
        fun e(tag: String, msg: String) {
            Log.e(tag, msg)
        }
    }
}