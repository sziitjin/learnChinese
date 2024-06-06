package com.learn.chinese.design.mode.factory;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  16:07
 */
public class Bus implements Car{
    @Override
    public void drive() {
        System.out.println("Bus drive");
    }
}
