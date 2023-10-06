package com.examples.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * java8 Stream流的使用示例
 *
 * @author Thinking9527
 * @date 2023-04-12 22:48
 */
public class StreamExample {

    public static final List<String> list = List.of("one", "two", "three", "jack", "json", "mark", "mock", "bite", "boos", "china", "chinese", "check", "very good", "hello world", "geminis", "title");

    public static void main(String[] args) {
        Stream<String> listStream = list.stream();

    }

}
