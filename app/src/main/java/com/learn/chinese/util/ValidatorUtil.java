package com.learn.chinese.util;

import android.text.TextUtils;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/3/10  11:34
 */
public class ValidatorUtil {
    public static boolean isEmail(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            return str.contains("@") && str.contains(".");
        }
    }
}
