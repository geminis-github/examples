package com.examples.spring.boot.mybatis.tk.common;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 基础Mapper
 *
 * @author Thinking9527
 * @date 2022-12-21 19:28
 */
public interface BaseMapper<T extends BaseEntity> extends Mapper<T> {



}
