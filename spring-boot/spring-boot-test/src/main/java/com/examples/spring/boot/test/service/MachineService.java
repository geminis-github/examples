package com.examples.spring.boot.test.service;

import com.examples.spring.boot.test.entity.Machine;

import java.util.List;

/**
 * machine-service
 *
 * @author Thinking9527
 * @date 2022-12-13 21:55
 */
public interface MachineService {

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
