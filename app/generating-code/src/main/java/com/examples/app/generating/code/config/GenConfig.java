package com.examples.app.generating.code.config;

import com.examples.app.generating.code.common.entity.GenDefaultInfo;
import com.examples.app.generating.code.common.util.GeminiUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.examples.app.generating.code.common.Constants.MY_NAME;

/**
 * 配置信息
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-27 10:52
 */
@Configuration
public class GenConfig {

    @Value("${spring.datasource.druid.slave.url}")
    private String slaveJdbcUrl;

    @Bean
    public GenDefaultInfo genDefaultInfo() {
        GenDefaultInfo bean = new GenDefaultInfo();
        bean.setDbHost(GeminiUtils.getDBHostByUrl(slaveJdbcUrl));
        bean.setDbType(GeminiUtils.getDBTypeByUrl(slaveJdbcUrl));
        bean.setLibraryName(GeminiUtils.getDBNameByUrl(slaveJdbcUrl));
        bean.setAuthor(MY_NAME);

        // todo ljlmark 这里要改成具体的包名称和模块名称
        bean.setPackageName("com.cnes.project");
        bean.setBaseEntityPath("com.cnes.framework.web.domain.BaseParentEntity");
        bean.setBaseMapperPath("com.cnes.framework.base.BasePlusMapper");
        bean.setBaseServicePath("com.cnes.framework.base.BasePlusService");
        bean.setBaseServiceImplPath("com.cnes.framework.base.BasePlusServiceImpl");
        bean.setBaseControllerPath("com.cnes.framework.web.controller.BasePlusController");

        bean.setModuleName("scoplegroup");
        return bean;
    }



}
