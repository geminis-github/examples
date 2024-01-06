package com.examples.spring.boot.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.examples.spring.boot.mybatis.plus.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户性格类型
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 10:43
 */
@TableName(value = "test_user_type")
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class UserType extends BaseEntity {

    private Integer type;
    private String name;
    private String code;

}
