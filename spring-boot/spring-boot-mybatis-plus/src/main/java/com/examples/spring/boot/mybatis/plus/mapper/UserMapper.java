package com.examples.spring.boot.mybatis.plus.mapper;

import com.examples.spring.boot.mybatis.plus.common.base.ParentMapper;
import com.examples.spring.boot.mybatis.plus.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户 mapper
 *
 * @author Thinking9527
 * @date 2023-10-06 17:33
 */
@Repository
public interface UserMapper extends ParentMapper<User> {


}
