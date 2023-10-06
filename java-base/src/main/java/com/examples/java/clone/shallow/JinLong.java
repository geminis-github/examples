package com.examples.java.clone.shallow;


/**
 * 金龙-有猫有狗
 *
 * @author Thinking9527
 * @date 2023-05-20 22:12
 */
public class JinLong implements Cloneable {

    private Dog dog;
    private Cat cat;

    public JinLong(int dogVal, boolean catVal) {
        this.dog = new Dog(dogVal);
        this.cat = new Cat(catVal);
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public JinLong clone() {
        try {
            return (JinLong) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "JinLong{" +
                "dog=" + dog +
                ", cat=" + cat +
                '}';
    }

}
