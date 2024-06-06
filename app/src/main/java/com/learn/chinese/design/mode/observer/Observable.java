package com.learn.chinese.design.mode.observer;

/**
 * @Author: Jin
 * @Description: 被观察者接口
 * @CreateDate: 2023/7/24  15:33
 */
public interface Observable {
    // 添加观察者
    void addObserver(Observer observer, String key);

    // 移除观察者
    void removeObserver(Observer observer);

    // 通知观察者
    void notifyObserver(String message, String key);
}
