package com.doromv.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.doromv.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Doromv
 * @create 2022-04-08-19:50
 */
@SpringBootTest
public class MybatisPlusPluginsTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void pageTest(){
        Page<User> page=new Page<>(1,3);
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
    @Test
    public void selectPageVo(){
        Page<User> page=new Page<>(1,3);
        userMapper.selectPageVo(page,20);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
}
