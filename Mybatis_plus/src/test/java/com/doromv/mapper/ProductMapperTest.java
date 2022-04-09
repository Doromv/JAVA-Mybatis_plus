package com.doromv.mapper;

import com.doromv.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Doromv
 * @create 2022-04-09-9:40
 */
@SpringBootTest
public class ProductMapperTest {
    @Autowired
    ProductMapper productMapper;
    @Test
    public void test1(){
        Product productL = productMapper.selectById(1);
        System.out.println("小李取出的价格：" + productL.getPrice());
        Product productW = productMapper.selectById(1);
        System.out.println("小王取出的价格：" + productW.getPrice());
        productL.setPrice(productL.getPrice()+50);
        productMapper.updateById(productL);
        productW.setPrice(productW.getPrice()-30);
        int rows = productMapper.updateById(productW);
        if (rows==0){
             productW = productMapper.selectById(1);
            productW.setPrice(productW.getPrice()-30);
             productMapper.updateById(productW);
        }
        Product productBoss = productMapper.selectById(1);
        System.out.println("老板取出的价格：" + productBoss.getPrice());
    }
}
