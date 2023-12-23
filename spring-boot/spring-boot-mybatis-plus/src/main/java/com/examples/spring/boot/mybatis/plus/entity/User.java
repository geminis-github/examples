package com.examples.spring.boot.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.examples.spring.boot.mybatis.plus.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户 entity
 *
 * @author Thinking9527
 * @date 2023-10-06 17:14
 */
@TableName(value = "test_user")
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private Integer userType;
    private String sn;
    private String nickname;
    private String cardNumber;
    private String realName;
    private Boolean sex;
    private String censusRegister;
    private LocalDateTime birthday;
    private String email;
    private String mobile;
    private String weChartId;
    private String qq;
    private String hobby;
    private String workingLocation;
    private BigDecimal salary;
    private String occupation;

}
