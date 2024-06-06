package com.learn.chinese.util;

import java.util.UUID;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/27  10:20
 */
public class UuidUtil {

    /**
     * 默认获取6位的UUID
     *
     * @return
     */
    public static String getUUID() {
        return getUUID(6);
    }

    public static String getUUID(int index) {
        // 32个字符长度的字符串
        UUID uuid = UUID.randomUUID();
        if (index >= 32) return uuid.toString();
        return uuid.toString().substring(0, index);
    }
}
