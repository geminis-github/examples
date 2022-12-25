package com.examples.spring.boot.test.service.impl;

import com.examples.spring.boot.test.dao.MachineDao;
import com.examples.spring.boot.test.entity.Machine;
import com.examples.spring.boot.test.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * machine-service-impl
 *
 * @author liangjinlong9527
 * @date 2022-12-13 21:55
 */
@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineDao machineDao;

    @Override
    public List<Machine> findList() {
        return machineDao.findList();
    }

    @Override
    public Machine findOne() {
        return machineDao.findOne();
    }

    @Override
    public int deleteById(Long id) {
        return machineDao.deleteById(id);
    }

}
