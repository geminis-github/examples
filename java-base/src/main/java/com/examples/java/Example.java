package com.examples.java;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 测试示例
 *
 * 编码设置：-Dfile.encoding=UTF-8dd
 * @author liangjinlong9527
 * @date 2022-11-13 12:11
 */
public class Example {

    private static final AtomicLong num = new AtomicLong(0);

    public static void main(String[] args) throws Exception {
        long beginTime = System.currentTimeMillis();
        int nThreads = 100;
        ExecutorService executor = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < nThreads; i++) {
            executor.execute(() -> {
                for (int j = 0; j < 1000000; j++) {
                    num.addAndGet(1);
                }
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(1000);
        }
        System.out.println("main thread end, num = " + num.get() + ", use times " + (System.currentTimeMillis() - beginTime));
    }

}

