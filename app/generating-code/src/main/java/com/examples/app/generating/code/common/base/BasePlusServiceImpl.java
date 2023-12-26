package com.examples.app.generating.code.common.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * mybatis-plus 基础 ServiceImpl
 *
 * @author liangjinlong-CT00345
 * @date 2023-10-26 8:55
 */
public abstract class BasePlusServiceImpl<M extends BasePlusMapper<T>, T> extends ServiceImpl<M, T> implements BasePlusService<T> {

}
