package com.example.spring.boot.mybatis.plus;

import com.example.spring.boot.mybatis.plus.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@Slf4j
@SpringBootTest(classes = MyBatisPlusApplication.class)
class SqlSessionTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 自定义查询增加分页
     */
    @Test
    void test001 () {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<User> list = sqlSession.selectList("select * from test_user limit 100", User.class);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
