package com.examples.java.design.observer;

/**
 * 观察者模式
 *
 * @see <a href="https://blog.csdn.net/qq_38526573/article/details/87483479">Java观察者模式(Observer)</a>
 * @author: Thinking9527
 * @date: 2023-04-01 00:38
 */
public class ClientExample {

    public static void main(String[] args) {
        // 目标对象
        ConcreteSubject subject = new ConcreteSubject();

        // 创建多个观察者
        ObserverOne obs1 = new ObserverOne();
        ObserverOne obs2 = new ObserverOne();
        ObserverOne obs3 = new ObserverOne();

        // 将这三个观察者添加到subject对象的观察者队伍中
        subject.registerObserver(obs1);
        subject.registerObserver(obs2);
        subject.registerObserver(obs3);

        // 改变subject的状态
        subject.setState(3000);
        System.out.println("########################");
        // 我们看看，观察者的状态是不是也发生了变化
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

        // 改变subject的状态
        subject.setState(30);
        System.out.println("########################");
        // 我们看看，观察者的状态是不是也发生了变化
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

        // 改变subject的状态
        subject.setState(99);
        System.out.println("########################");
        // 我们看看，观察者的状态是不是也发生了变化
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());
    }

}
