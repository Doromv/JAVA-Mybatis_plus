package com.doromv.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author Doromv
 * @create 2022-04-08-15:05
 */
@SpringBootTest
public class MybatisPlusWrapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void selectList1(){
        //查询用户名包含a，年龄在20~30之间，邮箱信息不为null
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("user_name","a")
                .between("age",20,30)
                .isNotNull("email");
        System.out.println(userMapper.selectList(queryWrapper));
    }
    @Test
    public void selectList2(){
        //查询用户的信息，按照年龄的降序排序，如果年龄相同按照ID的升序排序
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("uid");
        for (int i = 0; i < userMapper.selectList(queryWrapper).size(); i++) {
            System.out.println(i);
        }
    }
    @Test
    public void delete1() {
        //删除邮箱地址为null的用户信息
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.isNull("email");
        System.out.println(userMapper.delete(queryWrapper));
    }
    @Test
    public void update1() {
        //将(年龄大于20且用户名含有a)或者邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("user_name","a")
                .or().isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("test@163.com");
        System.out.println(userMapper.update(user, queryWrapper));
    }
    @Test
    public void update2(){
        //将用户名包含a并且（年龄大于20或者邮箱为null）的用户信息修改
        //lambda中的条件优先执行
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        User user = new User();
        user.setName("小红");
        user.setEmail("test@163.com");
        System.out.println(userMapper.update(user, queryWrapper));
    }
    @Test
    public void select1(){
        //查询用户的用户名，年龄，邮箱
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("user_name","age","email");
        for (Map<String, Object> selectMap : userMapper.selectMaps(queryWrapper)) {
            System.out.println(selectMap);
        }
    }
    @Test
    //子查询
    public void select2(){
        //查询id小于等于100的用户信息
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.inSql("uid","select uid from t_user where uid<=5");
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void update3(){
        //将用户名包含a并且（年龄大于20或者邮箱为null）的用户信息修改
        UpdateWrapper<User> updateWrapper=new UpdateWrapper<>();
        updateWrapper.like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        updateWrapper.set("user_name","小黑").set("email","Doromv@163.com");
        System.out.println(userMapper.update(null, updateWrapper));
    }
    @Test
    public void select3(){
        String username="a";
        Integer ageBegin=null;
        Integer ageEnd=30;
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        if(StringUtils.isNotBlank(username)){
            queryWrapper.like("user_name",username);
        }
        if(ageBegin!=null){
            queryWrapper.ge("age",ageBegin);
        }
        if(ageEnd!=null){
            queryWrapper.le("age",ageEnd);
        }
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void select4(){
        String username="a";
        Integer ageBegin=null;
        Integer ageEnd=30;
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),"user_name",username)
                .ge(ageBegin!=null,"age",ageBegin)
                .le(ageEnd!=null,"age",ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void select5(){
        String username="a";
        Integer ageBegin=null;
        Integer ageEnd=30;
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin!=null,User::getAge,ageBegin)
                .le(ageEnd!=null,User::getAge,ageEnd);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void update4(){
        //将用户名包含a并且（年龄大于20或者邮箱为null）的用户信息修改
        LambdaUpdateWrapper<User> lambdaUpdateWrapper=new LambdaUpdateWrapper();
        lambdaUpdateWrapper.like(User::getName,"o")
                .and(i->i.gt(User::getAge,20).or().isNull(User::getEmail));
        lambdaUpdateWrapper.set(User::getName,"小狗")
                .set(User::getEmail,"DoromvQAQ@163.com");
        userMapper.update(null,lambdaUpdateWrapper);
    }
}
