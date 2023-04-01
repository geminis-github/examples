package com.examples.spring.boot.data.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring-boot-elasticsearch使用
 *
 * @see <a href="https://blog.csdn.net/weixin_45056780/article/details/125408524">Docker安装Elasticsearch 8.x 、Kibana 8.x等</a>
 * @see <a href="https://blog.csdn.net/tu_wer/article/details/126908948">【六】ElasticSearch8.x Java API 实体类、工具类、测试类及常见问题</a>
 * @author liangjinlong9527
 * @date 2022-12-14 21:06
 */
@SpringBootApplication
public class ElasticSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class, args);
    }

}
