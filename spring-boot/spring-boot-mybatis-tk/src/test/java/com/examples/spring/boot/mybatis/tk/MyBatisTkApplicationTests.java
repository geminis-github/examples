package com.examples.spring.boot.mybatis.tk;

import com.examples.spring.boot.common.util.BusinessUtil;
import com.examples.spring.boot.mybatis.tk.entity.User;
import com.examples.spring.boot.mybatis.tk.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest(classes = MyBatisTkApplication.class)
public class MyBatisTkApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void example() {
        log.info("version = {}", BusinessUtil.getVersion());
    }

    @Test
    public void test01() {
        PageHelper.startPage(1, 10);

        List<User> list = userMapper.selectAll();
    }

}
