package com.examples.java.clone.immutable;

/**
 * 不可变类（int），不提供public的修改方法，需要改变的话只会创建新的对象
 * 缺点：会频繁触发GC
 * 优点：线程安全
 *
 * @author liangjinlong9527
 * @date 2023-05-23 0:11
 */
public class ImmutableInt {

    /**
     * 持有的不可修改状态的数据
     */
    private final int data;

    /**
     * 构造器初始化数据对象
     *
     * @param data 数据
     */
    public ImmutableInt(int data) {
        this.data = data;
    }

    /**
     * 读取数据状态
     *
     * @return 数据状态
     */
    public int read() {
        return data;
    }

    /**
     * 判断数据是否为0
     *
     * @return status
     */
    public boolean nonZero() {
        return data != 0;
    }

    /**
     * 获取相乘后的数据对象，此处不修改原有对象，支持创建一个新的对象返回
     *
     * @param multiplier 乘数
     * @return 新的不可变int对象
     */
    public ImmutableInt multiply(int multiplier) {
        return new ImmutableInt(data * multiplier);
    }

    @Override
    public String toString() {
        return "ImmutableInt{" +
                "data=" + data +
                '}';
    }
}
