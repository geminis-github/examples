package com.examples.app.generating.code.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 自动生成类配置信息
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-27 10:31
 */
@Data
@ToString
@EqualsAndHashCode
public class GenDefaultInfo implements Serializable {

    /**
     * 注释的作者名称
     */
    private String author;

    /**
     * 包路径
     */
    private String packageName;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 数据库主机名称
     */
    private String dbHost;

    /**
     * 数据库类型：MYSQL,ORACLE
     */
    private String dbType;

    /**
     * mysql数据库 or oracle模式名称
     */
    private String libraryName;

    /**
     * 基础实体包路径
     */
    private String baseEntityPath;

    /**
     * 基础Mapper包路径
     */
    private String baseMapperPath;

    /**
     * 基础Service包路径
     */
    private String baseServicePath;

    /**
     * 基础ServiceImpl包路径
     */
    private String baseServiceImplPath;

    /**
     * 基础Controller包路径
     */
    private String baseControllerPath;

    /**
     * 控制器路径
     */
    private String controllerPath;
}
