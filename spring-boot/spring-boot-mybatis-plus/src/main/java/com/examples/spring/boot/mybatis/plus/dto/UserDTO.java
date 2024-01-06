package com.examples.spring.boot.mybatis.plus.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户封装类
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-26 10:49
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // User
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

    // UserType
    private Integer type;
    private String name;
    private String code;

}
