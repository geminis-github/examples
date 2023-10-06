package com.examples.java.clone.depth;

/**
 * 克隆组合对象-狗狗
 *
 * @author Thinking9527
 * @date 2023-05-20 21:57
 */
public class Dog implements Cloneable {

    private int age;

    public Dog(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Dog clone() {
        try {
            return (Dog) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }
}
