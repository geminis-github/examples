package com.examples.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List去除重复元素
 *
 * @see <a href="https://mp.weixin.qq.com/s/4wIb-DDxu51iYEpswfZTTA">面试官：怎么去除 List 中的重复元素？我一行代码搞定，赶紧拿去用！</a>
 * @author: Thinking9527
 * @date: 2023-03-21 22:12
 */
public class ListDuplicatedRemove {

    /**
     * 3 个张三，2 个李强
     */
    private static final List<String> initList = Arrays.asList(
            "张三",
            "李四",
            "张三",
            "周一",
            "刘四",
            "李强",
            "李白",
            "张三",
            "李强",
            "王五"
    );

    /**
     * for 循环添加去重
     */
    public void remove01() {
        List<String> list = new ArrayList(initList);
        List<String> itemList = new ArrayList<>();
        for (String element : list) {
            if (!itemList.contains(element)) {
                itemList.add(element);
            }
        }
        System.out.println(itemList);
    }

    /**
     * for 双循环去重（倒序循环删除）
     */
    public void remove02() {
        List<String> list = new ArrayList(initList);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        System.out.println(list);
    }

    /**
     * for 循环重复坐标去重（判断两个相同元素出现的位置是否一样，不一样则删除）
     */
    public void remove03() {
        List<String> list = new ArrayList(initList);
        List<String> itemList = new ArrayList(initList);
        for (String element : itemList) {
            if (list.indexOf(element) != list.lastIndexOf(element)) {
                list.remove(list.lastIndexOf(element));
            }
        }
        System.out.println(list);
    }

    /**
     * Set 去重（如果要保证顺序性，可以把 HashSet 换成 LinkedHashSet）
     */
    public void remove04() {
        List<String> list = new ArrayList(initList);
        List<String> list2 = new ArrayList(new HashSet(list));
        System.out.println(list2);
    }

    /**
     * Stream 去重
     */
    public void remove05() {
        List<String> list = new ArrayList(initList);
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);
    }

}
