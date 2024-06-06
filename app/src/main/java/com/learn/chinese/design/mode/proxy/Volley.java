package com.learn.chinese.design.mode.proxy;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  15:09
 */
public class Volley implements IHttpApi {
    @Override
    public void register() {
        System.out.println("Volley register");
    }

    @Override
    public void login() {
        System.out.println("Volley login");
    }

    @Override
    public void getUserInfo() {
        System.out.println("Volley getUserInfo");
    }
}
