package com.doromv.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doromv.mybatis_plus.pojo.User;

import java.util.Map;

/**
 * @author Doromv
 * @create 2022-04-05-21:18
 */
public interface UserMapper extends BaseMapper<User> {
    Map<String,Object> selectMapById(Integer id);
}
