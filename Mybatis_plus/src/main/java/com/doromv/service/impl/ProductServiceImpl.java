package com.doromv.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doromv.mapper.ProductMapper;
import com.doromv.pojo.Product;
import com.doromv.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author Doromv
 * @create 2022-04-10-9:03
 */
@DS("slave_1")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
