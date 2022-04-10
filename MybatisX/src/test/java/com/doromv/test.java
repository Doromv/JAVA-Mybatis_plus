package com.doromv;

import com.doromv.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Doromv
 * @create 2022-04-10-10:38
 */
@SpringBootTest
public class test {
    @Autowired()
    UserMapper userMapper;
    @Test
    public void Test(){
        System.out.println(userMapper.selectAgeAndSexByAgeBetween(15, 20));
    }
}
