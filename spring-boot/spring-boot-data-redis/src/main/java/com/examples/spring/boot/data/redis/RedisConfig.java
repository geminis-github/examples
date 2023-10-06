package com.examples.spring.boot.data.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis 配置类
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
@Configuration
public class RedisConfig {

    /**
     * 默认template
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        // 设置工厂链接
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 设置自定义序列化方式
        setSerializeConfig(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 设置序列化（required）
     *
     * @param redisTemplate
     * @param redisConnectionFactory
     */
    private void setSerializeConfig(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory redisConnectionFactory) {
        // 对字符串采取普通的序列化方式 适用于key 因为我们一般采取简单字符串作为key
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // 普通的string类型的key采用 普通序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        // 普通hash类型的key也使用 普通序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // 对象映射
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(new DefaultBaseTypeLimitingValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        // 解决查询缓存转换异常的问题  大家不能理解就直接用就可以了 这是springboot自带的jackson序列化类，但是会有一定问题
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(om, Object.class);
        // 普通的值采用jackson方式自动序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // hash类型的值也采用jackson方式序列化
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        // 属性设置完成afterPropertiesSet就会被调用，可以对设置不成功的做一些默认处理
        redisTemplate.afterPropertiesSet();
    }

    /**
     * Key为String类型的模板类
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

}