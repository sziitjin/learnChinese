package com.learn.chinese.interfaces;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/12  18:01
 */
public interface ICallback<T> {
    void onDone(T data);
}
