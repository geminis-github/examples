package com.examples.spring.boot.mybatis.tk.entity;

import com.examples.spring.boot.mybatis.tk.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户实体
 *
 * @author Thinking9527
 * @date 2022-11-13 12:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "test_user")
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
