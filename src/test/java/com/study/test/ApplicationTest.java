package com.study.test;

import com.study.cache.Application;

import com.study.cache.product.entity.Product;
import com.study.cache.product.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class ApplicationTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testDao(){
        Product product = new Product();
        product.setId(1);
        product.setName("a");
        //productMapper.insert(product);
        boolean insert = product.insert();
    }
}
