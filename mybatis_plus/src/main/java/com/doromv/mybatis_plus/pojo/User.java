package com.doromv.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Doromv
 * @create 2022-04-05-21:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("t_user")
public class User {
    private long id;
    private String name;
    private Integer age;
    private String email;
}
