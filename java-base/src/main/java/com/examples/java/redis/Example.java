package com.examples.java.redis;

/**
 * 使用示例
 *
 * @author Thinking9527
 * @date 2023-08-27 7:44
 */
public class Example {

    public static void main(String[] args) {
        // 初始化一个缓存容器，并给一个最大缓存容量
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.put("one", "1");
        cache.put("two", "2");
        cache.put("three", "3");
        // 当增加到最大容量的时候，在往里添加元素，则会删除最早加入的元素
        System.out.println(cache);
        cache.put("four", "4");
        cache.put("five", "5");
        // 只会有三个元素，one和two都已经被删除
        System.out.println(cache);
    }

}
