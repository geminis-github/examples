package com.examples.java.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * HttpURLConnectionExample使用示例
 *
 * @author liangjinlong-CT00345
 * @date 2024-04-08 17:00
 */
public class HttpURLConnectionExample {

    public static void main(String[] args) throws Exception{
        doGet();
    }

    private static void doGet() throws Exception {
        // 创建URL对象
        URL url = new URL("https://httpbin.org/get?param1=value1&param2=value2");
        // 打开连接
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        // 设置请求方法为GET
        con.setRequestMethod("GET");

        // 获取响应状态码
        int status = con.getResponseCode();
        // 创建BufferedReader来读取响应内容
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        // 循环读取响应流中的内容，并追加到content
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        // 关闭BufferedReader
        in.close();
        // 断开连接
        con.disconnect();

        // 打印响应状态和内容
        System.out.println("Response Status: " + status);
        System.out.println("Response Body: " + content);
    }

    private static void doPost() throws Exception {

    }
}
