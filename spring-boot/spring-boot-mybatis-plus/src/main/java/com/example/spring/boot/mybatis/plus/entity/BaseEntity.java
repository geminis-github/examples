package com.example.spring.boot.mybatis.plus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 基础实体
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    private Long id;
    private Long createdBy;
    private Long updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean deleted;

}
