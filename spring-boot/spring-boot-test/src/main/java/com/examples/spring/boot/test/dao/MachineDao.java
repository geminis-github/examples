package com.examples.spring.boot.test.dao;

import com.examples.spring.boot.test.entity.Machine;

import java.util.List;

/**
 * machine-dao
 *
 * @author liangjinlong9527
 * @date 2022-12-13 21:55
 */
public interface MachineDao {

    /**
     * findList
     *
     * @return 数据列表
     */
    List<Machine> findList();

    /**
     * findOne
     *
     * @return a one machine
     */
    Machine findOne();

    /**
     * deleteById
     *
     * @param id id
     * @return delete num
     */
    int deleteById(Long id);

}
