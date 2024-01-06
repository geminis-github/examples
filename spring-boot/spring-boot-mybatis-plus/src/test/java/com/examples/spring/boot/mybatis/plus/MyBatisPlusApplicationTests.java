package com.examples.spring.boot.mybatis.plus;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.examples.spring.boot.mybatis.plus.dto.UserDTO;
import com.examples.spring.boot.mybatis.plus.entity.User;
import com.examples.spring.boot.mybatis.plus.entity.UserType;
import com.examples.spring.boot.mybatis.plus.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
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
    public void test02() {
        PageHelper.startPage(1, 100);
        List<UserDTO> userList = userMapper.selectJoinList(
                UserDTO.class,
                new MPJLambdaWrapper<User>()
                        .selectAll(User.class)
                        .select(UserType::getName)
                        .select(UserType::getCode)
                        .leftJoin(UserType.class, UserType::getType, User::getUserType)
                        .eq(UserType::getType, 5)
        );
    }

    @Test
    public void test01() {
        long startTime = System.currentTimeMillis();
        PageHelper.startPage(1, 100);
        List<User> list =  userMapper.selectList(Wrappers.emptyWrapper());
        System.out.println("100 time = " + (System.currentTimeMillis() - startTime));
    }

}
