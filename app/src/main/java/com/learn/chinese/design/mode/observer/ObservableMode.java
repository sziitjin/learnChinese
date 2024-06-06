package com.learn.chinese.design.mode.observer;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/24  15:52
 */
public class ObservableMode {

    public static void main(String[] args) {
        // 创建观察者
        ObserverImpl observer1 = new ObserverImpl("observer1");
        ObserverImpl observer2 = new ObserverImpl("observer2");
        ObserverImpl observer3 = new ObserverImpl("observer3");
        // 添加观察者
        ObservableImpl.getInstance().addObserver(observer1, "test");
        ObservableImpl.getInstance().addObserver(observer2, "test");
        ObservableImpl.getInstance().addObserver(observer3, "test");
        // 通知观察者
        ObservableImpl.getInstance().notifyObserver("更新数据", "test");
    }
}
