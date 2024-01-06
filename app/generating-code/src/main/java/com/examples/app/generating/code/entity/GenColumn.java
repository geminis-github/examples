package com.examples.app.generating.code.entity;

import com.examples.app.generating.code.domain.GenColumnDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * 表字段信息-Entity
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 15:38
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class GenColumn extends GenColumnDO {

    @Serial
    private static final long serialVersionUID = 1L;

    private String capJavaField;

}
