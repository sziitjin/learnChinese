package com.learn.chinese.design.mode.factory;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  16:04
 */
public class Train implements Car {
    @Override
    public void drive() {
        System.out.println("Train drive");
    }
}
