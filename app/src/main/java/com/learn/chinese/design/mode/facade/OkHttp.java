package com.learn.chinese.design.mode.facade;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  14:48
 */
public class OkHttp implements IHttpApi {
    @Override
    public void register() {
        System.out.println("OkHttp register");
    }

    @Override
    public void login() {
        System.out.println("OkHttp login");
    }

    @Override
    public void getUserInfo() {
        System.out.println("OkHttp getUserInfo");
    }
}
