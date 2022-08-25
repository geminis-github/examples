package com.example.spring.boot.mybatis.plus.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Druid配置类
 *
 * @author: ljl
 * @since: 2021/4/23 0023 1:37
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
