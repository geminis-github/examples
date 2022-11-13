package com.example.spring.boot.mybatis.plus.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Druid配置类
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
@Configuration
@PropertySource(value = "classpath:application.yml")
@org.mybatis.spring.annotation.MapperScan(
        basePackages = "com.example.spring.boot.mybatis.plus.dao",
        sqlSessionFactoryRef = "",
        sqlSessionTemplateRef = ""
)
public class DruidConfiguration {

    /**
     * 数据源配置
     */
    @Bean(destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

}
