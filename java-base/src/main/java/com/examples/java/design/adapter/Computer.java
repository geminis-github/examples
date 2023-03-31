package com.examples.java.design.adapter;

/**
 * 客户端：想上网，插不上网线
 *
 * @author liangjinlong9527
 * @date 2023-03-08 23:17
 */
public class Computer {

    /**
     * 上网
     *
     * @param adapter 适配器
     */
    public void net(NetToUsb adapter){
        // 上网的具体实现：找一个转接头
        adapter.handleRequest();
    }

    public static void main(String[] args) {
        // 电脑：需要上网的对象
        Computer computer = new Computer();
        // 网线
        Adaptee adaptee = new Adaptee();
        // 适配器（网线 -> usb）
        Adapter adapter = new Adapter(adaptee);
        // 上网（需要usb才能上网）
        computer.net(adapter);
    }

}
