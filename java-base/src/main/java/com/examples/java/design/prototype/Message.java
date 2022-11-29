package com.examples.java.design.prototype;

import java.io.*;
import java.util.Date;

/**
 * 原型设计模式（说直白点就是将一个对象作为原型，对其进行复制、克隆产生一个和源对象类似的新对象），实现序列化和克隆接口
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
public class Message implements Cloneable, Serializable {

    private String content;
    private String name;
    private Integer size;
    private Date date;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 浅克隆
     */
    @Override
    protected Message clone() throws CloneNotSupportedException {
        return (Message) super.clone();
    }

    /**
     * 深度克隆
     */
    public Message deepClone() throws IOException, ClassNotFoundException {
        // 把对象写入到字节流中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        // 把字节流转化为对象
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (Message) ois.readObject();
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", date=" + date +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        // 浅克隆
        Message proto = new Message();
        proto.setContent("hello");
        proto.setDate(new Date());
        proto.setName("say");
        proto.setSize(500);
        // protoMsg.clone();  使用不同的克隆方式返回的结果不一样
        Message cloneMsg = proto.deepClone();
        System.out.println("proMsg = " + proto);
        System.out.println("newMsg = " + cloneMsg);
        // 浅复制只是复制了引用类型的值，并没有改变其地址，指向的仍然是原对象的变量地址
        System.out.println(proto.getContent().equals(cloneMsg.getContent()));
        System.out.println(proto.getDate().equals(cloneMsg.getDate()));
        System.out.println(proto.getName().equals(cloneMsg.getName()));
        System.out.println(proto.getSize().equals(cloneMsg.getSize()));
    }

}
