package com.examples.java.design.observer;

/**
 * 具体观察者角色
 *
 * @author: Thinking9527
 * @date: 2023-04-01 00:37
 */
public class ObserverOne implements Observer {

    /**
     * myState需要跟目标对象的state值保持一致！
     */
    private int myState;

    /**
     * 这里的update方法是当Subject发生改变的时候，用于更新的方法（更新为和目标对象的值一致）
     */
    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject)subject).getState();
    }

    public int getMyState() {
        return myState;
    }
    public void setMyState(int myState) {
        this.myState = myState;
    }
}
