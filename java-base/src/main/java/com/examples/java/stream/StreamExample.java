package com.examples.java.stream;

import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson2.JSONArray;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Map<String, List<StreamUser>> collect = list
                .stream()
                .limit(10000)
                .filter(StreamUser::getSex)
                .filter(e -> StringUtils.isNotBlank(e.getEmail()) && e.getEmail().endsWith("@qq.com"))
                .collect(Collectors.groupingBy(StreamUser::getCensusRegister));
    }

}
