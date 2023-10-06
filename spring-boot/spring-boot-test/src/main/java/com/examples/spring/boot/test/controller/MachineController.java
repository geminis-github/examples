package com.examples.spring.boot.test.controller;

import com.examples.spring.boot.test.Result;
import com.examples.spring.boot.test.entity.Machine;
import com.examples.spring.boot.test.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * machine-controller
 *
 * @author Thinking9527
 * @date 2022-12-13 21:55
 */
@RestController
@RequestMapping(value = "/machine")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping(value = "/findList")
    public Result<List<Machine>> findList() {
        return Result.success(machineService.findList());
    }

    @GetMapping(value = "/findOne")
    public Result<List<Machine>> findOne() {
        return Result.success(machineService.findOne());
    }

    @GetMapping(value = "/deleteById/{id}")
    public Result<List<Machine>> deleteById(@PathVariable Long id) {
        return Result.success(machineService.deleteById(id));
    }


}
