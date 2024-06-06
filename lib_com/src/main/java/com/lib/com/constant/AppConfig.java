package com.lib.com.constant;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2022/12/1  19:06
 */
public class AppConfig {
    /**
     * application包名+类名
     */
    private static final String LIB_COMMON = "com.lib.com.CommonApp";
    private static final String LIB_DEO = "com.lib.deo.DeoApp";

    /**
     * module application集合，通过反射初始化
     */
    public static final String[] APP_COMPONENTS = {LIB_COMMON, LIB_DEO};
}
