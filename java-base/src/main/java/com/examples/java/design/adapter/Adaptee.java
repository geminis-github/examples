package com.examples.java.design.adapter;

/**
 * 要适配的类：网线（被收养者）
 *
 * @author Thinking9527
 * @date 2023-03-07 23:17
 */
public class Adaptee {

    /**
     * 功能：上网
     */
    public void request(){
        System.out.println("链接网线上网");
    }

}
