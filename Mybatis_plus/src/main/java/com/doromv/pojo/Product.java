package com.doromv.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author Doromv
 * @create 2022-04-09-9:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version//乐观锁版本号字段
    private Integer version;
}
