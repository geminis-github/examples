package com.example.spring.boot.mybatis.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spring.boot.mybatis.plus.dao.UserDao;
import com.example.spring.boot.mybatis.plus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.spring.boot.mybatis.plus.test.GenerateSqls.*;

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

    /**
     * 批量插入数据
     *
     * @throws InterruptedException
     */
    @Test
    void insertUserData() throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(new CreateTask(i)));
        }
        for (Thread thread : list) {
            thread.start();
        }
        for (Thread thread : list) {
            thread.join();
        }
    }

    /**
     * 循环创建用户任务
     */
    private class CreateTask implements Runnable {
        private int num;
        public CreateTask(int num) {
            this.num = num;
        }
        @Override
        public void run() {
            int step = 1000;
            int start = step * (num + 1);
            for (int i = (start - step); i < start; i++) {
                User user = buildUser(i);
                userDao.insert(user);
                System.out.println(i + ": " + user);
            }
        }
    }

    /**
     * 创建模拟用户
     *
     * @param sn 用户序号
     * @return
     */
    private User buildUser (int sn) {
        User user = User.builder()
                .userType(userType())
                .sn(String.valueOf(sn))
                .nickname(nickName())
                .cardNumber(cardNumber())
                .realName(realName())
                .sex(sex())
                .censusRegister(censusRegister())
                .birthday(birthday())
                .email(email())
                .mobile(mobile())
                .weChartId(weChartId())
                .qq(qq())
                .hobby(hobby())
                .workingLocation(workingLocation())
                .salary(salary())
                .occupation(occupation())
                .build();
        user.setId(id());
        user.setCreatedBy(0L);
        user.setUpdatedBy(0L);
        user.setCreateTime(createTime());
        user.setUpdateTime(LocalDateTime.now());
        user.setDeleted(false);
        return user;
    }

}
