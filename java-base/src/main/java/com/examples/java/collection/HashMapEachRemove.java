package com.examples.java.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

/**
 * HashMap遍历删除（根据value删除）
 *
 * @see <a href="https://mp.weixin.qq.com/s/zzW7C2kNvJS8RS9KfIi4sw">面试官：怎么删除 HashMap 中的元素？我一行代码搞定，赶紧拿去用！</a>
 * @author: liangjinlong9527
 * @date: 2023-03-21 22:47
 */
public class HashMapEachRemove {

    public static Map<String, String> initMap = new HashMap<>() {{
        put("user1", "张三");
        put("user2", "李四");
        put("user3", "张三");
        put("user4", "李四");
        put("user5", "王五");
        put("user6", "赵六");
        put("user7", "李四");
        put("user8", "王五");
    }};

    /**
     * 使用 for 循环删除
     */
    public void remove01() {
        Set<Map.Entry<String, String>> entries = new CopyOnWriteArraySet<>(initMap.entrySet());
        for (Map.Entry<String, String> entry : entries) {
            if ("张三".equals(entry.getValue())) {
                initMap.remove(entry.getKey());
            }
        }
        System.out.println(initMap);
    }

    /**
     * 使用 forEach 循环删除
     */
    public void remove02() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(initMap);
        map.forEach((k, v) -> {
            if ("张三".equals(v)) {
                map.remove(k);
            }
        });
        System.out.println(map);
    }

    /**
     * 使用 Iterator 迭代器删除
     */
    public void remove3() {
        Iterator<Map.Entry<String, String>> iterator = initMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if ("张三".equals(entry.getValue())) {
                iterator.remove();
            }
        }
        System.out.println(initMap);
    }

    /**
     * 使用 removeIf 删除
     */
    public void remove04() {
        initMap.entrySet().removeIf(entry -> "张三".equals(entry.getValue()));
        System.out.println(initMap);
    }

    /**
     * 使用 Stream 删除
     */
    public void remove05() {
        Map<String, String> map = initMap.entrySet().stream()
                .filter(entry -> !"张三".equals(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(map);
    }
}
