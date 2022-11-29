package com.examples.spring.boot.data.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest(classes = RedisApplication.class)
class RedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        ValueOperations<String, String> operations =  stringRedisTemplate.opsForValue();
        operations.set("username", "jack", 1, TimeUnit.DAYS);
        String username = operations.get("username");
        log.info("username value = {}", username);
    }

}
