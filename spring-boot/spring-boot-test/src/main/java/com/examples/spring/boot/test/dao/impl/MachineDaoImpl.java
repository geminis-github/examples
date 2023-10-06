package com.examples.spring.boot.test.dao.impl;

import com.examples.spring.boot.test.dao.MachineDao;
import com.examples.spring.boot.test.entity.Machine;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * machine-dao-impl
 *
 * @author Thinking9527
 * @date 2022-12-15 22:46
 */
@Repository
public class MachineDaoImpl implements MachineDao {

    @Override
    public List<Machine> findList() {
        List<Machine> list = new ArrayList<>();
        list.add(new Machine("jack", 21, false));
        list.add(new Machine("mark", 22, true));
        return list;
    }

    @Override
    public Machine findOne() {
        return new Machine("google", 50, true);
    }

    @Override
    public int deleteById(Long id) {
        return 1;
    }

}
