package com.learn.chinese.design.mode.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Jin
 * @Description: 被观察者实现类(管理所有观察者)
 * @CreateDate: 2023/7/24  15:36
 */
public class ObservableImpl implements Observable {

    /**
     * 使用线程安全的ConcurrentHashMap
     */
    private Map<String, List<Observer>> observerMap = new ConcurrentHashMap<>();

    public static ObservableImpl getInstance() {
        return ObservableHelper.observable;
    }

    private static class ObservableHelper {
        private static ObservableImpl observable = new ObservableImpl();
    }

    @Override
    public void addObserver(Observer observer, String key) {
        if (observerMap.containsKey(key)) {
            List<Observer> observerList = observerMap.get(key);
            if (!observerList.contains(observer)) {
                observerList.add(observer);
                observerMap.put(key, observerList);
            }
        } else {
            List<Observer> observerList = new ArrayList<>();
            observerList.add(observer);
            observerMap.put(key, observerList);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        Iterator<Map.Entry<String, List<Observer>>> iterator = observerMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Observer>> entry = iterator.next();
            String key = entry.getKey();
            List<Observer> observerList = entry.getValue();
            // 处理键值对
            if (observerList.contains(observer)) {
                observerList.remove(observer);
                observerMap.put(key, observerList);
            }
        }
    }

    @Override
    public void notifyObserver(String message, String key) {
        if (!observerMap.containsKey(key)) {
            return;
        }
        List<Observer> observerList = observerMap.get(key);
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }
}
