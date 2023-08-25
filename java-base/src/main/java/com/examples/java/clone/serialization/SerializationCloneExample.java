package com.examples.java.clone.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化和反序列化克隆对象演示
 * PS：序列化的方式克隆对象，相对比较比较消耗性能
 *
 * @see <a href="https://blog.csdn.net/qq_22343483/article/details/99961610">使用序列化与反序列化方式克隆对象</a>
 * @author liangjinlong9527
 * @date 2023-05-22 22:32
 */
public class SerializationCloneExample {

    public static void main(String[] args) {
        Person person1 = new Person("Jack", 23, new Car("BMW", 250));
        try {
            Person person2 = serializationClone(person1);
            person2.getCar().setBrand("BENZ");
            /**
             * 修改克隆的 Person 对象 p2 关联的汽车对象的品牌属性
             * 原来的 Person 对象 p1 关联的汽车不会受到任何影响
             * 因为在克隆 Person 对象时其关联的汽车对象也被克隆了
             */
            System.out.println("person1 = " + person1);
            System.out.println("person2 = " + person2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化克隆对象
     *
     * @param obj 需要被克隆的对象
     * @return 克隆对象
     * @param <T> 必须实现了可序列化接口
     * @throws IOException 流io异常
     * @throws ClassNotFoundException 克隆出来的Object对象强制转换类型的时候抛出
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T serializationClone(T obj) throws ClassNotFoundException, IOException {
        ByteArrayInputStream bin = null;
        ObjectInputStream ois = null;
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(bout)) {
            oos.writeObject(obj);
            bin = new ByteArrayInputStream(bout.toByteArray());
            ois = new ObjectInputStream(bin);
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            if (bin != null) {
                bin.close();
            }
            if (ois != null) {
                ois.close();
            }
        }
        return (T) ois.readObject();
    }

}
