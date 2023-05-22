package com.examples.java.oom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 创建对象的六种方式
 *
 * <a href="javastack.cn/java-create-object-six-ways/">再见单身狗！Java 创建对象的 6 种方式，再也不用舔狗了。。</a>
 * @author liangjinlong9527
 * @date 2023-04-11 23:22
 */
public class CreateObjectWay {


    public static void main(String[] args) throws Exception {
        // 第一种：new
        Friend newFriend = new Friend();
        // 第二种：克隆
        Friend cloneFriend = (Friend) newFriend.clone();
        // 第三种：反射-构造器newInstance
        Friend reflectFriend = Friend.class.getDeclaredConstructor().newInstance();
        // 第四种：反射-forName
        Friend forNameFriend = (Friend) Class.forName("com.examples.java.oom.Friend").getDeclaredConstructor().newInstance();
        // 第五种：反序列化
        Friend fileFriend = new Friend("fileFriend");
        // 5.1、序列化一个对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("friend.obj"));
        objectOutputStream.writeObject(fileFriend);
        objectOutputStream.close();
        // 5.2、反序列化获得对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("friend.obj"));
        Friend readerFriend = (Friend) objectInputStream.readObject();
        objectInputStream.close();
    }

}
