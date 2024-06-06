package com.learn.chinese.design.mode.facade;

/**
 * @Author: Jin
 * @Description: 外观模式
 * @CreateDate: 2023/7/24  14:16
 */
public class FacadeMode {

    public static void main(String[] args) {
        UserApi.getInstance().login();
        UserApi.getInstance().getUserInfo();
    }
}
