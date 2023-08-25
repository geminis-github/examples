package com.examples.spring.boot.mybatis.tk;

import com.examples.spring.boot.common.util.BusinessUtil;
import com.examples.spring.boot.mybatis.tk.entity.User;
import com.examples.spring.boot.mybatis.tk.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.examples.spring.boot.mybatis.tk.test.GenerateSqls.*;

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

    /**
     * 批量插入数据
     *
     * @throws InterruptedException
     */
    @Test
    void insertUserData() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add(new Thread(new CreateTask(i)));
        }
        for (Thread thread : list) {
            thread.start();
        }
        for (Thread thread : list) {
            thread.join();
        }
        log.info("insert use time = {}", System.currentTimeMillis() - beginTime);
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
            int step = 400;
            int start = step * (num + 1);
            for (int i = (start - step); i < start; i++) {
                User user = buildUser(i);
                userMapper.insertSelective(user);
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
        return user;
    }
}
