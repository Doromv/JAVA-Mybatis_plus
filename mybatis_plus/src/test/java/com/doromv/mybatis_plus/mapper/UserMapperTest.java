package com.doromv.mybatis_plus.mapper;

import com.doromv.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

/**
 * @author Doromv
 * @create 2022-04-05-21:22
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void selectList(){
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
    }
    @Test
    public void insert(){
        User user = new User();
        user.setName("张三");
        user.setAge(25);
        user.setEmail("123124124");
        int result = userMapper.insert(user);
        System.out.println(result);
    }
    @Test
    public void delete(){
//        int rows = userMapper.deleteById(6);
//        System.out.println(rows);
//        Map<String,Object> map=new HashMap<>();
//        map.put("name","李四");
//        map.put("age",23);
//        int rows = userMapper.deleteByMap(map);
//        System.out.println(rows);
        List<Integer> list = Arrays.asList(9, 10);
        int rows = userMapper.deleteBatchIds(list);
        System.out.println(rows);
    }
    @Test
    public void update(){
        User user = new User();
        user.setId(4);
        user.setName("Sand");
        userMapper.updateById(user);
    }
    @Test
    public void select(){
//        System.out.println(userMapper.selectById(1));
//        List<Integer> List = Arrays.asList(3,4,5);
//        System.out.println(userMapper.selectBatchIds(List));
//        Map<String,Object> map=new HashMap<>();
////        map.put("name","Jack");
////        map.put("age",20);
////        System.out.println(userMapper.selectByMap(map));
        System.out.println(userMapper.selectMapById(1));
    }
}
