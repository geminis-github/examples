package com.examples.spring.boot.mybatis.tk.mapper;

import com.examples.spring.boot.mybatis.tk.common.ParentMapper;
import com.examples.spring.boot.mybatis.tk.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户-mapper
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
@Repository
public interface UserMapper extends ParentMapper<User> {


}
