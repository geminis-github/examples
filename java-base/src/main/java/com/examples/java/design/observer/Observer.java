package com.examples.java.design.observer;

/**
 * 观察者
 *
 * @author: Thinking9527
 * @date: 2023-04-01 00:34
 */
public interface Observer {

    /**
     * 更新
     *
     * @param subject 对象目标模板
     */
    void update(Subject subject);

}