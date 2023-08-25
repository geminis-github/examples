package com.examples.java.clone.immutable;

/**
 * 用于修改不可变类的伴生类（这里是ImmutableInt），就比如String（不可变）和StringBuilder（可变）的关系一样
 * 如果有很多的修改工作，可以切换使用可变类进行操作，完成之后切换回不可变类
 *
 * @author liangjinlong9527
 * @date 2023-05-23 0:29
 */
public class MutableInt {

    /**
     * 状态数据，可以被修改
     */
    private int data;

    public MutableInt(int data) {
        this.data = data;
    }

    public MutableInt add(int x) {
        this.data += x;
        return this;
    }

    public MutableInt multiply(int x) {
        this.data *= x;
        return this;
    }

    /**
     * 获取不可变类对象
     *
     * @return 不可变类对象
     */
    public ImmutableInt makeImmutable() {
        return new ImmutableInt(data);
    }

}
