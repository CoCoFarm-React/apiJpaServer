package com.project.apiserver.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apiserver.productboard.service.ProductService;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductServiceTests {
    
    @Autowired
    private ProductService productService;

    @Test
    @Transactional
    public void getListTest(){

        productService.getList();

    }

    @Test
    @Transactional
    public void readTest(){

        productService.readOne(2L);

    }

}
