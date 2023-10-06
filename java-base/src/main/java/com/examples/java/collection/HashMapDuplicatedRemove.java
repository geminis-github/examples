package com.examples.java.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 怎么删除 HashMap 中的重复元素
 *
 * @see <a href="https://www.javastack.cn/remove-duplicated-elements-from-hashmap/">面试官：怎么删除 HashMap 中的重复元素？第 3 种实现思路，99% 的人不会！</a>
 * @author: Thinking9527
 * @date: 2023-03-21 22:40
 */
public class HashMapDuplicatedRemove {

    public Map<String, String> initMap = new HashMap<>() {{
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
     * 新创建 Map 添加不重复元素
     */
    public void removeDuplicated01() {
        Map<String, String> map = new HashMap<>();
        initMap.forEach((k, v) -> {
            if (!map.containsValue(v)) {
                map.put(k, v);
            }
        });
        System.out.println(map);
    }

    /**
     * 添加 Set 再删除重复元素
     */
    public void removeDuplicated02() {
        Set<String> set = new HashSet<>();
        Iterator<Map.Entry<String, String>> iterator = initMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (!set.add(entry.getValue())) {
                iterator.remove();
            }
        }
        System.out.println(initMap);
    }

    /**
     * 使用 Stream 删除重复元素
     */
    public void removeDuplicated03() {
        Map<String, String> resultMap = initMap.entrySet().stream().collect(
                Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (key1, key2) -> key1)
        ).entrySet().stream().collect(
                Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (key1, key2) -> key1)
        );
        System.out.println(resultMap);
    }

}
