package com.examples.spring.boot.mybatis.plus;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.examples.spring.boot.mybatis.plus.entity.User;
import com.examples.spring.boot.mybatis.plus.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest(classes = MyBatisPlusApplication.class)
public class MyBatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        long startTime = System.currentTimeMillis();
        PageHelper.startPage(1, 100);
        List<User> list =  userMapper.selectList(Wrappers.emptyWrapper());
        System.out.println("100 time = " + (System.currentTimeMillis() - startTime));

//        String data = JSONArray.toJSONString(list);
//        FileWriter writer = new FileWriter("D:\\dev\\data\\user_data.json");
//        writer.write(data);
    }

}
