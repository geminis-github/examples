package com.examples.spring.cloud.nacos.discovery.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 生产者
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryProviderApplication.class, args);
    }

}
