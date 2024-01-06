package com.examples.app.generating.code.entity;

import com.examples.app.generating.code.domain.GenTableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.util.List;

/**
 * 业务表信息-Entity
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 15:53
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class GenTable extends GenTableDO {

    @Serial
    private static final long serialVersionUID = 1L;

    private List<GenColumn> columns;

    /**
     * 基础实体包名称
     */
    private String baseEntityName;

    /**
     * 基础Mapper包名称
     */
    private String baseMapperName;

    /**
     * 基础Service包名称
     */
    private String baseServiceName;

    /**
     * 基础ServiceImpl包名称
     */
    private String baseServiceImplName;

    /**
     * 基础Controller包名称
     */
    private String baseControllerName;

}
