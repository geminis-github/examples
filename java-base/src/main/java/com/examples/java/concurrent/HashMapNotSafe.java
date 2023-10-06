package com.examples.java.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 测试HashMap不是线程安全的
 *
 * @author Thinking9527
 * @date 2023-09-03 13:49
 */
public class HashMapNotSafe {

    public static void main(String[] args) {
        final Map<Integer, String> map = new HashMap<>();
        final Integer targetKey = 0b1111_1111_1111_1111; // 65535
        final String targetValue = "v";
        // put内容
        map.put(targetKey, targetValue);
        new Thread(() -> {
            // 循环插入，模拟真实环境一直put会触发扩容导致线程不安全的机制
            IntStream.range(0, targetKey).forEach(key -> map.put(key, "someValue"));
        }).start();
        while (true) {
            // 如果 HashMap 是线程安全的，那么无论如何，取出来的值就应该是一开始放进去的字符串 “v“
            if (null == map.get(targetKey)) {
                throw new RuntimeException("HashMap is not thread safe.");
            }
        }
    }

}
