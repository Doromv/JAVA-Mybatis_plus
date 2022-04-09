package com.doromv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.doromv.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Doromv
 * @create 2022-04-08-11:21
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    Page<User> selectPageVo(Page<User> page, Integer age);
}
