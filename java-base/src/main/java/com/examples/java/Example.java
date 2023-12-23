package com.examples.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试示例
 *
 * 编码设置：-Dfile.encoding=UTF-8
 * @author Thinking9527
 * @date 2022-11-13 12:11
 */
public class Example {

    public static void main(String[] args) {
        File file = new File("E:\\BaiduNetdiskDownload");
        List<File> fileList = new ArrayList<>();
        listAllFiles(file, fileList);
        for (File item : fileList) {
            item.renameTo(new File(item.getAbsolutePath().replace("【itjc8.com】", "")));
        }
    }

    public static void listAllFiles(File folder, List<File> fileList) {
        File[] fileArray = folder.listFiles();
        if (fileArray != null) {
            for (File file : fileArray) {
                if (file.isDirectory()) {
                    listAllFiles(file, fileList);
                } else {
                    fileList.add(file);
                }
            }
        }
    }

}

