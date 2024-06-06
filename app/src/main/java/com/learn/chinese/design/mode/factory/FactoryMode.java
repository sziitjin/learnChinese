package com.learn.chinese.design.mode.factory;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  16:01
 */
public class FactoryMode {
    public static void main(String[] args) {
        CarFactory.makeCar("Bike").drive();
        CarFactory.makeCar("Bus").drive();
        CarFactory.makeCar("Train").drive();
    }
}
