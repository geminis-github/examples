package com.examples.java.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户 entity
 *
 * @author Thinking9527
 * @date 2023-10-06 17:14
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StreamUser implements Serializable {

    private Long id;
    private Long createdBy;
    private Long updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean deleted;

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
