package com.example.spring.boot.mybatis.plus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.spring.boot.mybatis.plus.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户-Dao
 *
 * @author: ljl
 * @since: 2021/4/23 0023 1:41
 */
@Repository
public interface UserDao extends BaseMapper<User> {

    List<User> selectList();

}
