package com.learn.chinese.design.mode.facade;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  14:50
 */
public class UserApi {

    private OkHttp okHttp;

    public static UserApi getInstance(){
        return UserApiHelper.userApi;
    }

    private static class UserApiHelper{
        private static UserApi userApi = new UserApi();
    }

    private UserApi() {
        okHttp = new OkHttp();
    }

    public void login(){
        System.out.println("UserApi login");
        okHttp.register();
        okHttp.login();
    }

    public void getUserInfo(){
        System.out.println("UserApi getUserInfo");
        okHttp.login();
        okHttp.getUserInfo();
    }
}
