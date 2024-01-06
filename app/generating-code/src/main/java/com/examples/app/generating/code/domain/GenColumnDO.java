package com.examples.app.generating.code.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.examples.app.generating.code.common.annotation.TableColumn;
import com.examples.app.generating.code.common.base.BasePlusEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * 表字段信息-Domain
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 15:38
 */
@TableName("gen_column")
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class GenColumnDO extends BasePlusEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 表ID
     */
    private Long tableId;

    /**
     * 排序
     */
    @TableColumn
    private Integer sort;

    /**
     * 列名称
     */
    @TableColumn
    private String columnName;

    /**
     * 列描述
     */
    @TableColumn
    private String columnComment;

    /**
     * 列类型（包含长度，精度信息）
     */
    @TableColumn
    private String columnType;

    /**
     * 字段数据类型（不包含长度，精度信息）
     */
    @TableColumn
    private String dataType;

    /**
     * 是否主键
     */
    @TableColumn
    private Boolean pk;

    /**
     * 是否自增
     */
    @TableColumn
    private Boolean increment;

    /**
     * 是否必填
     */
    @TableColumn
    private Boolean required;

    /**
     * 是否是父类字段
     */
    private Boolean superColumn;

    /**
     * JAVA类型
     */
    private String javaType;

    /**
     * JAVA字段名
     */
    private String javaField;

    /**
     * 查询方式：参考QueryType枚举类
     */
    private String queryType;

    /**
     * 插入标识
     */
    private Boolean inserted;

    /**
     * 删除标识
     */
    private Boolean deleted;

    /**
     * 编辑标识
     */
    private Boolean edited;

    /**
     * 查询标识
     */
    private Boolean queryed;

    /**
     * 列表标识
     */
    private Boolean listed;

}
