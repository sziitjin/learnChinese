package com.learn.chinese.design.mode.factory;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  16:05
 */
public class Bike implements Car{
    @Override
    public void drive() {
        System.out.println("Bike drive");
    }
}
