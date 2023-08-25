package com.examples.java.clone.immutable;

/**
 * 可不可变类使用示例
 *
 * @author liangjinlong9527
 * @date 2023-05-23 0:25
 */
public class ImmutableIntExample {

    public static void main(String[] args) {
        // 不可变类对象使用示例
        ImmutableInt one = new ImmutableInt(10);
        ImmutableInt two = one.multiply(5);
        System.out.println("one: " + one.read());
        System.out.println("two: " +two.read());
        // 如果需要频繁修改的话，先使用可变对象修改完成再转换成不可变类对象
        MutableInt mutableInt = new MutableInt(10);
        ImmutableInt result = mutableInt.add(5).multiply(3).makeImmutable();
        System.out.println("immutableObj: " + result);
    }

}
