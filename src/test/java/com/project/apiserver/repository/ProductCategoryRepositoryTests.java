package com.project.apiserver.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.apiserver.common.ProductCategory;
import com.project.apiserver.common.ProudctCategoryRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductCategoryRepositoryTests {
    
    @Autowired
    private ProudctCategoryRepository repository;

    @Test
    public void insertCategory(){

        ProductCategory category = ProductCategory.builder().procatename("과일가공품").build();

        repository.save(category);

    }

}
