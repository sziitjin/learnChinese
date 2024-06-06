package com.lib.com.util

import android.content.Context

/**
 * @Author:  Jin
 * @Description:
 * @CreateDate: 2023/7/20  14:10
 */
class FileUtil {
    companion object {
        /**
         * @return data/data/应用包名/files
         */
        @JvmStatic
        fun getFilesDir(context: Context): String {
            return context.filesDir.absolutePath
        }

        /**
         * @return data/data/应用包名/cache
         */
        @JvmStatic
        fun getCacheDir(context: Context): String {
            return context.cacheDir.absolutePath
        }
    }
}