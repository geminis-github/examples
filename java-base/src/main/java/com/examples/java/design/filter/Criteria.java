package com.examples.java.design.filter;

import java.util.List;

/**
 * Criteria 接口 - 标准接口
 *
 * @author liangjinlong-CT00345
 * @date 2024-04-25 15:25
 */
public interface Criteria {

    /**
     * 子类要实现的过滤方法
     *
     * @param persons 过滤目标列表
     * @return 过滤后的数据
     */
    List<Person> meetCriteria(List<Person> persons);

}
