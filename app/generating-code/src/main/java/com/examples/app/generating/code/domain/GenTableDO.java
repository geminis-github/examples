package com.examples.app.generating.code.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.examples.app.generating.code.common.base.BasePlusEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 业务表信息-Domain
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 15:38
 */
@TableName("gen_table")
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class GenTableDO extends BasePlusEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 数据库主机
     */
    private String dbHost;

    /**
     * 数据库类型
     */
    private String dbType;

    /**
     * 数据库名称
     */
    private String libraryName;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表描述
     */
    private String tableComment;

    /**
     * 表创建时间
     */
    private LocalDateTime tableCreateTime;

    /**
     * 表修改时间
     */
    private LocalDateTime tableUpdateTime;

    /**
     * 实体类名称
     */
    private String className;

    /**
     * 生成包路径
     */
    private String packageName;

    /**
     * 生成模块名
     */
    private String moduleName;

    /**
     * 生成业务名
     */
    private String businessName;

    /**
     * 生成功能名
     */
    private String functionName;

    /**
     * 生成功能作者
     */
    private String functionAuthor;

    /**
     * 生成代码方式（1=zip压缩包 2=自定义路径）
     */
    private Integer genType;

    /**
     * 生成路径
     */
    private String genPath;

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
