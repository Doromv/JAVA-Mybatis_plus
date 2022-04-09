package com.doromv.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.doromv.enums.SexEnum;
import com.doromv.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Doromv
 * @create 2022-04-08-19:50
 */
@SpringBootTest
public class MybatisPlusEnumTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void Test() {
        User user = new User();
        user.setName("admin");
        user.setAge(18);
        user.setSex(SexEnum.MALE);
        int rows= userMapper.insert(user);
        System.out.println(user.getSex().getSexName());
    }
}
