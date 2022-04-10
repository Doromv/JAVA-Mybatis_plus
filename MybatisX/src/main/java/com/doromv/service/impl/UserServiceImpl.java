package com.doromv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doromv.pojo.User;
import com.doromv.service.UserService;
import com.doromv.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author DoromvQAQ
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-04-10 10:16:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




