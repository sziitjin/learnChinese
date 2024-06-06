package com.learn.chinese.design.mode.factory;

import android.widget.Switch;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  16:08
 */
public class CarFactory {
    public static Car makeCar(String type) {
        Car car = null;
        switch (type) {
            case "Bike":
                car = new Bike();
                break;
            case "Bus":
                car = new Bus();
                break;
            case "Train":
                car = new Train();
                break;
        }
        return car;
    }
}
