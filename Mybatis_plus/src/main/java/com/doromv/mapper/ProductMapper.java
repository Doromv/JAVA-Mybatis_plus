package com.doromv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.doromv.pojo.Product;
import com.doromv.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author Doromv
 * @create 2022-04-08-11:21
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
