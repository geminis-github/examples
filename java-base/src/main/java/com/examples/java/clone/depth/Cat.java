package com.examples.java.clone.depth;

/**
 * 克隆组合对象-猫猫
 *
 * @author liangjinlong9527
 * @date 2023-05-20 22:03
 */
public class Cat implements Cloneable{

    private boolean sex;

    public Cat(boolean sex) {
        this.sex = sex;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public Cat clone() {
        try {
            return (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "sex=" + sex +
                '}';
    }

}
