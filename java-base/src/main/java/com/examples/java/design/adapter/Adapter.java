package com.examples.java.design.adapter;

/**
 * 适配器：(收养者)真正的适配器，链接usb,连接网线
 *
 * @see <a href="https://blog.csdn.net/IAMZTDSF/article/details/124387246">Java设计模式之适配器模式详解</a>
 * @author Thinking9527
 * @date 2023-03-07 23:17
 */
public class Adapter implements NetToUsb {

    /**
     * 收养的对象
     */
    private Adaptee adaptee;

    /**
     * 构造参数，需要给一个收养对象
     *
     * @param adaptee 收养对象
     */
    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request(); // 可以上网了（通过操作收养对象的方法来实现适配）
    }

}
