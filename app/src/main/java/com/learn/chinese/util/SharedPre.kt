package com.learn.chinese.util

import android.content.Context
import android.content.SharedPreferences
import com.learn.chinese.base.BaseApplication

/**
 * @Author:  Jin
 * @Description:
 * @CreateDate: 2022/11/22  10:58
 */
class SharedPre {
    private var mPreferences: SharedPreferences? = null

    companion object {
        @JvmStatic
        private val TAG: String = "SharedPre"

        @JvmStatic
        private val PREFERENCE_NAME = "LEARN_CN"

        @JvmStatic
        fun getInstance() = SharedPreHelper.sharedPre
    }

    init {
        mPreferences = BaseApplication.getAppContext()?.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    object SharedPreHelper {
        val sharedPre = SharedPre()
    }

    fun putString(key: String, value: String) {
        val editor: SharedPreferences.Editor? = mPreferences?.edit()
        editor?.putString(key, value)
        editor?.commit()
    }

    fun putLong(key: String, value: Long) {
        val editor: SharedPreferences.Editor? = mPreferences?.edit()
        editor?.putLong(key, value)
        editor?.commit()
    }

    fun putInt(key: String, value: Int) {
        val editor: SharedPreferences.Editor? = mPreferences?.edit()
        editor?.putInt(key, value)
        editor?.commit()
    }

    fun putBoolean(key: String, value: Boolean) {
        val editor: SharedPreferences.Editor? = mPreferences?.edit()
        editor?.putBoolean(key, value)
        editor?.commit()
    }

    fun getString(key: String): String {
        return getString(key, "")
    }

    fun getString(key: String, defValue: String): String {
        return mPreferences?.getString(key, defValue)!!
    }

    fun getLong(key: String): Long {
        return getLong(key, -1)
    }

    fun getLong(key: String, defValue: Long): Long {
        return mPreferences?.getLong(key, defValue)!!
    }

    fun getInt(key: String): Int {
        return getInt(key, -1)
    }

    fun getInt(key: String, defValue: Int): Int {
        return mPreferences?.getInt(key, defValue)!!
    }

    fun getBoolean(key: String): Boolean {
        return getBoolean(key, false)
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return mPreferences?.getBoolean(key, defValue)!!
    }
}