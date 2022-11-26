package com.example.spring.boot.mybatis.plus;

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
    @Test
    void test001 () {
        List<User> list = userDao.selectList(); // query2
    }

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

    class CreateTask implements Runnable {
        private int num;
        public CreateTask(int num) {
            this.num = num;
        }
        @Override
        public void run() {
            int step = 50000;
            int start = step * (num + 1);
            for (int i = (start - step); i < start; i++) {
                User user = buildUser(i);
                userDao.insert(user);
                System.out.println(i + ": " + user);
            }
        }
    }

    private User buildUser (int i) {
        User user = User.builder()
                .userType(userType())
                .sn(i + "")
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
