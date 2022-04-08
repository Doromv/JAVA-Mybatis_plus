package com.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
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
//@TableName("t_user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
