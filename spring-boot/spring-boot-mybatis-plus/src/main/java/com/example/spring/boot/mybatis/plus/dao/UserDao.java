package com.example.spring.boot.mybatis.plus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spring.boot.mybatis.plus.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户-Dao
 *
 * @author liangjinlong9527
 * @date 2022-11-13 12:57
 */
@Repository
public interface UserDao extends BaseMapper<User> {

    /**
     * 自定义查询
     *
     * @return 列表数据
     */
    List<User> selectSample(Page<User> page);

}
