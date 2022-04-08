package com.doromv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doromv.mapper.UserMapper;
import com.doromv.service.UserService;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Doromv
 * @create 2022-04-08-11:34
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
