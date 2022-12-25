package com.examples.spring.boot.mybatis.tk.common;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 基础Mapper
 *
 * @author liangjinlong9527
 * @date 2022-12-21 19:28
 */
public interface ParentMapper<T extends BaseEntity> extends BaseMapper<T>, MySqlMapper<T> {



}
