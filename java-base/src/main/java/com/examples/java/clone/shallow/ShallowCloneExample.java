package com.examples.java.clone.shallow;

/**
 * 浅克隆使用示例
 *
 * @author liangjinlong9527
 * @date 2023-05-20 22:51
 */
public class ShallowCloneExample {

    public static void main(String[] args) {
        // 初始对象
        JinLong reading = new JinLong(20, false);
        // 进行克隆
        JinLong clone = reading.clone();
        // 对克隆对象的修改不会影响到原始对象
        Dog dog = clone.getDog();
        dog.setAge(999);
        Cat cat = clone.getCat();
        cat.setSex(true);
        // 引用互相影响
        System.out.println(reading); // JinLong{dog=Dog{age=999}, cat=Cat{sex=true}}
        System.out.println(clone); // JinLong{dog=Dog{age=999}, cat=Cat{sex=true}}
    }

}
