package com.doromv;
import com.doromv.service.ProductService;
import com.doromv.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Test
    void contextLoads() {
    }
    @Test
    public void test(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }
}
