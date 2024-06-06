package com.learn.chinese.design.mode.observer;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  15:38
 */
public class ObserverImpl implements Observer {

    private String observerName;

    public ObserverImpl(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(String message) {
        System.out.println(observerName + ":" + message);
    }
}
