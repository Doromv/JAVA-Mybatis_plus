package com.doromv.mybatis_plus.service;

import com.doromv.mybatis_plus.mapper.UserMapper;
import com.doromv.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Doromv
 * @create 2022-04-05-21:22
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void selectList(){
        System.out.println(userService.count());
    }
    @Test
    public void insertMore(){
        List<User> list=new ArrayList<>();
        for (int i=1;i<=10;i++){
            User user = new User();
            user.setName("zr"+i);
            user.setAge(20+i);
            list.add(user);
        }
        System.out.println(userService.saveBatch(list));
    }
}
