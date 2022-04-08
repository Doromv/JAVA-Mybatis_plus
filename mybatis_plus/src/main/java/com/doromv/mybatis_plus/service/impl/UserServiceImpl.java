package com.doromv.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doromv.mybatis_plus.mapper.UserMapper;
import com.doromv.mybatis_plus.pojo.User;
import com.doromv.mybatis_plus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Doromv
 * @create 2022-04-06-11:29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
