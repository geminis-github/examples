package com.examples.app.generating.code.common.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础类
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-23 21:58
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public abstract class BasePlusEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 创建人ID
     */
    private Long createdBy;

    /**
     * 最后更新人ID
     */
    private Long updatedBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}
