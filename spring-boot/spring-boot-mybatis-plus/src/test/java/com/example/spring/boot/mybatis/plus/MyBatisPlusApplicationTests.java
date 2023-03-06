package com.example.spring.boot.mybatis.plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spring.boot.mybatis.plus.dao.UserDao;
import com.example.spring.boot.mybatis.plus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = MyBatisPlusApplication.class)
class MyBatisPlusApplicationTests {

    @Autowired
    private UserDao userDao;

    /**
     * 自定义查询增加分页
     */
    @Test
    void test001 () {
        Page<User> page = new Page<>(1, 100);
        // 需要把分页page作为第一个参数传给查询
        // 方法
        List<User> list = userDao.selectSample(page);
    }

}
