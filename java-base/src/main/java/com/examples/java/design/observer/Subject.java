package com.examples.java.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 *
 * @author: Thinking9527
 * @date: 2023-04-01 00:32
 */
public interface Subject<T> {

    /**
     * 存储订阅者
     */
    List<Observer> list = new ArrayList<>();

    /**
     * 注册订阅者
     *
     * @param obs 订阅者
     */
    void registerObserver(T obs);


    /**
     * 移除订阅者
     *
     * @param obs 订阅者
     */
    void removeObserver(T obs);

    /**
     * 通知所有的观察者更新状态
     */
    void notifyAllObservers();


}

