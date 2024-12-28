package com.examples.spring.boot.mybatis.tk.common;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 基础实体
 *
 * @author Thinking9527
 * @date 2022-12-21 19:28
 */
@Data
public class BaseEntity {

    /**
     * 主键ID
     */
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

    /**
     * 删除标志
     */
    private Boolean deleted;

}
