package com.doromv.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author Doromv
 * @create 2022-04-09-10:22
 */
@Getter
public enum SexEnum {
    MALE(1,"男"),
    FEMALE(2,"女");
    @EnumValue//将注解所标识的属性的值储存到数据库中
    private Integer sex;
    private String sexName;

     SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
