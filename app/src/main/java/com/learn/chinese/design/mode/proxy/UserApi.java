package com.learn.chinese.design.mode.proxy;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  15:12
 */
public class UserApi implements IHttpApi {
    private IHttpApi iHttpApi;

    public UserApi(IHttpApi iHttpApi) {
        this.iHttpApi = iHttpApi;
    }


    @Override
    public void register() {
        System.out.println("UserApi register");
        iHttpApi.register();
    }

    @Override
    public void login() {
        System.out.println("UserApi login");
        iHttpApi.login();
    }

    @Override
    public void getUserInfo() {
        System.out.println("UserApi getUserInfo");
        iHttpApi.getUserInfo();
    }
}
