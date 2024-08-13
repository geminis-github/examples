package com.examples.java.stream;

import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson2.JSONArray;

import java.util.List;

/**
 * java8 Stream流的使用示例
 *
 * @author Thinking9527
 * @date 2023-04-12 22:48
 */
public class StreamExample {

    private static final List<StreamUser> list;

    static {
        FileReader reader = new FileReader("D:\\dev\\data\\user_data.json");
        String data = reader.readString();
        list = JSONArray.parseArray(data, StreamUser.class);
    }

    public static void main(String[] args) {

    }

}
