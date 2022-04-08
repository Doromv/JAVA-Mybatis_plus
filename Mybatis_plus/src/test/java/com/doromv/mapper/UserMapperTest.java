package com.doromv.mapper;

import com.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Doromv
 * @create 2022-04-08-11:22
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
    //selectList()根据MP内置的条件构造器查询一个list集合，null表示没有条件，即查询所有
        userMapper.selectList(null).forEach(System.out::println);
    }
    @Test
    public void testInsert(){
        User user = new User(null, "张三", 23, "zhangsan@atguigu.com");
//INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        int result = userMapper.insert(user);
        System.out.println("受影响行数："+result);
        System.out.println("id自动获取："+user.getId());
    }
    @Test
    public void testDeleteById(){
//通过id删除用户信息
//DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1475754982694199298L);
        System.out.println("受影响行数："+result);
    }
    @Test
    public void testDeleteBatchIds(){
//通过多个id批量删除
//DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Integer> idList = Arrays.asList(1, 2, 3);
        int result = userMapper.deleteBatchIds(idList);
        System.out.println("受影响行数："+result);
    }
    @Test
    public void testDeleteByMap(){
//根据map集合中所设置的条件删除记录
//DELETE FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("age", 23);
        map.put("name", "张三");
        int result = userMapper.deleteByMap(map);
        System.out.println("受影响行数："+result);
    }
    @Test
    public void testUpdateById(){
        User user = new User(4L, "admin", 22, null);
//UPDATE user SET name=?, age=? WHERE id=?
        int result = userMapper.updateById(user);
        System.out.println("受影响行数："+result);
    }
    @Test
    public void testSelectById(){
//根据id查询用户信息
//SELECT id,name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(4L);
        System.out.println(user);
    }
    @Test
    public void testSelectBatchIds(){
//根据多个id查询多个用户信息
//SELECT id,name,age,email FROM user WHERE id IN ( ? , ? )
        List<Long> idList = Arrays.asList(4L, 5L);
        List<User> list = userMapper.selectBatchIds(idList);
        list.forEach(System.out::println);
    }
    @Test
    public void testSelectByMap(){
//通过map条件查询用户信息
//SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("age", 22);
        map.put("name", "admin");
        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }
}
