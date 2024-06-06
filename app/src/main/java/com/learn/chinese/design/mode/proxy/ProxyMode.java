package com.learn.chinese.design.mode.proxy;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  15:04
 */
public class ProxyMode {

    public static void main(String[] args) {
        // 代理OkHttp
        System.out.println("代理OkHttp");
        OkHttp okHttp = new OkHttp();
        UserApi userApi = new UserApi(okHttp);
        userApi.register();
        userApi.login();
        userApi.getUserInfo();
        // 代理Volley
        System.out.println("代理Volley");
        Volley volley = new Volley();
        userApi = new UserApi(volley);
        userApi.register();
        userApi.login();
        userApi.getUserInfo();
    }
}
