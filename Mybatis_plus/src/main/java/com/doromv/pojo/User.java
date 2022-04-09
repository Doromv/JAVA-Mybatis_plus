package com.doromv.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.doromv.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Doromv
 * @create 2022-04-08-11:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//在实体类类型上添加@TableName("t_user")，标识实体类对应的表，即可成功执行SQL语句
//@TableName("t_user")
public class User {
//    在实体类中id属性上通过@TableId将其标识为主键,value="",设置属性所对应的字段名
    @TableId("uid")
    private Long id;
//    @TableField("username")设置属性所对应的字段名
    @TableField("user_name")
    private String name;
    private Integer age;
    private String email;
    private SexEnum sex;
    @TableLogic
    private Integer isDeleted;
}
