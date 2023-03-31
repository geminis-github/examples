package com.examples.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 遍历删除List元素
 *
 * @see <a href="https://mp.weixin.qq.com/s/9EyfmuWrGZ7WzfQOE6WYJQ">遍历删除List元素</a>
 * @author: liangjinlong9527
 * @date: 2023-03-21 00:32
 */
public class ListEachRemove {

    /**
     * 元素集合，需要遍历删除姓“李”的人
     */
    private static List<String> initList = Arrays.asList("张三", "李四", "周一", "刘四", "李强", "李白");

    public static void main(String[] args) {
        remove02();
    }

    /**
     * 普通 for 循环倒序删除
     */
    public static void remove01() {
        List<String> list = new ArrayList(initList);
        for (int i = list.size() - 1; i > 0; i--) {
            String str = list.get(i);
            if (str.startsWith("李")) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }

    /**
     * 迭代器循环删除（iterator.remove）
     */
    public static void remove02() {
        List<String> list = new ArrayList(initList);
        // for
//        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
//            String str = iterator.next();
//            if (str.startsWith("李")) {
//                iterator.remove();
//            }
//        }
        // while
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.startsWith("李")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    /**
     * stream filter 过滤
     */
    public static void remove03() {
        List<String> list = new ArrayList(initList);
        list = list.stream().filter(e -> !e.startsWith("李")).collect(Collectors.toList());
        System.out.println(list);
    }

}
